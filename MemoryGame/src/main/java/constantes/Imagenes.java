package constantes;

import javax.swing.*;

public class Imagenes {
	
	public static final ImageIcon ALIEN = convertidorImagen("alien-Cumbiero.png");
	public static final ImageIcon ANNOYED = convertidorImagen("annoyed-bird.png");
	public static final ImageIcon DOGO = convertidorImagen("dogo.png");
	public static final ImageIcon GANSO = convertidorImagen("el-ganso.png");
	public static final ImageIcon CAT = convertidorImagen("grumpy-cat.png");
	public static final ImageIcon PAJARO = convertidorImagen("pajaro-amarillo.png");
	public static final ImageIcon PIOLA = convertidorImagen("re-piola.png");
	public static final ImageIcon UGANDA = convertidorImagen("uganda-knuckles.png");
	public static ImageIcon[] arrayImagenes = image2Array();
	
	private static ImageIcon convertidorImagen(String img){
		ImageIcon imagen = new ImageIcon("src/main/resources/" + img);
		return imagen;
	}
	
	public static ImageIcon[] image2Array() {
		arrayImagenes = new ImageIcon[8];
		arrayImagenes[0] = ALIEN;
		arrayImagenes[1] = ANNOYED;
		arrayImagenes[2] = DOGO;
		arrayImagenes[3] = GANSO;
		arrayImagenes[4] = CAT;
		arrayImagenes[5] = PAJARO;
		arrayImagenes[6] = PIOLA;
		arrayImagenes[7] = UGANDA;
		
		return arrayImagenes;
	}
	
	public static ImageIcon[] randomizador () {
		
		return arrayImagenes;
	}
}
