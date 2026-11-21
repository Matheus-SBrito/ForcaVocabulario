package screens.observadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import screens.Jogar;

public class ObservadorDoBotaoJogar implements ActionListener {

		private JFrame menuInicial;
	    

		public ObservadorDoBotaoJogar(JFrame menuInicial) {
	        this.menuInicial = menuInicial;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        Jogar telaJogar = new Jogar();
	        telaJogar.setVisible(true);

	        if (menuInicial != null) {
	            menuInicial.dispose();
	        }
	    }
}
