package com.solvd.secondBlock.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private volatile static ConnectionPool instance;
    BlockingQueue<Connection> conns;

    private ConnectionPool(int poolSize) throws InterruptedException, SQLException {
        this.conns = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "NewPassword");
            conns.put(connection);

        }
    }

    public synchronized static ConnectionPool getInstance(int size) throws SQLException, InterruptedException {
        if (instance == null) {
            instance = new ConnectionPool(size);
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return conns.take();
    }

    public void releaseConnection(Connection con) {
        conns.offer(con);
    }
}
