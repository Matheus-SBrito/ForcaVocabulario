package screens;

import javax.swing.*;
import java.awt.*;

public class RankingGlobal extends JFrame {

    public RankingGlobal() {
        inicializarJanela();
        criarComponentes();
    }

    private void inicializarJanela() {
        setTitle("Ranking Global");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void criarComponentes() {
        JLabel lblTitulo = new JLabel("Ranking Global", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitulo, BorderLayout.CENTER);
    }
}