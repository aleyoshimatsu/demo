package dev.alexandreyoshimatsu.demo.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "usuario", schema = "demo")
open class Usuario {
    @Id
    @Column(name = "\"Id\"", nullable = false)
    open var id: Long? = null

    @Column(name = "\"Nome\"", length = Integer.MAX_VALUE)
    open var nome: String? = null
}