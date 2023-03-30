import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUITeste {

	private JFrame frameValetinho;
	private JTextField insPlacaField;
	private JTextField insVagaField;
	private JTextField vagaOrigemTextField;
	private JTextField vagaDestinoTextField;
	private Estacionamento estacionamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITeste window = new GUITeste();
					window.frameValetinho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUITeste() {
		try {
			estacionamento = new Estacionamento(10);
			estacionamento.lerDados();
			initialize();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameValetinho = new JFrame();
		frameValetinho.setTitle("Valetinho");
		frameValetinho.setBounds(100, 100, 450, 300);
		frameValetinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameValetinho.getContentPane().setLayout(null);
		
		JPanel home = new JPanel();

		home.setBounds(0, 0, 434, 261);
		frameValetinho.getContentPane().add(home);
		home.setLayout(null);
		
		JButton situacaoButton = new JButton("Situação");
		situacaoButton.setBounds(110, 11, 89, 23);
		home.add(situacaoButton);
		
		JButton vagasButton = new JButton("Vagas");
		vagasButton.setBounds(219, 11, 89, 23);
		home.add(vagasButton);
		
		JButton consultaButton = new JButton("Consulta");
		consultaButton.setBounds(110, 171, 89, 23);
		home.add(consultaButton);
		
		JButton entradaButton = new JButton("Entrada");
		
		entradaButton.setBounds(110, 205, 89, 23);
		home.add(entradaButton);
		
		JButton transferirButton = new JButton("Transferir");
		transferirButton.setBounds(219, 171, 89, 23);
		home.add(transferirButton);
		
		JButton saidaButton = new JButton("Saída");
		saidaButton.setBounds(219, 205, 89, 23);
		home.add(saidaButton);
		
		JTextArea vagasTextArea = new JTextArea();
		
		String [] vagasAtuais = this.estacionamento.listarGeral();
		int tamanho = vagasAtuais.length;
		
		for (int i = 0; i < tamanho; i++) {
			System.out.println(vagasAtuais[i]);
			vagasTextArea.append(String.format("%s%n",vagasAtuais[i]));
		}
		
		vagasTextArea.setEnabled(false);
		vagasTextArea.setEditable(false);
		vagasTextArea.setBounds(110, 45, 198, 115);
		
		home.add(vagasTextArea);
		
		JPanel entrada = new JPanel();
		entrada.setBounds(0, 0, 434, 261);
		entrada.setLayout(null);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(43, 202, 89, 23);
		entrada.add(cancelar);
		
		insPlacaField = new JTextField();
		insPlacaField.setBounds(43, 64, 143, 23);
		entrada.add(insPlacaField);
		insPlacaField.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Digite os dados a serem inseridos.");
		lblDescricao.setBounds(43, 11, 334, 23);
		entrada.add(lblDescricao);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(43, 45, 46, 14);
		entrada.add(lblPlaca);
		
		insVagaField = new JTextField();
		insVagaField.setBounds(196, 64, 28, 23);
		entrada.add(insVagaField);
		insVagaField.setColumns(10);
		
		JLabel insLblVaga = new JLabel("Vaga");
		insLblVaga.setBounds(196, 45, 46, 14);
		entrada.add(insLblVaga);
		
		JTextArea insLblStatus = new JTextArea();
		insLblStatus.setWrapStyleWord(true);
		insLblStatus.setLineWrap(true);
		insLblStatus.setEnabled(false);
		insLblStatus.setEditable(false);
		insLblStatus.setBounds(43, 98, 334, 93);
		entrada.add(insLblStatus);
		JButton confirmar = new JButton("Confirmar");
		
		JPanel transferirPanel = new JPanel();
		transferirPanel.setBounds(0, 0, 434, 261);
		transferirPanel.setLayout(null);
		
		JLabel tituloLabel = new JLabel("Transferir");
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloLabel.setBounds(178, 10, 75, 20);
		transferirPanel.add(tituloLabel);
		
		vagaOrigemTextField = new JTextField();
		vagaOrigemTextField.setBounds(216, 76, 96, 19);
		vagaOrigemTextField.setColumns(10);
		transferirPanel.add(vagaOrigemTextField);
		
		vagaDestinoTextField = new JTextField();
		vagaDestinoTextField.setBounds(216, 125, 96, 19);
		vagaDestinoTextField.setColumns(10);
		transferirPanel.add(vagaDestinoTextField);
		
		JLabel vagaOrigemLabel = new JLabel("№ da vaga de origem");
		vagaOrigemLabel.setBounds(87, 75, 125, 19);
		transferirPanel.add(vagaOrigemLabel);
		
		JLabel vagaDestinoLabel = new JLabel("№ da vaga de destino");
		vagaDestinoLabel.setBounds(87, 125, 125, 19);
		transferirPanel.add(vagaDestinoLabel);
		
		JButton confirmarTransferenciaButton = new JButton("Confirmar");
		confirmarTransferenciaButton.setBounds(112, 210, 85, 21);
		transferirPanel.add(confirmarTransferenciaButton);
		
		JButton cancelarTransferenciaButton = new JButton("Cancelar");
		cancelarTransferenciaButton.setBounds(214, 210, 85, 21);
		transferirPanel.add(cancelarTransferenciaButton);
		
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(home);
			}
		});
		
		entradaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(entrada);
			}
		});
		
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				estacionamento.entrar(insPlacaField.getText(), Integer.parseInt(insVagaField.getText()));
				insLblStatus.setText("Carro inserido com êxito!");
				} catch (Exception err) {
					insLblStatus.setText(String.format("Erro ao inserir carro! %s", err.getMessage()));
				}
			}
		});
		
		transferirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(transferirPanel);
			}
		});
		
		confirmarTransferenciaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int vagaOrigem = Integer.parseInt(vagaOrigemTextField.getText());
					int vagaDestino = Integer.parseInt(vagaDestinoTextField.getText());
					System.out.println("Vagas -> " + vagaOrigem + " e " + vagaDestino);
					int opcao = JOptionPane.showConfirmDialog(
						null,
						String.format("Deseja mesmo transferir o veículo da vaga %s para a vaga %s?", vagaOrigem, vagaDestino));
					if (opcao == JOptionPane.YES_NO_OPTION)
						estacionamento.transferir(vagaOrigem, vagaDestino);
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, "Ops! " + err.getMessage());
				}
			}
		});
		
		cancelarTransferenciaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(home);
			}
		});
		
		confirmar.setBounds(142, 202, 89, 23);
		entrada.add(confirmar);
	}
	
	private String [][] extrairVagas() {
		int tamanho = estacionamento.listarGeral().length;
		String [][] out = new String[tamanho][2];
		
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0)
					out[i][j] = estacionamento.listarGeral()[i];
				else
					out[i][j] = String.format("%s",i + 1);
			}
		}
		return out;
	}
}
