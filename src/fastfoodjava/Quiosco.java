package fastfoodjava;

public class PensionNoFijo extends Pension{
    // ** PensionNoFijo SUBCLASE de Pension

    private boolean entrada;    // true ó false (🍮)
    private boolean almuerzo;   // true ó false (🍛)
    private boolean sopa;       // true ó false (🥣)
    private boolean bebida;     // true ó false (🧃)
    private double precio;      // precio de la comida en General (💰)

    // Constructores - Getters / Setters
    public PensionNoFijo() {
        this.entrada = false;
        this.almuerzo = false;
        this.sopa = false;
        this.bebida = false;
        this.precio = 0;
    }
    public PensionNoFijo(boolean a, boolean b, boolean c, boolean d, double precio) {
        this.entrada = a;
        this.almuerzo = b;
        this.sopa = c;
        this.bebida = d;
        this.precio = precio;
    }


    public boolean getEntrada() {
        return this.entrada;
    }
    public boolean getAlmuerzo() {
        return this.almuerzo;
    }
    public boolean getSopa() {
        return this.sopa;
    }
    public boolean getBebida() {
        return this.bebida;
    }
    public double getPrecio() {
        return this.precio;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }
    public void setAlmuerzo(boolean almuerzo) {
        this.almuerzo = almuerzo;
    }
    public void setSopa(boolean sopa) {
        this.sopa = sopa;
    }
    public void setBebida(boolean bebida) {
        this.bebida = bebida;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTodo(boolean a, boolean b, boolean c, boolean d, double precio) {
        this.entrada = a;
        this.almuerzo = b;
        this.sopa = c;
        this.bebida = d;
        this.precio = precio;
    }


    // Metodos

}
