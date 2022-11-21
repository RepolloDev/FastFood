package fastfoodjava;

public class Comida {
    private String nombre; // Nombre de la opción (🍗)
    private double precio; // Precio de la opición (💸)

    // Constructores - Getters / Setters
    public Comida() {
        this.nombre = "salteña";
        this.precio = 5;
    }
    public Comida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setTodo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Metodos

    /**
     * * Metodos de comparación PRECIO
     *
     * @param otraComida    : Comida con la que se compara
     * @return              : Opcion comida que cumpla la condicion
     */
    public Comida MayorQue(Comida otraComida) {

        if (this.precio > otraComida.getPrecio()) {
            return new Comida(this.nombre, this.precio);
        } else {
            return otraComida;
        }
    }

    public Comida MenorQue(Comida otraComida) {
        if (this.precio < otraComida.getPrecio()) {
            return new Comida(this.nombre, this.precio);
        } else {
            return otraComida;
        }
    }



    public void mostrar() {
        System.out.printf("Nombre: %s \t Precio: %s", this.nombre, this.precio);
    }

}
