package Controller;

import Negocio.Bar;
import Negocio.CadastroCliente;
import Negocio.Categoria;
import Negocio.Cliente;

public class Controle {

	String nome;
	Bar bar;
	Cliente cliente;
	CadastroCliente arquivo;

	public Controle() {

    }
	
	public Controle(String nome) {
	        this.nome = nome;
	        bar = new Bar(nome);
	    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void cadastraCliente(String nome, String cpf, int idade,char genero,Categoria status) {
		bar.adicionaCliente(nome, cpf, idade, genero, status);
	}
	
	public void removeCliente(String cpf) {
		bar.removeCliente(cpf);
	}

	public Cliente consultaCliente(String cpf) {
		return bar.consultaCliente(cpf);
	}

	public String toString() {
		return bar.toString();
	}
	
	public int numeroClientes(){
		return bar.numeroClientes();
	}
	
	public int numeroClientesFemininos(){
		return bar.numClientesFemininos();
	}
	
	public int numeroClientesMasculinos(){
		return bar.numClientesMasculinos();
	}
	
	public int numeroClientesSilver(){
		return bar.numClientesSilver();
	}
	
	public int numeroClientesGold(){
		return bar.numClientesGold();
	}
	
	public int numeroClientesPlatinum(){
		return bar.numClientesPlatinum();
	}
	
	public boolean cpfExiste(String cpf){
		if(bar.equals(cpf)){
			return true;
		}
		return false;
	}
	
}
