package com.avanade.rpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpgApplication {
	private static String Jogadores(){
		/*
		Scanner s = new Scanner(System.in);

		System.out.println("Olá, seja bem vindo ao AVA-RPG !!!");
		System.out.println("Jogador 1, digite seu nome:");

		Jogador jog1 = new Jogador();
		jog1.setNome(s.nextLine());

		System.out.println("Jogador 2, digite seu nome:");
		Jogador jog2 = new Jogador();
		jog2.setNome(s.nextLine());

		 */

		return "Que comecem os jogos! ";// + jog1.getNome() + " vs " + jog2.getNome();
	}

	public static void main(String[] args) {
		SpringApplication.run(RpgApplication.class, args);
		System.out.println(Jogadores());
	}

}
