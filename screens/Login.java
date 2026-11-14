package screens;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



// Utilização do padrão Singleton
public class Login extends JFrame {
	
	
	private static Login INSTANCIA;
	
	private Login () {
		this.configuracao();
		this.add(painelCaixaLogin());
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
		
		setTitle("Login");
		setLayout(null);
		setSize(UtilScreens.LARGURA_PADRAO, UtilScreens.ALTURA_PADRAO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Alterando a cor da Janela
		getContentPane().setBackground(UtilScreens.AMARELO_CLARO);
		setLocationRelativeTo(null);
	}
	
	
	// Configuração do Painel, Caixa do login
	private JPanel painelCaixaLogin () {
		
		JPanel caixaLogin = new JPanel();
		
		// -- Configurações basicas do painel --
		caixaLogin.setLayout(null); // Posição
		caixaLogin.setBounds(245, 150, 300, 300); // Cordenadas, Altura e Largura
		caixaLogin.setBackground(UtilScreens.CINZA); // Cor do painel
		
			// Adicção de bordas ao painel
			caixaLogin.setBorder(BorderFactory.createLineBorder(UtilScreens.PRETO));
		
		// -- Texto no Painel -- 
		JLabel textoLogin = new JLabel ("Login", SwingConstants.CENTER); // Texto e Alinhamento
		textoLogin.setFont(new Font(Font.DIALOG, Font.BOLD, 20)); // Fonte, Negrito e Tamanho
		textoLogin.setBounds(0,0,300,40); // Cordenadas e Tamnho da Caixa do Texto
		
			// Adição de borda a caixa do texto
			textoLogin.setBorder(BorderFactory.createLineBorder(UtilScreens.PRETO));
			
			// -- Mensagem de Orientação --
			JPanel fundoOrientacao = new JPanel (); /// Construção da Margen e Fundo
			fundoOrientacao.setLayout(null);
			fundoOrientacao.setBackground(UtilScreens.BRANCO);
			fundoOrientacao.setBorder(BorderFactory.createLineBorder(UtilScreens.PRETO));
			fundoOrientacao.setBounds(3, 50, 294, 50);
				
			// Texto
				JLabel orientacaoLogin = new JLabel (
					"<html>O campo 'username' aceita duas formas de entrada, " +
					"pode ser utilizado tanto o 'email' cadastrado, quanto " +
					"'nome de usuário' atual.<html>"); // Tags Html para o texto 'descer'
				
				orientacaoLogin.setFont(new Font(Font.DIALOG, Font.ITALIC, 12)); // Caracteriscas da fonte
				orientacaoLogin.setBounds(3, 0, 290, 50);
				
			fundoOrientacao.add(orientacaoLogin);
			
		// -- Botões e seus respectivos textos --
		JPanel margemInputs = new JPanel (null);
		
		margemInputs.setBackground(UtilScreens.CINZA);
		margemInputs.setBorder(BorderFactory.createLineBorder(UtilScreens.PRETO));
		margemInputs.setBounds(0, 110, 300, 190);
			
			// -- Campo de Nome do Usuário --
			// Construção do texto
			JLabel nomeUsuarioOuEmail = new JLabel ("Username: ", SwingConstants.LEFT); 
			nomeUsuarioOuEmail.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			nomeUsuarioOuEmail.setBounds(10, 30, 100, 15);
			
			// Construção do Input
			JTextField inputNomeOuEmail = new JTextField ();
			inputNomeOuEmail.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
			inputNomeOuEmail.setBounds(90, 30, 200, 20);
			
			// -- Campo de Nome do Usuário --
			// Construção do texto
			JLabel senha = new JLabel ("Senha: ", SwingConstants.LEFT); 
			senha.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			senha.setBounds(10, 80, 100, 15);
						
			// Construção do Input
			JPasswordField inputSenha = new JPasswordField ();
			inputSenha.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
			inputSenha.setBounds(90, 80, 200, 20);
			
			
		margemInputs.add(nomeUsuarioOuEmail);
		margemInputs.add(inputNomeOuEmail);
		margemInputs.add(senha);
		margemInputs.add(inputSenha);
			
			
		
		
		
		caixaLogin.add(textoLogin);
		caixaLogin.add(fundoOrientacao);
		caixaLogin.add(margemInputs);
		
		
		return caixaLogin;
	}
	
		

	
	private JLabel criarLabelForca() {
		ImageIcon forca = new ImageIcon(getClass().getResource("/images/forcaBonecoCompleto.png"));	
	    Image redimensionada = forca.getImage().getScaledInstance(-1, 500, Image.SCALE_SMOOTH);
	    JLabel label = new JLabel(new ImageIcon(redimensionada));
	    label.setHorizontalAlignment(JLabel.CENTER);
	    return label;
		
	}
	

}
