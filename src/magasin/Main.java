package magasin;

import javax.swing.SwingUtilities;
import ui.GestionProduitsFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestionProduitsFrame frame = new GestionProduitsFrame();
            frame.setVisible(true);
        });
    }
}
