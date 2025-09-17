package API.Biblioteca.de.Tarefas.APIbiblioteca.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prioridades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prioridade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ex.: "BAIXA", "MEDIA", "ALTA" (você pode usar Enum depois, se preferir)
    @Column(nullable = false, unique = true, length = 20)
    private String nome;

    // Um número para facilitar ordenação: 1 (baixa), 2 (média), 3 (alta)
    @Column(nullable = false)
    private Integer nivel;
}
