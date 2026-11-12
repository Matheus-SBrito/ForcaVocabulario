package screens;

import javax.swing.*;
import java.awt.*;

public class CadastrarJogador extends JFrame {

	   public CadastrarJogador() {
	        inicializarJanela();
	        criarComponentes();
	        criarCamposTexto();
	        criarBotoes();
	    }

	    private void inicializarJanela() {
	        setTitle("Jogo da Forca");
	        setSize(500, 450);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(null);
			setResizable(false);
			getContentPane().setBackground(UtilScreens.AMARELO_CLARO);

	    }

	    private void criarComponentes() {
	        JLabel lblTitulo = new JLabel("Cadastrar jogador");
	        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
	        lblTitulo.setBounds(100, 30, 275, 40);
	        add(lblTitulo);
	        
	        
	        JLabel lbNomeUsu = new JLabel ("Nome do Usuário:"); 
	        lbNomeUsu.setFont(new Font("Arial", Font.BOLD, 14));
	        lbNomeUsu.setBounds(50,100,130,20);
	        add(lbNomeUsu);
	        
	        JLabel lbEmail = new JLabel("Email: ");
	        lbEmail.setFont(new Font("Arial", Font.BOLD, 14));
	        lbEmail.setBounds(50,180,50,20);
	        add(lbEmail);
	        
	        JLabel lbSenha = new JLabel("Senha do Usuário:");
	        lbSenha.setFont(new Font("Arial", Font.BOLD, 14));
	        lbSenha.setBounds(50,260,130,20);
	        add(lbSenha);
	        
	        
	    		ImageIcon forca = new ImageIcon(getClass().getResource("/images/forcaBonecoCompleto.png"));	
	    		Image redimensionada = forca.getImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
	    		JLabel lbForca = new JLabel(new ImageIcon(redimensionada));
	    	    lbForca.setBounds(2,2,100,100);
	    	   add(lbForca);
	    		
	   
	    }
	    
	    
	    private void criarCamposTexto() {
	    	JTextField jtNomeUsu = new JTextField();
	    	jtNomeUsu.setBounds(50,120,200,30);
	    	add(jtNomeUsu);
	    	
	    	JTextField jtEmail= new JTextField();
	    	jtEmail.setBounds(50, 200, 200, 30);
	    	add(jtEmail);
	    	
	    	JTextField jtSenha= new JTextField();
	    	jtSenha.setBounds(50, 280, 200, 30);
	    	add(jtSenha);
	    	
	    }
	    
	    private void criarBotoes() {
	    	JButton btSair = new JButton("SAIR");
	    	btSair.setBounds(50, 350, 130, 30);
	    	btSair.setOpaque(true);
	    	btSair.setBackground(Color.white);
	    	add(btSair);
	    	
	    	JButton btCadastrar = new JButton("CADASTRAR");
	    	btCadastrar.setBounds(320,350,130,30);
	    	btCadastrar.setOpaque(true);
	    	btCadastrar.setBackground(Color.white);
	    	add(btCadastrar);
	    }
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new CadastrarJogador().setVisible(true));
	    }
}