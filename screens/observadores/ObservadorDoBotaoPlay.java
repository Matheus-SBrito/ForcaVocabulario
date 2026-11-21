package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ObservadorDoBotaoPlay implements ActionListener{
	 private JFrame telaInicial;

	    public ObservadorDoBotaoPlay(JFrame telaInicial) {
	        this.telaInicial = telaInicial;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        Login.obterInstancia();          // próxima tela (o Login já faz setVisible(true))
	        if (telaInicial != null) {
	            telaInicial.dispose();
	        }
	    }
}
