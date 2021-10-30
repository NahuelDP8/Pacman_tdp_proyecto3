package Entities;

import javax.swing.ImageIcon;

public class MapaGrilla {
	ImageIcon miFondo;
	public MapaGrilla(ImageIcon fondo) {
		miFondo = fondo;
	}
	
	public ImageIcon getImage() {
		return miFondo;
	}
}
