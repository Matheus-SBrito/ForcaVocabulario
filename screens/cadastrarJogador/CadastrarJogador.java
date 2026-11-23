package screens.cadastrarJogador;
import java.awt.*;
import javax.swing.*;

import screens.UtilScreens;

public class CadastrarJogador extends JFrame {
		private JButton btSair;
		private JButton btCadastrar;
		private JTextField jtNomeUsu;
		private JTextField jtEmail;
		private JPasswordField jpSenha;
		
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
	    	jtNomeUsu = new JTextField();
	    	jtNomeUsu.setBounds(50,120,200,30);
	    	add(jtNomeUsu);
	    	
	    	jtEmail = new JTextField();
	    	jtEmail.setBounds(50, 200, 200, 30);
	    	add(jtEmail);
	    	
	    	jpSenha = new JPasswordField();
	    	jpSenha.setBounds(50, 280, 200, 30);
	    	add(jpSenha);
	    	
	    }
	    
	    private void criarBotoes() {
	        btSair = new JButton("SAIR");
	        btSair.setBounds(50, 350, 130, 30);
	        btSair.setOpaque(true);
	        btSair.setBackground(Color.white);
	        add(btSair);

	        btCadastrar = new JButton("CADASTRAR");
	        btCadastrar.setBounds(320, 350, 130, 30);
	        btCadastrar.setOpaque(true);
	        btCadastrar.setBackground(Color.white);
	        add(btCadastrar);

	        criarObservadores();
	    }
	    // Acesso aos campos para o observador do botão CADASTRAR
	    public String getNomeUsuario() { return jtNomeUsu.getText().trim(); }
	    public String getEmail() { return jtEmail.getText().trim(); }
	    public String getSenha() { return new String(jpSenha.getPassword()).trim(); }

	    public void limparCampos() {
	    	jtNomeUsu.setText("");
	    	jtEmail.setText("");
	    	jpSenha.setText("");
	    	jtNomeUsu.requestFocusInWindow();
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new CadastrarJogador().setVisible(true));
	    }
	    
	    private void criarObservadores() {
	    	btSair.addActionListener(new ObservadorDoBotaoSair(this));
	    	btCadastrar.addActionListener(new ObservadorDoBotaoCadastrar(this));
	    	
	    }
}