package Evizinhotest2.model;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="CPost")
public class CondominoPost extends Post{
	
	@Column
	private String details;
	
	@Column
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
		ArrayList<String> categorys = new ArrayList<>();
		categorys.add("venda");
		categorys.add("troca");
		categorys.add("servico");
		
		if(!categorys.contains(this.category)) {
			return false;
		}
		else if(this.title == null || this.details == null || this.user == null) {
			return false;
		}
		else if(this.title == "" || this.details == "") {
			return false;
		}
		return true;
		
	}
}
