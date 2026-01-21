package com.exadmax.projetoia.repository;

import com.exadmax.projetoia.model.Conversa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para gerenciar conversas
 */
@Repository
public interface ConversaRepository extends JpaRepository<Conversa, Long> {

    /**
     * Busca todas as conversas ordenadas por data/hora decrescente
     */
    List<Conversa> findAllByOrderByDataHoraDesc();

}
