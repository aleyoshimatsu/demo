package dev.alexandreyoshimatsu.demo.dto

import java.io.Serializable

/**
 * A DTO for the {@link dev.alexandreyoshimatsu.demo.entity.Usuario} entity
 */
data class UsuarioDto(var id: Long? = null, var nome: String? = null) : Serializable