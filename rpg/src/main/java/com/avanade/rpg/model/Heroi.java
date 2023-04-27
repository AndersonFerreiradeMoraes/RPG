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
@Table(name="HEROI")
@Entity

public class Heroi extends Personagem implements Serializable {
    @Autowired
    private Personagem heroi;

    public void setHeroi() {
        this.heroi.setTipoPersonagem('H');
    }
}
