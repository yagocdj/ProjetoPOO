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
	private JTextField entradaTextFieldPlaca;
	private JTextField entradaTextFieldVaga;
	private JTextField consultaTextFieldPlaca;
	private JTextField saidaTextFieldVaga;
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
		frameValetinho.setBounds(100, 100, 449, 300);
		frameValetinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameValetinho.getContentPane().setLayout(null);

		JPanel home = new JPanel();

		home.setBounds(0, 0, 434, 261);
		frameValetinho.getContentPane().add(home);

		home.setLayout(null);

		JButton situacao = new JButton("Situação");
		situacao.setBounds(110, 11, 89, 23);
		home.add(situacao);

		JButton vagas = new JButton("Vagas");
		vagas.setBounds(219, 11, 89, 23);
		home.add(vagas);

		JButton homeConsultaButton = new JButton("Consulta");
		homeConsultaButton.setBounds(110, 171, 89, 23);
		home.add(homeConsultaButton);

		JButton entrada_1 = new JButton("Entrada");

		entrada_1.setBounds(110, 205, 89, 23);
		home.add(entrada_1);

		JButton transferirButton = new JButton("Transferir");
		transferirButton.setBounds(219, 171, 89, 23);
		home.add(transferirButton);

		JButton saida_1 = new JButton("Saída");
		saida_1.setBounds(219, 205, 89, 23);
		home.add(saida_1);

		JTextArea txtVagas = new JTextArea();

		txtVagas.setEnabled(false);
		txtVagas.setEditable(false);
		txtVagas.setBounds(110, 45, 198, 115);

		home.add(txtVagas);

		JPanel entrada = new JPanel();
		entrada.setBounds(0, 0, 434, 261);
		entrada.setLayout(null);

		JButton entradaButtonCancelar = new JButton("Cancelar");
		entradaButtonCancelar.setBounds(142, 202, 89, 23);
		entrada.add(entradaButtonCancelar);

		entradaTextFieldPlaca = new JTextField();
		entradaTextFieldPlaca.setBounds(43, 64, 143, 23);
		entrada.add(entradaTextFieldPlaca);
		entradaTextFieldPlaca.setColumns(10);

		JLabel entradaLabelDescricao = new JLabel("Digite os dados a serem inseridos.");
		entradaLabelDescricao.setBounds(43, 11, 334, 23);
		entrada.add(entradaLabelDescricao);

		JLabel entradaLabelPlaca = new JLabel("Placa");
		entradaLabelPlaca.setBounds(43, 45, 46, 14);
		entrada.add(entradaLabelPlaca);

		entradaTextFieldVaga = new JTextField();
		entradaTextFieldVaga.setBounds(196, 64, 28, 23);
		entrada.add(entradaTextFieldVaga);
		entradaTextFieldVaga.setColumns(10);

		JLabel entradaLabelVaga = new JLabel("Vaga");
		entradaLabelVaga.setBounds(196, 45, 46, 14);
		entrada.add(entradaLabelVaga);

		JTextArea entradaTextAreaStatus = new JTextArea();
		entradaTextAreaStatus.setWrapStyleWord(true);
		entradaTextAreaStatus.setLineWrap(true);
		entradaTextAreaStatus.setEnabled(false);
		entradaTextAreaStatus.setEditable(false);
		entradaTextAreaStatus.setBounds(43, 98, 334, 93);
		entrada.add(entradaTextAreaStatus);
		JButton entradaButtonConfirmar = new JButton("Confirmar");
		frameValetinho.getContentPane().add(entrada);
		entradaButtonConfirmar.setBounds(43, 202, 89, 23);
		entrada.add(entradaButtonConfirmar);

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

		entradaButtonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					estacionamento.entrar(entradaTextFieldPlaca.getText(), Integer.parseInt(entradaTextFieldVaga.getText()));
					entradaTextAreaStatus.setText("Carro inserido com êxito!");
				} catch (Exception err) {
					entradaTextAreaStatus.setText(String.format("Erro ao inserir carro! %s", err.getMessage()));
				}
			}
		});


		JPanel consulta = new JPanel();
		consulta.setLayout(null);
		consulta.setBounds(0, 0, 434, 261);
		frameValetinho.getContentPane().add(consulta);

		entradaButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(home);
			}
		});

		JButton consultaButtonCancelar = new JButton("Cancelar");
		consultaButtonCancelar.setBounds(142, 202, 89, 23);
		consulta.add(consultaButtonCancelar);

		JLabel consultaLabelDescricao = new JLabel("Digite a placa a ser consultada.");
		consultaLabelDescricao.setBounds(43, 11, 334, 23);
		consulta.add(consultaLabelDescricao);

		JLabel consultaLabelPlaca = new JLabel("Placa");
		consultaLabelPlaca.setBounds(43, 45, 46, 14);
		consulta.add(consultaLabelPlaca);

		JTextArea consultaTextAreaStatus = new JTextArea();
		consultaTextAreaStatus.setWrapStyleWord(true);
		consultaTextAreaStatus.setLineWrap(true);
		consultaTextAreaStatus.setEnabled(false);
		consultaTextAreaStatus.setEditable(false);
		consultaTextAreaStatus.setBounds(43, 98, 334, 93);
		consulta.add(consultaTextAreaStatus);

		JButton consultaButtonConfirmar = new JButton("Confirmar");
		consultaButtonConfirmar.setBounds(43, 202, 89, 23);
		consulta.add(consultaButtonConfirmar);

		consultaTextFieldPlaca = new JTextField();
		consultaTextFieldPlaca.setColumns(10);
		consultaTextFieldPlaca.setBounds(43, 64, 143, 23);
		consulta.add(consultaTextFieldPlaca);

		JPanel saida = new JPanel();
		saida.setBounds(0, 0, 434, 261);
		frameValetinho.getContentPane().add(saida);
		saida.setLayout(null);

		JLabel saidaLabelVaga = new JLabel("Vaga de Saída:");
		saidaLabelVaga.setBounds(48, 47, 94, 25);
		saida.add(saidaLabelVaga);

		saidaTextFieldVaga = new JTextField();
		saidaTextFieldVaga.setBounds(147, 49, 89, 20);
		saida.add(saidaTextFieldVaga);
		saidaTextFieldVaga.setColumns(10);

		JButton sairButtonConfirmar = new JButton("Confirmar");
		sairButtonConfirmar.setBounds(48, 92, 89, 23);
		saida.add(sairButtonConfirmar);

		JButton sairButtonCancelar = new JButton("Cancelar");
		sairButtonCancelar.setBounds(147, 92, 89, 23);
		saida.add(sairButtonCancelar);

		JTextArea saidaTextArea = new JTextArea();
		saidaTextArea.setEditable(false);
		saidaTextArea.setBounds(48, 141, 188, 52);
		saida.add(saidaTextArea);

		sairButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(home);
			}
		});


		sairButtonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					estacionamento.sair(Integer.parseInt(saidaTextFieldVaga.getText()));
					saidaTextArea.setText("Vaga desocupada com êxito!");
				}

				catch (Exception err) {
					saidaTextArea.setText(String.format(err.getMessage()));
				}
			}
		});

		entrada_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(entrada);
			}
		});

		saida_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(saida);
			}
		});

		homeConsultaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(consulta);
			}
		});
		entradaButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(home);
			}
		});

		consultaButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(home);
			}
		});

		consultaButtonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String placa = consultaTextFieldPlaca.getText();
					int vaga = estacionamento.consultarPlaca(placa);
					if (vaga > 0)
						consultaTextAreaStatus.setText(String.format("A placa %s está na vaga %s", placa, vaga));
					else
						consultaTextAreaStatus.setText("A placa não foi encontrada!");

				} catch (Exception err) {
					consultaTextAreaStatus.setText(String.format("Erro ao inserir carro! %s", err.getMessage()));
				}
			}
		});

		String [] vagasAtuais = this.estacionamento.listarGeral();
		int tamanho = vagasAtuais.length;

		for (int i = 0; i < tamanho; i++) {
			txtVagas.append(String.format("%s%n",vagasAtuais[i]));
		}

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
