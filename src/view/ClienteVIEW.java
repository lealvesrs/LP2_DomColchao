package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import ctr.PessoaController;
import dto.Cliente;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ClienteVIEW extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField cpf;
	private JTextField telefone;
	private JTextField cep;
	private JTextField rua;
	private JTextField numero;
	private JTextField pesqNome;
	private JTable TabelaCliente;
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
					ClienteVIEW frame = new ClienteVIEW();
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
		pesqNome.setText("");
		btnSalvar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
		cpf.setEnabled(true);
		habilitaCampos(true);
	}
	
	private void limpaTabela() {
		DefaultTableModel model = (DefaultTableModel) TabelaCliente.getModel();
        model.setRowCount(0); 
	}
	
	private void habilitaCampos(Boolean status) {
		nome.setEnabled(status);
		telefone.setEnabled(status);
		cep.setEnabled(status);
		rua.setEnabled(status);
		numero.setEnabled(status);
	}
	
	private void preencheTabela(List<Cliente> clientes) {
		DefaultTableModel model = (DefaultTableModel) TabelaCliente.getModel();
        model.setRowCount(0); 
        
        for (Cliente cliente : clientes) {
            model.addRow(new Object[] { cliente.getNome(), cliente.getCpf() });
        }
	}
	
	private void preencherCampos(List<Cliente> clientes) {

		 for (Cliente cliente : clientes) {
             nome.setText(cliente.getNome());
             cpf.setText(cliente.getCpf());
             cep.setText(cliente.getCep());
             telefone.setText( cliente.getTelefone());
             rua.setText(cliente.getRua());
             numero.setText(String.valueOf(cliente.getNumero()));
         }
	    
	}
	
	/**
	 * Create the frame.
	 */
	public ClienteVIEW() {
		getContentPane().setBackground(new Color(249, 235, 223));
		getContentPane().setForeground(new Color(0, 0, 0));

		PessoaController pessoaController = new PessoaController();
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 22));
		setBounds(100, 100, 751, 385);
		getContentPane().setLayout(null);
		setTitle("Cadastro de Cliente");
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(182, 82, 44, 26);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 235, 229));
		panel.setBounds(39, 119, 367, 148);
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
		
		JLabel lblNumero = new JLabel("nº");
		lblNumero.setBounds(236, 117, 18, 14);
		panel.add(lblNumero);
		
		numero = new JTextField();
		numero.setBounds(250, 114, 46, 20);
		panel.add(numero);
		numero.setColumns(10);
		
		 btnSalvar = new JButton("");
		 btnSalvar.setBackground(new Color(249, 235, 223));
		 btnSalvar.setIcon(new ImageIcon(ClienteVIEW.class.getResource("/imagens/Salvar.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificaPreenchimento()) {
					String nomeCli = nome.getText();
					String cpfCli = cpf.getText();
					String telCli = telefone.getText();
					String cepCli = cep.getText();
					String ruaCli = rua.getText();
					int numeroCli;
					
					try {
						numeroCli = Integer.parseInt(numero.getText());
					}catch (Exception err) {
						JOptionPane.showMessageDialog(null, "Número da residência no formato inválido");
						return;
					}
		
					if(pessoaController.verificaExistencia(cpfCli)) {
						 boolean status = pessoaController.editarCliente(nomeCli,cpfCli, cepCli, telCli, ruaCli, numeroCli);
						exibeMensagem(status,"editar");
					}else {
						boolean status = pessoaController.criarCliente(nomeCli,cpfCli, cepCli, telCli, ruaCli, numeroCli);
						exibeMensagem(status,"cadastrar");
					} 
				
					
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}
				
				
			}
		});
		btnSalvar.setBounds(39, 296, 56, 48);
		getContentPane().add(btnSalvar);
		
		btnEditar = new JButton("");
		btnEditar.setBackground(new Color(249, 235, 223));
		btnEditar.setIcon(new ImageIcon(ClienteVIEW.class.getResource("/imagens/editar.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setEnabled(false);
				btnSalvar.setEnabled(true);
				habilitaCampos(true);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBounds(115, 296, 56, 48);
		getContentPane().add(btnEditar);
		
		btnCancelar = new JButton("");
		btnCancelar.setBackground(new Color(249, 235, 223));
		btnCancelar.setIcon(new ImageIcon(ClienteVIEW.class.getResource("/imagens/fechar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
				limpaTabela();
			}
		});
		btnCancelar.setBounds(268, 296, 56, 48);
		getContentPane().add(btnCancelar);
		
		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(249, 235, 223));
		btnSair.setIcon(new ImageIcon(ClienteVIEW.class.getResource("/imagens/logout_16dp_F_FILL0_wght400_GRAD0_opsz20.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(351, 296, 56, 48);
		getContentPane().add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 235, 229));
		panel_1.setBounds(416, 119, 288, 225);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		pesqNome = new JTextField();
		pesqNome.setBounds(49, 22, 115, 20);
		panel_1.add(pesqNome);
		pesqNome.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Nome:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(10, 25, 31, 14);
		panel_1.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 268, 144);
		panel_1.add(scrollPane);
		
		TabelaCliente = new JTable();
		scrollPane.setViewportView(TabelaCliente);

		TabelaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				 if (evt.getClickCount() == 1) {
			            int row = TabelaCliente.getSelectedRow();
			            if (row != -1) { 
			            	DefaultTableModel model = (DefaultTableModel) TabelaCliente.getModel(); 
			        	    String nome = model.getValueAt(row, 0).toString();
			            	List<Cliente> clientes = pessoaController.pesquisarPorNome(nome);
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

		TabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {

				 "Nome", "CPF",

			}
		));
		
		JButton btnPesq = new JButton("Pesquisar");
		btnPesq.setBackground(new Color(249, 235, 223));
		btnPesq.setBounds(174, 18, 104, 28);
		panel_1.add(btnPesq);
		btnPesq.setIcon(null);
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 List<Cliente> clientes;
				
				if(!pesqNome.getText().isEmpty()) clientes = pessoaController.pesquisarPorNome(pesqNome.getText());
				else clientes = pessoaController.listarClientes();
				preencheTabela(clientes);
				
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Pesquisar");
		lblNewLabel_6.setBounds(542, 94, 78, 14);
		getContentPane().add(lblNewLabel_6);
		
		 btnExcluir = new JButton("");
		 btnExcluir.setBackground(new Color(249, 235, 223));
		 btnExcluir.setIcon(new ImageIcon(ClienteVIEW.class.getResource("/imagens/delete.png")));
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
		 	            boolean status = pessoaController.excluirCliente(cpf.getText()); 	
		 	           exibeMensagem(status,"excluir");
		 	           if(status) {
		 	        	  limpaCampos();
		 	        	  limpaTabela();
		 	           }
		 	        } 
		 	}
		 });
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(194, 296, 56, 48);
		getContentPane().add(btnExcluir);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(ClienteVIEW.class.getResource("/imagens/imagemLogo-removebg-preview.png")));
		lblNewLabel_8.setBounds(339, 11, 154, 97);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(ClienteVIEW.class.getResource("/imagens/cliente.png")));
		lblNewLabel_9.setBounds(10, 11, 67, 56);
		getContentPane().add(lblNewLabel_9);
		
	}
}
