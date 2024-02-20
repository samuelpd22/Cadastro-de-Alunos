package com.cadastroAlunosapi.controller;

import com.cadastroAlunosapi.dto.AlunoDTO;
import com.cadastroAlunosapi.entity.AlunoEntity;
import com.cadastroAlunosapi.exceptions.UsuarioJaExisteException;
import com.cadastroAlunosapi.exceptions.UsuarioNaoEncontradoException;
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
    public List<AlunoEntity> mostrarTodos() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        Optional<AlunoEntity> alunoExist = alunoRepository.findByprimeiroName(alunoDTO.primeiroName());
        if (alunoExist.isPresent()) {
            throw new UsuarioJaExisteException("Usuario já cadastrado em nosso banco de dados.");
        } else {
            AlunoEntity alunoEntity = new AlunoEntity();
            BeanUtils.copyProperties(alunoDTO, alunoEntity);
            alunoRepository.save(alunoEntity);
            return new ResponseEntity<>(alunoEntity, HttpStatus.CREATED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
        Optional<AlunoEntity> alunoExist = alunoRepository.findById(id);
        if (alunoExist.isPresent()) {
            return new ResponseEntity<>(alunoExist, HttpStatus.OK);
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado em nossa base de dados.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
        if (alunoEntity.isPresent()) {
            alunoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado em nossa base de dados.");
        }
    }
}