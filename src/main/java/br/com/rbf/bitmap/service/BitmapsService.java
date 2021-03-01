package br.com.rbf.bitmap.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

/**
 * @author Rommel
 *
 */
@Service
public class BitmapsService implements Bitmap{

	public HashMap<Integer, Long> buscarOcorrencia(Integer... vetor) {

		int[][] bitmap = recuperarBitmap();

		Stream<Integer> bitmapList = Arrays.stream(bitmap).flatMapToInt(Arrays::stream).boxed();

		Map<Integer, Long> mapBitmapValoresZerados = bitmapList
				.collect(Collectors.toMap(v -> v, v -> Long.valueOf(0), (var1, var2) -> var1));

		java.util.Map<Integer, Long> listaContagemOcorrencia = contarFrequenciaOcorrencia(bitmap, vetor);

		var mergeOcorrence = new HashMap<Integer, Long>();
		mergeOcorrence.putAll(mapBitmapValoresZerados);
		mergeOcorrence.putAll(listaContagemOcorrencia);

		return mergeOcorrence;
	}

	/**
	 * @param bitmap Matrix do Bitmap
	 * @param vetor Vetor com valores que se deseja procurar
	 * @return Map com o bit do Bitmap e quantas vezes fora encontrado.
	 */
	private java.util.Map<Integer, Long> contarFrequenciaOcorrencia(int[][] bitmap, Integer... vetor) {
		java.util.Map<Integer, Long> listaContagemOcorrencia = Arrays.stream(bitmap).flatMapToInt(Arrays::stream)
				.filter(f -> Arrays.stream(vetor).collect(Collectors.toList()).contains(Integer.valueOf(f))).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return listaContagemOcorrencia;
	}

	private int[][] recuperarBitmap() {
		return new int[][] { { 15, 5, 7, 3, 0, 4 }, { 11, 7, 12, 10, 1, 7 } };
	}

}
