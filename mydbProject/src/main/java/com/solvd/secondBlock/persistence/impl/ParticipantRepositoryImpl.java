package com.solvd.secondBlock.persistence.impl;

import com.solvd.secondBlock.model.Participant;
import com.solvd.secondBlock.persistence.ParticipantRepository;
import com.solvd.secondBlock.persistence.connection.ConnectionPool;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ParticipantRepositoryImpl implements ParticipantRepository {
    private static final ConnectionPool CONNECTION_POOL;

    static {
        try {
            CONNECTION_POOL = ConnectionPool.getInstance(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String CREATE_QUERY = "INSERT INTO participants(country_id,sport_id,name,surname,birthdate,gender,email) VALUES (?, ?,?,?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE participants SET country_id=?, sport_id=?, name=?, surname=?, birthdate=?, gender=?, email=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM participants WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM participants WHERE id=?";
    private static final String FIND_CAPTAIN = "SELECT p.id,p.country_id,p.sport_id,p.name,p.surname,p.birthdate,p.gender,p.email " +
            " FROM participants p left join teams t ON p.id = t.captain_id " +
            "WHERE t.id=?";
    private static final String FIND_MEMBERS = "SELECT p.id,p.country_id,p.sport_id,p.name,p.surname,p.birthdate,p.gender,p.email " +
            "FROM participants p left join team_has_members thm ON p.id = thm.member_id " +
            "WHERE thm.team_id=?";

    @Override
    public void create(Participant participant) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, participant.getCountry().getId());
            preparedStatement.setLong(2, participant.getSport().getId());
            preparedStatement.setString(3, participant.getName());
            preparedStatement.setString(4, participant.getSurname());
            preparedStatement.setDate(5, Date.valueOf(participant.getBirthdate()));
            preparedStatement.setString(6, participant.getGender());
            preparedStatement.setString(7, participant.getEmail());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                participant.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, Participant updatedParticipant) throws InterruptedException, SQLException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setLong(1, updatedParticipant.getCountry().getId());
            preparedStatement.setLong(2, updatedParticipant.getSport().getId());
            preparedStatement.setString(3, updatedParticipant.getName());
            preparedStatement.setString(4, updatedParticipant.getSurname());
            preparedStatement.setDate(5, Date.valueOf(updatedParticipant.getBirthdate()));
            preparedStatement.setString(6, updatedParticipant.getGender());
            preparedStatement.setString(7, updatedParticipant.getEmail());
            preparedStatement.setLong(8, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Participant findById(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapParticipant(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    public Participant findCaptainByTeamId(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_CAPTAIN)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapParticipant(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    public List<Participant> findPlayersByTeamId(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Participant> participants = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_MEMBERS)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                participants.add(mapParticipant(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    public List<Participant> findAll() throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Participant> participants = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM participants")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                participants.add(mapParticipant(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return participants;
    }

    private Participant mapParticipant(ResultSet resultSet) throws SQLException {
        Long participantId = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
        String gender = resultSet.getString("gender");
        String email = resultSet.getString("email");
        return new Participant(participantId, null, null, name, surname, birthdate, gender, email, new ArrayList<>());
    }
}
