import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Estacionamento {

	private String[] placas;

	public Estacionamento(int n) throws Exception {
		if (n <= 0) {
			throw new Exception("O número de vagas deve ser maior que 0!");
		}
		placas = new String[n];
		Arrays.fill(placas, "vazia");
	}
	
	private boolean vagaEstaVazia(int vaga) {
		return placas[vaga-1].equals("vazia");
	}
	
	private boolean vagaPossuiCarro(int vaga) {
		return !(placas[vaga-1].equals("vazia"));
	}
	
	private boolean vagaInvalida(int vaga) {
		return !(vaga > 0 && vaga <= placas.length);
	}
	
	private void gravarNoHistorico(String operacao, int vaga, String placa) throws Exception {
		try {
			FileWriter arquivoHistorico = new FileWriter(
					"Valetinho/data/historico.csv", true);
			LocalDateTime dataAtual = LocalDateTime.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String dataFormatada = dataAtual.format(formato);
			
			if (operacao.equals("ENTRADA")) {
				placas[vaga - 1] = placa;
				arquivoHistorico.write(String.format("%s;%s;%s;%s%n",
					dataFormatada, vaga, placa, operacao));
			} else {
				arquivoHistorico.write(String.format("%s;%s;%s;%s%n",
					dataFormatada, vaga, placas[vaga - 1], operacao));
				placas[vaga - 1] = "vazia";
			}
	
			arquivoHistorico.flush();
			arquivoHistorico.close();
		} catch (IOException err) {
			throw new Exception("Houve problemas na hora de ler/gravar no historico.");
		}
	}

	public void entrar(String placa, int vaga) throws Exception {
		if (vagaInvalida(vaga))
			throw new Exception("Vaga inválida!");
		if (vagaEstaVazia(vaga))
			gravarNoHistorico("ENTRADA", vaga, placa);
		else 
			throw new Exception("Vaga ocupada!");
	}

	public void sair(int vaga) throws Exception {
		if (vagaInvalida(vaga))
			throw new Exception("Vaga inválida!");
		if (vagaPossuiCarro(vaga))
			gravarNoHistorico("SAIDA", vaga, null);
		else
			throw new Exception("Vaga vazia!");
	}

	public int consultarPlaca(String placa) throws Exception {
		try {
			for (int i = 0; i < placas.length; i++) {
				if (vagaPossuiCarro(i+1) && placas[i].equals(placa))
					return i + 1;
			} 
			return -1;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void transferir(int vaga1, int vaga2) throws Exception {
		if (vagaInvalida(vaga1) || vagaInvalida(vaga2))
			throw new Exception("Vaga(s) inválida(s)!");

		if (vagaPossuiCarro(vaga1)) { 
			if (vagaEstaVazia(vaga2)) {
				placas[vaga2 - 1] = placas[vaga1 - 1];
				placas[vaga1 - 1] = "vazia";
			} else 
				throw new Exception("Vaga de destino ocupada!");
		} else 
			throw new Exception("Vaga de origem vazia!");
	}

	public String[] listarGeral() {

		String[] todasAsVagas = new String[placas.length];

		for (int i = 0; i < placas.length; i++) {
			todasAsVagas[i] = placas[i];
		}
		return todasAsVagas;

	}

	public ArrayList<Integer> listarLivres() {

		ArrayList<Integer> vagasLivres = new ArrayList<>();

		for (int i = 0; i < placas.length; i++) {
			if (vagaEstaVazia(i+1))
				vagasLivres.add(i + 1);
		}
		return vagasLivres;
	}

	public void gravarDados() throws Exception {
		try {

			FileWriter arqplacas = new FileWriter("./Valetinho/data/placas.csv");

			for (int i = 0; i < placas.length; i++) {
				if (vagaPossuiCarro(i+1)) {
					if (i < placas.length - 1)
						arqplacas.write(String.format("%s;%s%n", placas[i], i + 1));
					else
						arqplacas.write(String.format("%s;%s", placas[i], i + 1));
				}
			}
			arqplacas.flush();
			arqplacas.close();

		} catch (IOException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void lerDados() throws Exception{
		try {

			File arqplacas = new File("./Valetinho/data/placas.csv");

			if (arqplacas.exists()) {
				Scanner leitor = new Scanner(arqplacas);

				while (leitor.hasNextLine()) {
					String[] linha = leitor.nextLine().split(";");
					if (linha.length > 0)
						this.placas[Integer.parseInt(linha[1]) - 1] = linha[0];
					
				}
				leitor.close();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}