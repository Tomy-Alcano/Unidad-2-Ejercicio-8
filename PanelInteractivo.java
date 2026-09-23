import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelInteractivo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {

            JFrame ventana = new JFrame("Panel Interactivo");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(400,300);
            ventana.setLocationRelativeTo(null);

            ventana.setLayout(new BorderLayout());

            JPanel panelInteractivo = new JPanel();
            panelInteractivo.setPreferredSize(new Dimension(300,200));

            Color colorOriginal = Color.LIGHT_GRAY;
            Color colorActivo = Color.CYAN;

            panelInteractivo.setBackground(colorOriginal);

            JLabel lblEstado = new JLabel("Esperando la interaccion");

            panelInteractivo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    panelInteractivo.setBackground(colorActivo);

                    lblEstado.setText("El cursor esta dentro del panel");
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    panelInteractivo.setBackground(colorOriginal);
                    lblEstado.setText("El cursor salió del panel");
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    lblEstado.setText("Clic en X=" + e.getX() + ", Y=" + e.getY());
                }
            });
            ventana.add(panelInteractivo, BorderLayout.CENTER);
            ventana.add(lblEstado, BorderLayout.SOUTH);

            ventana.setVisible(true);
        });

    }

}
