package fastfoodjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Registro {
    ArchivoCliente clientes;
    ArchivoRestaurante restaurantes;
    ArchivoPension pensiones;
    ArchivoQuiosco quioscos;
    Cliente sesion;

    public Registro() {
        this.clientes = new ArchivoCliente();
        this.restaurantes = new ArchivoRestaurante();
        this.pensiones = new ArchivoPension();
        this.quioscos = new ArchivoQuiosco();
    }

    public Registro(ArchivoCliente a, ArchivoRestaurante b, ArchivoPension c, ArchivoQuiosco d) {
        this.clientes = a;
        this.restaurantes = b;
        this.pensiones = c;
        this.quioscos = d;
    }

    public ArchivoCliente getClientes() {
        return clientes;
    }

    public ArchivoPension getPensiones() {
        return pensiones;
    }

    public ArchivoQuiosco getQuioscos() {
        return quioscos;
    }

    public ArchivoRestaurante getRestaurantes() {
        return restaurantes;
    }

    public Cliente getSesion() {
        return sesion;
    }

    public void setClientes(ArchivoCliente clientes) {
        this.clientes = clientes;
    }

    public void setPensiones(ArchivoPension pensiones) {
        this.pensiones = pensiones;
    }

    public void setQuioscos(ArchivoQuiosco quioscos) {
        this.quioscos = quioscos;
    }

    public void setRestaurantes(ArchivoRestaurante restaurantes) {
        this.restaurantes = restaurantes;
    }

    public void setSesion(Cliente sesion) {
        this.sesion = sesion;
    }

    /* Metodos CLIENTE */
    public void login(String nombre) throws FileNotFoundException, IOException {
        this.sesion = this.clientes.getElement(nombre);
    }

    public void register(String nombre) throws FileNotFoundException, IOException {
        this.clientes.agregar(nombre);
        this.sesion = this.clientes.getElement(nombre);
    }

    public void eliminarCliente(String nombre) throws FileNotFoundException, IOException {
        this.clientes.eliminar(nombre);
    }

    public void eliminarCliente(int index) throws FileNotFoundException, IOException {
        this.clientes.eliminar(index);
    }

    public void sesionEdit(String nombre) throws FileNotFoundException, IOException {
        String aux = sesion.getNombre();
        this.sesion.setNombre(nombre);
        this.clientes.editar(aux, sesion);
    }

    public void cambiarUbicacion(double a, double b) throws FileNotFoundException, IOException {
        String aux = sesion.getNombre();
        this.sesion.setCoord(a, b);
        this.clientes.editar(aux, sesion);
    }

    public void agregarVisitado(LugarAComer A) throws FileNotFoundException, IOException {
        String aux = this.sesion.getNombre();
        this.sesion.agregarvisitados(A);
        this.clientes.editar(aux, sesion);
        this.clientes.getElement(aux);
    }

    public void eliminarVisitado(LugarAComer A) throws FileNotFoundException, IOException {
        String aux = this.sesion.getNombre();
        this.sesion.quitarVisitado(A);
        this.clientes.editar(aux, sesion);
        this.clientes.getElement(aux);
    }

    public void agregarFavorito(LugarAComer A) throws FileNotFoundException, IOException {
        String aux = this.sesion.getNombre();
        this.sesion.agregarFavoritos(A);
        this.clientes.editar(aux, sesion);
        this.clientes.getElement(aux);
    }

    public void eliminarFavorito(LugarAComer A) throws FileNotFoundException, IOException {
        String aux = this.sesion.getNombre();
        this.sesion.quitarFavoritos(A);
        this.clientes.editar(aux, sesion);
        this.clientes.getElement(aux);
    }

    public void mostrarLogin() {
        System.out.println("/*\tSesion abierta\t*/");
        System.out.println(this.sesion.mostrarString());
    }

    public void mostrarLoginFormat() {
        System.out.println("/*\tSesion abierta\t*/");
        System.out.println(this.sesion.mostrarString());
    }

    public void mostrarClientes() throws FileNotFoundException, IOException {
        System.out.println("/*\tLista de clientes\t*/");
        this.clientes.listar();
    }

    public void mostrarClientesFormat() throws FileNotFoundException, IOException {
        System.out.println("/*\tLista de clientes formateado\t*/");
        this.clientes.listarFormat();
    }

    // ⭐⭐⭐⭐⭐ METODO MOSTRAR VISITADOS ⭐⭐⭐⭐⭐
    public void mostrarVisitados() {
        if (this.sesion.getVisitados().size() > 0) {
            System.out.println("________________Lista de visitados________________");
            for (LugarAComer i : this.sesion.getVisitados()) {
                try {
                    System.out.println(i.mostrarString());
                } catch (Exception e) {
                    System.out.println("_____No hay lista de visitados_____");
                }
            }
        }

    }

    // ⭐⭐⭐⭐⭐ METODO MOSTRAR FAVORITOS ⭐⭐⭐⭐⭐
    public void mostrarFavoritos() {
        ArrayList<LugarAComer> aux = this.sesion.getVisitados();
        if (this.sesion.getFavoritos().size() > 0) {
            System.out.println("________________Lista de favoritos________________");
            for (LugarAComer i : aux) {
                try {
                    System.out.println(i.mostrarString());
                } catch (Exception e) {
                    System.out.println("_____No hay lista de favoritos_____");
                }
            }
        }

    }

    /* METODOS RESTAURANTE */
    public void agregarRestaurante(Restaurante a) throws FileNotFoundException, IOException {
        this.restaurantes.agregar(a);
    }

    public void agregarRestaurante(String nombre) throws FileNotFoundException, IOException {
        this.restaurantes.agregar(nombre);
    }

    public void eliminarRestaurante(Restaurante a) throws FileNotFoundException, IOException {
        this.restaurantes.eliminar(a);
    }

    public void eliminarRestaurante(String nombre, String ubicacion) throws FileNotFoundException, IOException {
        this.restaurantes.eliminar(nombre, ubicacion);
    }

    public void eliminarRestaurante(int index) throws FileNotFoundException, IOException {
        this.restaurantes.eliminar(index);
    }

    public void editarRestaurante(String nombre, String ubicacion, Restaurante a)
            throws FileNotFoundException, IOException {
        this.restaurantes.editar(nombre, ubicacion, a);
    }

    public void editarRestaurante(int index, Restaurante a) throws FileNotFoundException, IOException {
        this.restaurantes.editar(index, a);
    }

    public void getRestaurante(int index) throws FileNotFoundException, IOException {
        this.restaurantes.getElement(index);
    }

    public void getRestaurante(String nombre, String ubicacion) throws FileNotFoundException, IOException {
        this.restaurantes.getElement(nombre, ubicacion);
    }

    /* METODOS ESPECIFICOS */
    // ⭐⭐⭐⭐⭐ METODO LUGARES MAS BARATOS ⭐⭐⭐⭐⭐
    public void masBarato() throws FileNotFoundException, IOException {
        System.out.println("________________Las opciones mas baratas:________________");
        String mostrar = "";
        mostrar += this.restaurantes.masBarato().mostrarString() + "\n";
        mostrar += this.pensiones.masBarato().mostrarString() + "\n";
        mostrar += this.quioscos.masBarato().mostrarString() + "\n";
        System.out.println(mostrar);

    }

    // ⭐⭐⭐⭐⭐ METODO LUGARES MAS CERCANOS ⭐⭐⭐⭐⭐
    public void masCerca() throws FileNotFoundException, IOException {
        System.out.println("________________Las opciones mas cercanas:________________");
        String mostrar = "";
        mostrar += this.restaurantes.masCerca(this.sesion.getCoord()).mostrarString() + "\n";
        mostrar += this.pensiones.masCerca(this.sesion.getCoord()).mostrarString() + "\n";
        mostrar += this.quioscos.masCerca(this.sesion.getCoord()).mostrarString() + "\n";
        System.out.println(mostrar);
    }

    // ⭐⭐⭐⭐⭐ METODO LUGARES MAS VALORADOS ⭐⭐⭐⭐⭐
    public void masValorado() throws FileNotFoundException, IOException {
        System.out.println("________________Las opciones valoradas son:________________");
        String mostrar = "";
        mostrar += this.restaurantes.masValorado().mostrarString() + "\n";
        mostrar += this.pensiones.masValorado().mostrarString() + "\n";
        System.out.println("-----------------------------------");
        System.out.println(mostrar);
    }

    // ⭐⭐⭐⭐⭐ METODO LUGARES MAS VISITADOS ⭐⭐⭐⭐⭐
    public void masVisitados() throws FileNotFoundException, IOException {
        System.out.println("________Las opciones mas visitadas son:________");
        ArrayList<Cliente> cli = this.clientes.getClientes();
        ArrayList<LugarAComer> res = this.restaurantes.getLugarAComer();
        ArrayList<LugarAComer> pen = this.pensiones.getLugarAComer();
        ArrayList<LugarAComer> qui = this.quioscos.getLugarAComer();

        ArrayList<Integer> conList1 = new ArrayList<Integer>();
        ArrayList<Integer> conList2 = new ArrayList<Integer>();
        ArrayList<Integer> conList3 = new ArrayList<Integer>();
        try {
            for (Cliente i : cli) {
                ArrayList<LugarAComer> cliList = i.getVisitados();
                for (LugarAComer j : res) {
                    int con = 0;
                    for (LugarAComer k : cliList) {
                        if (j.getNombre().equals(k.getNombre()) && j.getUbicacion().equals(k.getNombre())) {
                            con++;
                        }
                    }
                    conList1.add(con);
                }
                for (LugarAComer j : pen) {
                    int con = 0;
                    for (LugarAComer k : cliList) {
                        if (j.getNombre().equals(k.getNombre()) && j.getUbicacion().equals(k.getNombre())) {
                            con++;
                        }
                    }
                    conList2.add(con);
                }
                for (LugarAComer j : qui) {
                    int con = 0;
                    for (LugarAComer k : cliList) {
                        if (j.getNombre().equals(k.getNombre()) && j.getUbicacion().equals(k.getNombre())) {
                            con++;
                        }
                    }
                    conList3.add(con);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        int conAux = conList1.get(0);
        LugarAComer lgcAux1 = res.get(0);
        for (int i = 0; i < conList1.size(); i++) {
            if (conList1.get(i) > conAux) {
                lgcAux1 = res.get(i);
                conAux = conList1.get(i);
            }
        }

        conAux = conList2.get(0);
        LugarAComer lgcAux2 = pen.get(0);
        for (int i = 0; i < conList2.size(); i++) {
            if (conList2.get(i) > conAux) {
                lgcAux2 = pen.get(i);
                conAux = conList2.get(i);
            }
        }

        conAux = conList3.get(0);
        LugarAComer lgcAux3 = qui.get(0);
        for (int i = 0; i < conList3.size(); i++) {
            if (conList3.get(i) > conAux) {
                lgcAux3 = pen.get(i);
                conAux = conList3.get(i);
            }
        }
        System.out.println("Lugares con mas visitas por tipo: ");
        System.out.println(lgcAux1.mostrarString());
        System.out.println(lgcAux2.mostrarString());
        System.out.println(lgcAux3.mostrarString());

    }

    // ⭐⭐⭐⭐⭐ METODO BUSCAR POR NOMBRE LUGAR ⭐⭐⭐⭐⭐
    public void buscarLugar(String nombre) throws FileNotFoundException, IOException {
        System.out.println("________________Todas las opciones de su busqueda de lugar:________________");
        String mostrar = "";
        ArrayList<Restaurante> res = this.restaurantes.buscarNombre(nombre);
        for (Restaurante i : res) {
            mostrar += i.mostrarString() + "\n";
        }
        ArrayList<Pension> pen = this.pensiones.buscarNombre(nombre);
        for (Pension i : pen) {
            mostrar += i.mostrarString() + "\n";
        }
        ArrayList<Quiosco> qui = this.quioscos.buscarNombre(nombre);
        for (Quiosco i : qui) {
            mostrar += i.mostrarString() + "\n";
        }
        System.out.println(mostrar);
    }

    // ⭐⭐⭐⭐⭐ METODO BUSCAR POR NOMBRE COMIDA ⭐⭐⭐⭐⭐
    public void buscar(String nombre) throws FileNotFoundException, IOException {
        System.out.println("________________Todas las opciones de su busqueda comida:________________");
        ArrayList<Restaurante> res = this.restaurantes.getRestaurantes();
        ArrayList<Pension> pen = this.pensiones.getPensiones();
        for (Restaurante i : res) {
            if (i.existeOpcion(nombre)) {
                System.out.println(i.mostrarString());
            }
        }
        for (Pension i : pen) {
            if (i.existeOpcion(nombre)) {
                System.out.println(i.mostrarString());
            }
        }
    }

    // ⭐⭐⭐⭐⭐ METODO LUGARES CON PRECIO MAYOR QUE ⭐⭐⭐⭐⭐
    public void lugaresPrecioMayorQue(double precio) throws FileNotFoundException, IOException {
        System.out.println("________________Opciones con precios mayores:________________");
        this.restaurantes.precioMayorQue(precio);
        this.pensiones.precioMayorQue(precio);
        this.quioscos.precioMayorQue(precio);
    }

    // ⭐⭐⭐⭐⭐ METODO LUGARES CON PRECIO MENOR QUE ⭐⭐⭐⭐⭐
    public void lugaresPrecioMenorQue(double precio) throws FileNotFoundException, IOException {
        System.out.println("________________Opciones con precios menores:________________");
        this.restaurantes.precioMenorQue(precio);
        this.pensiones.precioMenorQue(precio);
        this.quioscos.precioMenorQue(precio);
    }

    // ⭐⭐⭐⭐⭐ METODO LUGARES CON PRECIO IGUAL QUE ⭐⭐⭐⭐⭐
    public void lugaresPrecioIgualQue(double precio) throws FileNotFoundException, IOException {
        System.out.println("________________Opciones con precios iguales:________________");
        this.restaurantes.precioIgualQue(precio);
        this.pensiones.precioIgualQue(precio);
        this.quioscos.precioIgualQue(precio);
    }

    // ⭐⭐⭐⭐⭐ METODO COMPARAR ⭐⭐⭐⭐⭐
    public void comparar(Restaurante A, Restaurante B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void comparar(Restaurante A, Pension B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void comparar(Restaurante A, Quiosco B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void comparar(Pension A, Restaurante B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void comparar(Pension A, Pension B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void comparar(Pension A, Quiosco B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void comparar(Quiosco A, Restaurante B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void comparar(Quiosco A, Pension B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void comparar(Quiosco A, Quiosco B) {
        A.comparar(B, this.sesion.getCoord());
    }

    public void mostrarTodo() throws FileNotFoundException, IOException {
        this.restaurantes.listarFormat();
        this.pensiones.listarFormat();
        this.quioscos.listarFormat();
    }

    public void mostrarTodoFormat() throws FileNotFoundException, IOException {
        ArrayList<Restaurante> res = this.restaurantes.getRestaurantes();
        ArrayList<Pension> pen = this.pensiones.getPensiones();
        ArrayList<Quiosco> qui = this.quioscos.getQuioscos();

        System.out.println("Lista de todos los lugares Formateado");
        for (Restaurante i : res) {
            System.out.println(i.mostrarString());
        }
        for (Pension i : pen) {
            System.out.println(i.mostrarString());
        }
        for (Quiosco i : qui) {
            System.out.println(i.mostrarString());
        }
    }

}