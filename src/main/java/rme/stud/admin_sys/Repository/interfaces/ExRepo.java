package rme.stud.admin_sys.Repository.interfaces;

import rme.stud.admin_sys.Model.Student;

import java.util.List;

public interface ExRepo {
    // CRUD operations
    boolean create(Student student);

    Student read(int id);

    List<Student> readAll();

    boolean update(Student student);

    boolean delete(int id);
}