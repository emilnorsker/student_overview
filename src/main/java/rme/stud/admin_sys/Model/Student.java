package rme.stud.admin_sys.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Student {


    @Id
    private int id;
    private String fornavn;
    private String efternavn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dato;
    private int cpr;



    public Student() {
    }

    public Student(int id, String fornavn, String efternavn, Date dato, int cpr){
        this.id = id;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.dato = dato;
        this.cpr = cpr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public Date getDate() {
        return dato;
    }

    public void setDate(Date dato) {
        this.dato = dato;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }
}
