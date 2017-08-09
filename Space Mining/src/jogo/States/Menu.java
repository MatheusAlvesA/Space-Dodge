package jogo.States;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jogo.graficos.ImageLoader;
import jogo.jogo.Handler;

public class Menu extends State{

	private BufferedImage n;
	
	public Menu(Handler handler){
		super(handler);		
		this.n = ImageLoader.carregaImagem("/texturas/menu.png");
	}
	
	@Override
	public void atualiza() {
		if(this.handler.getKeyManager().enter){
			handler.getJogo().changeState();
		}
	}

	@Override
	public void desenha(Graphics g) {
		g.drawImage(n, 0, 0, null);
	}
	




}
