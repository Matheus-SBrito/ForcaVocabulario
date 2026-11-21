package screens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ObservadorDoBotaoMinhaConta implements ActionListener {
     
    private JFrame menuInicial;

    public ObservadorDoBotaoMinhaConta(JFrame menuInicial){
        this.menuInicial = menuInicial;
    }

    @Override 
    public void actionPerformed(ActionEvent e){
        MinhaConta tela = new MinhaConta();
        tela.setVisible(true);
        if(menuInicial != null){
            menuInicial.dispose();
        }
    }
}
