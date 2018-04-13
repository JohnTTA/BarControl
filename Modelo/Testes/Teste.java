package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.Controle;
import Negocio.Bar;
import Negocio.Categoria;
import Negocio.Cliente;

public class Teste {

	private Bar bar;
	private Cliente cliente;
	private Controle controller;

	@Before
	public void setUp() throws Exception {
		bar = new Bar();
		cliente = new Cliente("camila", "1234", 23, 'F', Categoria.Silver);
	}

	
	@Test
	public void numeroClientes(){
		int num = bar.numeroClientes();
		assertEquals(0,num,0.1);
	}
	


}
