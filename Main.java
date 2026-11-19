
import javax.swing.SwingUtilities;

import config.Central;
import config.tabelas_base.*;
import screens.*;

public class Main {
	
	public static void criarUsuTeste() {
		Central central =Central.obterInstancia();
		
		Jogador jogUm = new Jogador("Hafiki","hg@gmail.com","senhaForte");
		Jogador jogDois = new Jogador("Matheus","teteu@gmail.com","senhaSuperForte");
		Jogador JogTres= new Jogador("vitinho","vitaozao@gmail.com","senhaMegaForte");
		Administrador admUnico = new Administrador("HMV administracoes","AdmLegal@gmail.com","MaiorSenhaDaHistoria");
		
		central.registrarJogador(admUnico);
		central.registrarJogador(jogUm);
		central.registrarJogador(jogDois);
		central.registrarJogador(JogTres);
	}
	
	
	
	
	
	public static void main (String[] args) {
		criarUsuTeste();
        SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));
        
        
        
	}
}
