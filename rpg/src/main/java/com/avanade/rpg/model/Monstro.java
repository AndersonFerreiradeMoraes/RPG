package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MONSTRO")
@Entity

public class Monstro extends Personagem implements Serializable {
    @Autowired
    private Personagem monstro;
    public void setMonstro() {
        this.monstro.setTipoPersonagem('M');
    }
}
