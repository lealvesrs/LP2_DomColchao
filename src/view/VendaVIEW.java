package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VendaVIEW extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField PesqCliente;
	private JTable TabelaCliente;
	private JTextField PesqProduto;
	private JTable TabelaProduto;
	private JTable TabelaVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendaVIEW frame = new VendaVIEW();
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
	public VendaVIEW() {
		setBounds(100, 100, 747, 491);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 38, 312, 344);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(10, 11, 33, 14);
		panel.add(lblNewLabel_2);
		
		PesqCliente = new JTextField();
		PesqCliente.setBounds(47, 8, 188, 20);
		panel.add(PesqCliente);
		PesqCliente.setColumns(10);
		
		JButton btnPesqCliente = new JButton("New button");
		btnPesqCliente.setBounds(245, 7, 49, 23);
		panel.add(btnPesqCliente);
		
		TabelaCliente = new JTable();
		TabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome"
			}
		));
		TabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(68);
		TabelaCliente.getColumnModel().getColumn(0).setMinWidth(19);
		TabelaCliente.getColumnModel().getColumn(0).setMaxWidth(100);
		TabelaCliente.setBounds(10, 55, 292, 154);
		panel.add(TabelaCliente);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(106, 220, 89, 62);
		panel.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total da venda:");
		lblNewLabel_3.setBounds(10, 294, 81, 39);
		panel.add(lblNewLabel_3);
		
		JLabel TotalVenda = new JLabel("0.00");
		TotalVenda.setBounds(106, 293, 81, 40);
		panel.add(TotalVenda);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(423, 24, 258, 358);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Produto");
		lblNewLabel_5.setBounds(10, 11, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		PesqProduto = new JTextField();
		PesqProduto.setBounds(54, 8, 138, 20);
		panel_1.add(PesqProduto);
		PesqProduto.setColumns(10);
		
		JButton btnPesqProduto = new JButton("New button");
		btnPesqProduto.setBounds(202, 7, 46, 23);
		panel_1.add(btnPesqProduto);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(20, 190, 89, 23);
		panel_1.add(btnAdicionar);
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.setBounds(146, 190, 89, 23);
		panel_1.add(btnRetirar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 228, 128);
		panel_1.add(scrollPane);
		
		TabelaProduto = new JTable();
		scrollPane.setViewportView(TabelaProduto);
		TabelaProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Valor"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 236, 238, 111);
		panel_1.add(scrollPane_1);
		
		TabelaVenda = new JTable();
		scrollPane_1.setViewportView(TabelaVenda);
		TabelaVenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Valor", "QTD"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Dados");
		lblNewLabel.setBounds(152, 11, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Produtos");
		lblNewLabel_1.setBounds(541, -1, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(79, 408, 89, 23);
		getContentPane().add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(217, 408, 89, 23);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(339, 408, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(464, 408, 89, 23);
		getContentPane().add(btnSair);

	}
}
