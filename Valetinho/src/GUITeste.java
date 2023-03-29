import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollBar;

public class GUITeste {

	private JFrame frmValetinho;
	private JTextField insPlacaField;
	private JTextField insVagaField;
	private Estacionamento estacionamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITeste window = new GUITeste();
					window.frmValetinho.setVisible(true);
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
		frmValetinho = new JFrame();
		frmValetinho.setTitle("Valetinho");
		frmValetinho.setBounds(100, 100, 450, 300);
		frmValetinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmValetinho.getContentPane().setLayout(null);
		
		JPanel home = new JPanel();

		home.setBounds(0, 0, 434, 261);
		frmValetinho.getContentPane().add(home);
		home.setLayout(null);
		
		JButton situacao = new JButton("Situação");
		situacao.setBounds(110, 11, 89, 23);
		home.add(situacao);
		
		JButton vagas = new JButton("Vagas");
		vagas.setBounds(219, 11, 89, 23);
		home.add(vagas);
		
		JButton consulta = new JButton("Consulta");
		consulta.setBounds(110, 171, 89, 23);
		home.add(consulta);
		
		JButton entrada_1 = new JButton("Entrada");
		
		entrada_1.setBounds(110, 205, 89, 23);
		home.add(entrada_1);
		
		JButton transferir = new JButton("Transferir");
		transferir.setBounds(219, 171, 89, 23);
		home.add(transferir);
		
		JButton saida = new JButton("Saída");
		saida.setBounds(219, 205, 89, 23);
		home.add(saida);
		
		JTextArea txtVagas = new JTextArea();
		
		String [] vagasAtuais = this.estacionamento.listarGeral();
		int tamanho = vagasAtuais.length;
		
		for (int i = 0; i < tamanho; i++) {
			System.out.println(vagasAtuais[i]);
			txtVagas.append(String.format("%s%n",vagasAtuais[i]));
		}
		
		txtVagas.setEnabled(false);
		txtVagas.setEditable(false);
		txtVagas.setBounds(110, 45, 198, 115);
		
		home.add(txtVagas);
		
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
		
		
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmValetinho.setContentPane(home);
			}
		});
		
		entrada_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmValetinho.setContentPane(entrada);
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
