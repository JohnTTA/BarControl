package Negocio;

import java.util.ArrayList;

public class Bar {

	private ArrayList<Cliente> lista;
	private String nome;

	
	public Bar(){
		lista = new ArrayList<Cliente>();
	}
	
	public Bar(String nome) {
		this.nome = nome;
		lista = new ArrayList<Cliente>();
	}

	public Cliente consultaCliente(String cpf) {
		for (Cliente cli : lista) {
			if (cli.getCpf().equals(cpf)) {
				return cli;
			}
		}
		return null;
	}

	public void adicionaCliente(String nome, String cpf, int idade, char genero, Categoria status) {
		if (lista.contains(cpf) != true) {
			lista.add(new Cliente(nome, cpf, idade, genero, status));
		}
	}

	public void removeCliente(String cpf) {
		for (Cliente cli : lista) {
			if (cli.getCpf().equals(cpf)) {
				lista.remove(cli);
				break;
			}
		}
	}

	public int numeroClientes() {
		return lista.size();
	}

	public int numClientesMasculinos() {
		int percentualMasculino = 0;
		for (Cliente cli : lista) {
			if (cli.getGenero() == 'M') {
				percentualMasculino++;
			}
		}
		return percentualMasculino;
	}

	public int numClientesFemininos() {
		int percentualFeminino = 0;
		for (Cliente cli : lista) {
			if (cli.getGenero() == 'F') {
				percentualFeminino++;
			}
		}
		return percentualFeminino;
	}

	public int numClientesSilver() {
		int silver = 0;
		for (Cliente cli : lista) {
			if (cli.getStatus() == Categoria.Silver) {
				silver++;
			}
		}
		return silver;
	}
	
	public int numClientesGold() {
		int gold = 0;
		for (Cliente cli : lista) {
			if (cli.getStatus() == Categoria.Gold) {
				gold++;
			}
		}
		return gold;
	}

	public int numClientesPlatinum() {
		int platinum = 0;
		for (Cliente cli : lista) {
			if (cli.getStatus() == Categoria.Platinum) {
				platinum++;
			}
		}
		return platinum;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "{" + "lista=" + lista + '}';
	}

}
