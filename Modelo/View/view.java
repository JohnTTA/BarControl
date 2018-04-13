package View;

import Negocio.Categoria;

import java.util.Scanner;

import Negocio.Bar;
import Negocio.CadastroCliente;
import Negocio.Categoria;
import Negocio.Cliente;
import Controller.Controle;

public class view {

	private static Controle bar;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		CadastroCliente registro;

		System.out.println("Digite o nome do estabelecimento: ");
		String nomeBar = input.nextLine();
		bar = new Controle(nomeBar);

		int op;
		do {
			System.out.println("Digite a sua opção: ");
			System.out.println("0: Adicionar clientes");
			System.out.println("1: Remover clientes");
			System.out.println("2: Mostrar clientes no bar");
			System.out.println("9: Fechar sistema");
			op = input.nextInt();

			switch (op) {
			case 0:
				System.out.println("--Cadastrando Cliente--\n");
				cadastraClientes();
				break;
			case 1:
				System.out.println("--Removendo Cliente--\n");
				removerClientes();
				break;
			case 2:
				System.out.println("\n Clientes no bar: " + bar.toString() + "\n");
				break;
			case 9:
				System.out.println("\nObrigado por utilizar nosso sistema\n");
				break;
			default:
				System.out.println("Opção inválida\n");
				break;
			}
		} while (op != 9);
	}

	private static void cadastraClientes() {
		Scanner input = new Scanner(System.in);
		CadastroCliente registro = new CadastroCliente();
		System.out.println("Digite o nome do cliente: ");
		String nome = input.nextLine();
		System.out.println("Digite o cpf: ");
		String cpf = input.nextLine();
		System.out.println("Digite a idade: ");
		int idade = input.nextInt();
//		System.out.println("Digite a categoria: ");
//		Categoria status = inpu	
//		bar.cadastraCliente(nome, cpf, idade,status);
//		registro.salvaClienteEntrada(new Cliente(nome, cpf, idade, status));

		System.out.println("\n");
	}

	private static void removerClientes() {
		Scanner input = new Scanner(System.in);
		CadastroCliente registro = new CadastroCliente();
		System.out.println("Digite o cpf: ");
		String cpf = input.nextLine();
		registro.salvaClienteSaida(bar.consultaCliente(cpf));
		bar.removeCliente(cpf);

		System.out.println("\n");
	}

}
