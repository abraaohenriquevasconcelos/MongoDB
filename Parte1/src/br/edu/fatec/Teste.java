package br.edu.fatec;

public class Teste {

	public static void main(String[] args) {
		String s = "João da Silva";
		String s2 = "Maria da Silva";
		String s3= "José da Silva";
		char[] charArray = s.toCharArray();
		
		for(char c : charArray){
			System.out.println("["+c+"]");
		}

	}

}
