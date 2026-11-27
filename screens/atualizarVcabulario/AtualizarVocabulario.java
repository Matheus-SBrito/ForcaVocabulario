package screens.atualizarVcabulario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AtualizarVocabulario extends JFrame {

    private JTextField campoPalavra;
    private JComboBox<String> seletorTema;
    private JTextField campoNovoTema;
    private JButton botaoAdicionar;
    private JButton botaoCriarTema;

    private JComboBox<String> filtroTema;
    private JTable tabelaPalavras;
    private DefaultTableModel dadosTabela;
    private JButton botaoExcluir;

    private JButton botaoVoltar;

    private Map<String, List<String>> palavrasPorTema;

    public AtualizarVocabulario() {
        carregarTemasIniciais();
        configurarJanela();
        criarComponentes();
        montarTela();
        configurarAcoes();
        atualizarLista();
    }

    private void carregarTemasIniciais() {
        palavrasPorTema = new LinkedHashMap<>();
        palavrasPorTema.put("Todas", new ArrayList<>());
        palavrasPorTema.put("Frutas", new ArrayList<>(List.of("BANANA", "MORANGO", "ABACAXI")));
        palavrasPorTema.put("Países", new ArrayList<>(List.of("BRASIL", "PORTUGAL", "JAPAO")));
        palavrasPorTema.put("Animais", new ArrayList<>(List.of("CACHORRO", "ELEFANTE", "GATO")));
    }

    private void configurarJanela() {
        setTitle("Jogo da Forca - Atualizar Vocabulário");
        setSize(960, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(254, 248, 205));
    }

    private void criarComponentes() {
        campoPalavra = new JTextField(16);
        campoNovoTema = new JTextField(14);

        List<String> temasCadastro = new ArrayList<>(palavrasPorTema.keySet());
        temasCadastro.remove("Todas");

        seletorTema = new JComboBox<>(temasCadastro.toArray(new String[0]));
        filtroTema = new JComboBox<>(palavrasPorTema.keySet().toArray(new String[0]));

        botaoAdicionar = new JButton("Adicionar Palavra");
        botaoCriarTema = new JButton("Nova Categoria");
        botaoExcluir = new JButton("Excluir Selecionada");
        botaoVoltar = new JButton("Voltar");

        String[] colunas = {"PALAVRA", "CATEGORIA"};
        dadosTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaPalavras = new JTable(dadosTabela);
        tabelaPalavras.setRowHeight(26);
        tabelaPalavras.setBackground(new Color(250, 240, 190));
    }

    private void montarTela() {
        setLayout(new BorderLayout(10, 10));
        add(criarTopo(), BorderLayout.NORTH);
        add(criarCentro(), BorderLayout.CENTER);
        add(criarRodape(), BorderLayout.SOUTH);
    }

    private JPanel criarTopo() {
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        topo.setBackground(new Color(245, 240, 210));
        topo.add(new JLabel("Jogo da Forca"));
        return topo;
    }

    private JPanel criarCentro() {
        JPanel centro = new JPanel(new BorderLayout(10, 15));
        centro.setOpaque(false);
        centro.setBorder(BorderFactory.createEmptyBorder(15, 25, 5, 25));

        JLabel titulo = new JLabel("Atualizar Vocabulário", SwingConstants.CENTER);
        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        centro.add(titulo, BorderLayout.NORTH);

        JPanel colunasPainel = new JPanel(new GridLayout(1, 2, 20, 0));
        colunasPainel.setOpaque(false);
        colunasPainel.add(criarLadoEsquerdo());
        colunasPainel.add(criarLadoDireito());

        centro.add(colunasPainel, BorderLayout.CENTER);
        return centro;
    }

    private JPanel criarLadoEsquerdo() {
        JPanel esquerdo = new JPanel(new GridBagLayout());
        esquerdo.setBackground(new Color(250, 240, 190));
        esquerdo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 165, 110), 1),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 6, 8, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel subtitulo = new JLabel("Cadastrar Palavra / Categoria", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        esquerdo.add(subtitulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        esquerdo.add(new JLabel("Categoria:"), gbc);

        gbc.gridx = 1;
        esquerdo.add(seletorTema, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        esquerdo.add(new JLabel("Nova Palavra:"), gbc);

        gbc.gridx = 1;
        esquerdo.add(campoPalavra, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        botaoAdicionar.setPreferredSize(new Dimension(180, 36));
        esquerdo.add(botaoAdicionar, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        esquerdo.add(new JLabel("Criar Categoria:"), gbc);

        gbc.gridx = 1;
        esquerdo.add(campoNovoTema, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        botaoCriarTema.setPreferredSize(new Dimension(180, 34));
        esquerdo.add(botaoCriarTema, gbc);

        return esquerdo;
    }

    private JPanel criarLadoDireito() {
        JPanel direito = new JPanel(new BorderLayout(8, 10));
        direito.setOpaque(false);

        JPanel barraFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        barraFiltro.setOpaque(false);
        barraFiltro.add(new JLabel("Filtrar Categoria:"));
        barraFiltro.add(filtroTema);

        direito.add(barraFiltro, BorderLayout.NORTH);
        direito.add(new JScrollPane(tabelaPalavras), BorderLayout.CENTER);

        JPanel acoesLista = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        acoesLista.setOpaque(false);
        botaoExcluir.setPreferredSize(new Dimension(170, 34));
        acoesLista.add(botaoExcluir);

        direito.add(acoesLista, BorderLayout.SOUTH);
        return direito;
    }

    private JPanel criarRodape() {
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 12));
        rodape.setOpaque(false);
        botaoVoltar.setPreferredSize(new Dimension(150, 38));
        rodape.add(botaoVoltar);
        return rodape;
    }

    private void configurarAcoes() {
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPalavra();
            }
        });

        botaoCriarTema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarTema();
            }
        });

        filtroTema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarLista();
            }
        });

        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirPalavra();
            }
        });

        botaoVoltar.addActionListener(new ObservadorDoBotaoVoltar(this));
    }

    private void adicionarPalavra() {
        String palavra = campoPalavra.getText().trim().toUpperCase();
        String tema = (String) seletorTema.getSelectedItem();

        if (palavra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite uma palavra antes de adicionar.");
            return;
        }
        if (tema == null || tema.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione ou crie uma categoria.");
            return;
        }

        List<String> listaDoTema = palavrasPorTema.computeIfAbsent(tema, k -> new ArrayList<>());
        if (!listaDoTema.contains(palavra)) {
            listaDoTema.add(palavra);
        }

        campoPalavra.setText("");
        filtroTema.setSelectedItem(tema);
        atualizarLista();
    }

    private void criarTema() {
        String novoTema = campoNovoTema.getText().trim();
        if (novoTema.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome da nova categoria.");
            return;
        }

        if (!palavrasPorTema.containsKey(novoTema)) {
            palavrasPorTema.put(novoTema, new ArrayList<>());
            seletorTema.addItem(novoTema);
            filtroTema.addItem(novoTema);
        }

        campoNovoTema.setText("");
        seletorTema.setSelectedItem(novoTema);
        filtroTema.setSelectedItem(novoTema);
        atualizarLista();
    }

    private void excluirPalavra() {
        int linha = tabelaPalavras.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma palavra na tabela para excluir.");
            return;
        }

        String palavra = (String) dadosTabela.getValueAt(linha, 0);
        String tema = (String) dadosTabela.getValueAt(linha, 1);

        List<String> listaDoTema = palavrasPorTema.get(tema);
        if (listaDoTema != null) {
            listaDoTema.remove(palavra);
        }

        atualizarLista();
    }

    private void atualizarLista() {
        dadosTabela.setRowCount(0);
        String temaEscolhido = (String) filtroTema.getSelectedItem();

        for (Map.Entry<String, List<String>> item : palavrasPorTema.entrySet()) {
            String tema = item.getKey();
            if ("Todas".equals(tema)) {
                continue;
            }
            if (temaEscolhido != null && !"Todas".equals(temaEscolhido) && !temaEscolhido.equals(tema)) {
                continue;
            }
            for (String palavra : item.getValue()) {
                dadosTabela.addRow(new Object[]{palavra, tema});
            }
        }
    }
}