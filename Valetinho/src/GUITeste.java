import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class GUITeste {

	private JFrame frameValetinho;
	private JTextField textfieldEntradaPlaca;
	private JTextField textfieldEntradaVaga;
	private JTextField textfieldConsultaPlaca;
	private JTextField textfieldSaidaVaga;
	private JTextField textfieldTransferenciaOrigem;
	private JTextField textfieldTransferenciaDestino;
	private Estacionamento estacionamento;
	private JPanel panelHome;
	private JButton btnHomeLivres;
	private JButton btnHomeAtualizar;
	private JButton btnHomeConsulta;
	private JButton btnHomeEntrada;
	private JButton btnHomeTransferir;
	private JButton btnHomeSaida;
	private JPanel panelEntrada;
	private JButton btnEntradaCancelar;
	private JLabel lblEntradaDescricao;
	private JLabel lblEntradaPlaca;
	private JLabel lblEntradaVaga;
	private JTextArea textareaEntradaStatus;
	private JButton btnEntradaConfirmar;
	private JPanel panelTransferir;
	private JLabel lblTransferenciaTitulo;
	private JLabel lblTransferenciaOrigem;
	private JLabel lblTransferenciaDestino;
	private JButton btnTransferenciaConfirmar;
	private JButton btnTransferenciaCancelar;
	private JPanel panelConsulta;
	private JButton btnConsultaCancelar;
	private JLabel lblConsultaDescricao;
	private JLabel lblConsultaPlaca;
	private JTextArea textareaConsultaStatus;
	private JButton btnConsultaConfirmar;
	private JPanel panelSaida;
	private JLabel lblSaidaVaga;
	private JButton btnSairConfirmar;
	private JButton btnSairCancelar;
	private JTextArea textareaSaida;
	private JList<String> listHomeVagas;
	private JScrollPane scrollPane;
	private DefaultListModel<String> modelHomeVagas;
	
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
		frameValetinho.setIconImage(Toolkit.getDefaultToolkit().getImage(GUITeste.class.getResource("/images/valetinhoIcon.png")));
		frameValetinho.setTitle("Valetinho");
		frameValetinho.setBounds(100, 100, 449, 300);
		frameValetinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameValetinho.getContentPane().setLayout(null);

		panelHome = new JPanel();
		panelHome.setBounds(0, 0, 434, 261);
		panelHome.setLayout(null);
		frameValetinho.getContentPane().add(panelHome);

		btnHomeAtualizar = new JButton("Atualizar");
		btnHomeAtualizar.setBounds(110, 11, 89, 23);
		panelHome.add(btnHomeAtualizar);

		btnHomeLivres = new JButton("Livres");
		btnHomeLivres.setBounds(219, 11, 89, 23);
		panelHome.add(btnHomeLivres);

		btnHomeConsulta = new JButton("Consulta");
		btnHomeConsulta.setBounds(110, 171, 89, 23);
		panelHome.add(btnHomeConsulta);

		btnHomeEntrada = new JButton("Entrada");
		btnHomeEntrada.setBounds(110, 205, 89, 23);
		panelHome.add(btnHomeEntrada);

		btnHomeTransferir = new JButton("Transferir");
		btnHomeTransferir.setBounds(219, 171, 89, 23);
		panelHome.add(btnHomeTransferir);

		btnHomeSaida = new JButton("Saída");
		btnHomeSaida.setBounds(219, 205, 89, 23);
		panelHome.add(btnHomeSaida);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 45, 161, 115);
		panelHome.add(scrollPane);
		
		listHomeVagas = new JList<>();
		
		scrollPane.setViewportView(listHomeVagas);
		atualizarVagas();

		panelEntrada = new JPanel();
		panelEntrada.setBounds(0, 0, 434, 261);
		panelEntrada.setLayout(null);

		btnEntradaCancelar = new JButton("Cancelar");
		btnEntradaCancelar.setBounds(142, 202, 89, 23);
		panelEntrada.add(btnEntradaCancelar);

		textfieldEntradaPlaca = new JTextField();
		textfieldEntradaPlaca.setBounds(43, 64, 143, 23);
		panelEntrada.add(textfieldEntradaPlaca);
		textfieldEntradaPlaca.setColumns(10);

		lblEntradaDescricao = new JLabel("Digite os dados a serem inseridos.");
		lblEntradaDescricao.setBounds(43, 11, 334, 23);
		panelEntrada.add(lblEntradaDescricao);

		lblEntradaPlaca = new JLabel("Placa");
		lblEntradaPlaca.setBounds(43, 45, 46, 14);
		panelEntrada.add(lblEntradaPlaca);

		textfieldEntradaVaga = new JTextField();
		textfieldEntradaVaga.setBounds(196, 64, 28, 23);
		panelEntrada.add(textfieldEntradaVaga);
		textfieldEntradaVaga.setColumns(10);

		lblEntradaVaga = new JLabel("Vaga");
		lblEntradaVaga.setBounds(196, 45, 46, 14);
		panelEntrada.add(lblEntradaVaga);

		textareaEntradaStatus = new JTextArea();
		textareaEntradaStatus.setWrapStyleWord(true);
		textareaEntradaStatus.setLineWrap(true);
		textareaEntradaStatus.setEnabled(false);
		textareaEntradaStatus.setEditable(false);
		textareaEntradaStatus.setBounds(43, 98, 334, 93);
		panelEntrada.add(textareaEntradaStatus);
		btnEntradaConfirmar = new JButton("Confirmar");
		btnEntradaConfirmar.setBounds(43, 202, 89, 23);
		panelEntrada.add(btnEntradaConfirmar);

		panelTransferir = new JPanel();
		panelTransferir.setBounds(0, 0, 434, 261);
		panelTransferir.setLayout(null);
		
		lblTransferenciaTitulo = new JLabel("Transferir");
		lblTransferenciaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTransferenciaTitulo.setBounds(178, 10, 75, 20);
		panelTransferir.add(lblTransferenciaTitulo);
		
		textfieldTransferenciaOrigem = new JTextField();
		textfieldTransferenciaOrigem.setBounds(216, 76, 96, 19);
		textfieldTransferenciaOrigem.setColumns(10);
		panelTransferir.add(textfieldTransferenciaOrigem);
		
		textfieldTransferenciaDestino = new JTextField();
		textfieldTransferenciaDestino.setBounds(216, 125, 96, 19);
		textfieldTransferenciaDestino.setColumns(10);
		panelTransferir.add(textfieldTransferenciaDestino);
		
		lblTransferenciaOrigem = new JLabel("№ da vaga de origem");
		lblTransferenciaOrigem.setBounds(87, 75, 125, 19);
		panelTransferir.add(lblTransferenciaOrigem);
		
		lblTransferenciaDestino = new JLabel("№ da vaga de destino");
		lblTransferenciaDestino.setBounds(87, 125, 125, 19);
		panelTransferir.add(lblTransferenciaDestino);
		
		btnTransferenciaConfirmar = new JButton("Confirmar");
		btnTransferenciaConfirmar.setBounds(112, 210, 85, 21);
		panelTransferir.add(btnTransferenciaConfirmar);
		
		btnTransferenciaCancelar = new JButton("Cancelar");
		btnTransferenciaCancelar.setBounds(214, 210, 85, 21);
		panelTransferir.add(btnTransferenciaCancelar);


		panelConsulta = new JPanel();
		panelConsulta.setLayout(null);
		panelConsulta.setBounds(0, 0, 434, 261);


		btnConsultaCancelar = new JButton("Cancelar");
		btnConsultaCancelar.setBounds(142, 202, 89, 23);
		panelConsulta.add(btnConsultaCancelar);

		lblConsultaDescricao = new JLabel("Digite a placa a ser consultada.");
		lblConsultaDescricao.setBounds(43, 11, 334, 23);
		panelConsulta.add(lblConsultaDescricao);

		lblConsultaPlaca = new JLabel("Placa");
		lblConsultaPlaca.setBounds(43, 45, 46, 14);
		panelConsulta.add(lblConsultaPlaca);

		textareaConsultaStatus = new JTextArea();
		textareaConsultaStatus.setWrapStyleWord(true);
		textareaConsultaStatus.setLineWrap(true);
		textareaConsultaStatus.setEnabled(false);
		textareaConsultaStatus.setEditable(false);
		textareaConsultaStatus.setBounds(43, 98, 334, 93);
		panelConsulta.add(textareaConsultaStatus);

		btnConsultaConfirmar = new JButton("Confirmar");
		btnConsultaConfirmar.setBounds(43, 202, 89, 23);
		panelConsulta.add(btnConsultaConfirmar);

		textfieldConsultaPlaca = new JTextField();
		textfieldConsultaPlaca.setColumns(10);
		textfieldConsultaPlaca.setBounds(43, 64, 143, 23);
		panelConsulta.add(textfieldConsultaPlaca);

		panelSaida = new JPanel();
		panelSaida.setBounds(0, 0, 434, 261);
		panelSaida.setLayout(null);

		lblSaidaVaga = new JLabel("Vaga de Saída:");
		lblSaidaVaga.setBounds(48, 47, 94, 25);
		panelSaida.add(lblSaidaVaga);

		textfieldSaidaVaga = new JTextField();
		textfieldSaidaVaga.setBounds(147, 49, 89, 20);
		panelSaida.add(textfieldSaidaVaga);
		textfieldSaidaVaga.setColumns(10);

		btnSairConfirmar = new JButton("Confirmar");
		btnSairConfirmar.setBounds(48, 92, 89, 23);
		panelSaida.add(btnSairConfirmar);

		btnSairCancelar = new JButton("Cancelar");
		btnSairCancelar.setBounds(147, 92, 89, 23);
		panelSaida.add(btnSairCancelar);

		textareaSaida = new JTextArea();
		textareaSaida.setEditable(false);
		textareaSaida.setBounds(48, 141, 188, 52);
		panelSaida.add(textareaSaida);
		
		btnHomeTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelTransferir);
			}
		});
		
		
		
		btnTransferenciaConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int vagaOrigem = Integer.parseInt(textfieldTransferenciaOrigem.getText());
					int vagaDestino = Integer.parseInt(textfieldTransferenciaDestino.getText());
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
		
		btnTransferenciaCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelHome);
				atualizarVagas();
			}
		});

		btnEntradaConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					estacionamento.entrar(textfieldEntradaPlaca.getText(), Integer.parseInt(textfieldEntradaVaga.getText()));
					textareaEntradaStatus.setText("Carro inserido com êxito!");
				} catch (Exception err) {
					textareaEntradaStatus.setText(String.format("Erro ao inserir carro! %s", err.getMessage()));
				}
			}
		});
		
		btnEntradaCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelHome);
				atualizarVagas();
			}
		});

		btnSairCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelHome);
				atualizarVagas();
			}
		});


		btnSairConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					estacionamento.sair(Integer.parseInt(textfieldSaidaVaga.getText()));
					textareaSaida.setText("Vaga desocupada com êxito!");
				}

				catch (Exception err) {
					textareaSaida.setText(String.format(err.getMessage()));
				}
			}
		});
		
		btnHomeAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarVagas();
				JOptionPane.showInternalMessageDialog(frameValetinho.getContentPane(), "Vagas atualizadas!");
			}
		});
		
		btnHomeLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarVagas(estacionamento.listarLivres());
				
			}
		});

		btnHomeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelEntrada);
			}
		});

		btnHomeSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelSaida);
			}
		});

		btnHomeConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelConsulta);
			}
		});
		
		btnEntradaCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelHome);
				atualizarVagas();
			}
		});

		btnConsultaCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelHome);
				atualizarVagas();
			}
		});

		btnConsultaConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String placa = textfieldConsultaPlaca.getText();
					int vaga = estacionamento.consultarPlaca(placa);
					if (vaga > 0)
						textareaConsultaStatus.setText(String.format("A placa %s está na vaga %s", placa, vaga));
					else
						textareaConsultaStatus.setText("A placa não foi encontrada!");

				} catch (Exception err) {
					textareaConsultaStatus.setText(String.format("Erro ao inserir carro! %s", err.getMessage()));
				}
			}
		});
		
		frameValetinho.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					estacionamento.gravarDados();
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, "Falha ao gravar dados!");
				}
			}
		});
		

	}
	
	private void atualizarVagas() {

		DefaultListModel<String> model = new DefaultListModel<>();
		String [] vagasAtuais = this.estacionamento.listarGeral();

		int tamanho = vagasAtuais.length;

		for (int i = 0; i < tamanho; i++) {
			if (vagasAtuais[i] == null) {
				model.addElement(String.format("%s - %s", i+1, "Livre"));
			} else {
				model.addElement(String.format("%s - %s", i+1, vagasAtuais[i]));
			}
		}

		listHomeVagas.setModel(model);
	}
	
	private void atualizarVagas(ArrayList<Integer> vagasLivres) {

		DefaultListModel<String> model = new DefaultListModel<>();

		for (int i : vagasLivres) {
			model.addElement(String.format("%s - %s", i, "Livre"));
		}

		listHomeVagas.setModel(model);
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
