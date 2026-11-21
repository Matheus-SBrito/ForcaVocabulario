package screens;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class TelaBase extends JFrame {

	public TelaBase() {
		configurarJanela();
		criarTitulo();
		criarImagemForca();
	}

	private void configurarJanela() {
		setTitle("Jogo da Forca");
		setLayout(null);
		setSize(UtilScreens.LARGURA_PADRAO, UtilScreens.ALTURA_PADRAO);
		getContentPane().setBackground(UtilScreens.AMARELO_CLARO);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void criarTitulo() {
		JLabel lblTitulo = new JLabel("Jogo da Forca!!", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblTitulo.setBounds(250, 60, 300, 60);
		add(lblTitulo);
	}

	private void criarImagemForca() {
		ImageIcon original = new ImageIcon(getClass().getResource("/images/forcaBonecoCompleto.png"));
		Image redimensionada = original.getImage().getScaledInstance(-1, 380, Image.SCALE_SMOOTH);
		ImageIcon icone = new ImageIcon(redimensionada);
		JLabel lblForca = new JLabel(icone);
		lblForca.setBounds(0, 120, icone.getIconWidth(), icone.getIconHeight());
		add(lblForca);
	}
}