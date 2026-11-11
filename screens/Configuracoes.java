package screens;

import javax.swing.*;
import java.awt.*;

public class Configuracoes extends JFrame {

    public Configuracoes() {
        inicializarJanela();
        criarComponentes();
    }

    private void inicializarJanela() {
        setTitle("Jogar");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void criarComponentes() {
        JLabel lblTitulo = new JLabel("Configuracoes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitulo, BorderLayout.CENTER);
    }
}
