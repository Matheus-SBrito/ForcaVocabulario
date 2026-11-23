package screens.rankingGlobal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import screens.menuInicial.MenuInicial;

public class ObservadorDoBotaoSair implements ActionListener {
	private JFrame rankingGlobal;

	public ObservadorDoBotaoSair(JFrame rankingGlobal) {
		this.rankingGlobal = rankingGlobal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MenuInicial.obterInstancia().setVisible(true);
		if (rankingGlobal != null) {
			rankingGlobal.dispose();
		}
	}
}
