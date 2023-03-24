import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Estacionamento {

	private String[] placas;

	public Estacionamento(int n) throws Exception {
		if (n <= 0) {
			throw new Exception("O número de vagas deve ser maior que 0!");
		}
		placas = new String[n];
	}

	public void entrar(String placa, int vaga) throws Exception {
		if (!(vaga > 0 && vaga <= placas.length))
			throw new Exception("Vaga inválida!");
		if (placas[vaga-1] == null) 
			placas[vaga-1] = placa;
		else 
			throw new Exception("Vaga ocupada!");
	}

	public void sair(int vaga) throws Exception {
		if (placas[vaga-1] == null) 
			throw new Exception("Vaga vazia!");
		else 
			placas[vaga-1] = null;

	}

	public int consultarPlaca(String placa) throws Exception {
		try {
			for (int i = 0; i < placas.length; i++) {
				if (placas[i] != null && placas[i].equals(placa))
					return i + 1;
			} 
			return -1;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void transferir(int vaga1, int vaga2) throws Exception {
		if (!(vaga1 > 0 && vaga1 < placas.length) && !(vaga2 > 0 && vaga2 < placas.length))
			throw new Exception("Vaga(s) inválida(s)!");

		if (placas[vaga1 - 1] != null && placas[vaga2 - 1] == null) 
			placas[vaga2 - 1] = placas[vaga1 - 1];
		else 
			throw new Exception("Vaga(s) vazia(s)!");
	}

	public String[] listarGeral() {

		String[] out = new String[placas.length];

		for (int i = 0; i < placas.length; i++) {
			out[i] = placas[i];
		} 
		return out;

	}

	public ArrayList<Integer> listarLivres() {

		ArrayList<Integer> out = new ArrayList<>();

		for (int i = 0; i < placas.length; i++) {
			if (placas[i] == null)
				out.add(i + 1);
		}
		return out;
	}

	public void gravarDados() throws Exception {
		try {

			FileWriter arqplacas = new FileWriter("./data/placas.csv");

			for (int i = 0; i < placas.length; i++) {
				if (placas[i]!=null) {
					if (i < placas.length - 1) {
						arqplacas.write(String.format("%s;%s%n", placas[i], i + 1));
					} else {
						arqplacas.write(String.format("%s;%s", placas[i], i + 1));
					}
				}
			}
			arqplacas.flush();
			arqplacas.close();

		} catch (IOException e) {
			throw new Exception("Erro na hora de criar o arquivo");
		}
	}

	public void lerDados() throws Exception{
		try {

			File arqplacas = new File("./data/placas.csv");

			if (arqplacas.exists()) {
				Scanner leitor = new Scanner(arqplacas);

				while (leitor.hasNextLine()) {
					String[] l = leitor.nextLine().split(";");
					if (l.length > 0) {
						this.placas[Integer.parseInt(l[1]) - 1] = l[0];
					}
				}
				leitor.close();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}