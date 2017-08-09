package jogo.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jogo.graficos.ImageLoader;

public class Cenario extends Item {

	private BufferedImage n;
	private double velocidade;
	private int y;
	public Cenario(){
		super(0, 0, 800, 600);
		n = ImageLoader.carregaImagem("/texturas/fundo.png");
		this.velocidade = velocidadeInicial;
	}
	
	public void atualiza(){
		this.Mover();
	}
	
	public void desenha(Graphics g){
		g.drawImage(n, 0, y, null);
		g.drawImage(n, 0, y-590, null);
		g.drawImage(n, 0, y-1190, null);
	}
	
	public void Mover(){
		this.y+= velocidade;
		if(y >=600){
			this.y= 0;
		}
	}
	
	public void Acelera(){
		this.velocidade += aceleracao;
	}

	public double getVelocidade() {
		return velocidade;
	}
		
}
