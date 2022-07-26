package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Main {

	public static void main(String[] args) {
		
		/* O programa armazena informações sobre pessoas físicas e pessoas jurídicas. */
		/* O programa calcula e exibe o imposto sobre esta pessoa. */
		/* Exercicio em java para treinamento de classes abstratas, métodos abstratos e herança */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantidade de contribuintes: ");
		int nContribuintes = sc.nextInt();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		for(int i=0;i<nContribuintes;i++) {
			System.out.println("Contribuinte #"+i+": ");
			System.out.println("Pessoa física ou jurídica? (f/j): ");
			char ch = sc.next().charAt(0);
			if(ch=='f' || ch=='j') {
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Renda anual: ");
				Double rendaAnual = sc.nextDouble();
				if(ch=='f') {
					System.out.print("Gastos com saúde: ");
					Double gastoSaude = sc.nextDouble();
					pessoas.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
				}else if(ch=='j') {
					System.out.print("Número de funcionários: ");
					Integer nFuncionarios = sc.nextInt();
					pessoas.add(new PessoaJuridica(nome, rendaAnual, nFuncionarios));
				}
			}else {
				System.out.println("Não existe este tipo de pessoa ");
			}
		}
		
		Double total = 0.0;
		
		for (Pessoa p : pessoas) {
			total += p.calcularImposto();
			System.out.println(p.getNome()+" - R$ "+String.format("%.2f", p.calcularImposto()));
		}
		
		System.out.println("Total: R$ "+String.format("%.2f", total));
		
		sc.close();

	}

}
