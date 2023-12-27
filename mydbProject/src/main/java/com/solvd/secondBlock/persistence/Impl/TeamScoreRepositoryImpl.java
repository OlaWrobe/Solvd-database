package com.solvd.secondBlock.persistence.Impl;

import com.solvd.secondBlock.model.Game;
import com.solvd.secondBlock.model.TeamScore;
import com.solvd.secondBlock.persistence.ConnectionPool;
import com.solvd.secondBlock.persistence.TeamScoreRepository;

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

    private static final String CREATE_QUERY = "INSERT INTO team_scores(game_id, team_id, team_points, team_time) VALUES (?,?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE team_scores SET game_id=?, team_id=?, team_points=?, team_time=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM team_scores WHERE id=?";
    //private static final String FIND_BY_ID_QUERY = "SELECT * FROM team_scores WHERE id=?";

    @Override
    public void create(TeamScore teamScore, Game game) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, teamScore.getGame().getId());
            preparedStatement.setLong(2, teamScore.getTeam().getId());
            preparedStatement.setInt(3, teamScore.getTeam_points());
            preparedStatement.setTime(4, teamScore.getTeam_time());

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
    public void updateById(int id, TeamScore updatedTeamScore) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setLong(1, updatedTeamScore.getTeam().getId());
            preparedStatement.setInt(2, updatedTeamScore.getTeam_points());
            preparedStatement.setTime(3, updatedTeamScore.getTeam_time());
            preparedStatement.setLong(4, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }

    @Override
    public void deleteById(int id) throws InterruptedException {
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

}
