package Service;

import Objects.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class IndustryService {
    private List<Funcionario> funcionarios;

    public IndustryService() {
        this.funcionarios = new ArrayList<>();
    }

    public void inserirFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public void imprimirFuncionarios() {
        System.out.println("Funcionários:");
        funcionarios.forEach(System.out::println);
    }

    public void aumentarSalarioTodos(BigDecimal percentualAumento) {
        funcionarios.forEach(funcionario -> funcionario.aumentarSalario(percentualAumento));
    }

    public Map<String, List<Funcionario>> agruparFuncionariosPorFuncao() {
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();
            List<Funcionario> listaFuncionarios = funcionariosPorFuncao.getOrDefault(funcao, new ArrayList<>());
            listaFuncionarios.add(funcionario);
            funcionariosPorFuncao.put(funcao, listaFuncionarios);
        }

        return funcionariosPorFuncao;
    }

    public void imprimirFuncionariosPorFuncao() {
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparFuncionariosPorFuncao();

        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
            System.out.println("Função: " + funcao);
            listaFuncionarios.forEach(System.out::println);
            System.out.println();
        });
    }


    public void imprimirAniversariantesMes(int mes) {
        List<Funcionario> aniversariantesMes = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getMonthValue() == mes) {
                aniversariantesMes.add(funcionario);
            }
        }

        if (!aniversariantesMes.isEmpty()) {
            System.out.println("Funcionários que fazem aniversário no mês " + mes + ":");
            aniversariantesMes.forEach(System.out::println);
        } else {
            System.out.println("Não há aniversariantes no mês " + mes);
        }
    }

    public void imprimirFuncionarioMaisVelho() {
        Funcionario funcionarioMaisVelho = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionarioMaisVelho == null || funcionario.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento())) {
                funcionarioMaisVelho = funcionario;
            }
        }

        if (funcionarioMaisVelho != null) {
            int idade = LocalDate.now().getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
            System.out.println("\nFuncionário mais velho:");
            System.out.println("Nome: " + funcionarioMaisVelho.getNome() + ", Idade: " + idade);
        }
    }

    public void imprimirFuncionariosOrdemAlfabetica() {
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));

        System.out.println("\nLista de funcionários por ordem alfabética:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    public void imprimirTotalSalarios() {
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }

        System.out.println("\nTotal dos salários dos funcionários: " + totalSalarios);
    }

    public void imprimirQuantidadeSalariosMinimos() {
        System.out.println("\nQuantidade de salários mínimos para cada funcionário:");
        funcionarios.forEach(funcionario -> {
            BigDecimal salarioMinimo = funcionario.getSalarioMinimo();
            System.out.println("Funcionário: " + funcionario.getNome() + ", Salários mínimos: " + salarioMinimo);
        });
    }
}