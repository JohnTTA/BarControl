package persistence;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import business.Cliente;


public class Buffer {
	
	List<Cliente> buffer = new ArrayList<Cliente>();
	
	//Registrar entrada	
	public boolean signIn(String nome, String cpf, String genero, String codSocio) {

		Cliente tmp = searchByCpf(cpf);		
		if(tmp == null) { //if cpf não está na casa
			
			Cliente c = new Cliente(nome, cpf, genero, codSocio);			
			buffer.add(c); // add na lista
			
			File file = new File(getNameFile());
			
			try {			
				FileWriter writer = new FileWriter(file,true);	
				writer.write(c.serealizeIn()+"\n");
				writer.close();
			}
			catch (Exception e){}
			
			return true;
		}
		
		return false;
	}
	
	//Registrar saída
	public boolean signOut(String cpf) {
		try {
			Cliente c = searchByCpf(cpf);
			buffer.remove(c);
					
			File file = new File(getNameFile()); 

			FileWriter writer = new FileWriter(file,true);	
			writer.write(c.serealizeOut()+"\n");
			writer.close();
		}
		catch (Exception e){ return false;}

		return true;
	}
	
	//Listar todos
	public List<Cliente> listAll() {		
		List<Cliente> tmp = new ArrayList(buffer);
		return tmp;
	}
	
	//Consultar por cpf
	public Cliente searchByCpf(String cpf) {
		Cliente out = null;
		
		for(Cliente tmp : buffer)
			if(tmp.getCpf().equals(cpf))
				{out = tmp;break;}			
		
		return out;
	}
	
	//Listar totais
	public HashMap<String, Integer> dataAnalysis() {
		
		int masc =0,fem=0,socios=0, nSocios=0, qtd=buffer.size();		
		
		for(int i = 0;i<qtd;i++)
	    {
			Cliente c = buffer.get(i);			
			int z = c.getGenero().equals("M") ? masc++ : fem++;				
			z=c.getCodSocio().equals("0") ? nSocios++ : socios++;				
	    }			
		
		 HashMap<String, Integer> hMap = new HashMap<String, Integer>();		 
		 hMap.put("qtd", qtd);
		 hMap.put("pctMasc", Math.round((float)masc/qtd*100));
		 hMap.put("pctFem", Math.round((float)fem/qtd*100));
		 hMap.put("socios", socios);
		 hMap.put("nSocios", qtd-socios);
		 
		 return hMap;	
	}
	
	private String getNameFile() {
		StringBuilder sb = new StringBuilder();
		Calendar cal = Calendar.getInstance();  
		sb.append(Integer.toString(cal.get(Calendar.DATE)));
		sb.append(Integer.toString(cal.get(Calendar.MONTH)));
		sb.append(Integer.toString(cal.get(Calendar.YEAR)));		
		return sb.toString();
	}
}
