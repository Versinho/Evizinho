package Evizinhotest2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import Evizinhotest2.strategy.Post;

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
}
