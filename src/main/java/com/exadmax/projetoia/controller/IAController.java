package com.exadmax.projetoia.controller;

import com.exadmax.projetoia.model.ChatRequest;
import com.exadmax.projetoia.model.ChatResponse;
import com.exadmax.projetoia.model.Conversa;
import com.exadmax.projetoia.service.IAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para endpoints de IA
 */
@RestController
@RequestMapping("/api/ia")
public class IAController {

    @Autowired
    private IAService iaService;

    /**
     * Endpoint para enviar mensagem à IA
     */
    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        try {
            ChatResponse response = iaService.enviarMensagem(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ChatResponse("Erro ao processar mensagem: " + e.getMessage(), null));
        }
    }

    /**
     * Endpoint para buscar histórico de conversas
     */
    @GetMapping("/conversas")
    public ResponseEntity<List<Conversa>> listarConversas() {
        List<Conversa> conversas = iaService.buscarConversas();
        return ResponseEntity.ok(conversas);
    }

    /**
     * Endpoint para buscar conversa específica
     */
    @GetMapping("/conversas/{id}")
    public ResponseEntity<Conversa> buscarConversa(@PathVariable Long id) {
        try {
            Conversa conversa = iaService.buscarConversaPorId(id);
            return ResponseEntity.ok(conversa);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint de health check
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Serviço de IA está funcionando!");
    }

}
