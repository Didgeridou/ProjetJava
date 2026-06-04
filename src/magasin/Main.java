package magasin;

import javax.swing.SwingUtilities;
import ui.GestionProduitsFrame;

/**
 * Programme principal
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Création d'un nouveau frame
         */
        SwingUtilities.invokeLater(() -> {
            GestionProduitsFrame frame = new GestionProduitsFrame();
            frame.setVisible(true);
        });
    }
}
