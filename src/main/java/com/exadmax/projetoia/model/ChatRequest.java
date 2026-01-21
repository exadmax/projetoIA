package com.exadmax.projetoia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para requisições à IA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequest {

    private String mensagem;

}
