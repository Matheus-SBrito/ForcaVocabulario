package screens;
import javax.swing.JFrame;

public class MenuInicial extends JFrame{
private static MenuInicial INSTANCIA;
	
	private MenuInicial() {
		
		
		this.setVisible(true);
	};
	
	
	public static MenuInicial obterInstancia () {
		if (INSTANCIA == null)
			INSTANCIA = new MenuInicial();
		
		return INSTANCIA;
			
	}
	
	
	
	
}
