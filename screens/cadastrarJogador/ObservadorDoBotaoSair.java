package screens.cadastrarJogador;
import java.awt.event.*;
import javax.swing.JFrame;

import screens.menuInicial.MenuInicial;

public class ObservadorDoBotaoSair implements ActionListener{
	private JFrame cadastrarJogador;
	
	public ObservadorDoBotaoSair(JFrame cadastrarJogador) {
		this.cadastrarJogador = cadastrarJogador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MenuInicial.obterInstancia().setVisible(true);
		if(cadastrarJogador!= null) {
			cadastrarJogador.dispose();
		}
	}

}
