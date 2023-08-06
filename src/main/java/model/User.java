package model;

import java.util.List;

public class User {
	private int id;
	private String name;
	private boolean isActive;
	
	public User(int id, String name, boolean isActive, List<String> skills) {
		super();
		this.id = id;
		this.name = name;
		this.isActive = isActive;
	}
	
	public User() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", isActive=" + isActive + "]";
	}
	
}
