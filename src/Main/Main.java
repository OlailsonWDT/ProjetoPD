package Main;

import Objects.Funcionario;
import Service.IndustryService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        IndustryService industryService = new IndustryService();


        // Inserir todos os funcionários
        industryService.inserirFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        industryService.inserirFuncionario(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        industryService.inserirFuncionario(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Cordenador"));
        industryService.inserirFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        industryService.inserirFuncionario(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        industryService.inserirFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        industryService.inserirFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        industryService.inserirFuncionario(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3071.45"), "Gerente"));
        industryService.inserirFuncionario(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        industryService.inserirFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));


        // Remover o funcionário "João" da lista
        industryService.removerFuncionario("João");

        // Imprimir todos os funcionários com todas as informações
        industryService.imprimirFuncionarios();

        // Aumentar o salário dos funcionários em 10%
        industryService.aumentarSalarioTodos(new BigDecimal("0.1"));

        // Imprimir os funcionários agrupados por função
        industryService.imprimirFuncionariosPorFuncao();

        // Imprimir os funcionários que fazem aniversário no mês 10 e 12
        industryService.imprimirAniversariantesMes(10);
        industryService.imprimirAniversariantesMes(12);

        // Imprimir o funcionário mais velho
        industryService.imprimirFuncionarioMaisVelho();

        // Imprimir a lista de funcionários por ordem alfabética
        industryService.imprimirFuncionariosOrdemAlfabetica();

        // Imprimir o total dos salários dos funcionários
        industryService.imprimirTotalSalarios();

        // Imprimir quantos salários mínimos ganha cada funcionário
        industryService.imprimirQuantidadeSalariosMinimos();
    }
}