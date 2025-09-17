package API.Biblioteca.de.Tarefas.APIbiblioteca.Repositories;

import API.Biblioteca.de.Tarefas.APIbiblioteca.Models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByStatus(String status);

}