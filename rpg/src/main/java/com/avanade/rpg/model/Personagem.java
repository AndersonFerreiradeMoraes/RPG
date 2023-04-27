package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PERSONAGEM")
@Entity
public class Personagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private long id;
    private String nome;
    private int pv;
    private int forca;
    private int defesa;
    private int agilidade;
    //private Dado dado;
    private int qtdDados;
    private int tipoDado;
    private char tipoPersonagem; // H-Herói | M-Monstro

    @Override
    public String toString() {
        return "Personagem{" +
                "id=" + id +
                ", nome='" + nome +
                ", Pontos de vida='" + pv +
                ", forca='" + forca +
                ", defesa='" + defesa +
                ", agilidade='" + agilidade +
                ", qtdDados='" + qtdDados +
                ", tipoDado='" + tipoDado +
                ", tipoPersonagem='" + tipoPersonagem +
                '}';
    }
}
