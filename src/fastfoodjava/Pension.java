package fastfoodjava;

import java.io.Serializable;
import java.util.ArrayList;

public class Pension extends LugarAComerFijo implements Serializable {
    // * PensionFijo SUBCLASE de Pension

    private Menu menu; // Lista de opciones que posee el restaurante (📄)

    // Constructores - Getters / Setters
    public Pension() {
        super();
        this.menu = new Menu();
    }

    public Pension(String a) {
        super(a);
        this.menu = new Menu();
    }

    public Pension(String a, String b, double c, double[] d, Menu menu) {
        super(a, b, c, d);
        this.menu = menu;
    }

    public Pension(String a, String b, double c, double d, double e, Menu menu) {
        super(a, b, c, d, e);
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setTodo(String a, String b, double c, double d, double e, Menu f) {
        super.setTodo(a, b, c, d, e);
        this.menu = f;
    }

    public void mostrar() {
        System.out.println(this.nombre);
        this.menu.mostrar();
    }

    public String mostrarString() {
        String mostrar = "";
        mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
        mostrar += "\n Direccion: " + this.getUbicacion();
        mostrar += "\n calificacion: " + super.getCalificacion();
        mostrar += "\n" + this.menu.mostrarString();
        return mostrar;
    }

    // Metodos
    public void agregarOpcion(Comida A) {
        this.menu.agregarComida(A);
    }

    public void quitarOpcion(String nombre) {
        this.menu.quitarComida(nombre);
    }

    public double precioTotal() {
        return this.menu.precioTotal();
    }

    public double minimoComida() {
        return this.menu.minPrecio();
    }

    public boolean existeOpcion(String nombre) {
        return this.menu.existeOpcion(nombre);
    }

    public void precioMayorQue(double a) {
        ArrayList<Comida> sol = this.menu.PrecioMayorQue(a);
        String mostrar = "";
        mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
        mostrar += "\n\t Direccion: " + this.getUbicacion();
        mostrar += "\n Calificacion: " + super.getCalificacion();
        int index = 1;
        for (Comida elemento : sol) {
            String nombre = elemento.getNombre();
            double precio = elemento.getPrecio();
            mostrar += index + " Nombre: " + nombre + " \t Precio: " + precio;
            mostrar += "\n";
            index++;
        }
        System.out.println(mostrar);
    }

    public void precioMenorQue(double a) {
        ArrayList<Comida> sol = this.menu.PrecioMenorQue(a);
        String mostrar = "";
        mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
        mostrar += "\n\t Direccion: " + this.getUbicacion();
        mostrar += "\n Calificacion: " + super.getCalificacion();
        int index = 1;
        for (Comida elemento : sol) {
            String nombre = elemento.getNombre();
            double precio = elemento.getPrecio();
            mostrar += index + " Nombre: " + nombre + " \t Precio: " + precio;
            mostrar += "\n";
            index++;
        }
        System.out.println(mostrar);
    }

    public void precioIgualQue(double a) {
        ArrayList<Comida> sol = this.menu.PrecioIgualQue(a);
        String mostrar = "";
        mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
        mostrar += "\n\t Direccion: " + this.getUbicacion();
        mostrar += "\n Calificacion: " + super.getCalificacion();
        int index = 1;
        for (Comida elemento : sol) {
            String nombre = elemento.getNombre();
            double precio = elemento.getPrecio();
            mostrar += index + " Nombre: " + nombre + " \t Precio: " + precio;
            mostrar += "\n";
            index++;
        }
        System.out.println(mostrar);
    }

    public int nroOpciones() {
        return this.menu.getComidas().size();
    }

    public double minPrecio() {
        return this.menu.minPrecio();
    }

    public double maxPrecio() {
        return this.menu.maxPrecio();
    }

    public void comparar(Restaurante A, double[] coord) {
        double distancia1 = Math
                .sqrt(Math.pow((coord[0] + this.coord[0]), 2) + Math.pow((coord[1] + this.coord[1]), 2));
        double distancia2 = Math
                .sqrt(Math.pow((coord[0] + A.getCoord(0)), 2) + Math.pow((coord[1] + A.getCoord(1)), 2));
        String mostrar = "";
        mostrar += "Comparando: " + this.nombre + " - " + A.getNombre();
        mostrar += "\n1RA FILA\t\t2DA FILA";
        mostrar += "\nValoracion: " + super.getCalificacion() + "\n" + A.getCalificacion();
        mostrar += "\nNro de opciones: " + this.menu.getComidas().size() + "\t" + A.nroOpciones();
        mostrar += "\nPrecio mayor: " + this.menu.maxPrecio() + "\t" + A.maxPrecio();
        mostrar += "\nPrecio menor: " + this.menu.minPrecio() + "\t" + A.minPrecio();
        mostrar += "\nDistancia: " + distancia1 + "\t" + distancia2;
        System.out.println(mostrar);
    }

    public void comparar(Pension A, double[] coord) {
        double distancia1 = Math
                .sqrt(Math.pow((coord[0] + this.coord[0]), 2) + Math.pow((coord[1] + this.coord[1]), 2));
        double distancia2 = Math
                .sqrt(Math.pow((coord[0] + A.getCoord(0)), 2) + Math.pow((coord[1] + A.getCoord(1)), 2));
        String mostrar = "";
        mostrar += "Comparando: " + this.nombre + " - " + A.getNombre();
        mostrar += "\n1RA FILA\t\t2DA FILA";
        mostrar += "\nValoracion: " + super.getCalificacion() + "\n" + A.getCalificacion();
        mostrar += "\nNro de opciones: " + this.menu.getComidas().size() + "\t" + A.nroOpciones();
        mostrar += "\nPrecio mayor: " + this.menu.maxPrecio() + "\t" + A.maxPrecio();
        mostrar += "\nPrecio menor: " + this.menu.minPrecio() + "\t" + A.minPrecio();
        mostrar += "\nDistancia: " + distancia1 + "\t" + distancia2;
        System.out.println(mostrar);
    }

    public void comparar(Quiosco A, double[] coord) {
        double distancia1 = Math
                .sqrt(Math.pow((coord[0] + this.coord[0]), 2) + Math.pow((coord[1] + this.coord[1]), 2));
        double distancia2 = Math
                .sqrt(Math.pow((coord[0] + A.getCoord(0)), 2) + Math.pow((coord[1] + A.getCoord(1)), 2));
        String mostrar = "";
        mostrar += "Comparando: " + this.nombre + " - " + A.getNombre();
        mostrar += "\n1RA FILA\t\t2DA FILA";
        mostrar += "\nValoracion: " + super.getCalificacion() + "\n" + A.getCalificacion();
        mostrar += "\nNro de opciones: " + this.menu.getComidas().size() + "\t" + A.nroOpciones();
        mostrar += "\nPrecio mayor: " + this.menu.maxPrecio() + "\t" + A.getPrecio();
        mostrar += "\nPrecio menor: " + this.menu.minPrecio() + "\t" + A.getPrecio();
        mostrar += "\nDistancia: " + distancia1 + "\t" + distancia2;
        System.out.println(mostrar);
    }
}
