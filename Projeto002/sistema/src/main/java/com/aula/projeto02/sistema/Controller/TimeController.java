package com.aula.projeto02.sistema.Controller;

import com.aula.projeto02.sistema.Models.Time;
import com.aula.projeto02.sistema.Repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {

    private final TimeRepository timeRepository;

    @Autowired
    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @GetMapping
    public List<Time> getAll() {
        return timeRepository.findAll();
    }
}
