package com.aula.projeto02.sistema.Repositories;

import com.aula.projeto02.sistema.Models.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}
