package Evizinhotest2.model;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="CPost")
public class UnivPost extends Post<UnivUser>{
	
	@Column
	private String platform;
	
	@Column
	private String genre;
	
	@Column
	private float price;
	
	@Column
	private String condition;
	
	
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public UnivPost() {
		//empty
	}
	@Override
	public Boolean verify() {
		ArrayList<String> platforms = this.acceptablePlatforms();
		ArrayList<String> genres = this.acceptableGenres();
		if(!platforms.contains(this.platform)) {
			return false;
		}
		else if(!genres.contains(this.genre)) {
			return false;
		}
		else if(!(this.condition.equals("novo") || this.condition.equals("usado"))) {
			return false;
		}
		else if(this.price == 0.0f) {
			return false;
		}
		return true;
	}
	
	public ArrayList<String> acceptablePlatforms(){
		ArrayList<String> platforms = new ArrayList<>();
		platforms.add("ps4");
		platforms.add("ps3");
		platforms.add("xboxone");
		platforms.add("xbox360");
		platforms.add("nintendoswitch");
		platforms.add("pc");
		platforms.add("outro");
		return platforms;
	}
	public ArrayList<String> acceptableGenres(){
		ArrayList<String> genres = new ArrayList<>();
		genres.add("acao");
		genres.add("aventura");
		genres.add("rpg");
		genres.add("estrategia");
		genres.add("esporte");
		genres.add("corrida");
		genres.add("simulacao");
		return genres;
	}
}
