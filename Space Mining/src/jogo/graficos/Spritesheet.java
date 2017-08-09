package jogo.graficos;

import java.awt.image.BufferedImage;

public class Spritesheet {
	private BufferedImage sheet;
	
	public Spritesheet(BufferedImage sheet){
		this.sheet = sheet;		
	}
	
	public BufferedImage recorta(int x, int y, int largura, int altura){
			return sheet.getSubimage(x, y, largura, altura);			
	}
}


