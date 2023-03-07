package dev.alexandreyoshimatsu.demo.controller

import dev.alexandreyoshimatsu.demo.dto.UsuarioDto
import dev.alexandreyoshimatsu.demo.entity.Usuario
import dev.alexandreyoshimatsu.demo.mapper.UsuarioMapper
import dev.alexandreyoshimatsu.demo.repository.UsuarioRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/v1")
class UsuarioController(private val usuarioMapper: UsuarioMapper, private val usuarioRepository: UsuarioRepository) {

    @GetMapping("/usuarios/find/{nome}")
    fun findByNome(@PathVariable nome: String): List<UsuarioDto> {
        val usuarios: List<Usuario> = usuarioRepository.findByNome(nome);

        return usuarios.stream().map(usuarioMapper::toDto).collect(Collectors.toList());
    }

}