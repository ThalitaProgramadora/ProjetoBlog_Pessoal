package com.blog.Pessoal.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Pessoal.model.Postagem;
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);

}
