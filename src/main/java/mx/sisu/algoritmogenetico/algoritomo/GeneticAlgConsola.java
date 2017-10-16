package mx.sisu.algoritmogenetico.algoritomo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import mx.sisu.algoritmogenetico.objetos.Bacteria;

/**
 *
 * @author Gibrán moreno
 */
public class GeneticAlgConsola {
    
    private List<Bacteria> poblacion;
    private int alimento;
    private int generacionActual;
    private static final int HORAS_DEL_DIA = 24;
    private static final int HAMBRE_POR_DIA = 3;
    private static final int NIVEL_DE_AZAR = 100;
    private long muertosTotales = 0;
    private long muertosDia = 0;
    
    public GeneticAlgConsola() {
        poblacion = new LinkedList();
        generarPrimerosIndividuos();
        alimento = 1000;
    }
    
    public boolean existePoblacion() {
        return !poblacion.isEmpty();
    }
    
    private void generarPrimerosIndividuos() {
        for (int i = 0; i < 10; i++)
            generarIndividuo(i);
    }
    
    private Bacteria generarIndividuo(int i) {
        
        Bacteria bacteria = new Bacteria();
        
        bacteria = bacteria.insertarCapacidadDeAtraccionDePareja(35).insertarCapacidadDeReproduccion(35)
                .insertarEstatura(1).insertarVelocidad(1)
                .insertarCapacidadParaOptenerAlimento(5).insertarCapacidadDeCombate(1)
                .insertarResistenciaDiasSinComer(2).insertarEstadoDeAlimento(1)
                .insertarLimiteAlimento(15).insertarLimiteBajoAlimento(-3)
                .insertarDiasDeVida(0).insertarGeneracion(generacionActual);
        
        bacteria.setX(i * 40);
        
        getPoblacion().add(bacteria);
        return bacteria;
    }
    
    public void pasarUnDia() {
        System.out.println("##########INICIO GERERACION " + generacionActual + "##########");
        for (int i = 0; i < HORAS_DEL_DIA; i++)
            for (Bacteria bacteria : getPoblacion())
                bacteria = buscarComida(bacteria);
        
        reproducir();
        incrementarDiasDeVida();
        generarHambre();
        actualizarSobreVivientes();
        
        imprimirEstado();
        
        System.out.println("##########FIN GERERACION " + generacionActual + "##########\n\n\n");
        generacionActual++;
        muertosDia = 0;
    }
    
    private Bacteria buscarComida(Bacteria bacteria) {
        /*  System.out.println("");

        System.out.println("bacteria.getEstadoDeAlimento() " + bacteria.getEstadoDeAlimento());
        System.out.println("bacteria.getLimiteAlimento() " + bacteria.getLimiteAlimento());
        System.out.println("Azar " + azar);
        System.out.println("bacteria.getCapacidadParaOptenerAlimento() " + bacteria.getCapacidadParaOptenerAlimento());
        System.out.println(bacteria.getEstadoDeAlimento() < bacteria.getLimiteAlimento());
        System.out.println(azar < bacteria.getCapacidadParaOptenerAlimento());

        System.out.println("");*/
        
        if (bacteria.getEstadoDeAlimento() < bacteria.getLimiteAlimento() && permiteAzar(bacteria.getCapacidadParaOptenerAlimento())) {
            bacteria.incrementarEstadoAlimento();
            bacteria.setComioHoy(true);
            bacteria.setDiasSinComer(0);
            alimento--;
        }
        
        return bacteria;
    }
    
    private boolean permiteAzar(double probabilidad) {
        Random random = new Random();
        int azar = random.nextInt(NIVEL_DE_AZAR) + 0;
        
        return azar <= probabilidad;
    }
    
    private void reproducir() {
        long individuosACrear = 0;
        
        for (Bacteria bacteria : getPoblacion())
            if (permiteAzar(bacteria.getCapacidadDeAtraccionDePareja()) && getPoblacion().size() > 1 && permiteAzar(bacteria.getCapacidadDeReproduccion()))
                individuosACrear++;
        
        for (int i = 0; i < individuosACrear; i++) {
            generarIndividuo(1);
            System.out.println("Hay un nuevo ser");
        }
        
    }
    
    private Bacteria getPareja(Bacteria buscador) {
        Random random = new Random();
        int azar = random.nextInt(getPoblacion().size() - 1) + 0;
        Bacteria pareja = getPoblacion().get(azar);
        
        if (pareja.equals(buscador))
            return getPareja(buscador);
        else
            return pareja;
    }
    
    private void incrementarDiasDeVida() {
        for (Bacteria bacteria : getPoblacion())
            bacteria.incrementarDiasDeVida();
    }
    
    private void generarHambre() {
        for (Bacteria bacteria : getPoblacion())
            bacteria.setEstadoDeAlimento(bacteria.getEstadoDeAlimento() - HAMBRE_POR_DIA);
    }
    
    private void actualizarSobreVivientes() {
        List<Bacteria> condenados = new LinkedList();
        
        for (Bacteria bacteria : getPoblacion())
            if (bacteria.getEstadoDeAlimento() < 1) {
                bacteria.incrementarDiasSinComer();
                if (debeMorir(bacteria))
                    condenados.add(bacteria);
            }
        
        for (Bacteria bacteria : condenados) {
            getPoblacion().remove(bacteria);
            muertosTotales++;
            muertosDia++;
        }
    }
    
    private boolean debeMorir(Bacteria bacteria) {
        return limiteDiasSinComerExcedido(bacteria)
                || limiteSinComerExcedido(bacteria);
    }
    
    private boolean limiteDiasSinComerExcedido(Bacteria bacteria) {
        return bacteria.getDiasSinComer() > bacteria.getResistenciaDiasSinComer();
    }
    
    private boolean limiteSinComerExcedido(Bacteria bacteria) {
        return bacteria.getEstadoDeAlimento() <= bacteria.getLimiteBajoAlimento();
    }
    
    private void imprimirEstado() {
        System.out.println("Generación : " + generacionActual);
        System.out.println("Alimento restante " + alimento);
        System.out.println("Muertos totales : " + muertosTotales);
        System.out.println("Muertos este día : " + muertosDia);
        System.out.println("Sobrevivieron " + getPoblacion().size() + "\n");
        
        for (Bacteria bacteria : getPoblacion()) {
            System.out.println("Días de vida : " + bacteria.getDiasDeVida());
            System.out.println("Estado alimento :" + bacteria.getEstadoDeAlimento());
            System.out.println("Días sin comer : " + bacteria.getDiasSinComer());
            System.out.println("Resistencia sin comer : " + bacteria.getResistenciaDiasSinComer());
            System.out.println("Generación : " + bacteria.getGeneracion());
            System.out.println("Estatura : " + bacteria.getEstatura());
            System.out.println("Limite bajo alimento : " + bacteria.getLimiteBajoAlimento());
            
            System.out.println("");
        }
    }
    
    public List<Bacteria> getPoblacion() {
        return poblacion;
    }
    
    public void setPoblacion(List<Bacteria> poblacion) {
        this.poblacion = poblacion;
    }
    
    
}
