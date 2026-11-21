package screens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ObservadorDoBotaoRankingGlobal implements ActionListener{
    private JFrame menuInicial;
    
    public ObservadorDoBotaoRankingGlobal(JFrame menuInicial){
        this.menuInicial = menuInicial;
    }
    @Override 
    public void actionPerformed(ActionEvent e){
        RankingGlobal tela = new RankingGlobal();
        tela.setVisible(true);
        if(menuInicial != null){
            menuInicial.dispose();
        }

    }
}
