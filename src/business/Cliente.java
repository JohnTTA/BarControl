package business;

public class Cliente {
	
	String nome,cpf,genero,codSocio;
		
	public Cliente(String nome, String cpf, String genero, String codSocio){
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.codSocio = codSocio;
	}
	
	public String getCpf() {return cpf;}
	public String getGenero() {return genero;}
	public String getCodSocio() {return codSocio;}
	public String serealizeIn() {return "1;"+nome+";"+cpf+";"+genero+";"+codSocio+";";}
	public String serealizeOut() {return "0;"+cpf+";";}
}
