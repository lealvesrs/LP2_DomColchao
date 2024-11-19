package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VendedorVIEW extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField cpf;
	private JTextField telefone;
	private JTextField rua;
	private JTextField cep;
	private JTextField numero;
	private JTextField data_nasc;
	private JTextField ctps;
	private JTextField remuneracao;
	private JTextField nomePesq;
	private JTable TabelaVendedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendedorVIEW frame = new VendedorVIEW();
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
	public VendedorVIEW() {
		setBounds(100, 100, 747, 369);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 48, 349, 233);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 11, 31, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(10, 38, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setBounds(10, 69, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CEP:");
		lblNewLabel_4.setBounds(10, 153, 23, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rua:");
		lblNewLabel_5.setBounds(10, 128, 23, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("nº");
		lblNewLabel_6.setBounds(231, 128, 23, 14);
		panel.add(lblNewLabel_6);
		
		nome = new JTextField();
		nome.setBounds(69, 8, 228, 20);
		panel.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(69, 35, 228, 20);
		panel.add(cpf);
		cpf.setColumns(10);
		
		telefone = new JTextField();
		telefone.setBounds(69, 66, 228, 20);
		panel.add(telefone);
		telefone.setColumns(10);
		
		rua = new JTextField();
		rua.setBounds(69, 125, 146, 20);
		panel.add(rua);
		rua.setColumns(10);
		
		cep = new JTextField();
		cep.setBounds(69, 150, 228, 20);
		panel.add(cep);
		cep.setColumns(10);
		
		numero = new JTextField();
		numero.setBounds(251, 125, 46, 20);
		panel.add(numero);
		numero.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DtaNasc:");
		lblNewLabel_7.setBounds(10, 100, 46, 14);
		panel.add(lblNewLabel_7);
		
		data_nasc = new JTextField();
		data_nasc.setBounds(69, 97, 228, 20);
		panel.add(data_nasc);
		data_nasc.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("CTPS:");
		lblNewLabel_8.setBounds(10, 178, 31, 14);
		panel.add(lblNewLabel_8);
		
		ctps = new JTextField();
		ctps.setBounds(69, 175, 228, 20);
		panel.add(ctps);
		ctps.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Salário:");
		lblNewLabel_9.setBounds(10, 207, 52, 14);
		panel.add(lblNewLabel_9);
		
		remuneracao = new JTextField();
		remuneracao.setBounds(69, 204, 228, 20);
		panel.add(remuneracao);
		remuneracao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Vendedor");
		lblNewLabel.setBounds(200, 23, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(22, 305, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(123, 305, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(222, 305, 89, 23);
		getContentPane().add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(321, 305, 89, 23);
		getContentPane().add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(444, 48, 235, 233);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Nome:");
		lblNewLabel_11.setBounds(10, 11, 31, 14);
		panel_1.add(lblNewLabel_11);
		
		nomePesq = new JTextField();
		nomePesq.setBounds(40, 8, 131, 20);
		panel_1.add(nomePesq);
		nomePesq.setColumns(10);
		
		JButton btnPesq = new JButton("Lupa");
		btnPesq.setBounds(181, 7, 44, 23);
		panel_1.add(btnPesq);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 57, 189, 150);
		panel_1.add(scrollPane);
		
		TabelaVendedor = new JTable();
		scrollPane.setViewportView(TabelaVendedor);
		TabelaVendedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome"
			}
		));
		
		JLabel lblNewLabel_10 = new JLabel("Pesquisar");
		lblNewLabel_10.setBounds(537, 23, 46, 14);
		getContentPane().add(lblNewLabel_10);

	}

}
