package model;


public class Editora {
	private int id;
	private String editora;
	
	public Editora () {
		
	}
	
	public Editora(String editora) {
		setEditora(editora);
	}

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
