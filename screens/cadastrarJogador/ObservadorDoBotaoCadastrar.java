package screens.cadastrarJogador;
import java.awt.event.*;
import javax.swing.JOptionPane;

import config.Central;
import config.tabelas_base.Jogador;
import screens.cadatrarNovo.CadastrarNovo;

public class ObservadorDoBotaoCadastrar implements ActionListener{
	private CadastrarJogador telaAtual;

    public ObservadorDoBotaoCadastrar(CadastrarJogador telaAtual) {
        this.telaAtual = telaAtual;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String nome = telaAtual.getNomeUsuario();
		String email = telaAtual.getEmail();
		String senha = telaAtual.getSenha();

		if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
			aviso("Preencha o nome de usuário, o e-mail e a senha.");
			return;
		}

		if (nome.contains("@")) {
			aviso("O nome de usuário não pode conter '@' (o login usa o '@' para reconhecer e-mails).");
			return;
		}

		if (!email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
			aviso("Digite um e-mail válido (exemplo: nome@dominio.com).");
			return;
		}

		Central central = Central.obterInstancia();

		if (central.recuperarJogadorPorNome(nome) != null) {
			aviso("Já existe um usuário com esse nome.");
			return;
		}

		if (central.recuperarJogadorPorEmail(email) != null) {
			aviso("Já existe um usuário com esse e-mail.");
			return;
		}

		central.registrarJogador(new Jogador(nome, email, senha));
		telaAtual.limparCampos();

		new CadastrarNovo(telaAtual).setVisible(true);
	}

	private void aviso(String mensagem) {
		JOptionPane.showMessageDialog(telaAtual, mensagem, "Cadastro", JOptionPane.WARNING_MESSAGE);
	}

}
