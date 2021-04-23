package Evizinhotest2.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="CPost")
public class CondominoPost extends Post{
	

	@Column
	private String date;
	
	@Column
	private String title;
	
	@Column
	private String details;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public CondominoPost() {
		//empty
	}
	@Override
	public Boolean verify() {
		return true;
		
	}
}
