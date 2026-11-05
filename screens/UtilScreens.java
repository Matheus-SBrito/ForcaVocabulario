package screens;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class UtilScreens {
	
	public static final Color LARANJA = new Color(255, 145, 77);
	public static final Color LARANJA_CLARO = new Color(255, 190, 122);

	private UtilScreens() {};
	
	public static int[] obterTamanhosDaTela() {
		// Obtém a ferramenta padrão do sistema
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
     // Captura a dimensão da tela principal
        Dimension screenSize = toolkit.getScreenSize();
        
        int largura = screenSize.width / 2;
        int altura = screenSize.height / 2 ;
        
        return new int[] {largura, altura};
	}
	
	
	
}
