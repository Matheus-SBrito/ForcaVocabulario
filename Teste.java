import config.Central;
import config.Persistencia;
import config.tabelas_base.Administrador;
import config.tabelas_base.Jogador;


public class Teste {
	
	public static void main (String[] agrs) {
		
		Central central =Central.obterInstancia();
		
		Jogador jogUm = new Jogador("Hafiki","hg@gmail.com","senhaForte");
		Jogador jogDois = new Jogador("Matheueus","teteu@gmail.com","senhaSuperForte");
		Jogador JogTres= new Jogador("vitinho","vitaozao@gmail.com","senhaMegaForte");
		Administrador admUnico = new Administrador("HMV administracoes","AdmLegal@gmail.com","MaiorSenhaDaHistoria");
		
		Persistencia persistencia = new Persistencia();
		
		persistencia.salvarCentral(central);
		
	}
	
}
