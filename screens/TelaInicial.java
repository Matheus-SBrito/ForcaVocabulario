package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import screens.observadores.*;


public class TelaInicial extends JFrame{
	 private JButton btnPlay;
	 
	 public TelaInicial() {
		  configurarJanela();
	        criarTitulo();
	        criarImagemForca();
	        criarBotaoPlay();
	        gerarObservadores();
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
	    
	  

	    private void criarBotaoPlay() {
	    	    btnPlay = new JButton();
	    	    btnPlay.setBounds(205, 280, 390, 120);
	    	    btnPlay.setLayout(new GridLayout(1, 5, 15, 0));   // 5 colunas, 15 px de espaço entre elas
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
