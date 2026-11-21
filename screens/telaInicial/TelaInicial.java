package screens.telaInicial;

import screens.TelaBase;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaInicial extends TelaBase {
	private JButton btnPlay;

	public TelaInicial() {
		super(); // janela, título e imagem da forca vêm da TelaBase
		criarBotaoPlay();
		gerarObservadores();
	}

	private void criarBotaoPlay() {
		btnPlay = new JButton();
		btnPlay.setBounds(205, 280, 390, 120);
		btnPlay.setLayout(new GridLayout(1, 5, 15, 0));
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(false);
		btnPlay.setFocusPainted(false);
		btnPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnPlay);
		String[] letras = { "P", "l", "a", "y", "!" };
		for (String letra : letras) {
			JLabel lbl = new JLabel(letra, SwingConstants.CENTER);
			lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
			lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK)); // traço embaixo
			btnPlay.add(lbl);
		}
	}

	private void gerarObservadores() {
		btnPlay.addActionListener(new ObservadorDoBotaoPlay(this));
		btnPlay.addMouseListener(new ObservadorHoverDoBotaoPlay(btnPlay));
	}
}