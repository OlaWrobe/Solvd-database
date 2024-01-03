package com.solvd.secondBlock.persistence.impl;

import com.solvd.secondBlock.model.Team;
import com.solvd.secondBlock.persistence.TeamRepository;
import com.solvd.secondBlock.persistence.connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class TeamRepositoryImpl implements TeamRepository {
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

    private static final String CREATE_QUERY = "INSERT INTO teams(country_id,captain_id,team_name,squad_size) VALUES (?, ?,?)";
    private static final String UPDATE_QUERY = "UPDATE teams SET country_id=?, captain_id=?, team_name=?, squad_size=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM teams WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM teams WHERE id=?";

    @Override
    public void create(Team team) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, team.getCountry().getId());
            preparedStatement.setLong(2, team.getCaptain().getId());
            preparedStatement.setString(3, team.getTeamName());
            preparedStatement.setInt(4, team.getSquadSize());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                team.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, Team updatedTeam) throws InterruptedException, SQLException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setLong(1, updatedTeam.getCountry().getId());
            preparedStatement.setLong(2, updatedTeam.getCaptain().getId());
            preparedStatement.setString(3, updatedTeam.getTeamName());
            preparedStatement.setInt(4, updatedTeam.getSquadSize());
            preparedStatement.setLong(5, id);

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
    public Team findById(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapTeam(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    private Team mapTeam(ResultSet resultSet) throws SQLException {
        Long teamId = resultSet.getLong("id");
        // Assuming you have methods like getCountryById, getParticipantById in your repository
        String teamName = resultSet.getString("team_name");
        int squadSize = resultSet.getInt("squad_size");
        return new Team(teamId, null, null, teamName, squadSize, new ArrayList<>(), new ArrayList<>());
    }

}
