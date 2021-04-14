package Evizinhotest2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	@Id
	private String role;

	@ManyToMany(mappedBy = "roles")
    private List<AbstractUser> users;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public List<AbstractUser> getUsuarios() {
		return users;
	}

	public void setUsuarios(List<AbstractUser> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.role;
	}
	
	
}
