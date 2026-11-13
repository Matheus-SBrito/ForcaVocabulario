package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ObservadorDoBotaoHistoricoDePartidas implements ActionListener {
    
    private JFrame menuInicial;

    public ObservadorDoBotaoHistoricoDePartidas(JFrame menuInicial){
        this.menuInicial = menuInicial;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        HistoricoDePartidas tela = new HistoricoDePartidas();
        tela.setVisible(true);
        if (menuInicial != null) {
            menuInicial.dispose();
        }
    }
}