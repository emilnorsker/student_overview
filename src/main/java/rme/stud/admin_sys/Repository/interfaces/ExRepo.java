package rme.stud.admin_sys.Repository.interfaces;

import rme.stud.admin_sys.Model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ExRepo {
    // CRUD operations
    Student create(Student student) throws SQLException;

    Student read(int id);

    List<Student> readAll();

    boolean update(Student student);

    Student delete(int id);
}