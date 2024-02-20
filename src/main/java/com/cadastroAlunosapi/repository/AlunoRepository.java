package com.cadastroAlunosapi.repository;

import com.cadastroAlunosapi.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    Optional findByprimeiroName(String primeiroName);
}
