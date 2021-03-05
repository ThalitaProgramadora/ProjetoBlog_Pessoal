package com.blog.Pessoal.test.model;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.Pessoal.model.Postagem;
import com.catalogo.App.models.Fornecedor;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostagemModelTest {

	@Autowired
    private TestEntityManager entityManager;

	@Test
	public void validaSeDoisObjetosPertencemAClaseObject() {
		Fornecedor gustavo = new Fornecedor(
				"Gustavo Boaz",
				"gustavo@email.com",
				"(19) 9 8172-2419",
				"Rua São Paulo, 265 - Nova Odessa",
				null);
		Fornecedor pamela = new Fornecedor(
				"Pamela Boaz",
				"pamela@email.com",
				"(19) 9 8172-2419",
				"Rua São Paulo, 265 - Nova Odessa",
				null);
		assertNotSame(gustavo, pamela); //Valida se pertence ao mesmo objeto
	}
	@Test
	public void validaSeDoisObjetosSaoIguais() {
		Postagem informatica = new Postagem(
				"viva a computacao",
				"a informatica é incrivel",
				null);
		Postagem direito = new Postagem(
				"viva a informatica",
				"a informatica é incrivel",
				null);
		assertFalse(direito.equals(direito));
	}
	
	@Test
	public void testaSizeMenorQueDois(){
		
		Postagem informatica = new Postagem(
				"viv",
				"a inf",
				null);
		
		Exception exception = assertThrows(
				ConstraintViolationException.class,
				() -> {
					entityManager.persistAndFlush(informatica);
					}
				);
		
		String expectedMessage = "Error size";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
}
