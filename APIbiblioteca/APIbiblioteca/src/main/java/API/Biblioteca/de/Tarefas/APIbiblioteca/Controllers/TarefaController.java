package API.Biblioteca.de.Tarefas.APIbiblioteca.Controllers;

import API.Biblioteca.de.Tarefas.APIbiblioteca.Dtos.TarefaDto;
import API.Biblioteca.de.Tarefas.APIbiblioteca.Models.Tarefa;
import API.Biblioteca.de.Tarefas.APIbiblioteca.Services.TarefaServices;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaServices service;

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodas() {
        List<Tarefa> tarefas = service.listarTodas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> buscarPorId(@PathVariable Long id) {
        TarefaDto tarefa = service.buscarPorId(id);
        return ResponseEntity.ok(new TarefaDto(tarefa));
    }

    @PostMapping
    public ResponseEntity<TarefaDto> criar(@RequestBody TarefaDto dto, UriComponentsBuilder uriBuilder) {
        TarefaDto criada = service.criar(dto);
        URI uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(criada.getId()).toUri();
        return ResponseEntity.created(uri).body(new TarefaDto(criada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDto> atualizar(@PathVariable Long id, @RequestBody TarefaDto dto) {
        TarefaDto atualizada = service.atualizar(id, dto);
        return ResponseEntity.ok(new TarefaDto(atualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}

