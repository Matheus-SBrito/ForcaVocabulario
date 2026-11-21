package screens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ObservadorDoBotaoCadrastarJogador implements ActionListener{
	
	private JFrame menuInicial;
	
	public ObservadorDoBotaoCadrastarJogador(JFrame menuInicial) {
		this.menuInicial = menuInicial;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CadastrarJogador telaCadastrarJogador = new CadastrarJogador();
		telaCadastrarJogador.setVisible(true);
		
		
		if(menuInicial != null) {
			menuInicial.dispose();
		}
		// TODO Auto-generated method stub
		
	}
	

}
