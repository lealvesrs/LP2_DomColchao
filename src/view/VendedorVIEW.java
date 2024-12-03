package view;

import java.awt.EventQueue;
import java.awt.Font;
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
import dto.Vendedor;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

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
	private JTextField pesqNome;
	private JTable TabelaVendedor;
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
					VendedorVIEW frame = new VendedorVIEW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean verificaPreenchimento() {
		if (nome.getText().isEmpty() ||
	        cpf.getText().isEmpty() ||
	        telefone.getText().isEmpty() ||
	        cep.getText().isEmpty() ||
	        rua.getText().isEmpty() ||
	        numero.getText().isEmpty()) {
	        return false;
	    }

	    return true;
	}
	
	
	private void exibeMensagem(boolean status, String acao) {
		if(status) {
			switch(acao) {
				case "cadastrar": JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				 break;
				case "editar": JOptionPane.showMessageDialog(null, "Editado com sucesso");
				 break;
				case "excluir": JOptionPane.showMessageDialog(null, "Excluído com sucesso");
				break;
			}
			limpaCampos();
			limpaTabela();
			
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao "+ acao);
		}
	}
	
	
	private void limpaCampos() {
		nome.setText("");
		cpf.setText("");
		telefone.setText("");
		cep.setText("");
		rua.setText("");
		numero.setText("");
		data_nasc.setText("");
		ctps.setText("");
		remuneracao.setText("");
		pesqNome.setText("");
		btnSalvar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
		cpf.setEnabled(true);
		habilitaCampos(true);
	}
	
	private void limpaTabela() {
		DefaultTableModel model = (DefaultTableModel) TabelaVendedor.getModel();
        model.setRowCount(0); 
	}
	
	private void habilitaCampos(Boolean status) {
		nome.setEnabled(status);
		telefone.setEnabled(status);
		cep.setEnabled(status);
		rua.setEnabled(status);
		numero.setEnabled(status);
		data_nasc.setEnabled(status);
		ctps.setEnabled(status);
		remuneracao.setEnabled(status);
	}
	
	private void preencheTabela(List<Vendedor> vendedores) {
		DefaultTableModel model = (DefaultTableModel) TabelaVendedor.getModel();
        model.setRowCount(0); 
        
        for (Vendedor vendedor : vendedores) {
            model.addRow(new Object[] { vendedor.getNome(), vendedor.getCpf() });
        }
	}
	
	private void preencherCampos(List<Vendedor> vendedores) {

		 for (Vendedor vendedor : vendedores) {
             nome.setText(vendedor.getNome());
             cpf.setText(vendedor.getCpf());
             cep.setText(vendedor.getCep());
             telefone.setText( vendedor.getTelefone());
             rua.setText(vendedor.getRua());
             numero.setText(String.valueOf(vendedor.getNumero()));
             String dataFormatada = vendedor.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
             data_nasc.setText(dataFormatada);
     		 ctps.setText(vendedor.getNumeroCTPS());
     		 remuneracao.setText(String.valueOf(vendedor.getRemuneracao()));
         }
	    
	}

	/**
	 * Create the frame.
	 */
	public VendedorVIEW() {
		getContentPane().setBackground(new Color(249, 235, 223));
		PessoaController pessoaController = new PessoaController();
		
		setBounds(100, 100, 765, 486);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 22));
		getContentPane().setLayout(null);
		setTitle("Cadastro de Vendedor");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 235, 229));
		panel.setBounds(44, 138, 349, 233);
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
		lblNewLabel.setBounds(200, 113, 46, 14);
		getContentPane().add(lblNewLabel);
		
		btnSalvar = new JButton("");
		btnSalvar.setBackground(new Color(249, 235, 223));
		btnSalvar.setIcon(new ImageIcon(VendedorVIEW.class.getResource("/imagens/Salvar.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificaPreenchimento()) {
					String nomeVend =nome.getText();
					String cpfVend =cpf.getText();
					String telVend =telefone.getText();
					String cepVend =cep.getText();
					String ruaVend =rua.getText();
					String dataVend =data_nasc.getText();
					String ctpsVend =ctps.getText();
					Double remuneracaoVend = Double.parseDouble(remuneracao.getText());
					int numeroVend;
					LocalDate dataNascimento = null;
					
					try {
						numeroVend =Integer.parseInt(numero.getText());
					}catch (Exception err) {
						JOptionPane.showMessageDialog(null, "Número da residência no formato inválido");
						return;
					}
					

			        try {
			            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			            dataNascimento = LocalDate.parse(dataVend, formatter);

			        } catch (DateTimeParseException err) {
			        	JOptionPane.showMessageDialog(null, "Formato de data inválido. Por favor, insira no formato dd/MM/yyyy.");
			        	return;
			        }
		
					if(pessoaController.verificaExistenciaVendedor(cpfVend)) {
						 boolean status = pessoaController.editarVendedor(nomeVend,cpfVend, cepVend, telVend, ruaVend, numeroVend, dataNascimento, ctpsVend, remuneracaoVend);
						exibeMensagem(status,"editar");
					}else {
						boolean status = pessoaController.criarVendedor(nomeVend,cpfVend, cepVend, telVend, ruaVend, numeroVend, dataNascimento, ctpsVend, remuneracaoVend);
						exibeMensagem(status,"cadastrar");
					} 
				
					
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}
				
				
			}
		});
		btnSalvar.setBounds(46, 382, 58, 50);
		getContentPane().add(btnSalvar);
		
		btnEditar = new JButton("");
		btnEditar.setBackground(new Color(249, 235, 223));
		btnEditar.setIcon(new ImageIcon(VendedorVIEW.class.getResource("/imagens/editar.png")));
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setEnabled(false);
				btnSalvar.setEnabled(true);
				habilitaCampos(true);
			}
		});
		btnEditar.setBounds(114, 382, 58, 50);
		getContentPane().add(btnEditar);
		
		btnExcluir = new JButton("");
		btnExcluir.setBackground(new Color(249, 235, 223));
		btnExcluir.setIcon(new ImageIcon(VendedorVIEW.class.getResource("/imagens/delete.png")));
		btnExcluir.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int resposta = JOptionPane.showConfirmDialog(
		 	            null, 
		 	            "Tem certeza que deseja excluir?", 
		 	            "Confirmação de Exclusão", 
		 	            JOptionPane.YES_NO_OPTION, 
		 	            JOptionPane.QUESTION_MESSAGE
		 	        );

		 	        
		 	        if (resposta == JOptionPane.YES_OPTION) {
		 	            boolean status = pessoaController.excluirVendedor(cpf.getText()); 	
		 	           exibeMensagem(status,"excluir");
		 	           if(status) {
		 	        	  limpaCampos();
		 	        	  limpaTabela();
		 	           }
		 	        } 
		 	}
		 });
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(188, 382, 58, 50);
		getContentPane().add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(249, 235, 223));
		btnSair.setIcon(new ImageIcon(VendedorVIEW.class.getResource("/imagens/logout_16dp_F_FILL0_wght400_GRAD0_opsz20.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(335, 382, 58, 50);
		getContentPane().add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 235, 229));
		panel_1.setBounds(403, 138, 297, 294);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Nome:");
		lblNewLabel_11.setBounds(10, 32, 31, 14);
		panel_1.add(lblNewLabel_11);
		
		pesqNome = new JTextField();
		pesqNome.setBounds(40, 29, 131, 20);
		panel_1.add(pesqNome);
		pesqNome.setColumns(10);
		
		JButton btnPesq = new JButton("Pesquisar");
		btnPesq.setBackground(new Color(249, 235, 223));
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 List<Vendedor> vendedores;
				
				if(!pesqNome.getText().isEmpty()) vendedores = pessoaController.pesquisarPorNomeVendedor(pesqNome.getText());
				else vendedores = pessoaController.listarVendedores();
				preencheTabela(vendedores);
				
			}
		});
		btnPesq.setBounds(183, 28, 91, 23);
		panel_1.add(btnPesq);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 264, 226);
		panel_1.add(scrollPane);
		
		TabelaVendedor = new JTable();
		TabelaVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 1) {
		            int row = TabelaVendedor.getSelectedRow();
		            if (row != -1) { 
		            	DefaultTableModel model = (DefaultTableModel) TabelaVendedor.getModel(); 
		        	    String nome = model.getValueAt(row, 0).toString();
		            	List<Vendedor> clientes = pessoaController.pesquisarPorNomeVendedor(nome);
		                preencherCampos(clientes);
						habilitaCampos(false);
						cpf.setEnabled(false);
		                btnCancelar.setEnabled(true);
		                btnExcluir.setEnabled(true);
				        btnEditar.setEnabled(true);
				        btnSalvar.setEnabled(false);
		            }
		        }

			}
		});
		scrollPane.setViewportView(TabelaVendedor);
		TabelaVendedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF"
			}
		));
		
		JLabel lblNewLabel_10 = new JLabel("Pesquisar");
		lblNewLabel_10.setBounds(541, 113, 46, 14);
		getContentPane().add(lblNewLabel_10);
		
		btnCancelar = new JButton("");
		btnCancelar.setBackground(new Color(249, 235, 223));
		btnCancelar.setIcon(new ImageIcon(VendedorVIEW.class.getResource("/imagens/fechar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
				limpaTabela();
			}
		});
		btnCancelar.setBounds(267, 382, 58, 50);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(VendedorVIEW.class.getResource("/imagens/vendedor.png")));
		lblNewLabel_12.setBounds(10, 11, 66, 50);
		getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(VendedorVIEW.class.getResource("/imagens/imagemLogo-removebg-preview.png")));
		lblNewLabel_13.setBounds(321, 11, 165, 95);
		getContentPane().add(lblNewLabel_13);

	}
}
