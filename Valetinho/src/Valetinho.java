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
import javax.swing.SwingConstants;

public class Valetinho {

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
	private JButton btnEntradaVoltar;
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
	private JButton btnTransferenciaVoltar;
	private JPanel panelConsulta;
	private JButton btnConsultaVoltar;
	private JLabel lblConsultaDescricao;
	private JLabel lblConsultaPlaca;
	private JTextArea textareaConsultaStatus;
	private JButton btnConsultaConfirmar;
	private JPanel panelSaida;
	private JLabel lblSaidaVaga;
	private JButton btnSairConfirmar;
	private JButton btnSairVoltar;
	private JTextArea textareaSaida;
	private JList<String> listHomeVagas;
	private JScrollPane scrollPaneHome;
	private JLabel lblHomeTitulo;
	private JScrollPane scrollPaneEntrada;
	private JScrollPane scrollPaneConsulta;
	private JScrollPane scrollPaneSaida;
	private JLabel lblSaidaDescricao;
	private JTextArea textareaTransferirStatus;
	private JScrollPane scrollPaneTransferir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Valetinho window = new Valetinho();
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
	public Valetinho() {
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
		frameValetinho.setIconImage(Toolkit.getDefaultToolkit().getImage(Valetinho.class.getResource("/images/valetinhoIcon.png")));
		frameValetinho.setTitle("Valetinho");
		frameValetinho.setBounds(100, 100, 449, 374);
		frameValetinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameValetinho.getContentPane().setLayout(null);
		
		panelHome = new JPanel();
		panelHome.setBounds(0, 0, 434, 335);
		panelHome.setLayout(null);

		btnHomeAtualizar = new JButton("Atualizar");
		btnHomeAtualizar.setBounds(110, 67, 89, 23);
		panelHome.add(btnHomeAtualizar);

		btnHomeLivres = new JButton("Livres");
		btnHomeLivres.setBounds(219, 67, 89, 23);
		panelHome.add(btnHomeLivres);

		btnHomeConsulta = new JButton("Consulta");
		btnHomeConsulta.setBounds(110, 251, 89, 23);
		panelHome.add(btnHomeConsulta);

		btnHomeEntrada = new JButton("Entrada");
		btnHomeEntrada.setBounds(110, 285, 89, 23);
		panelHome.add(btnHomeEntrada);

		btnHomeTransferir = new JButton("Transferir");
		btnHomeTransferir.setBounds(219, 251, 89, 23);
		panelHome.add(btnHomeTransferir);

		btnHomeSaida = new JButton("Saída");
		btnHomeSaida.setBounds(219, 285, 89, 23);
		panelHome.add(btnHomeSaida);

		scrollPaneHome = new JScrollPane();
		scrollPaneHome.setBounds(129, 101, 161, 139);
		panelHome.add(scrollPaneHome);

		listHomeVagas = new JList<>();
		scrollPaneHome.setViewportView(listHomeVagas);
		atualizarVagas();

		lblHomeTitulo = new JLabel("Vagas Valetinho");
		lblHomeTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeTitulo.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblHomeTitulo.setBounds(129, 11, 161, 45);
		panelHome.add(lblHomeTitulo);
		
		
		panelConsulta = new JPanel();
		panelConsulta.setLayout(null);
		panelConsulta.setBounds(0, 0, 434, 335);


		btnConsultaVoltar = new JButton("Voltar");
		btnConsultaVoltar.setBounds(142, 289, 89, 23);
		panelConsulta.add(btnConsultaVoltar);

		lblConsultaDescricao = new JLabel("Digite a placa a ser consultada.");
		lblConsultaDescricao.setBounds(43, 11, 334, 23);
		panelConsulta.add(lblConsultaDescricao);

		lblConsultaPlaca = new JLabel("Placa");
		lblConsultaPlaca.setBounds(43, 45, 46, 14);
		panelConsulta.add(lblConsultaPlaca);
		
		scrollPaneConsulta = new JScrollPane();
		scrollPaneConsulta.setBounds(43, 98, 334, 180);
		panelConsulta.add(scrollPaneConsulta);

		textareaConsultaStatus = new JTextArea();
		scrollPaneConsulta.setViewportView(textareaConsultaStatus);
		textareaConsultaStatus.setWrapStyleWord(true);
		textareaConsultaStatus.setLineWrap(true);
		textareaConsultaStatus.setEnabled(false);
		textareaConsultaStatus.setEditable(false);

		btnConsultaConfirmar = new JButton("Confirmar");
		btnConsultaConfirmar.setBounds(43, 289, 89, 23);
		panelConsulta.add(btnConsultaConfirmar);

		textfieldConsultaPlaca = new JTextField();
		textfieldConsultaPlaca.setColumns(10);
		textfieldConsultaPlaca.setBounds(43, 64, 143, 23);
		panelConsulta.add(textfieldConsultaPlaca);
		

		
		panelEntrada = new JPanel();
		panelEntrada.setBounds(0, 0, 434, 335);
		panelEntrada.setLayout(null);

		btnEntradaVoltar = new JButton("Voltar");
		btnEntradaVoltar.setBounds(142, 289, 89, 23);
		panelEntrada.add(btnEntradaVoltar);

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
		textfieldEntradaVaga.setBounds(196, 64, 43, 23);
		panelEntrada.add(textfieldEntradaVaga);
		textfieldEntradaVaga.setColumns(10);

		lblEntradaVaga = new JLabel("Vaga");
		lblEntradaVaga.setBounds(196, 45, 46, 14);
		panelEntrada.add(lblEntradaVaga);
		
		scrollPaneEntrada = new JScrollPane();
		scrollPaneEntrada.setBounds(43, 98, 334, 180);
		panelEntrada.add(scrollPaneEntrada);

		textareaEntradaStatus = new JTextArea();
		scrollPaneEntrada.setViewportView(textareaEntradaStatus);
		textareaEntradaStatus.setWrapStyleWord(true);
		textareaEntradaStatus.setLineWrap(true);
		textareaEntradaStatus.setEditable(false);
		btnEntradaConfirmar = new JButton("Confirmar");
		btnEntradaConfirmar.setBounds(43, 289, 89, 23);
		panelEntrada.add(btnEntradaConfirmar);
		
		
		panelTransferir = new JPanel();
		panelTransferir.setBounds(0, 0, 434, 335);
		panelTransferir.setLayout(null);
		
		scrollPaneTransferir = new JScrollPane();
		scrollPaneTransferir.setBounds(43, 98, 334, 180);
		textareaTransferirStatus = new JTextArea();
		scrollPaneTransferir.setViewportView(textareaTransferirStatus);
		panelTransferir.add(scrollPaneTransferir);

		lblTransferenciaTitulo = new JLabel("Digite a vaga de origem e destino. (A de destino precisa estar vaga)");
		lblTransferenciaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTransferenciaTitulo.setBounds(43, 11, 334, 23);
		panelTransferir.add(lblTransferenciaTitulo);

		textfieldTransferenciaOrigem = new JTextField();
		textfieldTransferenciaOrigem.setBounds(43, 64, 143, 23);
		textfieldTransferenciaOrigem.setColumns(10);
		panelTransferir.add(textfieldTransferenciaOrigem);

		textfieldTransferenciaDestino = new JTextField();
		textfieldTransferenciaDestino.setBounds(196, 64, 143, 23);
		textfieldTransferenciaDestino.setColumns(10);
		panelTransferir.add(textfieldTransferenciaDestino);

		lblTransferenciaOrigem = new JLabel("Vaga de origem");
		lblTransferenciaOrigem.setBounds(43, 45, 125, 14);
		panelTransferir.add(lblTransferenciaOrigem);

		lblTransferenciaDestino = new JLabel("Vaga de destino");
		lblTransferenciaDestino.setBounds(196, 45, 125, 14);
		panelTransferir.add(lblTransferenciaDestino);

		btnTransferenciaConfirmar = new JButton("Confirmar");
		btnTransferenciaConfirmar.setBounds(43, 289, 89, 23);
		panelTransferir.add(btnTransferenciaConfirmar);

		btnTransferenciaVoltar = new JButton("Voltar");
		btnTransferenciaVoltar.setBounds(142, 289, 89, 23);
		panelTransferir.add(btnTransferenciaVoltar);
		
		
		
		panelSaida = new JPanel();
		panelSaida.setBounds(0, 0, 434, 335);
		panelSaida.setLayout(null);
		
		lblSaidaDescricao = new JLabel("Digite a vaga a ser removida.");
		lblSaidaDescricao.setBounds(43, 11, 334, 23);
		panelSaida.add(lblSaidaDescricao);

		lblSaidaVaga = new JLabel("Vaga");
		lblSaidaVaga.setBounds(43, 45, 46, 14);
		panelSaida.add(lblSaidaVaga);

		textfieldSaidaVaga = new JTextField();
		textfieldSaidaVaga.setBounds(43, 64, 43, 23);
		panelSaida.add(textfieldSaidaVaga);
		textfieldSaidaVaga.setColumns(10);

		btnSairConfirmar = new JButton("Confirmar");
		btnSairConfirmar.setBounds(43, 289, 89, 23);
		panelSaida.add(btnSairConfirmar);

		btnSairVoltar = new JButton("Voltar");
		btnSairVoltar.setBounds(142, 289, 89, 23);
		panelSaida.add(btnSairVoltar);

		scrollPaneSaida = new JScrollPane();
		scrollPaneSaida.setBounds(43, 98, 334, 180);
		panelSaida.add(scrollPaneSaida);

		textareaSaida = new JTextArea();
		scrollPaneSaida.setViewportView(textareaSaida);
		textareaSaida.setEditable(false);

		
		
		btnSairVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelHome);
				atualizarVagas();
			}
		});

		btnEntradaConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String placa = textfieldEntradaPlaca.getText();
					int vaga = Integer.parseInt(textfieldEntradaVaga.getText());

					estacionamento.entrar(placa, vaga);
					textareaEntradaStatus.append(String.format("Carro de placa %s inserido na vaga %s!%n", placa, vaga));
				} catch (NumberFormatException err) {
					String vaga = textfieldSaidaVaga.getText();
					JOptionPane.showInternalMessageDialog(panelEntrada, String.format("Vaga %s inválida! Somente números inteiros!", vaga));
				}
				catch (Exception err) {
					String placa = textfieldEntradaPlaca.getText();
					int vaga = Integer.parseInt(textfieldEntradaVaga.getText());
					JOptionPane.showInternalMessageDialog(panelEntrada, String.format("Erro ao inserir placa %s na vaga %s! %s", placa, vaga, err.getMessage()));
				}
			}
		});

		btnEntradaVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelHome);
				atualizarVagas();
			}
		});

		btnConsultaVoltar.addActionListener(new ActionListener() {
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
						textareaConsultaStatus.append(String.format("A placa %s está na vaga %s!%n", placa, vaga));
					else
						JOptionPane.showInternalMessageDialog(panelConsulta, String.format("Placa %s não encontrada!", placa, vaga));
				} catch (Exception err) {
					JOptionPane.showInternalMessageDialog(panelConsulta, String.format("Erro! %s", err.getMessage()));
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

		btnSairConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int vaga = Integer.parseInt(textfieldSaidaVaga.getText());
					estacionamento.sair(vaga);
					textareaSaida.append(String.format("Vaga %s desocupada com êxito!%n", vaga));
				}
				catch (NumberFormatException err) {
					String vaga = textfieldSaidaVaga.getText();
					JOptionPane.showInternalMessageDialog(panelSaida, String.format("Vaga %s inválida! Somente números inteiros!", vaga));
				}
				catch (Exception err) {
					int vaga = Integer.parseInt(textfieldSaidaVaga.getText());
					JOptionPane.showInternalMessageDialog(panelSaida, String.format("Erro ao tentar removar da vaga %s! %s", vaga, err.getMessage()));
				}
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

		btnTransferenciaVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelHome);
				atualizarVagas();
			}
		});

		btnHomeTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameValetinho.setContentPane(panelTransferir);
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
		
		frameValetinho.getContentPane().add(panelHome);


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
