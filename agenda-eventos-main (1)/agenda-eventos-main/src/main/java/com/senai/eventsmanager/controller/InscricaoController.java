package com.senai.eventsmanager.controller;

import com.senai.eventsmanager.dto.InscricaoDTO;
import com.senai.eventsmanager.entity.Inscricao;
import com.senai.eventsmanager.service.InscricaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/inscricao")
public class InscricaoController {

    InscricaoService service;

    @GetMapping("/{id}")
    public InscricaoDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<InscricaoDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public InscricaoDTO save(
            @RequestBody InscricaoDTO inscricaoCreateDTO ){
        return service.save(inscricaoCreateDTO);
    }

    @PutMapping("/{id}")
    public InscricaoDTO update(
            @PathVariable("id")Long id,
            @RequestBody InscricaoDTO inscricaoCreateDTO){
        return service.update(id,inscricaoCreateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
         service.deleteById(id);
    }
}
