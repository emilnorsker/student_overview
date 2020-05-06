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
    public boolean create(Student student) {
        return false;
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
           //     studentToReturn.setDate(rs.getDate(4));
           //     studentToReturn.setCpr(rs.getInt(5));
            }
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
           //     tempStudent.setDate(rs.getDate(4));
            //    tempStudent.setCpr(rs.getInt(5));
                allStudents.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStudents;
    }

    @Override
    public boolean update(Student student) {
        return false;


    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}