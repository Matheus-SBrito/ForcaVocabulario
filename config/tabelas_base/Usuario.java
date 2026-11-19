package config.tabelas_base;

public class Usuario {
	
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
	
	
	public Usuario() {}


	// Metodos de Visibilidade
	public String getNomeDeUsuario () {return nomeDeUsuario;}
	public void setNomeDeUsuario (String nomeDeUsuario) {this.nomeDeUsuario = nomeDeUsuario;}
	
	public String getEmail () {return email;}
	public void setEmail (String email) {this.email = email;}
	
	public String getSenha () {return senha;}
	public void setSenha (String senha) {this.senha = senha;}
	
	
	@Override
	public String toString () {
		return nomeDeUsuario;}
	
	@Override
	public boolean equals (Object obj) {
		if (obj != null &&  obj instanceof Usuario) {
			
			Usuario dowcase = (Usuario) obj;
			if (
				email.equals(dowcase.getEmail()) || 
				nomeDeUsuario.equals(dowcase.getNomeDeUsuario())
				) return true;}
		
		return false;}
	
	
	

}