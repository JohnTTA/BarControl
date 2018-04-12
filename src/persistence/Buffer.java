package persistence;

import java.util.ArrayList;
import java.util.List;
import business.Cliente;

public class Buffer {
	
	List<Cliente> buffer = new ArrayList<Cliente>();
	
	//Registrar entrada	
	boolean signIn() {
		/*-Validar se cpf ja está na casa
		  -Inserir na lista
		  -Criar txt(verificar se já existe txt da data)		 
		  -Registrar entrada no .txt*/
		
		//Modelo serealização de entrada(1;Nome;Cpf;Genero;codSocio)
		return true;
	}
	
	//Registrar saída
	boolean signOut() {
		/*-Retirar da lista
		  -Registrar saída no .txt*/
		
		//Modelo serealização de saída(0;Cpf)
		return false;
	}
	
	//Listar todos
	List<Cliente> listAll() {		
		//retornar uma copia da lista;
		List<Cliente> l = null;
		return l;
	}
	
	//Consultar por cpf
	Cliente listByCpf() {
		//buscar na lista e retornar o match
		Cliente c = null;
		return c;
	}
	
	//Listar totais
	void dataAnalysis() {
		/*Calcular e retornar os dados em alguma estrutura 
		  sugiro uma hash(key,value)
		ex.
		qtd=100
		pctMasc=40
		pctFem=60
		socios=80
		nSocios=20*/		
	}

}
