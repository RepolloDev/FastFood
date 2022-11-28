package fastfoodjava;

import java.io.Serializable;

public class LugarAComerFijo extends LugarAComer implements Serializable {
    // * Pension es SUBCLASE de LugarAComer
    // ? Posiblemente la clase sera una "CLASE ABSTRACTA"

    public LugarAComerFijo() {
        super();
    }
    public LugarAComerFijo(String a) {
        super(a);
    }
    public LugarAComerFijo(String a, String b, double c, double[] d) {
        super(a, b, c, d);
    }
    public LugarAComerFijo(String a, String b, double c, double d, double e) {
        super(a, b, c, d, e);
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
}
