package com.solvd.secondBlock.persistence.Impl;

import com.solvd.secondBlock.model.Venue;
import com.solvd.secondBlock.persistence.ConnectionPool;
import com.solvd.secondBlock.persistence.VenueRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VenueRepositoryImpl implements VenueRepository {
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

    private static final String FIND_ALL_QUERY = "Select " +
            "v.id as venue_id, v.name as venue_name, c.address as venue_address, c.capacity as venue_capacity " +
            "From venues v ";

    @Override
    public void create(Venue venue) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement("Insert into venues(name,address,capacity) values (?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, venue.getName());
            preparedStatement.setString(2, venue.getAddress());
            preparedStatement.setInt(3, venue.getCapacity());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                venue.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Venue> findAll() throws InterruptedException {
        List<Venue> venues = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Venue venue = mapVenue(resultSet);
                venues.add(venue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
            return venues;
        }
    }

    @Override
    public void updateById(int id, Venue updatedVenue) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE venues SET name=?, address=?, capacity=? WHERE id=?")) {
            preparedStatement.setString(1, updatedVenue.getName());
            preparedStatement.setString(2, updatedVenue.getAddress());
            preparedStatement.setInt(3, updatedVenue.getCapacity());
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM venues WHERE id=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Venue findById(int id) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM venues WHERE id=?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapVenue(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    private Venue mapVenue(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("venue_id");
        String name = resultSet.getString("venue_name");
        String address = resultSet.getString("venue_address");
        int capacity = resultSet.getInt("venue_capacity");

        return new Venue(id, name, address, capacity);
    }
}
