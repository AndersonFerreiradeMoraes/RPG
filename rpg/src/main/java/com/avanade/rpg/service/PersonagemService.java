package com.avanade.rpg.service;

import com.avanade.rpg.exception.ResourceNotFoundException;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PersonagemService implements ApplicationRunner {

    //private static final Logger LOGGER = Logger.getLogger(PersonagemService.class.getName());
    @Autowired
    private PersonagemRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Heróis
        Personagem guerreiro = new Personagem(1,"Guerreiro",20,7,5,6,1,12,'H');
        repository.save(guerreiro);

        Personagem barbaro = new Personagem(2,"Barbaro",21,10,2,5,2,8,'H');
        repository.save(barbaro);

        Personagem cavaleiro = new Personagem(3,"Cavaleiro",26,6,8,3,2,6,'H');
        repository.save(cavaleiro);

        //Monstro
        Personagem orc = new Personagem(4,"Orc",42,7,1,2,3,4,'M');
        repository.save(orc);

        Personagem gigante = new Personagem(5,"Gigante",34,10,4,4,2,6,'M');
        repository.save(gigante);

        Personagem lobisomen = new Personagem(6,"Lobisomen",34,7,4,7,2,4,'M');
        repository.save(lobisomen);

    }
    public Personagem Criar(Personagem personagem){
        return this.repository.save(personagem);
    }
    public List<Personagem> Listar(){
        return repository.findAll();
    }

    public Personagem ListarPorId(Long id){
        return repository.findById( id ).orElseThrow( ( ) -> new ResourceNotFoundException( "Personagem não encontrado: " + id ) );
    }
    public Personagem Selecionar(){
        return null;
    }


    public void delete(Long id){
        repository.deleteById(id);
    }

    public Personagem update(Personagem personagem){
        //if (null == personagem.getId()) {
        //    throw new InvalidInputException( "There is no ID.");
        //}
        return repository.save(personagem);
    }

}
