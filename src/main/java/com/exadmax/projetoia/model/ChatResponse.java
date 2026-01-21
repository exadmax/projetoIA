package com.exadmax.projetoia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para respostas da IA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponse {

    private String resposta;
    private Long conversaId;

}
