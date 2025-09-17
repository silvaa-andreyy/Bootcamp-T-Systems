package API.Biblioteca.de.Tarefas.APIbiblioteca.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    private LocalDate prazo;

    @Column(name = "atribuida_para", length = 100)
    private String atribuidaPara;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prioridade_id")
    private Prioridade prioridade;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }
}