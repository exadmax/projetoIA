package com.exadmax.projetoia.service;

import com.exadmax.projetoia.model.ChatRequest;
import com.exadmax.projetoia.model.ChatResponse;
import com.exadmax.projetoia.model.Conversa;
import com.exadmax.projetoia.repository.ConversaRepository;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço para gerenciar interações com IA
 */
@Service
public class IAService {

    @Autowired
    private ChatClient chatClient;

    @Autowired
    private ConversaRepository conversaRepository;

    /**
     * Envia uma mensagem para a IA e salva a conversa
     */
    public com.exadmax.projetoia.model.ChatResponse enviarMensagem(ChatRequest request) {
        // Chama a IA
        ChatResponse aiResponse = chatClient.call(new Prompt(request.getMensagem()));
        String resposta = aiResponse.getResult().getOutput().getContent();

        // Salva a conversa no banco
        Conversa conversa = new Conversa();
        conversa.setPergunta(request.getMensagem());
        conversa.setResposta(resposta);
        conversa = conversaRepository.save(conversa);

        // Retorna a resposta
        return new com.exadmax.projetoia.model.ChatResponse(resposta, conversa.getId());
    }

    /**
     * Busca todas as conversas salvas
     */
    public List<Conversa> buscarConversas() {
        return conversaRepository.findAllByOrderByDataHoraDesc();
    }

    /**
     * Busca uma conversa específica por ID
     */
    public Conversa buscarConversaPorId(Long id) {
        return conversaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada com ID: " + id));
    }

}
