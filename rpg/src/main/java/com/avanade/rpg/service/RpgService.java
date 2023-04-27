package com.avanade.rpg.service;

import com.avanade.rpg.model.Jogador;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.model.Turno;
import org.springframework.stereotype.Service;

@Service
public class RpgService {
    public void Fluxo(){
        //CarregarPersonagensPadrao;
        //SelecionarPersonagens;
        Jogador jog1 = new Jogador();
        Jogador jog2 = new Jogador();
        jog1.getPersonagem().setTipoPersonagem('H');
        jog2.getPersonagem().setTipoPersonagem('M');
        Iniciativa(jog1, jog2);
        //GravarLog
        Turno(jog1, jog2);


    }
    public void Turno(Jogador j1, Jogador j2){
        int forcaAtaque;
        int forcaDefesa;
        int dano;

        Turno turno = new Turno();

        //turno.setJogadorInicio(j1.getIniciativa() > j2.getIniciativa() ? j1 : j2);

        if (j1.getIniciativa() > j2.getIniciativa()) {
            //começa com herói atacando
            turno.setForcaAtaque(Ataque(j1.getPersonagem()));
            //monstro defendendo
            turno.setForcaDefesa(Defesa(j2.getPersonagem()));

            if (turno.getForcaAtaque() > turno.getForcaDefesa())
               turno.setDano(CalcularDano(j1.getPersonagem(), j2.getPersonagem()));

            turno.setPvAtualizado(CalcPv(j2.getPersonagem().getPv(), turno.getDano()));

        }
        else {
            //começa com monstro atacando
            turno.setForcaAtaque(Ataque(j2.getPersonagem()));
            //heroi defendendo
            turno.setForcaDefesa(Defesa(j1.getPersonagem()));
            if (turno.getForcaAtaque() > turno.getForcaDefesa())
                turno.setDano(CalcularDano(j2.getPersonagem(), j1.getPersonagem()));

            turno.setPvAtualizado(CalcPv(j1.getPersonagem().getPv(), turno.getDano()));
        }

        while ((j2.getPersonagem().getPv() > 0) && (j1.getPersonagem().getPv() > 0)) {
            j2.getPersonagem().setPv(0);
        }
    }
    public void Iniciativa(Jogador j1, Jogador j2){
        int p1 = JogarDado(20,1);
        int p2 = JogarDado(20,1);

        while (p1 == p2){
            p1 = JogarDado(20,1);
            p2 = JogarDado(20,1);
        }
        j1.setIniciativa(p1);
        j2.setIniciativa(p2);
    }
    public int JogarDado(int TipoDado, int Qtd){
        int valor;

        valor=0;

        for (int i = 0; i<Qtd; i++) {
            valor += (int) (Math.random() * TipoDado) + 1;
        }
		return valor;
    }

    public int CalcularDano(Personagem pAtq, Personagem pDef){
        int ataque = JogarDado(pAtq.getTipoDado(), pAtq.getQtdDados()) + pAtq.getForca();
        int defesa = JogarDado(pDef.getTipoDado(), pDef.getQtdDados()) + pDef.getDefesa();

        return ataque - defesa;
    }
    public int CalcPv(int pv, int dano){
        return ((pv - dano) <= 0) ? 0 : pv - dano;
    }

    public int Ataque(Personagem p){
        return JogarDado(12, 1) + p.getForca() + p.getAgilidade();
    }
    public int Defesa(Personagem monstro){
        return JogarDado(12,1) + monstro.getDefesa() + monstro.getAgilidade();

    }

}