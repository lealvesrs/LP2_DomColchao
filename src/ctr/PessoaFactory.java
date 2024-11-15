package ctr;

import java.time.LocalDate;

import dto.Cliente;
import dto.Pessoa;
import dto.Vendedor;

public class PessoaFactory {
    public static Pessoa criarPessoa(String tipo, String nome, String cpf, String cep, String telefone, String rua, int numero,
                                     LocalDate dataNascimento, String numeroSerieCarteiraTrabalho, Double remuneracao) {
        switch (tipo.toLowerCase()) {
            case "vendedor":
                return new Vendedor(nome, cpf, cep, telefone, rua, numero, dataNascimento, numeroSerieCarteiraTrabalho, remuneracao);
            case "cliente":
                return new Cliente(nome, cpf, cep, telefone, rua, numero);
            default:
                throw new IllegalArgumentException("Tipo de pessoa desconhecido");
        }
    }
}
