package com.digitalinnovationone.aula03.repostory;

import com.digitalinnovationone.aula03.entity.SoldadoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldadoRepository extends JpaRepository<SoldadoEntity, Long> {
    
}
