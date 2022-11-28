package fastfoodjava;

import java.io.Serializable;

public class LugarAComer implements Serializable {
    protected String ubicacion; // Ubicación del lugar. Ej. Av. 20 de octubre (🗺)
    protected String nombre; // Nombre del lugar. Ej. Pollos María (🏪)
    protected double calificacion; // Valoracion del lugar. Ej. 3.5 de 5 (⭐)
    protected double[] coord = new double[2]; // Coordenadas en Mapa del lugar. Ej. 16.231, -7.125 (🔻)

    // Contructores - Getters / Setters
    public LugarAComer() {
        this.ubicacion = "--";
        this.nombre = "Desconocido";
        this.calificacion = 0;
        this.coord[0] = 0;
        this.coord[1] = 0;
    }

    public LugarAComer(String a) {
        this.ubicacion = "--";
        this.nombre = a;
        this.calificacion = 0;
        this.coord[0] = 0;
        this.coord[1] = 0;
    }

    public LugarAComer(String a, String b) {
        this.ubicacion = b;
        this.nombre = a;
        this.calificacion = 0;
        this.coord[0] = 0;
        this.coord[1] = 0;
    }

    public LugarAComer(String a, String b, double c, double[] d) {
        this.ubicacion = a;
        this.nombre = b;
        this.calificacion = c;
        this.coord = d;
    }

    public LugarAComer(String a, String b, double c, double d, double e) {
        this.ubicacion = a;
        this.nombre = b;
        this.calificacion = c;
        this.coord[0] = d;
        this.coord[1] = e;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public double[] getCoord() {
        return coord;
    }

    public double getCoord(int index) {
        return coord[index];
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setCoord(double[] coord) {
        this.coord = coord;
    }

    public void setCoord(double a, double b) {
        this.coord[0] = a;
        this.coord[1] = b;
    }

    public void setTodo(String a, String b, double c, double[] d) {
        this.ubicacion = a;
        this.nombre = b;
        this.calificacion = c;
        this.coord = d;
    }

    public void setTodo(String a, String b, double c, double d, double e) {
        this.ubicacion = a;
        this.nombre = b;
        this.calificacion = c;
        this.coord[0] = d;
        this.coord[1] = e;
    }

    // Metodos
    public String mostrarString() {
        String mostrar = "";
        mostrar += "NombreLugar: " + this.nombre + "\t [" + this.coord[0] + ", " + this.coord[1] + "]";
        mostrar += "\nValoracion: " + this.calificacion + "\t Ubicacion: " + this.ubicacion;
        return mostrar;
    }

}
