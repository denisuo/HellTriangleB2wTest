package br.com.b2w.helltriangle.main;


public class Triangulo {
	
	int[][] arPiramideInferno;
	
	public Triangulo (int[][] pArPiramideInferno){
		arPiramideInferno = pArPiramideInferno;
	}

	public int getMaiorSoma(){
		return getValor(0, 0);
	}
	
	private int getValor(int linha, int coluna) {
		int valorArvoreEsq = 0;
		int valorArvoreDir = 0;
		
		int valorNoAtual = arPiramideInferno[linha][coluna];
		int qtdLinhasTriangulo = arPiramideInferno.length;
		
		int proximaLinhaTriangulo = linha + 1;
		if(qtdLinhasTriangulo !=  proximaLinhaTriangulo){
			valorArvoreEsq = getValor(proximaLinhaTriangulo, coluna); // esquerda

			int proximaColuna = coluna + 1;
			valorArvoreDir = getValor(proximaLinhaTriangulo, proximaColuna); // direita
		}
		
		int retornoSoma = valorNoAtual + ((valorArvoreEsq > valorArvoreDir) ? valorArvoreEsq : valorArvoreDir);

		return retornoSoma;
	}

}
