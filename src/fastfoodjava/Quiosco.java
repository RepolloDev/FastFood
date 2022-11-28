package fastfoodjava;

import java.io.Serializable;

public class Quiosco extends LugarAComerFijo implements LugarAComerNoFijo, Serializable {
    // ** PensionNoFijo SUBCLASE de Pension

    private boolean entrada; // true ó false (🍮)
    private boolean almuerzo; // true ó false (🍛)
    private boolean sopa; // true ó false (🥣)
    private boolean bebida; // true ó false (🧃)
    private double precio; // precio de la comida en General (💰)

    // Constructores - Getters / Setters
    public Quiosco() {
        super();
        this.entrada = false;
        this.almuerzo = false;
        this.sopa = false;
        this.bebida = false;
        this.precio = 0;
    }

    public Quiosco(String a) {
        super(a);
        this.entrada = false;
        this.almuerzo = false;
        this.sopa = false;
        this.bebida = false;
        this.precio = 0;
    }

    public Quiosco(boolean a, boolean b, boolean c, boolean d, double precio) {
        this.entrada = a;
        this.almuerzo = b;
        this.sopa = c;
        this.bebida = d;
        this.precio = precio;
    }
    public Quiosco(String m, String n, double p, double q, double r, boolean a, boolean b, boolean c, boolean d, double precio) {
        super(m, n, p, q, r);
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

    public void mostrar() {
        System.out.println(this.nombre);
        System.out.println("entrada: " + this.entrada);
        System.out.println("almuerzo: " + this.almuerzo);
        System.out.println("sopa: " + this.sopa);
        System.out.println("bebida: " + this.bebida);
        System.out.println("precio: " + this.precio);
    }

    public String mostrarString() {
        String mostrar = "";
        mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
        mostrar += "\n Direccion: " + this.getUbicacion();
        mostrar += "\n calificacion: " + super.getCalificacion();
        mostrar += "\n\t entrada: " + this.entrada;
        mostrar += "\n\t almuerzo: " + this.almuerzo;
        mostrar += "\n\t sopa: " + this.sopa;
        mostrar += "\n\t bebida: " + this.bebida;
        mostrar += "\n\t precio: " + this.precio;
        return mostrar;
    }

    public void precioMayorQue(double a) {
        if (this.precio > a) {
            String mostrar = "";
            mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
            mostrar += "\n Direccion: " + this.getUbicacion();
            mostrar += "\n calificacion: " + super.getCalificacion();
            mostrar += "\n\t entrada: " + this.entrada;
            mostrar += "\n\t almuerzo: " + this.almuerzo;
            mostrar += "\n\t sopa: " + this.sopa;
            mostrar += "\n\t bebida: " + this.bebida;
            mostrar += "\n\t precio: " + this.precio;
            System.out.println(mostrar);
        }
    }

    public void precioMenorQue(double a) {
        if (this.precio < a) {
            String mostrar = "";
            mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
            mostrar += "\n Direccion: " + this.getUbicacion();
            mostrar += "\n calificacion: " + super.getCalificacion();
            mostrar += "\n\t entrada: " + this.entrada;
            mostrar += "\n\t almuerzo: " + this.almuerzo;
            mostrar += "\n\t sopa: " + this.sopa;
            mostrar += "\n\t bebida: " + this.bebida;
            mostrar += "\n\t precio: " + this.precio;
            System.out.println(mostrar);
        }
    }

    public void precioIgualQue(double a) {
        if (this.precio < a) {
            String mostrar = "";
            mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
            mostrar += "\n Direccion: " + this.getUbicacion();
            mostrar += "\n calificacion: " + super.getCalificacion();
            mostrar += "\n\t entrada: " + this.entrada;
            mostrar += "\n\t almuerzo: " + this.almuerzo;
            mostrar += "\n\t sopa: " + this.sopa;
            mostrar += "\n\t bebida: " + this.bebida;
            mostrar += "\n\t precio: " + this.precio;
            System.out.println(mostrar);
        }
    }

    public int nroOpciones() {
        int con = 0;
        if (this.almuerzo) {
            con++;
        }
        if (this.bebida) {
            con++;
        }
        if (this.entrada) {
            con++;
        }
        if (this.sopa) {
            con++;
        }
        return con;
    }

    public void comparar(Restaurante A, double[] coord) {
        int con = 0;
        if (this.almuerzo) {
            con++;
        }
        if (this.bebida) {
            con++;
        }
        if (this.entrada) {
            con++;
        }
        if (this.sopa) {
            con++;
        }
        double distancia1 = Math
                .sqrt(Math.pow((coord[0] + this.coord[0]), 2) + Math.pow((coord[1] + this.coord[1]), 2));
        double distancia2 = Math
                .sqrt(Math.pow((coord[0] + A.getCoord(0)), 2) + Math.pow((coord[1] + A.getCoord(1)), 2));
        String mostrar = "";
        mostrar += "Comparando: " + this.nombre + " - " + A.getNombre();
        mostrar += "\n1RA FILA\t\t2DA FILA";
        mostrar += "\nValoracion: " + super.getCalificacion() + "\n" + A.getCalificacion();
        mostrar += "\nNro de opciones: " + con + "\t" + A.nroOpciones();
        mostrar += "Precio mayor: " + this.precio + "\t" + A.maxPrecio();
        mostrar += "Precio menor: " + this.precio + "\t" + A.minPrecio();
        mostrar += "Distancia: " + distancia1 + "\t" + distancia2;
        System.out.println(mostrar);
    }

    public void comparar(Pension A, double[] coord) {
        int con = 0;
        if (this.almuerzo) {
            con++;
        }
        if (this.bebida) {
            con++;
        }
        if (this.entrada) {
            con++;
        }
        if (this.sopa) {
            con++;
        }
        double distancia1 = Math
                .sqrt(Math.pow((coord[0] + this.coord[0]), 2) + Math.pow((coord[1] + this.coord[1]), 2));
        double distancia2 = Math
                .sqrt(Math.pow((coord[0] + A.getCoord(0)), 2) + Math.pow((coord[1] + A.getCoord(1)), 2));
        String mostrar = "";
        mostrar += "Comparando: " + this.nombre + " - " + A.getNombre();
        mostrar += "\n1RA FILA\t\t2DA FILA";
        mostrar += "\nValoracion: " + super.getCalificacion() + "\n" + A.getCalificacion();
        mostrar += "\nNro de opciones: " + con + "\t" + A.nroOpciones();
        mostrar += "Precio mayor: " + this.precio + "\t" + A.maxPrecio();
        mostrar += "Precio menor: " + this.precio + "\t" + A.minPrecio();
        mostrar += "Distancia: " + distancia1 + "\t" + distancia2;
        System.out.println(mostrar);
    }

    public void comparar(Quiosco A, double[] coord) {
        int con = 0;
        if (this.almuerzo) {
            con++;
        }
        if (this.bebida) {
            con++;
        }
        if (this.entrada) {
            con++;
        }
        if (this.sopa) {
            con++;
        }
        double distancia1 = Math
                .sqrt(Math.pow((coord[0] + this.coord[0]), 2) + Math.pow((coord[1] + this.coord[1]), 2));
        double distancia2 = Math
                .sqrt(Math.pow((coord[0] + A.getCoord(0)), 2) + Math.pow((coord[1] + A.getCoord(1)), 2));
        String mostrar = "";
        mostrar += "Comparando: " + this.nombre + " - " + A.getNombre();
        mostrar += "\n1RA FILA\t\t2DA FILA";
        mostrar += "\nValoracion: " + super.getCalificacion() + "\n" + A.getCalificacion();
        mostrar += "\nNro de opciones: " + con + "\t" + A.nroOpciones();
        mostrar += "\nPrecio: " + this.precio + "\t" + A.getPrecio();
        mostrar += "\nDistancia: " + distancia1 + "\t" + distancia2;
        System.out.println(mostrar);
    }

}
