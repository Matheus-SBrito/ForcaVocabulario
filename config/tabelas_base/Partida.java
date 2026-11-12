package config.tabelas_base;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Partida {

	private Usuario jogador;
	private String palavra;
	private ArrayList<Character> letrasTentadas = new ArrayList<Character>();
	private int erros;
	private int maxErros = 6;
	private int pontos;
	private boolean vitoria;
	private LocalDateTime dataHora;


	public Partida(Usuario jogador, String palavra) {
		this.jogador = jogador;
		this.palavra = palavra;
		this.dataHora = LocalDateTime.now();
	}

	public Partida() {}


	// Metodos de Visibilidade
	public Usuario getJogador() {return jogador;}
	public void setJogador(Usuario jogador) {this.jogador = jogador;}

	public String getPalavra() {return palavra;}
	public void setPalavra(String palavra) {this.palavra = palavra;}

	public ArrayList<Character> getLetrasTentadas() {return letrasTentadas;}
	public void setLetrasTentadas(ArrayList<Character> letrasTentadas) {this.letrasTentadas = letrasTentadas;}

	public int getErros() {return erros;}
	public void setErros(int erros) {this.erros = erros;}

	public int getMaxErros() {return maxErros;}
	public void setMaxErros(int maxErros) {this.maxErros = maxErros;}

	public int getPontos() {return pontos;}
	public void setPontos(int pontos) {this.pontos = pontos;}

	public boolean isVitoria() {return vitoria;}
	public void setVitoria(boolean vitoria) {this.vitoria = vitoria;}

	public LocalDateTime getDataHora() {return dataHora;}
	public void setDataHora(LocalDateTime dataHora) {this.dataHora = dataHora;}
	
	// Logica do jogo

	public boolean tentarLetra(char letra) {
		letra = Character.toLowerCase(letra);

		if (isFinalizada() || !Character.isLetter(letra) || letrasTentadas.contains(letra))
			return false;

		letrasTentadas.add(letra);

		if (palavra.toLowerCase().indexOf(letra) >= 0) {
			if (todasLetrasDescobertas())
				vitoria = true;
			return true;
		}

		erros++;
		return false;
	}

	// finalizar partida
	
	public boolean isFinalizada() {
		return vitoria || erros >= maxErros;
	}

	// lê letra digitada e verifica palavra 
	
	private boolean todasLetrasDescobertas() {
		for (char c : palavra.toLowerCase().toCharArray())
			if (Character.isLetter(c) && !letrasTentadas.contains(c))
				return false;
		return true;
	}
}