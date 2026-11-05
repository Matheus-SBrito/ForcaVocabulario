package screens;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;

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
		
		this.setVisible(true);
	};
	
	
	public static Login obterInstancia () {
		if (INSTANCIA == null)
			INSTANCIA = new Login();
		
		return INSTANCIA;
			
	}
	
	
	
	
	/*
	 * -------------------------------
	 * Construção das Telas e Design
	 * 			'Responsivo'
	 * -------------------------------
	 */
	
	private void configuracao () { // Configurações Básicas da tela
		int[] tamanhoTela = UtilScreens.obterTamanhosDaTela();
		this.setTitle("Login");
		this.setSize(tamanhoTela[0], tamanhoTela[1]);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
	}
	

	private void adicaoDeMargens() {
		// -- Construção do fundo, Margens do painel --
		
		JPanel margenEsquerda = new JPanel();
			margenEsquerda.setPreferredSize(new Dimension(250, 0));
			margenEsquerda.setBackground(UtilScreens.LARANJA);
		JPanel margenDireita = new JPanel();
			margenDireita.setPreferredSize(new Dimension(250, 0));
			margenDireita.setBackground(UtilScreens.LARANJA);
				
		JPanel margenAcima = new JPanel();
			margenAcima.setPreferredSize(new Dimension(0, 100));
			margenAcima.setBackground(UtilScreens.LARANJA);
		JPanel margenAbaixo = new JPanel();
			margenAbaixo.setPreferredSize(new Dimension(0, 100));
			margenAbaixo.setBackground(UtilScreens.LARANJA);
		
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
	

}
