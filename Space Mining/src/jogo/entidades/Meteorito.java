package jogo.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jogo.graficos.ImageLoader;
import jogo.graficos.Spritesheet;

public class Meteorito extends Item {

	private double velocidade;
	private Spritesheet s;
	private BufferedImage n;
	
	public Meteorito(float x, double velocidade){
		super(x, -75, 64, 64);
		this.velocidade = velocidade;
		this.s = new Spritesheet(ImageLoader.carregaImagem("/texturas/animated_asteroid.png"));
		this.n = s.recorta(0, 0, 64, 64);	
	}

	public void desenha(Graphics g){
		g.drawImage(n, (int) x, (int) y, null);
	}
	
	public void atualiza(){
		this.Mover();
	}

	public void Mover() {
		this.y+= velocidade;
	}
	
	public void Acelera(){
		this.velocidade += aceleracao;
	}
}
