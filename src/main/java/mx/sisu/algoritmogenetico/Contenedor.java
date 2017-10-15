package mx.sisu.algoritmogenetico;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Gibrán moreno
 */
public class Contenedor extends JComponent {

    private JPanel panel;
    private int x;
    private int y;

    public Contenedor(JPanel panel) {
        this.panel = panel;

        setBounds(0, 0, panel.getWidth(), panel.getHeight());
    }

    Thread hilo = new Thread() {
        @Override
        public void run() {
            try {
                while (true) {
                    x += 10;
                    panel.repaint();
                    hilo.sleep(100);
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    };

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 100, 100);
    }

    public void iniciar() {

        if (!hilo.isAlive()) {
            hilo.start();
        }

        x = 100;
    }


}
