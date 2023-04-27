package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TURNO")
@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private long id;
    private String jogadorInicio;
    private Personagem heroi;
    private Personagem monstro;
    private int forcaAtaque;
    private int forcaDefesa;
    private int dano;
    private int pvAtualizado;
}
