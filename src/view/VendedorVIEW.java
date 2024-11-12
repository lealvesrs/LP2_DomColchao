package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

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
		setBounds(100, 100, 476, 369);
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
		lblNewLabel_6.setBounds(188, 128, 11, 14);
		panel.add(lblNewLabel_6);
		
		nome = new JTextField();
		nome.setBounds(51, 8, 232, 20);
		panel.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(35, 36, 213, 20);
		panel.add(cpf);
		cpf.setColumns(10);
		
		telefone = new JTextField();
		telefone.setBounds(57, 66, 169, 20);
		panel.add(telefone);
		telefone.setColumns(10);
		
		rua = new JTextField();
		rua.setBounds(39, 125, 139, 20);
		panel.add(rua);
		rua.setColumns(10);
		
		cep = new JTextField();
		cep.setBounds(35, 150, 162, 20);
		panel.add(cep);
		cep.setColumns(10);
		
		numero = new JTextField();
		numero.setBounds(198, 125, 31, 20);
		panel.add(numero);
		numero.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DataNascimento:");
		lblNewLabel_7.setBounds(10, 100, 86, 14);
		panel.add(lblNewLabel_7);
		
		data_nasc = new JTextField();
		data_nasc.setBounds(95, 97, 86, 20);
		panel.add(data_nasc);
		data_nasc.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("CTPS:");
		lblNewLabel_8.setBounds(10, 178, 31, 14);
		panel.add(lblNewLabel_8);
		
		ctps = new JTextField();
		ctps.setBounds(45, 175, 106, 20);
		panel.add(ctps);
		ctps.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Remuneração:");
		lblNewLabel_9.setBounds(10, 207, 70, 14);
		panel.add(lblNewLabel_9);
		
		remuneracao = new JTextField();
		remuneracao.setBounds(81, 206, 86, 20);
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

	}

}
