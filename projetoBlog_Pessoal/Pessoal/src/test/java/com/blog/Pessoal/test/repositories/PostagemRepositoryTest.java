package com.blog.Pessoal.test.repositories;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.Pessoal.Repository.PostagemRepository;
import com.blog.Pessoal.model.Postagem;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostagemRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PostagemRepository repository;

	@Test
	public void procurarPostagemPorID_ReotrnaPostagem() {
		Postagem informatica = new Postagem();
		entityManager.persistAndFlush(informatica);
	}

	@Test
	public void TestSizeMenorQueCinco() {
		Postagem informatica = new Postagem();

		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			entityManager.persistAndFlush(informatica);
		});
		String expectedMessage = "Error size";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
