package fastfoodjava;

import java.util.ArrayList;

public class Menu {
    // ! Usando ArrayList para no usar "vectores"

    private ArrayList<Comida> comidas;  // LISTA de comidas (📄)
    private int nroComidas;             // Número de elementos (📊)

    // Constructores - Getters / Setters
    public Menu() {
        this.comidas = new ArrayList<Comida>();
        this.nroComidas = 0;
    }
    public Menu(ArrayList<Comida> listaComida) {
        this.comidas = listaComida;
        this.nroComidas = listaComida.size();
    }


    public ArrayList<Comida> getComidas() {
        return comidas;
    }
    public Comida getComida(int index) {
        return this.comidas.get(index);
    }
    public Comida getComida(String nombre) {
        for(Comida elemento : comidas) {
            if (elemento.getNombre() == nombre) {
                return elemento;
            }
        }
        return new Comida();
    }
    public int getNroComidas() {
        return nroComidas;
    }


    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
        this.nroComidas = comidas.size();
    }
    public void setNroComidas(int nroComidas) {
        this.nroComidas = nroComidas;
    }

    // __Metodos__

    /**
     * * General - Para agregar / quitar / editar
     *
     * @param nombre : nombre de la comida
     * @param precio : precio de la comida
     * @param opcion : objeto comida
     * @param index  : posicion del objeto comida en el Array (vector)
     */
    public void agregarComida(String nombre, double precio) {
        this.comidas.add(new Comida(nombre, precio));
        System.out.println("Agregado al menu");
    }

    public void agregarComida(Comida opcion) {
        this.comidas.add(opcion);
    }

    public void quitarComida(int index) {
        this.comidas.remove(index);
        System.out.println("Quitado con exito");
    }

    public void quitarComida(String nombre) {
        int index = 0;
        boolean detector = false;
        for (Comida elemento : this.comidas) {
            if (elemento.getNombre() == nombre) {
                detector = true;
                break;
            }
            index++;
        }
        if (detector) {
            this.comidas.remove(index);
            System.out.println("Quitado con exito");
        } else {
            System.out.println("No existe tal opcion");
        }
    }

    public void editarComida(String nombre, Comida opcion) {
        int index = 0;
        for (Comida elemento : this.comidas) {
            if (elemento.getNombre() == nombre) {
                this.comidas.set(index, opcion);
                break;
            }
            index++;
        }
    }

    public void editarComida(String nombre, String nombreEdit, double precioEdit) {
        int index = 0;
        for (Comida elemento : this.comidas) {
            if (elemento.getNombre() == nombre) {
                this.comidas.set(index, new Comida(nombreEdit, precioEdit));
                break;
            }
            index++;
        }
    }



    /**
     * * EXISTENCIA de una Comida en el menu
     *
     * @param nombre    : nombre de la opcion de comida
     * @return          : Restorna si un Opcion de comida existe en el menú
     */
    public boolean existeOpcion(String nombre) {
        boolean existe = false;
        for (Comida elemento : this.comidas) {
            if (elemento.getNombre() == nombre) {
                existe = true;
                break;
            }
        }
        return existe;
    }



    /**
     * * Lista de OPCIONES de comida con precio >= ó <= al ingresado
     *
     * @param nombre    : nombre de COMIDA
     * @param precio    : precio de COMIDA
     * @return          : Retorna una Array(vector) que cumpla la condicion
     */
    public ArrayList<Comida> PrecioMenorQue(double precio) {
        ArrayList<Comida> menor = new ArrayList<Comida>();
        for (Comida elemento : this.comidas) {
            if (elemento.getPrecio() <= precio) {
                menor.add(elemento);
            }
        }
        return menor;
    }

    public ArrayList<Comida> PrecioMayorQue(double precio) {
        ArrayList<Comida> mayor = new ArrayList<Comida>();
        for (Comida elemento : this.comidas) {
            if (elemento.getPrecio() >= precio) {
                mayor.add(elemento);
            }
        }
        return mayor;
    }

    public ArrayList<Comida> PrecioIgualQue(double precio) {
        ArrayList<Comida> igual = new ArrayList<Comida>();
        for (Comida elemento : this.comidas) {
            if (elemento.getPrecio() == precio) {
                igual.add(elemento);
            }
        }
        return igual;
    }



    public void mostrar() {
        int index = 1;
        for (Comida elemento : this.comidas) {
            String nombre = elemento.getNombre();
            double precio = elemento.getPrecio();
            System.out.printf("%s Nombre: %s \t Precio: %s", index, nombre, precio);
            index++;
        }
    }
}
