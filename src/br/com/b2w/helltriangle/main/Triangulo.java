package br.com.b2w.helltriangle.main;


public class Triangulo {
	
	int[][] arPiramideInferno;
	
	public Triangulo (int[][] pArPiramideInferno){
		arPiramideInferno = pArPiramideInferno;
	}

	public int getMaiorSoma(){
		//inicia a busca na arvore começando na posicao 0,0
		return getMaiorValorArvore(0, 0);
	}
	
	private int getMaiorValorArvore(int linha, int coluna) {
		int valorArvoreEsq = 0;
		int valorArvoreDir = 0;
		
		int valorNoAtual = arPiramideInferno[linha][coluna];
		int qtdLinhasTriangulo = arPiramideInferno.length;
		
		int proximaLinhaTriangulo = linha + 1;
		if(qtdLinhasTriangulo !=  proximaLinhaTriangulo){
			valorArvoreEsq = getMaiorValorArvore(proximaLinhaTriangulo, coluna); // esquerda

			int proximaColuna = coluna + 1;
			valorArvoreDir = getMaiorValorArvore(proximaLinhaTriangulo, proximaColuna); // direita
		}
		
		int retornoSoma = valorNoAtual + ((valorArvoreEsq > valorArvoreDir) ? valorArvoreEsq : valorArvoreDir);

		return retornoSoma;
	}

}
