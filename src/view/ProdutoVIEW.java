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

public class ProdutoVIEW extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField Pesquisar;
	private JTable TabelaProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoVIEW frame = new ProdutoVIEW();
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
	public ProdutoVIEW() {
		setBounds(100, 100, 742, 380);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 59, 348, 181);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(10, 11, 31, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(10, 36, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tamanho:");
		lblNewLabel_4.setBounds(10, 61, 48, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Densidade:");
		lblNewLabel_5.setBounds(10, 86, 59, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Material:");
		lblNewLabel_6.setBounds(10, 111, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Preço:");
		lblNewLabel_7.setBounds(10, 136, 46, 14);
		panel.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 244, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 58, 244, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 83, 244, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 33, 244, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(66, 108, 244, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(66, 133, 244, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(446, 59, 216, 181);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nome:");
		lblNewLabel_8.setBounds(10, 11, 31, 14);
		panel_1.add(lblNewLabel_8);
		
		Pesquisar = new JTextField();
		Pesquisar.setBounds(47, 8, 120, 20);
		panel_1.add(Pesquisar);
		Pesquisar.setColumns(10);
		
		JButton btnPesquisar = new JButton("Lupa");
		btnPesquisar.setBounds(175, 7, 31, 23);
		panel_1.add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 40, 172, 118);
		panel_1.add(scrollPane);
		
		TabelaProduto = new JTable();
		scrollPane.setViewportView(TabelaProduto);
		TabelaProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome:", "CPF"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setBounds(183, 34, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pesquisar");
		lblNewLabel_1.setBounds(526, 34, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 266, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 266, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(208, 266, 89, 23);
		getContentPane().add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(307, 266, 89, 23);
		getContentPane().add(btnSair);

	}

}
