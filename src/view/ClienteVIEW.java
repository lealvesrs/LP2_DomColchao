package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ClienteVIEW extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField cpf;
	private JTextField telefone;
	private JTextField cep;
	private JTextField rua;
	private JTextField textField_5;
	private JTextField pesqNome;
	private JTable TabelaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteVIEW frame = new ClienteVIEW();
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
	public ClienteVIEW() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 22));
		setBounds(100, 100, 749, 329);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(221, 11, 44, 26);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(52, 48, 367, 148);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		nome = new JTextField();
		nome.setBounds(56, 8, 240, 20);
		panel.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(10, 39, 29, 14);
		panel.add(lblNewLabel_2);
		
		cpf = new JTextField();
		cpf.setBounds(58, 36, 238, 20);
		panel.add(cpf);
		cpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setBounds(10, 64, 46, 14);
		panel.add(lblNewLabel_3);
		
		telefone = new JTextField();
		telefone.setBounds(58, 61, 238, 20);
		panel.add(telefone);
		telefone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CEP:");
		lblNewLabel_4.setBounds(10, 89, 29, 14);
		panel.add(lblNewLabel_4);
		
		cep = new JTextField();
		cep.setBounds(56, 86, 240, 20);
		panel.add(cep);
		cep.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Rua:");
		lblNewLabel_5.setBounds(10, 117, 29, 14);
		panel.add(lblNewLabel_5);
		
		rua = new JTextField();
		rua.setBounds(56, 114, 161, 20);
		panel.add(rua);
		rua.setColumns(10);
		
		JLabel numero = new JLabel("nº");
		numero.setBounds(236, 117, 18, 14);
		panel.add(numero);
		
		textField_5 = new JTextField();
		textField_5.setBounds(250, 114, 46, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(36, 226, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(146, 226, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(245, 226, 89, 23);
		getContentPane().add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(355, 226, 89, 23);
		getContentPane().add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(473, 48, 234, 148);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		pesqNome = new JTextField();
		pesqNome.setBounds(39, 11, 115, 20);
		panel_1.add(pesqNome);
		pesqNome.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Nome:");
		lblNewLabel_7.setBounds(8, 14, 31, 14);
		panel_1.add(lblNewLabel_7);
		
		JButton btnPesq = new JButton("(lupa)");
		btnPesq.setBounds(164, 10, 31, 23);
		panel_1.add(btnPesq);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 42, 193, 95);
		panel_1.add(scrollPane);
		
		TabelaCliente = new JTable();
		scrollPane.setViewportView(TabelaCliente);
		TabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome"
			}
		));
		
		JLabel lblNewLabel_6 = new JLabel("Pesquisar");
		lblNewLabel_6.setBounds(553, 17, 46, 14);
		getContentPane().add(lblNewLabel_6);

	}
}
