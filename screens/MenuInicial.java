package screens;
import javax.swing.JFrame;

public class MenuInicial extends JFrame{
private static MenuInicial INSTANCIA;
	
	private MenuInicial() {
		gerarTela();
		gerarComponentes();
		
		this.setVisible(true);
	};
	
	
	public static MenuInicial obterInstancia () {
		if (INSTANCIA == null)
			INSTANCIA = new MenuInicial();
		
		return INSTANCIA;
			
	}
	
	private void gerarTela(){
		setTitle("TELA INICIAL");
		setSize(800 , 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void gerarComponentes(){
		gerarBotoes();
		gerarObservadores();
		
	}
	
	
}
