package screens;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



// Utilização do padrão Singleton
public class Login extends JFrame {
	
	
	private static Login INSTANCIA;
	
	private Login () {
		
		this.configuracao();
		this.adicaoDeMargens();
		this.painelCaixaLogin();
		this.criarLabelForca();
		
		this.setVisible(true);
	};
	
	
	public static Login obterInstancia () {
		if (INSTANCIA == null)
			INSTANCIA = new Login();
		
		return INSTANCIA;
			
	}
	
	
	
	
	/*
	 * -------------------------------
	 *  Construção dos Componentes de
	 * 			  Design
	 * -------------------------------
	 */
	
	private void configuracao () { // Configurações Básicas da tela
		int[] tamanhoTela = UtilScreens.obterTamanhosDaTela();
		this.setTitle("Login");
		this.setSize(1000, 1000);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
	}
	

	private void adicaoDeMargens() {
		// -- Construção do fundo, Margens do painel --
		
		JPanel margenEsquerda = new JPanel();
			margenEsquerda.setMaximumSize(new Dimension(500, 0));
			margenEsquerda.setMinimumSize(new Dimension(200, 0));
			margenEsquerda.setBackground(UtilScreens.AMARELO_CLARO);
			margenEsquerda.add(criarLabelForca(), BorderLayout.CENTER);
		JPanel margenDireita = new JPanel();
			margenDireita.setPreferredSize(new Dimension(250, 0));
			margenDireita.setBackground(UtilScreens.AMARELO_CLARO);
				
		JPanel margenAcima = new JPanel();
			margenAcima.setPreferredSize(new Dimension(0, 100));
			margenAcima.setBackground(UtilScreens.AMARELO_CLARO);
		JPanel margenAbaixo = new JPanel();
			margenAbaixo.setPreferredSize(new Dimension(0, 100));
			margenAbaixo.setBackground(UtilScreens.AMARELO_CLARO);
		
		// -- Adicionando ao Painel principal -- 
			
		this.add(margenEsquerda, BorderLayout.WEST);
		this.add(margenDireita, BorderLayout.EAST);
		
		this.add(margenAcima, BorderLayout.NORTH);
		this.add(margenAbaixo, BorderLayout.SOUTH);
	}
	
	
	private void painelCaixaLogin () {
		
		JPanel painelLogin = new JPanel();
			painelLogin.setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 1)
				);
		
		painelLogin.setBackground(UtilScreens.LARANJA_CLARO);
		
		
		
		this.add(painelLogin, BorderLayout.CENTER);
	}
	
	private JLabel criarLabelForca() {
		ImageIcon forca = new ImageIcon(getClass().getResource("/images/forcaBonecoCompleto.png"));	
	    Image redimensionada = forca.getImage().getScaledInstance(-1, 500, Image.SCALE_SMOOTH);
	    JLabel label = new JLabel(new ImageIcon(redimensionada));
	    label.setHorizontalAlignment(JLabel.CENTER);
	    return label;
	   
		
	}
	

}
