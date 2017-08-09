package jogo.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLoader {
	
	public static BufferedImage carregaImagem(String caminho){
		try{
			return ImageIO.read(ImageLoader.class.getResource(caminho));
		} catch (IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		return null;		
	}

}
