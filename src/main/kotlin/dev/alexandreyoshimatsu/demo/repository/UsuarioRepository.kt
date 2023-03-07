package dev.alexandreyoshimatsu.demo.repository;

import dev.alexandreyoshimatsu.demo.entity.Usuario
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository : CrudRepository<Usuario, Long> {

    fun findByNome(nome: String): List<Usuario>;

}