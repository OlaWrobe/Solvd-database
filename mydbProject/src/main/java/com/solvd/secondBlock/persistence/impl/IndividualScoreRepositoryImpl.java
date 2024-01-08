package com.solvd.secondBlock.persistence.impl;

import com.solvd.secondBlock.model.IndividualScore;
import com.solvd.secondBlock.persistence.IndividualScoreRepository;
import com.solvd.secondBlock.persistence.connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndividualScoreRepositoryImpl implements IndividualScoreRepository {
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

    private static final String CREATE_QUERY = "INSERT INTO individual_scores(time,points,distance) VALUES (?, ?,?)";
    private static final String UPDATE_QUERY = "UPDATE individual_scores SET time=?, points=?, distance=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM individual_scores WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM individual_scores WHERE id=?";
    private static final String FIND_BY_PARTICIPANT_ID_QUERY = "SELECT ins.id, ins.participant_id, ins.game_id, ins.time, ins.points, ins.distance " +
            "FROM individual_scores ins left join participants p ON ins.participant_id = p.id " +
            "where p.id=?";

    @Override
    public void create(IndividualScore individualScore) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTime(1, individualScore.getTime());
            preparedStatement.setLong(2, individualScore.getPoints());
            preparedStatement.setDouble(3, individualScore.getDistance());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                individualScore.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, IndividualScore updatedIndividualScore) throws InterruptedException, SQLException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setTime(1, updatedIndividualScore.getTime());
            preparedStatement.setLong(2, updatedIndividualScore.getPoints());
            preparedStatement.setDouble(3, updatedIndividualScore.getDistance());
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

    @Override
    public IndividualScore findById(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapIndividualScore(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    public List<IndividualScore> findIndividualScoresById(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        List<IndividualScore> individualScoreList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PARTICIPANT_ID_QUERY)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                individualScoreList.add(mapIndividualScore(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return individualScoreList;
    }

    private IndividualScore mapIndividualScore(ResultSet resultSet) throws SQLException {
        Long individualScoreId = resultSet.getLong("id");
        Time time = resultSet.getTime("time");
        Integer points = resultSet.getInt("points");
        float distance = resultSet.getFloat("distance");
        return new IndividualScore(individualScoreId, time, points, distance);
    }
}
