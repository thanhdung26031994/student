package org.example.student.service;

import org.example.student.config.DBConnection;
import org.example.student.model.Class;
import org.example.student.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{
    private static final String SELECT_STUDENT = "select student.* , class.name as nameClass from student join class on class.c_id = student.c_id;";
    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList =new ArrayList<>();
        Connection connection;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(SELECT_STUDENT);
            rs = statement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Integer idClass = rs.getInt("c_id");
                String nameClass = rs.getString("nameClass");
                Class aClass = new Class(idClass, nameClass);
                studentList.add(new Student(id, name, email, address, aClass));
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
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("insert into student values (?,?,?,?,?);");
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getAddress());
            statement.setInt(5, student.getaClass().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
