package br.com.b2w.helltriangle.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.b2w.helltriangle.main.Triangulo;
import br.com.b2w.helltriangle.util.BibliotecaHellTriangle;




public class Teste {
		
	@Test
	public void validarArgumentoEntrada (){
		Assert.assertEquals(true, BibliotecaHellTriangle.validarArgumentoEntrada("[[6],[3,5],[9,7,1],[10,6,8,4]]"));
		Assert.assertEquals(false, BibliotecaHellTriangle.validarArgumentoEntrada("[[6],[3,5],[9,7,1],[10,6,8,4,]]"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void converterArgumentoEntradaEmArrayInteiros(){
		int dados[][] = new int[4][];
		dados[0] = new int[]{6};
		dados[1] = new int[]{3,5};
		dados[2] = new int[]{9,7,1};
		dados[3] = new int[]{10,6,8,4};
		
		int[][] arHellTriangle = BibliotecaHellTriangle.converterArgEntrada("[[6],[3,5],[9,7,1],[10,6,8,4]]");
		Assert.assertEquals(dados,arHellTriangle);

	}
	
	@Test
	public void validarLinhasTriangulo(){
		
		int dados[][] = new int[1][];
		Assert.assertEquals(false, BibliotecaHellTriangle.validarLinhas(dados));
		
		dados = new int[4][];
		dados[0] = new int[]{6};
		dados[1] = new int[]{3,5};
		dados[2] = new int[]{9,7,1};
		dados[3] = new int[]{10,6,8,4};
		
		Assert.assertEquals(true, BibliotecaHellTriangle.validarLinhas(dados));
		
		//altera o array para retornar inválido
		dados[3] = new int[]{10,6,8,4,9};
		Assert.assertEquals(false, BibliotecaHellTriangle.validarLinhas(dados));
	}

	@Test
	public void encontrarMaiorSomaTriangulo(){
		int dados[][] = new int[4][];
		dados[0] = new int[]{6};
		dados[1] = new int[]{3,5};
		dados[2] = new int[]{9,7,1};
		dados[3] = new int[]{10,6,8,4};
		
		Triangulo triangulo = new Triangulo(dados);
		
		Assert.assertEquals(28, triangulo.getMaiorSoma());
		
		dados[3]=new int[]{4,6,8,4};
		Assert.assertEquals(26, triangulo.getMaiorSoma());
	}
	
}
