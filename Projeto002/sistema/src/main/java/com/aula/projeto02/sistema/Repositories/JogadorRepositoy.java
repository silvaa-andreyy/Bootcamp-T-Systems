package com.aula.projeto02.sistema.Repositories;

import com.aula.projeto02.sistema.Models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JogadorRepositoy extends JpaRepository<Jogador, Long> {

}
