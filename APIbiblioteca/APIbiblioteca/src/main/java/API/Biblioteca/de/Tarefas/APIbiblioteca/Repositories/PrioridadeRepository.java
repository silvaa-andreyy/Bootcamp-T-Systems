package API.Biblioteca.de.Tarefas.APIbiblioteca.Repositories;

import API.Biblioteca.de.Tarefas.APIbiblioteca.Models.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrioridadeRepository extends JpaRepository<Prioridade, Long> {
    Optional<Prioridade> findByNome(String nome);
    List<Prioridade> findByNivel(Integer nivel);
}

