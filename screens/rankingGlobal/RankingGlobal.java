package screens.rankingGlobal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RankingGlobal extends JFrame {
	private JButton btnSair;

    
    public RankingGlobal() {
        inicializarJanela();
        criarComponentes();
        gerarObservadores();
    }

    private void gerarObservadores() {
		btnSair.addActionListener(new ObservadorDoBotaoSair(this));
	}

	private void inicializarJanela() {
    	setTitle("Jogo da Forca - Ranking");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(254, 248, 205));
    }

    private void criarComponentes() {
    	JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        painelTopo.setBackground(new Color(245, 240, 210));
        painelTopo.add(new JLabel("Jogo da Forca"));
        add(painelTopo, BorderLayout.NORTH);
        
        JPanel painelCentro = new JPanel(new BorderLayout(10, 15));
        painelCentro.setOpaque(false);
        painelCentro.setBorder(BorderFactory.createEmptyBorder(15, 25, 10, 25));
        
        JLabel lblTitulo = new JLabel("Ranking", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        painelCentro.add(lblTitulo, BorderLayout.NORTH);
        
        
        JPanel painelTabelas = new JPanel(new GridLayout(1, 2, 25, 0));
        painelTabelas.setOpaque(false);
        
        String[] colunas = {"JOGADOR", "PONTOS"};
        Object[][] dadosSemanal= {
        };
        
        Object[][] dadosMensal = {
              
        };

        painelTabelas.add(criarBlocoTabela("Semanal", colunas, dadosSemanal));
        painelTabelas.add(criarBlocoTabela("Mensal", colunas, dadosMensal));

        painelCentro.add(painelTabelas, BorderLayout.CENTER);
        add(painelCentro, BorderLayout.CENTER);
        
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        painelInferior.setOpaque(false);

        btnSair = new JButton("Sair");
        btnSair.setPreferredSize(new Dimension(150, 38));
        painelInferior.add(btnSair);

        add(painelInferior, BorderLayout.SOUTH);
    }
    
    
    
    private JPanel criarBlocoTabela(String titulo, String[] colunas, Object[][] dados) {
        JPanel bloco = new JPanel(new BorderLayout(5, 8));
        bloco.setOpaque(false);

        JLabel lblSubtitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        bloco.add(lblSubtitulo, BorderLayout.NORTH);

        DefaultTableModel modelo = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(modelo);
        tabela.setRowHeight(28);
        tabela.setBackground(new Color(250, 240, 190));

        JScrollPane scrollPane = new JScrollPane(tabela);
        bloco.add(scrollPane, BorderLayout.CENTER);

        return bloco;
    }
    
    
}