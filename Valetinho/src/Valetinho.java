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
	private JLabel operacaoLabel;
	private JTextField placaInput;
	private JTextField vagaOrigemInput;
	private JTextField vagaDestinoInput;

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
		titulo.setBounds(158, 11, 75, 28);
		contentPane.add(titulo);
		
		operacao = new JTextField();
		operacao.setBounds(67, 66, 86, 20);
		contentPane.add(operacao);
		operacao.setColumns(10);
		
		operacaoLabel = new JLabel("Opção");
		operacaoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		operacaoLabel.setBounds(67, 50, 35, 14);
		contentPane.add(operacaoLabel);
		
		JTextArea menuOpcoes = new JTextArea();
		menuOpcoes.setEditable(false);
		menuOpcoes.setText(" 0 - terminar programa\r\n 1 - entrar carro\r\n 2 - sair carro\r\n 3 - consultar placa\r\n 4 - transferir placa\r\n 5 - listar geral\r\n 6 - listar vagas livres");
		menuOpcoes.setBounds(193, 50, 148, 109);
		menuOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(menuOpcoes);
		
		JButton opcaoConfirmar = new JButton("Confirmar");
		opcaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = operacao.getText();
				switch(x) {
				case "0" : 
					JOptionPane.showMessageDialog(null, "Opção escolhida: "+operacao.getText());
					//System.out.println("Volte sempre!!!"); 
					break;
				case "1" : 
					JOptionPane.showMessageDialog(null, "Opção escolhida: "+operacao.getText());
					/**System.out.print("Qual a placa para entrar? ");
					placa = teclado.nextLine();
					System.out.print("Qual a vaga para entrar? ");
					vaga = Integer.parseInt(teclado.nextLine());
					estacionamento.entrar(placa, vaga); 
					System.out.println("entrou");**/
					break;
				case "2" : 
					JOptionPane.showMessageDialog(null, "Opção escolhida: "+operacao.getText());
					/**System.out.print("Qual a vaga para sair? ");
					vaga = Integer.parseInt(teclado.nextLine());
					estacionamento.sair(vaga); 
					System.out.println("saiu");**/
					break;
				case "3" : 
					JOptionPane.showMessageDialog(null, "Opção escolhida: "+operacao.getText());
					/**System.out.print("Qual a placa para consultar? ");
					placa = teclado.nextLine();
					vaga = estacionamento.consultarPlaca(placa); 
					System.out.println("vaga="+vaga);**/
					break;
				case "4" : 
					JOptionPane.showMessageDialog(null, "Opção escolhida: "+operacao.getText());
					/**System.out.print("Qual a vaga origem? ");
					vaga = Integer.parseInt(teclado.nextLine());
					System.out.print("Qual a vaga destino? ");
					int vagadestino = Integer.parseInt(teclado.nextLine());
					estacionamento.transferir(vaga, vagadestino); 
					System.out.println("transferiu");**/
					break;
				case "5" : 
					JOptionPane.showMessageDialog(null, "Opção escolhida: "+operacao.getText());
					/**System.out.println("listar vagas geral");
					for(String s : estacionamento.listarGeral()) {
						System.out.println(s);
					}**/
					break;
				case "6" : 
					JOptionPane.showMessageDialog(null, "Opção escolhida: "+operacao.getText());
					/**System.out.println("listar vagas livres");
					for(int i : estacionamento.listarLivres()) {
						System.out.println(i);
					}**/
					break;
				default: 
					JOptionPane.showMessageDialog(null, "Opção Invalida!"+operacao.getText());
					//System.out.println("Opção Invalida!");;
				}
			}
		});
		opcaoConfirmar.setBounds(67, 97, 86, 23);
		opcaoConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(opcaoConfirmar);
		
		JLabel inserirPlacaLabel = new JLabel("Placa");
		inserirPlacaLabel.setBounds(67, 167, 86, 14);
		contentPane.add(inserirPlacaLabel);
		
		placaInput = new JTextField();
		placaInput.setEnabled(false);
		placaInput.setBounds(67, 182, 86, 20);
		contentPane.add(placaInput);
		placaInput.setColumns(10);
		
		JButton placaConfirmarButton = new JButton("Confirmar");
		placaConfirmarButton.setEnabled(false);
		placaConfirmarButton.setBounds(67, 213, 86, 23);
		contentPane.add(placaConfirmarButton);
		
		JLabel vagaOrigemLabel = new JLabel("Da Vaga:");
		vagaOrigemLabel.setBounds(213, 167, 86, 14);
		contentPane.add(vagaOrigemLabel);
		
		vagaOrigemInput = new JTextField();
		vagaOrigemInput.setEnabled(false);
		vagaOrigemInput.setBounds(213, 182, 86, 20);
		contentPane.add(vagaOrigemInput);
		vagaOrigemInput.setColumns(10);
		
		JLabel vagaDestinoLabel = new JLabel("Para Vaga:");
		vagaDestinoLabel.setBounds(213, 213, 86, 14);
		contentPane.add(vagaDestinoLabel);
		
		vagaDestinoInput = new JTextField();
		vagaDestinoInput.setEnabled(false);
		vagaDestinoInput.setBounds(213, 227, 86, 20);
		contentPane.add(vagaDestinoInput);
		vagaDestinoInput.setColumns(10);
		
		JButton vagaConfirmarButton = new JButton("Confirmar");
		vagaConfirmarButton.setEnabled(false);
		vagaConfirmarButton.setBounds(213, 258, 86, 23);
		contentPane.add(vagaConfirmarButton);
	}
		
}

		
		