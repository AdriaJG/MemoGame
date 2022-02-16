package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constantes.Imagenes;
import objects.Casilla;

public class VisualApp extends JFrame {

	private JPanel contentPane;
	private Casilla[][] casillas = new Casilla[4][4];
	private Casilla test;
	private int contador = 0;
	private boolean ultimo = false;
	private Casilla comparaCasilla;
	private int aciertos = 0;
	private int intentos = 0;
	private ActionListener listener;
	
	/**
	 * Create the frame.
	 */
	public VisualApp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Imagenes.TAMAÑO * casillas.length + 20, Imagenes.TAMAÑO * casillas.length + 50);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = Integer.valueOf(e.getActionCommand().charAt(0) - 48);
				int j = Integer.valueOf(e.getActionCommand().charAt(1) - 48);
				
				System.out.println(i + "" + j);
				try {
					compararDos(i, j);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
		generarTablero();
		
	}
	
	public void generarTablero() {
		ArrayList<ImageIcon> imagenesRandom = Imagenes.randomizador();
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla(Imagenes.obtenerImagenRandom());
				casillas[i][j].setPosicion(i, j);
				contentPane.add(casillas[i][j].getButton());
				casillas[i][j].getButton().setActionCommand(i + "" + j);
				casillas[i][j].getButton().addActionListener(listener);
			}
		}
	}
	
	public void compararDos(int i, int j) throws InterruptedException {
		casillas[i][j].getButton().setEnabled(false);
		casillas[i][j].getButton().setIcon(casillas[i][j].getImagen());
		if (ultimo) {
			intentos++;
			if (comparaCasilla.comparador(casillas[i][j].getImagen())) {
				aciertos++;
			} else {
				comparaCasilla.getButton().setSelected(false);
				casillas[i][j].getButton().setSelected(false);
				comparaCasilla.getButton().setEnabled(true);
				casillas[i][j].getButton().setEnabled(true);
				comparaCasilla.getButton().setIcon(null);
				casillas[i][j].getButton().setIcon(null);
			}
			ultimo = !ultimo;
			if (aciertos >= Imagenes.randomizador.size() / 2) {
				JOptionPane.showMessageDialog(contentPane, "Has ganado con " + intentos + " intentos");
				int eleccion = JOptionPane.showConfirmDialog(contentPane, "Jugar otra partida?");
				if (eleccion == JOptionPane.OK_OPTION) {
					contentPane.removeAll();
					generarTablero();
					contentPane.repaint();
					intentos = 0;
					aciertos = 0;
				} else {
					System.exit(0);
				}
			}
		} else {
			comparaCasilla = casillas[i][j];
			ultimo = !ultimo;
		}
	}

}
