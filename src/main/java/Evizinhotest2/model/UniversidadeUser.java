package Evizinhotest2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="conduser")
public class UniversidadeUser extends AbstractUser{

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String name;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public UniversidadeUser(){}
}