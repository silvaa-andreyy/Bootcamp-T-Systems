package com.Aula.projeto01.Controllers;

import com.Aula.projeto01.Models.Aluno;
import com.Aula.projeto01.Repositories.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public String add(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
        return "Aluno criado com sucesso!";

    }
}
