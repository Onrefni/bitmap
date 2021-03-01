package br.com.rbf.bitmap.service;

import java.util.Map;

public interface Bitmap {
	
	/**
	 * Busca a ocorrência de acordo com os dos valores fornecidos.
	 * 
	 * @param vetor
	 * @return Lista do bit do Bitmap e quantas ocorrencias referente ao vetor fornecido.
	 */
	public Map<Integer, Long> buscarOcorrencia(Integer... vetor);
	
}
