package screens.cadastrarJogador;
import java.awt.event.*;
import javax.swing.JFrame;

import screens.cadatrarNovo.CadastrarNovo;
import screens.menuInicial.MenuInicial;

public class ObservadorDoBotaoCadastrar implements ActionListener{
	private JFrame telaAtual;

    public ObservadorDoBotaoCadastrar(JFrame telaAtual) {
        this.telaAtual = telaAtual;
        }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		CadastrarNovo novoCadastro = new CadastrarNovo();
		novoCadastro.setVisible(true);
		// TODO Auto-generated method stub
		
	}

}
