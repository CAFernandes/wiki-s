package model;

public class UserInfo {
	private boolean logado;
	private String user;
	private String senha;
	
	public UserInfo(String user, String senha) {
		setUser(user);
		setsenha(senha);
		setLogado(false);
	}

	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getsenha() {
		return senha;
	}
	public void setsenha(String senha) {
		this.senha = senha;
	}
}
