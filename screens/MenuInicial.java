package screens;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MenuInicial extends JFrame {
    private static MenuInicial INSTANCIA;

    private JButton btnJogar;
    private JButton btnCadastrarJogador;
    private JButton btnHistoricoPartidas;
    private JButton btnAtualizarVocabulario;
    private JButton btnMinhaConta;
    private JButton btnRankingGlobal;
    private JButton btnConfiguracoes;

    private MenuInicial() {
        gerarTela();
        gerarComponentes();
        setVisible(true);
    }

    public static MenuInicial obterInstancia() {

        if (INSTANCIA == null)
            INSTANCIA = new MenuInicial();
        return INSTANCIA;
    }

    private void gerarTela() {
        setTitle("TELA INICIAL");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void gerarComponentes() {
        gerarBotoes();
        gerarObservadores();
        montarTela();
    }

    private void gerarBotoes() {
        Dimension tamanhoPadrao = new Dimension(170, 35);

        btnJogar = new JButton("Jogar");
        btnJogar.setPreferredSize(tamanhoPadrao);

        btnCadastrarJogador = new JButton("Cadastrar Jogador");
        btnCadastrarJogador.setPreferredSize(tamanhoPadrao);

        btnHistoricoPartidas = new JButton("Histórico de Partidas");
        btnHistoricoPartidas.setPreferredSize(tamanhoPadrao);

        btnAtualizarVocabulario = new JButton("Atualizar Vocabulário");
        btnAtualizarVocabulario.setPreferredSize(tamanhoPadrao);

        btnMinhaConta = new JButton("Minha Conta");
        btnMinhaConta.setPreferredSize(tamanhoPadrao);

        btnRankingGlobal = new JButton("Ranking Global");
        btnRankingGlobal.setPreferredSize(tamanhoPadrao);

        btnConfiguracoes = new JButton("Configurações");
        btnConfiguracoes.setPreferredSize(tamanhoPadrao);
    }

    private void gerarObservadores() {
        btnJogar.addActionListener(new ObservadorDoBotaoJogar(this));
        btnCadastrarJogador.addActionListener(new ObservadorDoBotaoCadrastarJogador(this));
        btnHistoricoPartidas.addActionListener(new ObservadorDoBotaoHistoricoDePartidas(this));
        btnAtualizarVocabulario.addActionListener(new ObservadorDoBotaoAtualizarVocabulario(this));
        btnMinhaConta.addActionListener(new ObservadorDoBotaoMinhaConta(this));
        btnRankingGlobal.addActionListener(new ObservadorDoBotaoRankingGlobal(this));
        // btnConfiguracoes.addActionListener(new ObservadorDoBotaoConfiguracoes(this));
    }

    private void montarTela() {
        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        painelTopo.add(new JLabel("Jogo da Forca"));
        add(painelTopo, BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                criarPainelEsquerdo(),
                criarPainelDireito());
        splitPane.setResizeWeight(0.55);
        splitPane.setDividerSize(5);

        add(splitPane, BorderLayout.CENTER);
    }

    private JPanel criarPainelEsquerdo() {
        JPanel painelEsquerdo = new JPanel(new BorderLayout(10, 10));
        painelEsquerdo.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Jogo da forca !!", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        painelEsquerdo.add(lblTitulo, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelBotoes.add(btnJogar, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelBotoes.add(btnHistoricoPartidas, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelBotoes.add(btnMinhaConta, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelBotoes.add(btnRankingGlobal, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        painelBotoes.add(btnConfiguracoes, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        painelBotoes.add(btnCadastrarJogador, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        painelBotoes.add(btnAtualizarVocabulario, gbc);

        painelEsquerdo.add(painelBotoes, BorderLayout.CENTER);
        return painelEsquerdo;
    }

    private JPanel criarPainelDireito() {
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS));
        painelDireito.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTop6 = new JLabel("Ranking - 6 melhores");
        lblTop6.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelDireito.add(lblTop6);
        painelDireito.add(Box.createVerticalStrut(5));

        String[] colunas = { "Nome do jogador", "Pontos", "Posição" };
        Object[][] dadosTop6 = {
                { "Jogador 1", 100, 1 },
                { "Jogador 2", 90, 2 },
                { "Jogador 3", 85, 3 },
                { "Jogador 4", 84, 4 },
                { "Jogador 5", 23, 5 },
                { "Jogador 6", 20, 6 }
        };

        JTable tabelaTop6 = new JTable(new DefaultTableModel(dadosTop6, colunas));
        JScrollPane scrollTop6 = new JScrollPane(tabelaTop6);
        scrollTop6.setPreferredSize(new Dimension(350, 120));
        painelDireito.add(scrollTop6);

        painelDireito.add(Box.createVerticalStrut(25));

        JLabel lblPosicaoAtual = new JLabel("Sua posição atual");
        lblPosicaoAtual.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelDireito.add(lblPosicaoAtual);
        painelDireito.add(Box.createVerticalStrut(5));

        Object[][] dadosPosicao = {
                { "-", "-", "-" },
                { "Jogador 0", 1, 99 }
        };

        JTable tabelaPosicao = new JTable(new DefaultTableModel(dadosPosicao, colunas));
        JScrollPane scrollPosicao = new JScrollPane(tabelaPosicao);
        scrollPosicao.setPreferredSize(new Dimension(350, 60));
        painelDireito.add(scrollPosicao);

        return painelDireito;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuInicial.obterInstancia();
        });
    }
}