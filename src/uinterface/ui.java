package uinterface;

import persistence.Buffer;

public class ui {
	public static void main( String[] args){
		
		Buffer b = new Buffer();
		
		b.signIn("Ramiro1", "cpf1", "M", "0");
		b.signIn("Ramiro2", "cpf2", "F", "123");
		b.signIn("Ramiro3", "cpf3", "M", "0");
		b.signOut("cpf2");
		b.signIn("Ramiro4", "cpf4", "M", "0");
		b.signIn("Ramiro5", "cpf5", "F", "566536");
		b.signIn("Ramiro6", "cpf6", "M", "0");
		b.signIn("Ramiro7", "cpf7", "F", "1236535");
		b.signIn("Ramiro8", "cpf8", "M", "0");
		b.signIn("Ramiro9", "cpf9", "F", "44444");
		b.signIn("Ramiro10", "cpf10", "M", "0");
		b.signIn("Ramiro11", "cpf11", "F", "1552");
		
		b.dataAnalysis();	
	}
}
