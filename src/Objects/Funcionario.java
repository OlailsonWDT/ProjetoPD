package Objects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }


    public void aumentarSalario(BigDecimal percentualAumento) {
        BigDecimal aumento = salario.multiply(percentualAumento);
        salario = salario.add(aumento);
    }

    @Override
    public String toString() {
        return super.toString() + ", Salário: " + salario.toString() + ", Função: " + funcao;
    }

    public BigDecimal getSalarioMinimo() {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        BigDecimal qtd = salario.divide(salarioMinimo, 2, RoundingMode.UP);
        return qtd;
    }
}