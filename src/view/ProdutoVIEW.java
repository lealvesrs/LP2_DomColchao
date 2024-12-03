package view;

import java.awt.Font;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ctr.PessoaController;
import dto.Vendedor;
import ctr.ProdutoController;

import dao.ProdutoDAO;
import dto.Produto;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ProdutoVIEW extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField nomeProd;
	private JTextField idProd;
	private JTextField tamanhoProd;
	private JTextField densidadeProd;
	private JTextField materialProd;
	private JTextField precoProd;
	private JTextField pesqNome;
	private JTable TabelaProduto;
	private JButton btnCancelar;
	private JButton btnEditar;
	private JButton btnSalvar;
	private JButton btnExcluir;

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

//Verifica Preenchimento
	private boolean verificaPreenchimento() {
		if (nomeProd.getText().isEmpty() || idProd.getText().isEmpty() || tamanhoProd.getText().isEmpty()
				|| densidadeProd.getText().isEmpty() || materialProd.getText().isEmpty()
				|| precoProd.getText().isEmpty()) {
			return false;
		}

		return true;
	}

	// Exibe Mensagem
	private void exibeMensagem(boolean status, String acao) {
		if (status) {
			switch (acao) {
			case "cadastrar":
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				break;
			case "editar":
				JOptionPane.showMessageDialog(null, "Editado com sucesso");
				break;
			case "excluir":
				JOptionPane.showMessageDialog(null, "Excluído com sucesso");
				break;
			}
			limpaCampos();
			limpaTabela();

		} else {
			JOptionPane.showMessageDialog(null, "Erro ao " + acao);
		}
	}

	// Limpa Campos

	private void limpaCampos() {
		nomeProd.setText("");
		idProd.setText("");
		tamanhoProd.setText("");
		densidadeProd.setText("");
		materialProd.setText("");
		precoProd.setText("");
		pesqNome.setText("");
		btnSalvar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
		idProd.setEnabled(true);
		habilitaCampos(true);
	}

	// Limpa Tabela
	
	private void limpaTabela() {
		DefaultTableModel model = (DefaultTableModel) TabelaProduto.getModel();
		model.setRowCount(0);
	}

	// Habilita Campos
	
	private void habilitaCampos(Boolean status) {
		nomeProd.setEnabled(status);
		idProd.setEnabled(status);
		tamanhoProd.setEnabled(status);
		densidadeProd.setEnabled(status);
		materialProd.setEnabled(status);
		precoProd.setEnabled(status);
	}

	// Preenche Tabela
	
	private void preencheTabela(List<Produto> produtos) {
		DefaultTableModel model = (DefaultTableModel) TabelaProduto.getModel();
		model.setRowCount(0);

		for (Produto produto : produtos) {
			model.addRow(new Object[] { produto.getNomeProd(), produto.getIdProd() });
		}
	}

	// Preenche Campos
	
	private void preencherCampos(List<Produto> produtos) {

		for (Produto produto : produtos) {
			nomeProd.setText(produto.getNomeProd());
			idProd.setText(String.valueOf(produto.getIdProd()));
			tamanhoProd.setText(produto.getTamanhoProd());
			densidadeProd.setText(produto.getDensidadeProd());
			materialProd.setText(produto.getMaterialProd());
			precoProd.setText(String.valueOf(produto.getPrecoProd()));
		}

	}

	/**
	 * Create the frame.
	 */
	public ProdutoVIEW() {
		ProdutoController produtoController = new ProdutoController();
		getContentPane().setBackground(new Color(249, 235, 223));
		setBounds(100, 100, 742, 467);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 235, 229));
		panel.setBounds(38, 180, 348, 181);
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

		nomeProd = new JTextField();
		nomeProd.setBounds(66, 8, 244, 20);
		panel.add(nomeProd);
		nomeProd.setColumns(10);

		tamanhoProd = new JTextField();
		tamanhoProd.setBounds(66, 58, 244, 20);
		panel.add(tamanhoProd);
		tamanhoProd.setColumns(10);

		densidadeProd = new JTextField();
		densidadeProd.setBounds(66, 83, 244, 20);
		panel.add(densidadeProd);
		densidadeProd.setColumns(10);

		idProd = new JTextField();
		idProd.setBounds(66, 33, 244, 20);
		panel.add(idProd);
		idProd.setColumns(10);

		materialProd = new JTextField();
		materialProd.setBounds(66, 108, 244, 20);
		panel.add(materialProd);
		materialProd.setColumns(10);

		precoProd = new JTextField();
		precoProd.setBounds(66, 133, 244, 20);
		panel.add(precoProd);
		precoProd.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 235, 229));
		panel_1.setBounds(406, 178, 288, 248);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Nome:");
		lblNewLabel_8.setBounds(10, 11, 31, 14);
		panel_1.add(lblNewLabel_8);

		pesqNome = new JTextField();
		pesqNome.setBounds(47, 8, 120, 20);
		panel_1.add(pesqNome);
		pesqNome.setColumns(10);

		// Botão pesquisar
		
		JButton btnPesq = new JButton("Pesquisar");
		btnPesq.setBackground(new Color(249, 235, 223));
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Produto> produtos;

				if (!pesqNome.getText().isEmpty())
					produtos = produtoController.pesquisarPorNomeProduto(pesqNome.getText());
				else
					produtos = produtoController.listarProdutos();
				preencheTabela(produtos);

			}
		});
		btnPesq.setBounds(175, 7, 103, 23);
		panel_1.add(btnPesq);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 40, 258, 197);
		panel_1.add(scrollPane);

		// tabela produto
		TabelaProduto = new JTable();
		TabelaProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 1) {
					int row = TabelaProduto.getSelectedRow();
					if (row != -1) {
						DefaultTableModel model = (DefaultTableModel) TabelaProduto.getModel();
						String nomeProd = model.getValueAt(row, 0).toString();
						List<Produto> clientes = produtoController.pesquisarPorNomeProduto(nomeProd);
						preencherCampos(clientes);
						habilitaCampos(false);
						idProd.setEnabled(false);
						btnCancelar.setEnabled(true);
						btnExcluir.setEnabled(true);
						btnEditar.setEnabled(true);
						btnSalvar.setEnabled(false);
					}
				}

			}
		});
		scrollPane.setViewportView(TabelaProduto);
		TabelaProduto.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome:", "ID" }));

		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setBounds(183, 155, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pesquisar");
		lblNewLabel_1.setBounds(541, 153, 46, 14);
		getContentPane().add(lblNewLabel_1);

		// Botão Salvar
		JButton btnSalvar = new JButton("");
		btnSalvar.setBackground(new Color(249, 235, 223));
		btnSalvar.setIcon(new ImageIcon(ProdutoVIEW.class.getResource("/imagens/Salvar.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verificaPreenchimento()) {
					String nome = nomeProd.getText();
					Integer id = Integer.parseInt(idProd.getText());
					String tamanho = tamanhoProd.getText();
					String densidade = densidadeProd.getText();
					String material = materialProd.getText();
					Double preco = Double.parseDouble(precoProd.getText());
					if (produtoController.verificaExistencia(id)) {
						boolean status = produtoController.editarProduto(nome, id, tamanho, densidade,
								material, preco);
						exibeMensagem(status, "editar");
					} else {
						boolean status = produtoController.criarProduto(nome, id, tamanho, densidade,
								material, preco);
						exibeMensagem(status, "cadastrar");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}
			}

		});

		btnSalvar.setBounds(38, 372, 51, 54);
		getContentPane().add(btnSalvar);

		// Botão editar
		
		JButton btnEditar = new JButton("");
		btnEditar.setBackground(new Color(249, 235, 223));
		btnEditar.setIcon(new ImageIcon(ProdutoVIEW.class.getResource("/imagens/editar.png")));
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setEnabled(false);
				btnSalvar.setEnabled(true);
				habilitaCampos(true);
			}
		});

		btnEditar.setBounds(108, 372, 51, 54);
		getContentPane().add(btnEditar);

		// Botão Excluir
		JButton btnExcluir = new JButton("");
		btnExcluir.setBackground(new Color(249, 235, 223));
		btnExcluir.setIcon(new ImageIcon(ProdutoVIEW.class.getResource("/imagens/delete.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?",
						"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (resposta == JOptionPane.YES_OPTION) {
					boolean status = produtoController.excluirProduto(Integer.parseInt(idProd.getText()));
					exibeMensagem(status, "excluir");
					if (status) {
						limpaCampos();
						limpaTabela();
					}
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(183, 372, 51, 54);
		getContentPane().add(btnExcluir);

		// Botão sair
		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(249, 235, 223));
		btnSair.setIcon(
				new ImageIcon(ProdutoVIEW.class.getResource("/imagens/logout_16dp_F_FILL0_wght400_GRAD0_opsz20.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(337, 372, 51, 54);
		getContentPane().add(btnSair);

		// Botão Cancelar
		JButton btnCancelar = new JButton("");
		btnCancelar.setBackground(new Color(249, 235, 223));
		btnCancelar.setIcon(new ImageIcon(ProdutoVIEW.class.getResource("/imagens/fechar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
				limpaTabela();
			}
		});
		btnCancelar.setBounds(264, 372, 51, 54);
		getContentPane().add(btnCancelar);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(ProdutoVIEW.class.getResource("/imagens/vendas.png")));
		lblNewLabel_9.setBounds(10, 11, 69, 54);
		getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10
				.setIcon(new ImageIcon(ProdutoVIEW.class.getResource("/imagens/imagemLogo-removebg-preview.png")));
		lblNewLabel_10.setBounds(307, 11, 166, 121);
		getContentPane().add(lblNewLabel_10);

	}
}
