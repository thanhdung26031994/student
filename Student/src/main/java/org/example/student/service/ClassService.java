package org.example.student.service;

import org.example.student.config.DBConnection;
import org.example.student.model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClassService implements IClassService{
    @Override
    public List<Class> findAll() {
        List<Class> classList = new ArrayList<>();
        Connection connection;
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select * from class;");
            rs = statement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("c_id");
                String name = rs.getString("name");
                classList.add(new Class(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return classList;
    }
}
