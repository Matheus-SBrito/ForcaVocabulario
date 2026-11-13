package screens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ObservadorDoBotaoAtualizarVocabulario implements ActionListener {
    
    private JFrame menuInicial;

    public ObservadorDoBotaoAtualizarVocabulario(JFrame menuInicial){
        this.menuInicial = menuInicial;
    }
    @Override
     public void actionPerformed(ActionEvent e) {
        AtualizarVocabulario tela = new AtualizarVocabulario();
        tela.setVisible(true);
        if(menuInicial != null){
            menuInicial.dispose();
        }
    }
}
