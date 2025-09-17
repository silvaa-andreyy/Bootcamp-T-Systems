package API.Biblioteca.de.Tarefas.APIbiblioteca.Dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import API.Biblioteca.de.Tarefas.APIbiblioteca.Models.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TarefaDto {
    private Long id;
    private String titulo;
    private String descricao;
    private String status;
    private LocalDateTime dataCriacao;
    private LocalDate prazo;
    private String atribuidaPara;
    private String prioridadeNome;
    private Integer prioridadeNivel;

    public TarefaDto(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
        this.dataCriacao = tarefa.getDataCriacao();
        this.prazo = tarefa.getPrazo();
        this.atribuidaPara = tarefa.getAtribuidaPara();
        this.prioridadeNome = tarefa.getPrioridade() != null ? tarefa.getPrioridade().getNome() : null;
        this.prioridadeNivel = tarefa.getPrioridade() != null ? tarefa.getPrioridade().getNivel() : null;
    }

    public TarefaDto(TarefaDto tarefaDto) {

    }
}
