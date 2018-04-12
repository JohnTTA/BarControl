package business;

public class Cliente {
	
	String nome,cpf,genero,codSocio;
		
	Cliente(String nome, String cpf, String genero, String codSocio){
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.codSocio = codSocio;
	}
	
	String getCpf() {return cpf;}
	String getGenero() {return genero;}
}
