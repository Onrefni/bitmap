package br.com.rbf.bitmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbf.bitmap.service.Bitmap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="BitmapEndPoint")
@RestController
@RequestMapping("/bitmap")
public class BitmapController {

	@Autowired
	private Bitmap service;

	@ApiOperation(value = "Busca de ocorrencias dentro da matriz do Bitmap.")
	@GetMapping(path = "/ocorrencia", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> buscarOcorrencia(@RequestParam Integer[] values)  {
		
		return ResponseEntity.ok(service.buscarOcorrencia(values));

	}

}
