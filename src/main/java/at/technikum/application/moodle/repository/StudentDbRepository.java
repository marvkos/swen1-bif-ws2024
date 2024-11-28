package at.technikum.application.moodle.repository;

import at.technikum.application.moodle.data.ConnectionPool;
import at.technikum.application.moodle.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentDbRepository implements StudentRepository {

    private final static String NEW_STUDENT
            = "INSERT INTO students VALUES (?, ?, ?)";

    private final ConnectionPool connectionPool;

    public StudentDbRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Student save(Student student) {

        try (
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(NEW_STUDENT)
        ) {
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());

            preparedStatement.execute();

            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Optional<Student> find(int id) {
        return Optional.empty();
    }

    @Override
    public Student delete(Student student) {
        return null;
    }
}
