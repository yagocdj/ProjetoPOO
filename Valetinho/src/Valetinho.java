import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Primeiro Design, ainda precisa organizar um pouco mais e colocar os eventos para
// serem lidos.

public class Valetinho extends JFrame {

	private JPanel contentPane;
	private JTextField operacao;
	private JLabel lblNewLabel_1;
	private JTextField placa1;
	private JTextField sairVaga;
	private JTextField entrarVaga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Valetinho frame = new Valetinho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Valetinho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Valetinho");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setBounds(158, 11, 65, 28);
		contentPane.add(titulo);
		
		operacao = new JTextField();
		operacao.setBounds(67, 66, 86, 20);
		contentPane.add(operacao);
		operacao.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Opção");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(67, 50, 35, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextArea menuOpcoes = new JTextArea();
		menuOpcoes.setText(" 0 - terminar programa\r\n 1 - entrar carro\r\n 2 - sair carro\r\n 3 - consultar placa\r\n 4 - transferir placa\r\n 5 - listar geral\r\n 6 - listar vagas livres");
		menuOpcoes.setBounds(193, 50, 148, 109);
		menuOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(menuOpcoes);
		
		JButton opcaoConfirmar = new JButton("Confirmar");
		opcaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Opção escolhida: "+operacao.getText());
			}
		});
		opcaoConfirmar.setBounds(67, 97, 86, 23);
		opcaoConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(opcaoConfirmar);
		
		JLabel lblNewLabel_2 = new JLabel("Placa");
		lblNewLabel_2.setBounds(67, 167, 25, 14);
		contentPane.add(lblNewLabel_2);
		
		placa1 = new JTextField();
		placa1.setEnabled(false);
		placa1.setBounds(67, 182, 86, 20);
		contentPane.add(placa1);
		placa1.setColumns(10);
		
		JButton placaConfirmar = new JButton("Confirmar");
		placaConfirmar.setEnabled(false);
		placaConfirmar.setBounds(67, 213, 86, 23);
		contentPane.add(placaConfirmar);
		
		JLabel lblNewLabel_4 = new JLabel("Da Vaga:");
		lblNewLabel_4.setBounds(213, 167, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		sairVaga = new JTextField();
		sairVaga.setEnabled(false);
		sairVaga.setBounds(213, 182, 86, 20);
		contentPane.add(sairVaga);
		sairVaga.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Para Vaga:");
		lblNewLabel_5.setBounds(213, 213, 53, 14);
		contentPane.add(lblNewLabel_5);
		
		entrarVaga = new JTextField();
		entrarVaga.setEnabled(false);
		entrarVaga.setBounds(213, 227, 86, 20);
		contentPane.add(entrarVaga);
		entrarVaga.setColumns(10);
		
		JButton vagaConfirmar = new JButton("Confirmar");
		vagaConfirmar.setEnabled(false);
		vagaConfirmar.setBounds(213, 258, 86, 23);
		contentPane.add(vagaConfirmar);
	}
}