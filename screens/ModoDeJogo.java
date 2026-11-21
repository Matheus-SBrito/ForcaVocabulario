package screens;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Tela de escolha do modo de jogo: partida solo ou multiplayer.
 */
public class ModoDeJogo extends TelaBase {
	private JButton btnSolo;
	private JButton btnMultiplayer;

	public ModoDeJogo() {
		super(); // janela, título e imagem da forca vêm da TelaBase
		criarBotoes();
		gerarObservadores();
	}

	private void criarBotoes() {
		btnSolo = criarBotaoModo("Partida solo", 300, 220, 200, 60);
		btnMultiplayer = criarBotaoModo("Partida Multiplayer", 300, 300, 200, 80);
	}

	private JButton criarBotaoModo(String texto, int x, int y, int largura, int altura) {
		JButton botao = new JButton(texto);
		botao.setBounds(x, y, largura, altura);
		botao.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		botao.setContentAreaFilled(false);
		botao.setFocusPainted(false);
		botao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botao);
		return botao;
	}

	private void gerarObservadores() {
		btnSolo.addActionListener(e -> {
		});
		btnMultiplayer.addActionListener(e -> {
		});
	}
}