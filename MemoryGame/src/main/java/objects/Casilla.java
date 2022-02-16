package objects;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;
import constantes.*;

public class Casilla {
	private JToggleButton casilla;
	private ImageIcon imagen;
	public final int TAMA�O = Imagenes.TAMA�O;

	public Casilla(ImageIcon icono) {
		this.casilla = new JToggleButton();
		this.imagen = new ImageIcon(icono.getImage().getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH));
		this.casilla.setSelectedIcon(imagen);
		this.casilla.setSize(new Dimension(TAMA�O, TAMA�O));
		this.casilla.setDisabledIcon(imagen);
	}
	
	public JToggleButton getButton() {
		return this.casilla;
	}
	
	public Icon getImagen() {
		return this.imagen;
	}
	
	public void setPosicion(int x, int y) {
		this.casilla.setLocation(x * TAMA�O, y * TAMA�O);
	}
	
	public boolean comparador(Icon imagen) {
		return this.imagen == imagen;
	}

}
