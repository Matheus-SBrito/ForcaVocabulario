package screens;

import javax.swing.*;
import java.awt.*;

public class HistoricoDePartidas extends JFrame {

    public HistoricoDePartidas() {
        inicializarJanela();
        criarComponentes();
    }

    private void inicializarHistoricoDePartidasJanela() {
        setTitle("Historico De Partidas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void criarComponentes() {
        JLabel lblTitulo = new JLabel("Historico de partidas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitulo, BorderLayout.CENTER);
    }
}