package com.avanade.rpg.controller;

import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.service.RpgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/rpg")
@Api(value= "RPG API REST")
@CrossOrigin(origins = "*")
public class RpgController {
    @Autowired
    private RpgService service;
    @GetMapping("/rpg/ataque")
    @ApiOperation("Ataque")
    public ResponseEntity<Personagem> Ataque (@RequestBody Personagem pAtq) {
        service.Ataque(pAtq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/rpg/defesa")
    @ApiOperation("Defesa")
    public ResponseEntity<Personagem> Defesa (@RequestBody Personagem pDef) {
        service.Defesa(pDef);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/rpg/dano")
    @ApiOperation("Calculo do dano")
    public ResponseEntity<Personagem> Dano (@RequestBody Personagem pAtq, Personagem pDef) {
        service.CalcularDano(pAtq, pDef);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
