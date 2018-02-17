package br.com.b2w.helltriangle.teste;

import br.com.b2w.helltriangle.main.Triangulo;
import br.com.b2w.helltriangle.util.BibliotecaHellTriangle;


public class TesteAlgoritmoContagem {
	
	private static String argumentoEntrada = "[[6],[0,5],[9,7,1],[4,6,8,4]]";
	//valor do teste
	//"[[6],[3,5],[9,7,1],[4,6,8,4]]"
	
	public static void main(String[] args) {
		
		int[][] arHellTriangle = BibliotecaHellTriangle.converterArgEntrada(argumentoEntrada);
		
		int contadorGeral = 0;
		int qtdLinhasTriangulo = arHellTriangle.length;
		int posicaoLinhaAnteriorTriangulo = 0;
		int posicaoValorArrayLinhaAnterior = 0;
		int combinacoesPossiveis = BibliotecaHellTriangle.calcularPossibilidadesPossiveis(qtdLinhasTriangulo);
		
		Triangulo triangulo = new Triangulo();
		
		
		
	}
	

}
