package MainPackage;

import Views.MainView;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ProyectoPrograGrafos {

    public static void main(String[] args) {
        try {
            FlatMacDarkLaf.setup();

            UIManager.put("Button.arc", 15);
            UIManager.put("Component.arc", 15);
            UIManager.put("TextComponent.arc", 12);

        } catch (Exception ex) {
            System.err.println("No se pudo cargar FlatLaf.");
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            mainView.setLocationRelativeTo(null);
            mainView.setVisible(true);
        });
    }
}