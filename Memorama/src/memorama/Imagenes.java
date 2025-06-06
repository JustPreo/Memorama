package memorama;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Imagenes {

    private JButton boton;
    private boolean volteado = false;
    private String defrente;
    private String reverso;

    public Imagenes(JButton boton, String defrente, String reverso) {
        this.boton = boton;
        this.defrente = defrente;
        this.reverso = reverso;
        this.boton.setIcon(redimensionarImagen(reverso));
    }

    public void voltear() {
        if (!volteado) {
            boton.setIcon(redimensionarImagen(defrente));
            volteado = true;
        } else {
            boton.setIcon(redimensionarImagen(reverso));
            volteado = false;
        }
    }

    public boolean estaVolteado() {
        return volteado;
    }

    public String getFrente() {
        return defrente;
    }

    public void ocultar() {
        if (volteado) {
            boton.setIcon(redimensionarImagen(reverso));
            volteado = false;
        }
    }
    
    public JButton getBoton() {
        return boton;
    }

    private ImageIcon redimensionarImagen(String ruta) {
        ImageIcon imagenOriginal = new ImageIcon(getClass().getResource(ruta));
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(132, 121, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}

