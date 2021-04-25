package Evizinhotest2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="conduser")
public class GamerUser extends AbstractUser{
	
	@Column(nullable = false)
	private String bairro;
	
	@Column
	private String bio;
    

    public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	public GamerUser(){}
}
