package Apuesta;

/**
 *Apuesta representa una apuesta en un partido de fútbol.
 * 
 * @author Barroso
 * 
 * @since 2025
 */
public class Apuesta {

    protected int examen;
    /** Cantidad de dinero disponible  */
    private int dinero_disp;

    /** Cantidad de goles del equipo local. */
    private int goles_local;

    /** Cantidad de goles del equipo visitante. */
    private int goles_visitante;

    /** Cantidad de dinero apostado. */
    private int apostado;

    /**
     * Constructor por defecto.
     */
    public Apuesta() {
    }

    /**
     * Funcion de apuesta que nos permite introducir el dinero
     * 
     * @param dinero_disp    Dinero para apostar
     * @param goles_local    Goles pronosticados para el equipo local.
     * @param goles_visitante Goles pronosticados para el equipo visitante.
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }

    /**
     * Obtiene el dinero disponible.
     * 
     * @return Dinero disponible.
     */
    public int getDinero_disp() {
        return dinero_disp;
    }

    /**
     * Establece la cantidad de dinero disponible.
     * 
     * @param dinero_disp Nueva cantidad de dinero disponible.
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Obtiene la cantidad de goles pronosticados para el equipo local.
     * 
     * @return Goles pronosticados del equipo local.
     */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * Establece la cantidad de goles pronosticados para el equipo local.
     * 
     * @param goles_local Nueva cantidad de goles pronosticados para el equipo local.
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    /**
     * Obtiene la cantidad de goles pronosticados para el equipo visitante.
     * 
     * @return Goles pronosticados del equipo visitante.
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Establece la cantidad de goles pronosticados para el equipo visitante.
     * 
     * @param goles_visitante Nueva cantidad de goles pronosticados para el equipo visitante.
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Obtiene la cantidad apostada.
     * 
     * @return Cantidad apostada.
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Establece la cantidad apostada.
     * 
     * @param apostado Nueva cantidad apostada.
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    /**
     * Realiza una apuesta con la cantidad especificada.
     * 
     * @param dinero Cantidad de dinero a apostar.
     * @throws Exception Si la cantidad es menor a 1 o mayor al dinero disponible.
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar más de lo que tienes");
        }

        setDinero_disp(getDinero_disp() - dinero);
        setApostado(dinero);
    }

    /**
     * Verifica si se ha acertado el resultado del partido.
     * 
     * @param local     Goles marcados por el equipo local.
     * @param visitante Goles marcados por el equipo visitante.
     * @return true si la apuesta es correcta, false si la apuesta no es correcta
     * @throws Exception Si los goles son negativos.
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        if (local < 0 || visitante < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }
        return getGoles_local() == local && getGoles_visitante() == visitante;
    }

    /**
     * Cobra la apuesta si el resultado es acertado.
     * 
     * @param cantidad_goles_local  Goles reales del equipo local.
     * @param cantidad_goles_visit  Goles reales del equipo visitante.

     */
    public void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {
        if (!comprobar_resultado(cantidad_goles_local, cantidad_goles_visit)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() + (apostado * 10));
    }
}
