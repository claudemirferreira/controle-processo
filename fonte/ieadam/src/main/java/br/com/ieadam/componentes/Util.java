package br.com.ieadam.componentes;

public class Util {
	
	public static int definirTamanhoColuna(int tamanho){
		
		double col = Math.sqrt(tamanho);
		int colunas = (int) col;

		if(colunas  < col)
			colunas ++;
		
		return colunas;
	}

}