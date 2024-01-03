package com.solvd.secondBlock.persistence.impl;

import com.solvd.secondBlock.model.TeamScore;
import com.solvd.secondBlock.persistence.TeamScoreRepository;
import com.solvd.secondBlock.persistence.connection.ConnectionPool;

import java.sql.*;

public class TeamScoreRepositoryImpl implements TeamScoreRepository {
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

    private static final String CREATE_QUERY = "INSERT INTO team_scores(team_points, team_time) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE team_scores SET team_points=?, team_time=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM team_scores WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM team_scores WHERE id=?";

    @Override
    public void create(TeamScore teamScore) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, teamScore.getTeamPoints());
            preparedStatement.setTime(2, teamScore.getTeamTime());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                teamScore.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, TeamScore updatedTeamScore) throws InterruptedException, SQLException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setLong(1, updatedTeamScore.getTeamPoints());
            preparedStatement.setTime(2, updatedTeamScore.getTeamTime());
            preparedStatement.setLong(3, id);

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
    public TeamScore findById(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapTeamScore(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    private TeamScore mapTeamScore(ResultSet resultSet) throws SQLException {
        Long teamScoreId = resultSet.getLong("id");
        int teamPoints = resultSet.getInt("team_points");
        Time teamTime = resultSet.getTime("team_time");
        return new TeamScore(teamScoreId, teamPoints, teamTime);
    }

}
