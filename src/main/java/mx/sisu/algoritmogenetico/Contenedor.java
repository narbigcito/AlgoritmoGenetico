package mx.sisu.algoritmogenetico;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;
import mx.sisu.algoritmogenetico.algoritomo.GeneticAlgConsola;
import mx.sisu.algoritmogenetico.objetos.Bacteria;

/**
 *
 * @author Gibrán moreno
 */
public class Contenedor extends JComponent {

    private JPanel panel;
    GeneticAlgConsola algoritmo;
    private int x = 0;
    private int y = 370;

    public Contenedor(JPanel panel) {
        this.panel = panel;
        algoritmo = new GeneticAlgConsola();
        setBounds(0, 0, panel.getWidth(), panel.getHeight());
    }

    Thread hilo = new Thread() {
        @Override
        public void run() {

            try {
                while (algoritmo.existePoblacion()) {
                    algoritmo.pasarUnDia();
                    x += 10;
                    panel.repaint();
                    hilo.sleep(2000);
                }

                algoritmo = new GeneticAlgConsola();

            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    };

    @Override
    public void paint(Graphics g) {
        g = dibujarArbol(g);

        g = dibujarBacterias(g);
    }

    public void iniciar() {
        if (!hilo.isAlive())
            hilo.start();

        x = 0;
    }

    private Graphics dibujarArbol(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(800, 300, 100, 300);

        return g;
    }

    private Graphics dibujarBacterias(Graphics g) {
        for (Bacteria bacteria : algoritmo.getPoblacion()) {
            g.setColor(Color.red);
            g.fillRect(bacteria.getX(), y, 30, 30);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(bacteria.getGeneracion()), bacteria.getX()+10, y + 20);

        }

        return g;
    }


}
