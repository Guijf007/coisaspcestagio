package com.guilherme.GabaritoAPi.Repository;

import com.guilherme.GabaritoAPi.Model.Questoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestoesRepository extends JpaRepository<Questoes, Integer> {
    List<Questoes> findAllByIdProva(int idProva);
}
