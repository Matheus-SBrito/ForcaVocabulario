import config.Central;
import config.Persistencia;
import config.tabelas_base.Administrador;
import config.tabelas_base.Jogador;


public class Teste {
	
	public static void main (String[] args) {
		
		Central central = Central.obterInstancia();
		
		Jogador jogUm = new Jogador("Hafiki","hg@gmail.com","senhaForte");
		Jogador jogDois = new Jogador("Matheus","teteu@gmail.com","senhaSuperForte");
		Jogador jogTres = new Jogador("vitinho","vitaozao@gmail.com","senhaMegaForte");
		Administrador admUnico = new Administrador("HMV administracoes","AdmLegal@gmail.com","MaiorSenhaDaHistoria");
		
		// Antes os usuários eram criados mas nunca registrados, então salvava uma Central vazia
		central.registrarJogador(admUnico);
		central.registrarJogador(jogUm);
		central.registrarJogador(jogDois);
		central.registrarJogador(jogTres);
		
		Persistencia persistencia = new Persistencia();
		persistencia.salvarCentral(central);
		
	}
	
}
