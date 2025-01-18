package com.alura.forumhub.usuaio;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacao(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        String estado,
        String autor,
        String curso) {
}
