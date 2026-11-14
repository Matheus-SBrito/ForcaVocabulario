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
	        getContentPane().setPreferredSize(new Dimension(800, 600));
	        getContentPane().setBackground(Color.YELLOW);
	        setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        pack();                       // ajusta o tamanho da área útil (sem contar a barra de título)
	        setLocationRelativeTo(null);  // centraliza DEPOIS do pack
	    }

	    private void criarTitulo() {
	        JLabel lblTitulo = new JLabel("Jogo da Forca!!", SwingConstants.CENTER);
	        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
	        lblTitulo.setBounds(0, 60, 880, 60);
	        add(lblTitulo);
	    }

	    private void criarImagemForca() {
	        ImageIcon original = new ImageIcon(getClass().getResource("forcaBonecoCompleto.png"));
	        Image redimensionada = original.getImage().getScaledInstance(-1, 420, Image.SCALE_SMOOTH);
	        ImageIcon icone = new ImageIcon(redimensionada);

	        JLabel lblForca = new JLabel(icone);
	        lblForca.setBounds(20, 80, icone.getIconWidth(), icone.getIconHeight());
	        add(lblForca);
	    }
	    
	  

	    private void criarBotaoPlay() {
	    	    btnPlay = new JButton();
	    	    btnPlay.setBounds(240, 280, 390, 120);
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
	        btnPlay.addMouseListener(new ObsHoverPlay(btnPlay));
	    }
	
}
