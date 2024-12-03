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
import javax.swing.ImageIcon;
import java.awt.Color;

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
		getContentPane().setBackground(new Color(249, 235, 223));
		setBounds(100, 100, 749, 545);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 235, 229));
		panel.setBounds(29, 96, 329, 344);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(10, 40, 33, 14);
		panel.add(lblNewLabel_2);
		
		PesqCliente = new JTextField();
		PesqCliente.setBounds(50, 37, 188, 20);
		panel.add(PesqCliente);
		PesqCliente.setColumns(10);
		
		JButton btnPesqCliente = new JButton("Pesquisar");
		btnPesqCliente.setBackground(new Color(249, 235, 229));
		btnPesqCliente.setBounds(239, 36, 80, 23);
		panel.add(btnPesqCliente);
		
		JLabel lblNewLabel_3 = new JLabel("Total da venda:");
		lblNewLabel_3.setBounds(10, 294, 81, 39);
		panel.add(lblNewLabel_3);
		
		JLabel TotalVenda = new JLabel("0.00");
		TotalVenda.setBounds(106, 293, 81, 40);
		panel.add(TotalVenda);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(VendaVIEW.class.getResource("/imagens/cifrão.png")));
		lblNewLabel_4.setBounds(119, 245, 64, 50);
		panel.add(lblNewLabel_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 68, 309, 166);
		panel.add(scrollPane_2);
		
		TabelaCliente = new JTable();
		scrollPane_2.setViewportView(TabelaCliente);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 235, 229));
		panel_1.setBounds(416, 96, 296, 408);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Produto");
		lblNewLabel_5.setBounds(10, 47, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		PesqProduto = new JTextField();
		PesqProduto.setBounds(54, 44, 138, 20);
		panel_1.add(PesqProduto);
		PesqProduto.setColumns(10);
		
		JButton btnPesqProduto = new JButton("Pesquisar");
		btnPesqProduto.setBackground(new Color(249, 235, 229));
		btnPesqProduto.setBounds(197, 43, 89, 23);
		panel_1.add(btnPesqProduto);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(249, 235, 229));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(10, 224, 89, 23);
		panel_1.add(btnAdicionar);
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.setBackground(new Color(249, 235, 229));
		btnRetirar.setBounds(197, 224, 89, 23);
		panel_1.add(btnRetirar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 276, 128);
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
		scrollPane_1.setBounds(10, 269, 276, 128);
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
		lblNewLabel.setBounds(162, 71, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Produtos");
		lblNewLabel_1.setBounds(543, 71, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setBackground(new Color(249, 235, 229));
		btnSalvar.setIcon(new ImageIcon(VendaVIEW.class.getResource("/imagens/Salvar.png")));
		btnSalvar.setBounds(29, 459, 53, 45);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setBackground(new Color(249, 235, 229));
		btnCancelar.setIcon(new ImageIcon(VendaVIEW.class.getResource("/imagens/fechar.png")));
		btnCancelar.setBounds(172, 462, 53, 42);
		getContentPane().add(btnCancelar);
		
		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(249, 235, 229));
		btnSair.setIcon(new ImageIcon(VendaVIEW.class.getResource("/imagens/logout_16dp_F_FILL0_wght400_GRAD0_opsz20.png")));
		btnSair.setBounds(305, 459, 53, 45);
		getContentPane().add(btnSair);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(VendaVIEW.class.getResource("/imagens/vendas.png")));
		lblNewLabel_6.setBounds(10, 11, 72, 53);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(VendaVIEW.class.getResource("/imagens/imagemLogo-removebg-preview.png")));
		lblNewLabel_7.setBounds(305, 2, 159, 83);
		getContentPane().add(lblNewLabel_7);

	}
}
