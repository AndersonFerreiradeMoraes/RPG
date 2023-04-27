package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LOG")
@Entity
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private long id;
    private Personagem heroi;
    private Personagem monstro;
    private String iniciadoPor;
    private Turno turno;
}
