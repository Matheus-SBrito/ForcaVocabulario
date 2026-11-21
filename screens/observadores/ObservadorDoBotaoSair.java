package screens.observadores;
import java.awt.event.*;
import javax.swing.JFrame;
import screens.MenuInicial;

public class ObservadorDoBotaoSair implements ActionListener{
	private JFrame cadastrarJogador;
	
	public ObservadorDoBotaoSair(JFrame menuInicial) {
		this.cadastrarJogador = menuInicial;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		MenuInicial telaMenuInicial = new MenuInicial();
		telaMenuInicial.setVisible(true);
		if(cadastrarJogador!= null) {
			cadastrarJogador.dispose();
		}
		// TODO Auto-generated method stub
		
	}

}
