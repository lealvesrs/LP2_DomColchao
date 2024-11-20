package dto;

import java.time.LocalDate;

public class Vendedor extends Pessoa {
    private LocalDate dataNascimento;
    private String numeroCTPS;
    private double remuneracao;

    public Vendedor(String nome, String cpf, String cep, String telefone, String rua, int numero,
                    LocalDate dataNascimento, String numeroCTPS, double remuneracao) {
        super(nome, cpf, cep, telefone, rua, numero);
        this.dataNascimento = dataNascimento;
        this.numeroCTPS = numeroCTPS;
        this.remuneracao = remuneracao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNumeroCTPS() {
        return numeroCTPS;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    @Override
    public String getTipo() {
        return "Vendedor";
    }
}