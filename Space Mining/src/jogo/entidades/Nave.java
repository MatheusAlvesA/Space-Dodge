package jogo.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jogo.graficos.ImageLoader;
import jogo.jogo.Handler;


public class Nave extends Criatura {
	private BufferedImage n;
	private Handler handler;
	
	public Nave(Handler handler, float x, float y) {
		super(x, y, 60, 120);
		this.handler = handler;
		n = ImageLoader.carregaImagem("/texturas/nave.png");		
	}

	@Override
	public void atualiza() {
		this.getInput();
		this.Mover();
		
	}
	
	private void getInput(){
		this.xMove = 0;
		this.yMove = 0;
		if((handler.getKeyManager().left) && (x > 2)){
			this.xMove -= this.velocidade;
		}
		if((handler.getKeyManager().right) &&(x < 748)){
			this.xMove += this.velocidade;
		}
		if((handler.getKeyManager().up) && (y > 0)){
			this.yMove -= this.velocidade;
		}
		if((handler.getKeyManager().down) && (y < 460)){
			this.yMove += this.velocidade;
		}
		
	}

	@Override
	public void desenha(Graphics g) {
		g.drawImage(n,(int) x,(int) y, largura, altura, null);
	}
	
	public void reduzvida(){
		this.vidas -=1;
	}
}


