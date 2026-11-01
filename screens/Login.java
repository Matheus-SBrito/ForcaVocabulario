package screens;
import javax.swing.JFrame;


public class Login extends JFrame {
	
	
	public void desenhoPadrao () {
		this.setTitle("Login");
		
		int[] tamanhoTela = UtilScreens.obterTamanhosDaTela();
		this.setSize(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	

}
