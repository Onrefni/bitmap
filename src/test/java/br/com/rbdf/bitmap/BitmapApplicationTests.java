package br.com.rbdf.bitmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class BitmapApplicationTests {

	@Autowired
	private MockMvc service;

	@DisplayName("Teste Hero Falha")
	@Test
	void TesteUrlNaoEncontrada() throws Exception {
		String uri = "/bitmap/ocorrencia";
		service.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}
	
	@DisplayName("Teste Hero Sucesso")
	@Test
	void contextLoads() throws Exception {
		String uri = "/bitmap/ocorrencia";
		service.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
