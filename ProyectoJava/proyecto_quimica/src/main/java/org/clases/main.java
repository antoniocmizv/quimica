import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import org.clases.interfaces.Login;

import javax.swing.*;

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            // Cambia la skin de la aplicación por FlatLaf
            // Se hace aqui ya que tiene que ser antes de que se inicie la Ventana Principal
            try {


                FlatLightLaf.setup();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            new Login();
        }
    });

}
