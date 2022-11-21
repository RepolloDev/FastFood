package fastfoodjava;

import java.util.ArrayList;

public class Registro {
    // TODO: añadir métodos⭐ para interactura con el programa
    // ! Usando ArrayList para no usar "vectores"

    private ArrayList<Restaurante> restaurantes;        // Lista de Restaurante (📄)
    private ArrayList<PensionFijo> pensionesFijos;      // Lista de PensionFijo (📄)
    private ArrayList<PensionNoFijo> pensionesNoFijos;  // Lista de PensionNoFijo (📄)
    private int nroRestaurantes;
    private int nroPensionesFijos;
    private int nroPensionesNoFijos;
    private Cliente cliente;                            // Usuario que usa la App (👤)

    // Constructores - Getters / Setters
    public Registro() {
        this.restaurantes = new ArrayList<Restaurante>();
        this.nroRestaurantes = 0;
        this.pensionesFijos = new ArrayList<PensionFijo>();
        this.nroPensionesFijos = 0;
        this.pensionesNoFijos = new ArrayList<PensionNoFijo>();
        this.nroPensionesNoFijos = 0;
        this.cliente = new Cliente();
    }
    public Registro(ArrayList<Restaurante> a, ArrayList<PensionFijo> b, ArrayList<PensionNoFijo> c, Cliente d) {
        this.restaurantes = a;
        this.nroRestaurantes = a.size();
        this.pensionesFijos = b;
        this.nroPensionesFijos = b.size();
        this.pensionesNoFijos = c;
        this.nroPensionesNoFijos = c.size();
        this.cliente = d;
    }


    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }
    public ArrayList<PensionFijo> getPensionesFijos() {
        return pensionesFijos;
    }
    public ArrayList<PensionNoFijo> getPensionesNoFijos() {
        return pensionesNoFijos;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
        this.nroRestaurantes = restaurantes.size();
    }
    public void setPensionesFijos(ArrayList<PensionFijo> pensionesFijos) {
        this.pensionesFijos = pensionesFijos;
        this.nroPensionesFijos = pensionesFijos.size();
    }
    public void setPensionesNoFijos(ArrayList<PensionNoFijo> pensionesNoFijos) {
        this.pensionesNoFijos = pensionesNoFijos;
        this.nroPensionesNoFijos = pensionesNoFijos.size();
    }
    public void setTodo(ArrayList<Restaurante> a, ArrayList<PensionFijo> b, ArrayList<PensionNoFijo> c, Cliente d) {
        this.restaurantes = a;
        this.nroRestaurantes = a.size();
        this.pensionesFijos = b;
        this.nroPensionesFijos = b.size();
        this.pensionesNoFijos = c;
        this.nroPensionesNoFijos = c.size();
        this.cliente = d;
    }

    // Metodos
}