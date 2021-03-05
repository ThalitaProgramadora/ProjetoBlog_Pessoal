package com.blog.Pessoal.test.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostagemControllerTest {
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void validarRetornoComFornecedor_RetornoAutorizado() {
		ResponseEntity<String> resposta = 
				testRestTemplate.withBasicAuth("Thalita", "26489")
				.exchange("/post", HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.ACCEPTED, resposta.getStatusCode());
	}
	
	@Test
	void validarRetornoComFornecedor_RetornoNaoAutorizado() {
		ResponseEntity<String> resposta = 
				testRestTemplate.withBasicAuth("", "")
				.exchange("/post", HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
	}
}
