package screens;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CadastrarNovo extends JFrame {

    private JFrame telaAnterior;

    public CadastrarNovo() {
        this.telaAnterior = telaAnterior;

        setTitle("Cadastro Concluído");
        setSize(360, 180);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        adicionarComponentes();
        
    }

    private void adicionarComponentes() {
        JLabel lblMensagem = new JLabel("O que deseja fazer agora?", SwingConstants.CENTER);
        lblMensagem.setFont(new Font("Arial", Font.BOLD, 14));
        lblMensagem.setBounds(20, 25, 310, 30);
        add(lblMensagem);

        JButton btnNovoJogador = new JButton("Cadastrar novo");
        btnNovoJogador.setBounds(30, 80, 140, 35);
        add(btnNovoJogador);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(185, 80, 130, 35);
        add(btnSair);
    }
}