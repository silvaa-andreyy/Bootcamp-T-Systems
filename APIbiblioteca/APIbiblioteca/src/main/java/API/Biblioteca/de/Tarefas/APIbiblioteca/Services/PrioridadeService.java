package API.Biblioteca.de.Tarefas.APIbiblioteca.Services;

import API.Biblioteca.de.Tarefas.APIbiblioteca.Models.Prioridade;
import API.Biblioteca.de.Tarefas.APIbiblioteca.Repositories.PrioridadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrioridadeService {
    private final PrioridadeRepository prioridadeRepository;

    public Prioridade criar(Prioridade p) {
        return prioridadeRepository.save(p);
    }

    public Optional<Prioridade> buscarPorId(Long id) {
        return prioridadeRepository.findById(id);
    }

    public List<Prioridade> listar() {
        return prioridadeRepository.findAll();
    }

    public void remover(Long id) {
        prioridadeRepository.deleteById(id);
    }
}
