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

		PessoaController pessoaController = new PessoaController();
		
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
		
		JLabel lblNumero = new JLabel("nº");
		lblNumero.setBounds(236, 117, 18, 14);
		panel.add(lblNumero);
		
		numero = new JTextField();
		numero.setBounds(250, 114, 46, 20);
		panel.add(numero);
		numero.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificaPreenchimento()) {
				String nomeCli = nome.getText();
				String cpfCli = cep.getText();
				String telCli = telefone.getText();
				String cepCli = cep.getText();
				String ruaCli = rua.getText();
				int numeroCli = 0;
				try {
					numeroCli = Integer.parseInt(numero.getText());
				}catch (Exception err) {
					JOptionPane.showMessageDialog(null, "Número da residência no formato inválido");
					return;
				}
					boolean status = pessoaController.criarCliente(nomeCli, telCli, cepCli, cpfCli, ruaCli, numeroCli);
					exibeMensagem(status,"cadastrar");
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}
				
				
			}
		});
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
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 List<Cliente> clientes;
				
				if(!pesqNome.getText().isEmpty()) clientes = pessoaController.pesquisarPorNome(nome.getText());
					
				else clientes = pessoaController.listarClientes();
				preencheTabela(clientes);
			}
		});
		btnPesq.setBounds(164, 10, 31, 23);
		panel_1.add(btnPesq);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 42, 193, 95);
		panel_1.add(scrollPane);
		
		TabelaCliente = new JTable();
<<<<<<< Updated upstream
		scrollPane.setViewportView(TabelaCliente);
=======
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
			            }
			        }
			}
		});
>>>>>>> Stashed changes
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