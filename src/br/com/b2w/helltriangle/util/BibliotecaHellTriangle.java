package br.com.b2w.helltriangle.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class BibliotecaHellTriangle {
	
	public static int[][] converterArgEntrada (String argumentoEntrada) {
		//remove os dpos primeiros e os dois ultimos colchetes
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
	
		return arPiramideInferno;
	}
	
	public static boolean validarArgumentoEntrada (String pArgumentoEntrada){
		boolean retornoValidacaoRegex = false;
		
		if(pArgumentoEntrada != null && !pArgumentoEntrada.trim().equals("")){
			//verifica se o parametro passado está dentro de acordo de um array de array que contenha apenas numeros
			Pattern regexValidacao = Pattern.compile("^\\[{2}(\\d+)(,\\d+)*(\\],\\[(\\d+)(,\\d+)*)*\\]{2}$");
			Matcher testeRetorno = regexValidacao.matcher(pArgumentoEntrada);
			retornoValidacaoRegex = testeRetorno.matches();
		}
		
		return retornoValidacaoRegex;
	}
	
	public static int calcularPossibilidadesPossiveis (int pQtdLinhasTriangulo){
		return (int) Math.pow(2, pQtdLinhasTriangulo-1);
	}

}
