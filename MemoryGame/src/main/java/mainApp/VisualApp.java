package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objects.Casilla;

public class VisualApp extends JFrame {

	private JPanel contentPane;
	private Casilla[][] casillas = new Casilla[4][4];
	private Casilla test;
	private int contador = 0;
	private boolean ultimo = false;
	private Casilla comparaCasilla;
	
	/**
	 * Create the frame.
	 */
	public VisualApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener listener = new ActionListener() {
			
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
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
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
			if (comparaCasilla.comparador(casillas[i][j].getImagen())) {
				
			} else {
				comparaCasilla.getButton().setSelected(false);
				casillas[i][j].getButton().setSelected(false);
				comparaCasilla.getButton().setEnabled(true);
				casillas[i][j].getButton().setEnabled(true);
				comparaCasilla.getButton().setIcon(null);
				casillas[i][j].getButton().setIcon(null);
			}
			ultimo = !ultimo;
		} else {
			comparaCasilla = casillas[i][j];
			ultimo = !ultimo;
		}
	}

}
