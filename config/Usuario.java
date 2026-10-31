package config;

public abstract class Usuario {
	
	private String nomeDeUsuario;
	private String email;
	private String senha;
	
	
	public Usuario (
			String nomeDeUsuario,
			String email,
			String senha
			) {
		
		this.nomeDeUsuario = nomeDeUsuario;
		this.email = email;
		this.senha = senha;
		
	}
	
	
	// Metodos de Visibilidade
	public String getNomeDeUsuario () {return nomeDeUsuario;}
	public void setNomeDeUsuario (String nomeDeUsuario) {this.nomeDeUsuario = nomeDeUsuario;}
	
	public String getEmail () {return email;}
	public void setEmail (String email) {this.email = email;}
	
	public String getSenha () {return senha;}
	public void setSenha (String senha) {this.senha = senha;}
	
	

}