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
		setLocationRelativeTo(null);
	}

	
	private JLabel criarLabelForca() {
		ImageIcon forca = new ImageIcon(getClass().getResource("/images/forcaBonecoCompleto.png"));	
	    Image redimensionada = forca.getImage().getScaledInstance(-1, 500, Image.SCALE_SMOOTH);
	    JLabel label = new JLabel(new ImageIcon(redimensionada));
	    label.setHorizontalAlignment(JLabel.CENTER);
	    return label;
		
	}
	

}
