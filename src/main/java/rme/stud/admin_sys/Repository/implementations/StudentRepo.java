package rme.stud.admin_sys.Repository.implementations;

import rme.stud.admin_sys.Model.Student;
import rme.stud.admin_sys.Repository.interfaces.ExRepo;
import rme.stud.admin_sys.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements ExRepo {
    private Connection conn;

    public StudentRepo() throws ClassNotFoundException {
        try {
            this.conn = DatabaseConnectionManager.getDatabaseConnection();
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }
    @Override
    public Student create(Student student) {
        Student studentToCreate = new Student();
        try {
            PreparedStatement createStudent = conn.prepareStatement("INSERT INTO student (id,fornavn,efternavn,dato,cpr) VALUES (?,?,?,?,?)");


            createStudent.setInt(1, student.getId());
            createStudent.setString(2, student.getFornavn());
            createStudent.setString(3, student.getEfternavn());
            createStudent.setString(4, student.getDato());
            createStudent.setInt(5, student.getCpr());

            createStudent.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentToCreate;
    }

    @Override
    public Student read(int id) {
        Student studentToReturn = new Student();
        try {
            PreparedStatement getSingleStudent = conn.prepareStatement("SELECT * FROM student WHERE student_id=?");
            ResultSet rs = getSingleStudent.executeQuery();
            while(rs.next()){
                studentToReturn = new Student();
                studentToReturn.setId(rs.getInt(1));
                studentToReturn.setFornavn(rs.getString(2));
                studentToReturn.setEfternavn(rs.getString(3));
                studentToReturn.setDato(rs.getString(4));
                studentToReturn.setCpr(rs.getInt(5));
            }
            conn.close();
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return studentToReturn;
    }

    @Override
    public List<Student> readAll() {
        List<Student> allStudents = new ArrayList<Student>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM student");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student tempStudent = new Student();
                tempStudent.setId(rs.getInt(1));
                tempStudent.setFornavn(rs.getString(2));
                tempStudent.setEfternavn(rs.getString(3));
                tempStudent.setDato(rs.getString(4));
                tempStudent.setCpr(rs.getInt(5));
                allStudents.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStudents;
    }

    @Override
    public Student update(Student student) {
        Student studentToUpdate = new Student();
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE student SET fornavn = ?, efternavn = ?,dato =?, cpr =? WHERE id =?");

            statement.setString(1, student.getFornavn());
            statement.setString(2, student.getEfternavn());
            statement.setString(3, student.getDato());
            statement.setInt(4, student.getCpr());
            statement.setInt(5, student.getId());


            statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return studentToUpdate;
    }

    @Override
    public Student delete(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM student WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return new Student();
    }
}