package fastfoodjava;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    // ! Usando ArrayList para no usar "vectores"
    // DOCUMENTACION : https://www.w3schools.com/java/java_arraylist.asp

    private String nombre; // Nombre del cliente (👤)
    private double[] coord = new double[2];
    private ArrayList<LugarAComer> visitados; // lugares VISITADOS por el cliente (📄)
    private ArrayList<LugarAComer> favoritos; // lugares FAVORITOS del cliente (♥)

    // Contructores - Getters / Setters
    public Cliente() {
        this.nombre = "Desconocido";
        this.coord[0] = -16.504707608262308;
        this.coord[1] = -68.12992424362548;
        this.visitados = new ArrayList<LugarAComer>();
        this.favoritos = new ArrayList<LugarAComer>();
    }

    public Cliente(String a) {
        this.nombre = a;
        this.coord[0] = -16.504707608262308;
        this.coord[1] = -68.12992424362548;
        this.visitados = new ArrayList<LugarAComer>();
        this.favoritos = new ArrayList<LugarAComer>();
    }

    public Cliente(String a, String b, String c) {
    };

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<LugarAComer> getFavoritos() {
        return this.favoritos;
    }

    public ArrayList<LugarAComer> getVisitados() {
        return this.visitados;
    }

    public double[] getCoord() {
        return this.coord;
    }

    public void setFavoritos(ArrayList<LugarAComer> favoritos) {
        this.favoritos = favoritos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVisitados(ArrayList<LugarAComer> visitados) {
        this.visitados = visitados;
    }

    public void setCoord(double[] coord) {
        this.coord = coord;
    }

    public void setCoord(double a, double b) {
        this.coord[0] = a;
        this.coord[1] = b;
    }

    public void mostrar() {
        System.out.println(this.nombre);
    }

    public String mostrarString() {
        String mostrar = "";
        mostrar += this.nombre + "\t[" + this.coord[0] + ", " + this.coord[1] + "]";
        mostrar += "\n\t" + "nro Visitados: " + this.visitados.size() + "\t" + "nro Favoritos: "
                + this.favoritos.size();
        return mostrar;
    }

    // Metodos
    public void agregarvisitados(LugarAComer A) {
        this.visitados.add(A);
    }

    public void agregarFavoritos(LugarAComer A) {
        this.favoritos.add(A);
    }

    public void quitarVisitado(int index) {
        this.visitados.remove(index);
    }

    public void quitarVisitados(String nombre, String ubicacion) {
        int index = 0;
        for (LugarAComer i : this.visitados) {
            if (i.getNombre().equals(nombre) && i.getUbicacion().equals(ubicacion)) {
                this.visitados.remove(index);
            }
            index++;
        }
    }

    public void quitarVisitado(LugarAComer A) {
        int index = 0;
        for (LugarAComer elemento : this.visitados) {
            if (elemento.getNombre().equals(A.getNombre())) {
                this.visitados.remove(index);
            }
            index++;
        }
    }

    public void quitarFavoritos(LugarAComer A) {
        int index = 0;
        for (LugarAComer elemento : this.favoritos) {
            if (elemento.getNombre().equals(A.getNombre())) {
                this.visitados.remove(index);
            }
            index++;
        }
    }

}
