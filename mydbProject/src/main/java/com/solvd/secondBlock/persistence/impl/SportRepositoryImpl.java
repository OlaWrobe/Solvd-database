package com.solvd.secondBlock.persistence.impl;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.persistence.SportRepository;
import com.solvd.secondBlock.persistence.connection.ConnectionPool;

import java.sql.*;

public class SportRepositoryImpl implements SportRepository {
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

    private static final String CREATE_QUERY = "INSERT INTO sports(name,sport_type_id, description) VALUES (?,?, ?)";
    private static final String UPDATE_QUERY = "UPDATE sports SET name=?,sport_type_id=?, description=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM sports WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM sports WHERE id=?";
    private static final String FIND_BY_PARTICIPANT_ID_QUERY = "SELECT s.id, s.sport_type_id, s.name, s.description " +
            "FROM sports s left join participants p ON s.id = p.sport_id " +
            "where p.id=?";

    @Override
    public void create(Sport sport) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, sport.getName());
            preparedStatement.setLong(2, sport.getSportType().getId());
            preparedStatement.setString(3, sport.getDescription());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                sport.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, Sport updatedSport) throws InterruptedException, SQLException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, updatedSport.getName());
            preparedStatement.setLong(2, updatedSport.getSportType().getId());
            preparedStatement.setString(3, updatedSport.getDescription());
            preparedStatement.setLong(4, id);

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

    public Sport findById(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapSports(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    public Sport findByParticipantId(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PARTICIPANT_ID_QUERY)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapSports(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    private Sport mapSports(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Sport(id, null, name, description);
    }
}
