package config;

import java.util.ArrayList;
import config.tabelas_base.Usuario;
import config.tabelas_base.Partida;

import java.util.Map;


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
		
		
		public Usuario recuperarJogadorPorNome(String nomeDeUsuario) {
			SearchUsuarioUnique pesquisa = new SearchUsuarioUnique(
				Map.of("nomeDeUsuario", nomeDeUsuario));
			
			if (usuarioJaCadastrado(pesquisa))
				return jogadores.get(
						jogadores.indexOf(pesquisa)
				);
			
			return null;
		}
		
		
		public Usuario recuperarJogadorPorEmail(String email) {
			SearchUsuarioUnique pesquisa = new SearchUsuarioUnique(
					Map.of("email", email));
			
			if (usuarioJaCadastrado(pesquisa))
				return jogadores.get(
					jogadores.indexOf(pesquisa)
				);
				
			return null;
		}
	
	
	// Registrar
		
		public void registrarJogador (Usuario obj) {
			if (!usuarioJaCadastrado(obj))
				jogadores.add(obj);
		}
	
	
	// Update
		
		public void updateJogador (Usuario obj) throws Exception{
			SearchUsuarioUnique pesquisaNomeDeUsuario = new SearchUsuarioUnique(
				Map.of("nomeDeUsuario", obj.getNomeDeUsuario())
			) ;
			
			if (usuarioJaCadastrado(pesquisaNomeDeUsuario)) {
				// Processo de atualização
				int posicaoRegistro = jogadores.indexOf(obj);
				Usuario usuarioNaoAtualizado = jogadores.get(posicaoRegistro);
				
				// Garantido que o email continue o mesmo
				obj.setEmail(usuarioNaoAtualizado.getEmail());
				
				
				jogadores.set(posicaoRegistro, obj); // Atualizando a lista.
			}
	}
	
	
	// Deletar
		
		public void removendoJogador (SearchUsuarioUnique Obj) {
			jogadores.remove(Obj);
		}
		
	
	
	/*
	 * ------------------------------------
	 * Classe para pesquisa de um usuário
	 * Através do email ou do nomeDeUsuario
	 * ------------------------------------
	 */
	
	public class SearchUsuarioUnique extends Usuario{
		
		public SearchUsuarioUnique(Map<String, String> kwargs) {
			setEmail(kwargs.get("email"));
			setNomeDeUsuario(kwargs.get("nomeDeUsuario"));	
		}
		
		
		
		
	}
	
}
