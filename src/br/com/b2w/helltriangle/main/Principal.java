package br.com.b2w.helltriangle.main;

import br.com.b2w.helltriangle.util.BibliotecaHellTriangle;



public class Principal {
	
	public static void main(String[] pArgs) {
			
		int[][] arHellTriangle = BibliotecaHellTriangle.converterArgEntrada(pArgs[0]);
		
		Triangulo triangulo = new Triangulo(arHellTriangle);
		
		System.out.println("Maior soma: " + triangulo.getMaiorSoma());
	}

}
