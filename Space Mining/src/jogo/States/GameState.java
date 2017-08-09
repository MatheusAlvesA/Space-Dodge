package jogo.States;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import jogo.entidades.Cenario;
import jogo.entidades.Meteorito;
import jogo.entidades.Nave;
import jogo.graficos.ImageLoader;
import jogo.jogo.Handler;

public class GameState extends State{
	
	private float[] possiveisX = {0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f};
	private Nave nave;
	private Cenario cenario;
	private ArrayList<Meteorito> Meteoritos;
	private int count;
	private boolean colisao;

	public GameState(Handler handler){
		super(handler);
		nave = new Nave(handler, 375, 450);
		cenario = new Cenario();
		Meteoritos = new ArrayList<>();	
		this.count = 0;
	}
	
	@Override
	public void atualiza() {
		if(nave.getVidas() == 0){
			this.handler.getJogo().changeState();
			this.reseta();
			return;
		}
		this.detectaColisao();
		if(colisao){
			nave.reduzvida();
		}
		if(count == 30){
			this.spawn();
		}
		nave.atualiza();
		cenario.atualiza();
		cenario.Acelera();
		for(Meteorito m: Meteoritos){
			m.atualiza();
		}
		Iterator<Meteorito> i = Meteoritos.iterator();
		while(i.hasNext()){
			if(i.next().getY() > 600){
				i.remove();
			}
		}
		this.count++;
	}

	@Override
	public void desenha(Graphics g) {
		cenario.desenha(g);
		nave.desenha(g);
		for(Meteorito m: Meteoritos){
			m.desenha(g);
		}
		if(colisao){
			g.drawImage(ImageLoader.carregaImagem("/texturas/explosion.png"), (int) nave.getX(), (int) nave.getY(), null);
		}
	}
	
	public void spawn(){
		int idx = new Random().nextInt(possiveisX.length);
		boolean found = false;
		for(Meteorito m: Meteoritos){
			if(m.getX() == possiveisX[idx]){
				found = true;
			}
		}
		if(found == false){
			Meteoritos.add(new Meteorito(possiveisX[idx], cenario.getVelocidade()));
		}
		this.count = 0;

	}
	
	public void detectaColisao(){
		this.colisao = false;
		for(Meteorito m: Meteoritos){
			if((nave.getX() < m.getX() + (m.getLargura())-5) && 
			((nave.getLargura()-5) + nave.getX() > m.getX()) &&
			(nave.getY() < m.getY() + (m.getAltura())-10) &&
			((nave.getAltura() -10) + nave.getY()> m.getY())){
				this.colisao = true;
			}
				
		}
	}
	
	public void reseta(){
		nave = new Nave(handler, 375, 450);
		cenario = new Cenario();
		Meteoritos = new ArrayList<>();	
		this.count = 0;
	}
	
}
