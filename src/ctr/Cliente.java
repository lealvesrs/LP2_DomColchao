package ctr;

public class Cliente extends Pessoa {
	public Cliente(String nome, String cpf, String cep, String telefone, String rua, int numero) {
        super(nome, cpf, cep, telefone, rua, numero);
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }
}
