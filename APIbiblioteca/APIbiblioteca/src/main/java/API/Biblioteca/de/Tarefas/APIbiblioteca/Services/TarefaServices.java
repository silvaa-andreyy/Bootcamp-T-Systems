package API.Biblioteca.de.Tarefas.APIbiblioteca.Services;

import API.Biblioteca.de.Tarefas.APIbiblioteca.Dtos.TarefaDto;
import API.Biblioteca.de.Tarefas.APIbiblioteca.Models.Tarefa;
import API.Biblioteca.de.Tarefas.APIbiblioteca.Repositories.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaServices {

    private final TarefaRepository repository;

    public List<Tarefa> listarTodas() {
        return repository.findAll();

    }

    public TarefaDto buscarPorId(Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
        return new TarefaDto(tarefa);
    }

    public TarefaDto criar(TarefaDto dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setPrazo(dto.getPrazo());
        tarefa.setAtribuidaPara(dto.getAtribuidaPara());

        Tarefa salva = repository.save(tarefa);
        return new TarefaDto(salva);
    }

    public TarefaDto atualizar(Long id, TarefaDto dto) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setPrazo(dto.getPrazo());
        tarefa.setAtribuidaPara(dto.getAtribuidaPara());

        Tarefa atualizada = repository.save(tarefa);
        return new TarefaDto(atualizada);
    }

    public void remover(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa não encontrada");
        }
        repository.deleteById(id);
    }
}
