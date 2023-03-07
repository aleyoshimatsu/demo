package dev.alexandreyoshimatsu.demo.mapper

import dev.alexandreyoshimatsu.demo.dto.UsuarioDto
import dev.alexandreyoshimatsu.demo.entity.Usuario
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class UsuarioMapper {

    abstract fun toEntity(usuarioDto: UsuarioDto): Usuario

    abstract fun toDto(usuario: Usuario): UsuarioDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(usuarioDto: UsuarioDto, @MappingTarget usuario: Usuario): Usuario
}