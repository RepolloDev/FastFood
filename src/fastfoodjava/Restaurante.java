package fastfoodjava;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurante extends LugarAComer implements Serializable {
    // * Restaurante es SUBCLASE de LugarAComer

    private String paginaWeb; // Pagina del restaurante si es que lo tuviera (🌐)
    private Menu menu; // Lista de opciones que posee el restaurante (📄)

    // Contructores - Getters / Setters
    public Restaurante() {
        super();
        this.paginaWeb = "--";
        this.menu = new Menu();
    }

    public Restaurante(String a) {
        super(a);
        this.paginaWeb = "--";
        this.menu = new Menu();
    }

    public Restaurante(String a, String b, double c, double[] d, String e, Menu f) {
        super(a, b, c, d);
        this.paginaWeb = e;
        this.menu = f;
    }

    public Restaurante(String a, String b, double c, double d, double e, String f, Menu g) {
        super(a, b, c, d, e);
        this.paginaWeb = f;
        this.menu = g;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setTodo(String a, Menu b) {
        this.paginaWeb = a;
        this.menu = b;
    }

    public void setTodo(String a, String b, double c, double d, double e, String f, Menu G) {
        super.setTodo(a, b, c, d, e);
        this.paginaWeb = f;
        this.menu = G;
    }

    // Metodos

    public void agregarOpcion(Comida A) {
        this.menu.agregarComida(A);
    }
    public void quitarOpcion(String nombre) {
        this.menu.quitarComida(nombre);
    }

    public Comida getOpcion(int index) {
        return this.menu.getComida(index);
    }

    public Comida getOpcion(String nombre) {
        return this.menu.getComida(nombre);
    }

    public double precioTotal() {
        return this.menu.precioTotal();
    }

    public double minimoComida() {
        return this.menu.minPrecio();
    }

    public void mostrar() {
        System.out.println("Nombre: " + this.nombre + "\nPaginaWeb: " + this.paginaWeb);
        this.menu.mostrar();
    }

    public boolean existeOpcion(String nombre) {
        return this.menu.existeOpcion(nombre);
    }

    public void precioMayorQue(double a) {
        ArrayList<Comida> sol = this.menu.PrecioMayorQue(a);
        String mostrar = "";
        mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
        mostrar += "\nPaginaWeb: " + this.paginaWeb + "\t Direccion: " + this.getUbicacion();
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
        mostrar += "\nPaginaWeb: " + this.paginaWeb + "\t Direccion: " + this.getUbicacion();
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
        mostrar += "\nPaginaWeb: " + this.paginaWeb + "\t Direccion: " + this.getUbicacion();
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

    public String mostrarString() {
        String mostrar = "";
        mostrar += "NombreLugar: " + this.nombre + "\t [" + super.getCoord(0) + ", " + super.getCoord(1) + "]";
        mostrar += "\nPaginaWeb: " + this.paginaWeb + "\t Direccion: " + this.getUbicacion();
        mostrar += "\n Calificacion: " + super.getCalificacion();
        mostrar += "\n" + this.menu.mostrarString();
        return mostrar;
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
