package Persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import Negocio.Cliente;
import Negocio.DAOClienteArquivo;

public class ArquivoCliente {
	
	private GregorianCalendar calendar;
	private Locale locale;
	private SimpleDateFormat formatador;
	private static FileWriter arqEntrada, arqSaida;
	private static PrintWriter gravarArqEntrada, gravarArqSaida;

	public ArquivoCliente(){
	        calendar = new GregorianCalendar();
	        locale = new Locale("pt","BR");
	        formatador = new SimpleDateFormat("h:mm a",locale);  
	        criaPath();
	    }

	public static void criaPath() {
		try {
			arqEntrada = new FileWriter("H:\\arquivoEntrada.txt", true);
			arqSaida = new FileWriter("H:\\arquivoSaida.txt", true);
			gravarArqEntrada = new PrintWriter(arqEntrada, true);
			gravarArqSaida = new PrintWriter(arqSaida, true);
		} catch (IOException ex) {
		}
	}

	public static void fechaArquivoEntrada() {
		try {
			arqEntrada.close();
		} catch (IOException ex) {
			System.out.println("Exception " + ex);
		}
	}

	public void salvaClienteEntrada(Cliente cli) {
		gravarArqEntrada.printf(cli.getNome() + " " + formatador.format(calendar.getTime()) + "%n");
	}

	public void salvaClienteSaida(Cliente cli) {
		gravarArqSaida.printf(cli.getNome() + " " + formatador.format(calendar.getTime()) + "%n");
	}

	public void iniciaArqivo() throws IOException {
		// FileWriter arqEntrada = new FileWriter("D:\\arquivoEntrada.txt");
	}

	public void fechaArquivo() {

	}
}
