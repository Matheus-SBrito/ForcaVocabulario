package screens;
import java.awt.Dimension;
import java.awt.Toolkit;

public class UtilScreens {
	
	
	public static int[] obterTamanhosDaTela() {
		// Obtém a ferramenta padrão do sistema
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
     // Captura a dimensão da tela principal
        Dimension screenSize = toolkit.getScreenSize();
        
        int largura = screenSize.width;
        int altura = screenSize.height;
        
        return new int[] {largura, altura};
	}
}
