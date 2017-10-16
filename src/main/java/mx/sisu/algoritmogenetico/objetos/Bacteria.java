package mx.sisu.algoritmogenetico.objetos;

/**
 *
 * @author Gibrán moreno
 */
public class Bacteria {

    private int x;
    private int y;

    private double capacidadDeAtraccionDePareja;
    private double capacidadDeReproduccion;
    private double estatura;
    private double velocidad;
    private double capacidadParaOptenerAlimento;
    private double capacidadDeCombate;
    private int resistenciaDiasSinComer;
    private int estadoDeAlimento;
    private int limiteAlimento;
    private int limiteBajoAlimento;
    private int diasDeVida;
    private int generacion;
    private int diasSinComer;
    private boolean comioHoy;

    public Bacteria() {
    }

    public Bacteria(double capacidadDeAtraccionDePareja, double capacidadDeReproduccion, double estatura,
                    double velocidad, double capacidadParaOptenerAlimento, double capacidadDeCombate,
                    int resistenciaSinComer, int estadoDeAlimento, int limiteAlimento, int limiteBajoAlimento,
                    int diasDeVida, int generacion) {
        this.capacidadDeAtraccionDePareja = capacidadDeAtraccionDePareja;
        this.capacidadDeReproduccion = capacidadDeReproduccion;
        this.estatura = estatura;
        this.velocidad = velocidad;
        this.capacidadParaOptenerAlimento = capacidadParaOptenerAlimento;
        this.capacidadDeCombate = capacidadDeCombate;
        this.resistenciaDiasSinComer = resistenciaSinComer;
        this.estadoDeAlimento = estadoDeAlimento;
        this.limiteAlimento = limiteAlimento;
        this.limiteBajoAlimento = limiteBajoAlimento;
        this.diasDeVida = diasDeVida;
        this.generacion = generacion;
    }

    public Bacteria insertarCapacidadDeAtraccionDePareja(double capacidadDeAtraccionDePareja) {
        this.capacidadDeAtraccionDePareja = capacidadDeAtraccionDePareja;

        return this;
    }

    public Bacteria insertarCapacidadDeReproduccion(double capacidadDeReproduccion) {
        this.capacidadDeReproduccion = capacidadDeReproduccion;

        return this;
    }

    public Bacteria insertarEstatura(double estatura) {
        this.estatura = estatura;

        return this;
    }

    public Bacteria insertarVelocidad(double velocidad) {
        this.velocidad = velocidad;

        return this;
    }

    public Bacteria insertarCapacidadParaOptenerAlimento(double capacidadParaOptenerAlimento) {
        this.capacidadParaOptenerAlimento = capacidadParaOptenerAlimento;

        return this;
    }

    public Bacteria insertarCapacidadDeCombate(double capacidadDeCombate) {
        this.capacidadDeCombate = capacidadDeCombate;

        return this;
    }

    public Bacteria insertarEstadoDeAlimento(int estadoDeAlimento) {
        this.estadoDeAlimento = estadoDeAlimento;

        return this;
    }

    public Bacteria insertarLimiteAlimento(int limiteAlimento) {
        this.limiteAlimento = limiteAlimento;

        return this;
    }

    public Bacteria insertarLimiteBajoAlimento(int limiteBajoAlimento) {
        this.limiteBajoAlimento = limiteBajoAlimento;

        return this;
    }

    public Bacteria insertarDiasDeVida(int diasDeVida) {
        this.diasDeVida = diasDeVida;

        return this;
    }

    public Bacteria insertarGeneracion(int generacion) {
        this.generacion = generacion;

        return this;
    }

    public Bacteria insertarDiasSinComer(int diasSinComer) {
        this.diasSinComer = diasSinComer;

        return this;
    }

    public Bacteria insertarResistenciaDiasSinComer(int resistenciaDiasSinComer) {
        this.resistenciaDiasSinComer = resistenciaDiasSinComer;

        return this;
    }

    public int incrementarEstadoAlimento() {
        return estadoDeAlimento++;
    }

    public int disminuirEstadoAlimento() {
        return estadoDeAlimento--;
    }

    public int incrementarDiasSinComer() {
        return diasSinComer++;
    }

    public int incrementarDiasDeVida() {
        return diasDeVida++;
    }

    public double getCapacidadDeAtraccionDePareja() {
        return capacidadDeAtraccionDePareja;
    }

    public void setCapacidadDeAtraccionDePareja(double capacidadDeAtraccionDePareja) {
        this.capacidadDeAtraccionDePareja = capacidadDeAtraccionDePareja;
    }

    public double getCapacidadDeReproduccion() {
        return capacidadDeReproduccion;
    }

    public void setCapacidadDeReproduccion(double capacidadDeReproduccion) {
        this.capacidadDeReproduccion = capacidadDeReproduccion;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public int getResistenciaDiasSinComer() {
        return resistenciaDiasSinComer;
    }

    public void setResistenciaDiasSinComer(int resistenciaDiasSinComer) {
        this.resistenciaDiasSinComer = resistenciaDiasSinComer;
    }

    public int getEstadoDeAlimento() {
        return estadoDeAlimento;
    }

    public void setEstadoDeAlimento(int estadoDeAlimento) {
        this.estadoDeAlimento = estadoDeAlimento;
    }

    public int getDiasDeVida() {
        return diasDeVida;
    }

    public void setDiasDeVida(int diasDeVida) {
        this.diasDeVida = diasDeVida;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public double getCapacidadParaOptenerAlimento() {
        return capacidadParaOptenerAlimento;
    }

    public void setCapacidadParaOptenerAlimento(double capacidadParaOptenerAlimento) {
        this.capacidadParaOptenerAlimento = capacidadParaOptenerAlimento;
    }

    public double getCapacidadDeCombate() {
        return capacidadDeCombate;
    }

    public void setCapacidadDeCombate(double capacidadDeCombate) {
        this.capacidadDeCombate = capacidadDeCombate;
    }

    public int getLimiteAlimento() {
        return limiteAlimento;
    }

    public void setLimiteAlimento(int limiteAlimento) {
        this.limiteAlimento = limiteAlimento;
    }

    public int getDiasSinComer() {
        return diasSinComer;
    }

    public void setDiasSinComer(int diasSinComer) {
        this.diasSinComer = diasSinComer;
    }

    public boolean isComioHoy() {
        return comioHoy;
    }

    public void setComioHoy(boolean comioHoy) {
        this.comioHoy = comioHoy;
    }

    public int getLimiteBajoAlimento() {
        return limiteBajoAlimento;
    }

    public void setLimiteBajoAlimento(int limiteBajoAlimento) {
        this.limiteBajoAlimento = limiteBajoAlimento;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
