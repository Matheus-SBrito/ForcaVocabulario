package config;

import java.util.ArrayList;
import config.tabelas_base.Usuario;
import config.tabelas_base.Partida;

public class Central {
	
	private ArrayList<Usuario> jogadores = new ArrayList<Usuario> ();
	private ArrayList<Partida> partidas = new ArrayList<Partida> ();
	
	
	/*
	 * ----------------------------
	 * Manipulação Básica dos Dados
	 * - Sem persistencia.
	 * ----------------------------
	 */
	
	// Funções Auxiliares
	
	private boolean usuarioJaCadastrado (Usuario obj) {
		int indice_instancia = jogadores.indexOf(obj);
		return (indice_instancia >= 0)? true : false;
	}
	

	
	// --- CRUD - Sem Persistencia ---
	
	
	// Consultar
	public ArrayList<Usuario> copiaListaDeJogadores (){
		ArrayList<Usuario> copia = (ArrayList<Usuario>) jogadores.clone();
		return copia;
	}
	
	
	public Usuario recuperarJogadorPorNome(String nomeJogador) {
		for (Usuario usuario : jogadores) 
			if (usuario.getNomeDeUsuario().equals(nomeJogador))
				return usuario;
		return null;
	}
	
	
	public Usuario recuperarJogadorPorEmail(String email) {
		for (Usuario usuario : jogadores) 
			if (usuario.getEmail().equals(email))
				return usuario;
		return null;
	}
	
	
	// Registrar
	public void registrarJogador (Usuario obj) {
		if (!usuarioJaCadastrado(obj))
			jogadores.add(obj);
	}
	
	
	// Update
	
	
	// Deletar
	public void
	
	
	
	
}
