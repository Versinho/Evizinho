package Evizinhotest2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="conduser")
public class CondominioUser extends AbstractUser{

    @Column(nullable = false)
    private String apartment;

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public CondominioUser(){}
}
