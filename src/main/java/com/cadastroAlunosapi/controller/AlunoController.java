package com.cadastroAlunosapi.controller;

import com.cadastroAlunosapi.dto.AlunoDTO;
import com.cadastroAlunosapi.entity.AlunoEntity;
import com.cadastroAlunosapi.exceptions.UsuarioJaExisteException;
import com.cadastroAlunosapi.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping
    public List<AlunoEntity> mostrarTodos (){
        return alunoRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<AlunoEntity> cadastrarAluno(@RequestBody AlunoDTO alunoDTO){
        Optional<AlunoEntity> alunoExist = alunoRepository.findByprimeiroName(alunoDTO.primeiroName());
        if(alunoExist.isPresent()){
             throw new UsuarioJaExisteException("");
        } else {
            AlunoEntity alunoEntity = new AlunoEntity();
            BeanUtils.copyProperties(alunoDTO, alunoEntity);
            alunoRepository.save(alunoEntity);
            return new ResponseEntity<>(alunoEntity,HttpStatus.CREATED);
        }
    }
}
