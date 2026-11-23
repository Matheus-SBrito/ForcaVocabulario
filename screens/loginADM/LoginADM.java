package screens.loginADM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import config.Central;
import config.tabelas_base.Usuario;
import screens.UtilScreens;

public class LoginADM extends JFrame{
	
	private static LoginADM INSTANCIA;
	private JTextField inputNomeDoUsuario;
	private JTextField inputEmailDoUsuario;
	private JPasswordField inputSenha;
	
	private LoginADM () {
		configuracao();
		add(tituloFrameLogin());
		iconeBonecoForca(0, 120);
		painelCaixaLogin();
		setVisible(true);
	};
	
	
	public static LoginADM obterInstancia () {
		if (INSTANCIA == null) INSTANCIA = new LoginADM();
		return INSTANCIA;}
	
	
	/*
	 * -------------------------------
	 *  Construção dos Observadores de
	 * 			  Login
	 * -------------------------------
	 */
	
	 
	
	
	/*
	 * -------------------------------
	 *  Construção dos Componentes de
	 * 			  Design
	 * -------------------------------
	 */
	
	private JLabel tituloFrameLogin() {
		
		JLabel tituloForca = new JLabel("Jogo da Forca!!", SwingConstants.CENTER);
		tituloForca.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		tituloForca.setBounds(0, 60, 800, 60);
        return tituloForca;
	}

	
	private void configuracao () { // Configurações Básicas da tela
		
		setTitle("Login");
		setLayout(null);
		setSize(UtilScreens.LARGURA_PADRAO, UtilScreens.ALTURA_PADRAO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Alterando a cor da Janela
		getContentPane().setBackground(UtilScreens.AMARELO_CLARO);
		setLocationRelativeTo(null);
	}
	
	
	private void iconeBonecoForca(int posicaoX,int posicaoY) {
			
		// -- Configurações para Construção da Imagem --
		// Carregamento da imagem para o projeto
		java.net.URL urlImagem = getClass().getResource("/images/forcaBonecoCompleto.png");
		ImageIcon imagemOriginal = (urlImagem != null)
				? new ImageIcon(urlImagem)
				: new ImageIcon("./images/forcaBonecoCompleto.png");
		
		
		// Redimensionamento da Imagem
		int alturaImg = 380;
		int larguraImg = -1;
		Image ajusteImg = imagemOriginal.getImage().getScaledInstance(
				larguraImg, alturaImg, Image.SCALE_SMOOTH);
		
		// Geração do Incone Redimensionado.
		ImageIcon imagemForca = new ImageIcon (ajusteImg);
		
		
		// Posicionamento da imagem
		JLabel posicionamentoImg = new JLabel (imagemForca, SwingConstants.CENTER);
		posicionamentoImg.setBounds(posicaoX, posicaoY, imagemForca.getIconWidth(), imagemForca.getIconHeight());
		
		add(posicionamentoImg);
		
	}
	
	
	
	// Configuração do Painel, Caixa do login
	private void painelCaixaLogin () {
		JPanel caixaLogin = new JPanel();
		
		// -- Configurações basicas do painel --
		caixaLogin.setLayout(null); // Posição
		caixaLogin.setBounds(245, 150, 300, 300); // Cordenadas, Altura e Largura
		caixaLogin.setBackground(UtilScreens.AREIA); // Cor do painel
		
			// Adicção de bordas ao painel
			caixaLogin.setBorder(BorderFactory.createLineBorder(UtilScreens.PRETO));

		caixaLogin.add(tituloCaixa());
		caixaLogin.add(mensagemOrientacao());
		caixaLogin.add(entradasCaixaLogin());		
		
		
		add(caixaLogin);
	}
	
	
		/*
		 * -------------------------------------
		 * Componentes visuis  
		 * 
		 * Abaixo estão os elementos 
		 * 
		 * -------------------------------------
		 */
	
			
			private JLabel tituloCaixa () {// Titulo da caixa de login
				 
				JLabel textoLogin = new JLabel ("Iniciando Banco de Dados", SwingConstants.CENTER); // Texto e Alinhamento
				textoLogin.setFont(new Font(Font.DIALOG, Font.BOLD, 20)); // Fonte, Negrito e Tamanho
				textoLogin.setBounds(0,0,300,40); // Cordenadas e Tamnho da Caixa do Texto
				
					// Adição de borda a caixa do texto
					textoLogin.setBorder(BorderFactory.createLineBorder(UtilScreens.PRETO));
					
				return textoLogin;
			}
			
			
			private JPanel mensagemOrientacao () { // Configuração das margens e o texto
				// -- Mensagem de Orientação --
				JPanel fundoOrientacao = new JPanel (); /// Construção da Margen e Fundo
				fundoOrientacao.setLayout(null);
				fundoOrientacao.setBackground(UtilScreens.BRANCO);
				fundoOrientacao.setBorder(BorderFactory.createLineBorder(UtilScreens.PRETO));
				fundoOrientacao.setBounds(3, 50, 294, 70);
					
				// Texto
					JLabel orientacaoLogin = new JLabel (
						"<html>Devido a faltra de dados cadastrados no sistema "
						+ "é necessário que o jogador se cadastre. Seu cadastro "
						+ "tem o privilegio de administrador logo seu usuário "
						+ "pode cadastrar ouutros jogadores</html>"); // Tags Html para o texto 'descer'
					
					orientacaoLogin.setFont(new Font(Font.DIALOG, Font.ITALIC, 12)); // Caracteriscas da fonte
					orientacaoLogin.setBounds(3, 0, 290, 70);
					
				fundoOrientacao.add(orientacaoLogin);
				
				return fundoOrientacao;
			}
			
			
			private JPanel entradasCaixaLogin () {
				// -- Botões e seus respectivos textos --
				JPanel margemInputs = new JPanel (null);
				
				margemInputs.setBackground(UtilScreens.AREIA);
				margemInputs.setBorder(BorderFactory.createLineBorder(UtilScreens.PRETO));
				margemInputs.setBounds(0, 130, 300, 170);
					
					// -- Campo de Nome do Usuário --
					// Construção do texto
					JLabel nomeDoUsuario = new JLabel ("Username: ", SwingConstants.LEFT); 
					nomeDoUsuario.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
					nomeDoUsuario.setBounds(10, 10, 100, 13);
						// Construção do Input
						inputNomeDoUsuario = new JTextField ();
						inputNomeDoUsuario.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
						inputNomeDoUsuario.setBounds(10, 30, 130, 20);
					
					// -- Campo de Email do Usuario --
					// Construção do texto
					JLabel emailUsuario = new JLabel ("Email: ", SwingConstants.LEFT); 
					emailUsuario.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
					emailUsuario.setBounds(160, 10, 100, 13);
						// Construção do Input
						inputEmailDoUsuario = new JTextField ();
						inputEmailDoUsuario.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
						inputEmailDoUsuario.setBounds(160, 30, 130, 20);
					
					// -- Campo de Nome do Usuário --
					// Construção do texto
					JLabel senha = new JLabel ("Senha: ", SwingConstants.LEFT); 
					senha.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
					senha.setBounds(10, 60, 100, 15);
						// Construção do Input
						inputSenha = new JPasswordField();
						inputSenha.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
						inputSenha.setBounds(10, 80, 280, 20);
					
				JButton botaoEntrar = new JButton ("Iniciar");
				botaoEntrar.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
				botaoEntrar.setBackground(Color.WHITE);
				botaoEntrar.setBounds(20, 120, 100, 20);
				
				
				JButton botaoCancelar = new JButton ("Cancelar");
				botaoCancelar.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
				botaoCancelar.setBackground(Color.WHITE);
				botaoCancelar.setBounds(180, 120, 100, 20);
					
				// -- Adição dos Campos de Inpusts e seus Label's --
					// Campo Nome do Usuário
					margemInputs.add(nomeDoUsuario);
					margemInputs.add(inputNomeDoUsuario);
					
					// Campo  de Email do Usuario
					margemInputs.add(emailUsuario);
					margemInputs.add(inputEmailDoUsuario);
					
					// Campo de Senha do Usuario
					margemInputs.add(senha);
					margemInputs.add(inputSenha);
					
				margemInputs.add(botaoEntrar);
				margemInputs.add(botaoCancelar);
				
				return margemInputs;
			}
			
	public static void main (String[] args) {
		
		
		LoginADM logADM = LoginADM.obterInstancia();
		
	}
}
