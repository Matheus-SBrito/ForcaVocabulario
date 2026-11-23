package screens.cadatrarNovo;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import screens.menuInicial.MenuInicial;

public class CadastrarNovo extends JFrame {

    private JFrame telaAnterior;

    public CadastrarNovo(JFrame telaAnterior) {
        this.telaAnterior = telaAnterior;

        setTitle("Cadastro Concluído");
        setSize(360, 180);
        setResizable(false);
        setLocationRelativeTo(telaAnterior);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        adicionarComponentes();

        // Bloqueia a tela de cadastro enquanto esta janela estiver aberta
        if (telaAnterior != null) {
            telaAnterior.setEnabled(false);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    CadastrarNovo.this.telaAnterior.setEnabled(true);
                }
            });
        }
    }

    private void adicionarComponentes() {
        JLabel lblMensagem = new JLabel("O que deseja fazer agora?", SwingConstants.CENTER);
        lblMensagem.setFont(new Font("Arial", Font.BOLD, 14));
        lblMensagem.setBounds(20, 25, 310, 30);
        add(lblMensagem);

        JButton btnNovoJogador = new JButton("Cadastrar novo");
        btnNovoJogador.setBounds(30, 80, 140, 35);
        btnNovoJogador.addActionListener(e -> dispose()); // volta para a tela de cadastro (campos já limpos)
        add(btnNovoJogador);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(185, 80, 130, 35);
        btnSair.addActionListener(e -> {
            dispose();
            if (telaAnterior != null) {
                telaAnterior.dispose();
            }
            MenuInicial.obterInstancia().setVisible(true);
        });
        add(btnSair);
    }
}
