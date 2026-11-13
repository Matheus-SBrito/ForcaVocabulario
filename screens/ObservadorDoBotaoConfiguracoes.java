package screens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ObservadorDoBotaoConfiguracoes implements ActionListener {
    private JFrame menuInicial;
    

    public ObservadorDoBotaoConfiguracoes(JFrame menuInicial){
        this.menuInicial = menuInicial;
    }
     
    @Override 
    public void actionPerformed(ActionEvent e){
        Configuracoes tela = new Configuracoes();
        tela.setVisible(true);
        if(menuInicial != null){
            menuInicial.dispose();
        }
    }
}
