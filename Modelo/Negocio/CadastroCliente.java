package Negocio;

import Persistencia.ArquivoCliente;

public class CadastroCliente {

	private ArquivoCliente arquivo;

	public CadastroCliente() {
        this.arquivo = new ArquivoCliente(); 
    }

	public void salvaClienteEntrada(Cliente cliente) {
		arquivo.salvaClienteEntrada(cliente);
	}

	public void salvaClienteSaida(Cliente cliente) {
		arquivo.salvaClienteSaida(cliente);
	}

}
