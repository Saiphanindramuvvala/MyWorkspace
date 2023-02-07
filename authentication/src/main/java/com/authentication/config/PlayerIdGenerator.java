package com.authentication.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.function.Function;

public class PlayerIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "MS-";
        int n = 100;
        Connection connection = session.connection();

        Function<Connection, String> sequenceLmbda = c -> {
            try {
                Statement statement = c.createStatement();
                ResultSet resultSet = statement.executeQuery("select count(id) from player_tbl");
                if (resultSet.next()) {
                    Integer id = n + resultSet.getInt(1) + 1;
                    return id.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        };

        return prefix + sequenceLmbda.apply(connection);
    }

}