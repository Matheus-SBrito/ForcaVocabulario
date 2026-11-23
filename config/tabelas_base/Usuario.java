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
	
	// Dois usuários são o "mesmo" se tiverem o mesmo e-mail OU o mesmo nome de usuário.
	@Override
	public boolean equals (Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Usuario)) return false;

		Usuario outro = (Usuario) obj;
		return iguaisNaoVazios(email, outro.getEmail())
			|| iguaisNaoVazios(nomeDeUsuario, outro.getNomeDeUsuario());
	}

	// Como equals usa "OU", o único hashCode consistente é um valor constante.
	@Override
	public int hashCode () {
		return 1;
	}

	private static boolean iguaisNaoVazios (String a, String b) {
		return a != null && !a.isEmpty() && a.equals(b);
	}

}
