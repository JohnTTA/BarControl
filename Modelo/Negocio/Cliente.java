package Negocio;

public class Cliente {

	private String nome;
	private String cpf;
	private char genero;
	private int idade;
	private Categoria status;

	public Cliente(String cpf){
		this.cpf = cpf;
	}
	
	public Cliente(String nome, String cpf, int idade, char genero,Categoria status) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.idade = idade;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Categoria getStatus() {
		return status;
	}

	public void setStatus(Categoria status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", genero=" + genero + ", idade=" + idade + '}';
	}

}
