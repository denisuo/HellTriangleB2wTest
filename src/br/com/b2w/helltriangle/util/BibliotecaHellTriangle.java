package br.com.b2w.helltriangle.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BibliotecaHellTriangle {
	
	public static int[][] converterArgEntrada (String argumentoEntrada) {
		boolean isArtumentoEntradaValido = BibliotecaHellTriangle.validarArgumentoEntrada(argumentoEntrada);
		
		if(!isArtumentoEntradaValido){
			throw new RuntimeException("Argumento de entrada não condiz com array de array de inteiros.");
		}
		
		//remove os dois primeiros e os dois ultimos colchetes
		argumentoEntrada = argumentoEntrada.substring(2, argumentoEntrada.length()-2).trim();
		
		//dá split por '],[' para gerar um novo array de string
		String[] arStringSplit = argumentoEntrada.split("\\],\\[");
		int qtdLinhasTriangulo = arStringSplit.length;
		
		//cria um array de array para separar as linhas do triangulo contendo a posicao da linha e seus respectivos valores
		int[][] arPiramideInferno = new int[qtdLinhasTriangulo][];
		
		for (int posicaoLinhaPiramideAtual = 0; posicaoLinhaPiramideAtual < arPiramideInferno.length; posicaoLinhaPiramideAtual++) {
			String strPosicaoAtualSplitString = arStringSplit[posicaoLinhaPiramideAtual];
			
			//caso a posicao contenha mais de um número, dá split pela vírgula para separar os valores e adicionar no array
			if(strPosicaoAtualSplitString.contains(",")){
				//recupera o tamanho do array da linha atual e cria o array da linha atual
				String[] splitLinhaAtual = strPosicaoAtualSplitString.split(","); 
				int tamanhoArrayLinhaAtual = splitLinhaAtual.length;
				int[] arLinha = new int[tamanhoArrayLinhaAtual];
				
				//itera os valores da linha para adicionar no array de valores e depois no array da linha
				for (int posicaoValorAtualLinha = 0; posicaoValorAtualLinha < arLinha.length; posicaoValorAtualLinha++) {
					arLinha[posicaoValorAtualLinha] = new Integer(splitLinhaAtual[posicaoValorAtualLinha]);
				}
				arPiramideInferno[posicaoLinhaPiramideAtual] = arLinha;
			} else {
				//adiciona a primeira posicao da piramide dentro do array de array
				arPiramideInferno[posicaoLinhaPiramideAtual] = new int[]{new Integer(strPosicaoAtualSplitString).intValue()};
			}
		}
	
		
		boolean isTrianguloValido = validarLinhas(arPiramideInferno);
		
		if(!isTrianguloValido){
			throw new RuntimeException("Formato do Triângulo inválido");
		}
		
		return arPiramideInferno;
	}
	
	
	//verifica se o parametro passado está dentro de acordo de um array de array que contenha apenas numeros
	public static boolean validarArgumentoEntrada (String pArgumentoEntrada){
		String regexValidacaoArrayEntrada = "^\\[{2}(\\d+)(,\\d+)*(\\],\\[(\\d+)(,\\d+)*)*\\]{2}$";
		boolean retornoValidacaoRegex = false;
		
		if(pArgumentoEntrada != null && !pArgumentoEntrada.trim().equals("")){
			Pattern p = Pattern.compile(regexValidacaoArrayEntrada);
			Matcher m = p.matcher(pArgumentoEntrada);
			//retorna o resultado do teste regex
			retornoValidacaoRegex = m.matches();
		}
		
		return retornoValidacaoRegex;
	}


	public static boolean validarLinhas(int[][] pArHellTriangle) {
		
		//o triangulo deve ter ao menos duas linhas
		if(pArHellTriangle.length < 2){
			return false;
		}
		
		//verifica se a quantidade de colunas em cada linha é maior que a anterior + 1
		for(int linhaAtual = 0; linhaAtual<pArHellTriangle.length; linhaAtual++){
			if(pArHellTriangle[linhaAtual] == null || pArHellTriangle[linhaAtual].length != linhaAtual+1)
				return false;
		}
		
		return true;
	}

}
