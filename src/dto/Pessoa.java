package dto;

public abstract class Pessoa {
	    private String nome;
	    private String cpf;
	    private String cep;
	    private String telefone;
	    private String rua;
	    private int numero;

	    public Pessoa(String nome, String cpf, String cep, String telefone, String rua, int numero) {
	        this.nome = nome;
	        this.cpf = cpf;
	        this.cep = cep;
	        this.telefone = telefone;
	        this.rua = rua;
	        this.numero = numero;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getCpf() {
	        return cpf;
	    }

	    public String getCep() {
	        return cep;
	    }

	    public String getTelefone() {
	        return telefone;
	    }

	    public String getRua() {
	        return rua;
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public abstract String getTipo();
	}

