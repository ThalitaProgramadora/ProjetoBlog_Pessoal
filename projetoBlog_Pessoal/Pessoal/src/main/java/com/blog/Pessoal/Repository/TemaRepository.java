package com.blog.Pessoal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Pessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
    public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
