package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Editora {
	private int id;
	private String editora;
	
	@Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}

}
