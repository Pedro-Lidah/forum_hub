package com.alura.forumhub.usuaio;

import jakarta.validation.Valid;

public record DadosUsuario(Long id, String titulo, String mensagem, String estado, String autor, String curso ) {

}
