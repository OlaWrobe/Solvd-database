package com.solvd.secondBlock.persistence.Impl;

import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.connection.ConnectionPool;
import com.solvd.secondBlock.persistence.SportTypeRepository;

import java.sql.*;

public class SportTypeRepositoryImpl implements SportTypeRepository {
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

    private static final String CREATE_QUERY = "INSERT INTO sport_types(name, is_individual) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE sport_types SET name=?, is_individual=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM sport_types WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM sport_types WHERE id=?";
    private static final String FIND_BY_SPORT_ID_QUERY = "SELECT sport_type_id as id, st.name as name, is_individual " +
            "FROM sport_types st join sports s ON s.sport_type_id = st.id " +
            "where s.id = ?";

    @Override
    public void create(SportType sportType) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, sportType.getName());
            preparedStatement.setBoolean(2, sportType.isIndividual());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                sportType.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }

    @Override
    public void updateById(Long id, SportType updatedType) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, updatedType.getName());
            preparedStatement.setBoolean(2, updatedType.isIndividual());
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
    public SportType findById(Long id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapSportType(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public SportType findBySportID(Long sportId) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_SPORT_ID_QUERY)) {
            preparedStatement.setLong(1, sportId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapSportType(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    private SportType mapSportType(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        boolean isIndividual = resultSet.getBoolean("is_individual");

        return new SportType(id, name, isIndividual);
    }
}
