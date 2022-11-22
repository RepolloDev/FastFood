package fastfoodjava;

import java.util.ArrayList;

public class Cliente {
    // ! Usando ArrayList para no usar "vectores"
    // DOCUMENTACION : https://www.w3schools.com/java/java_arraylist.asp

    private String nombre;                          // Nombre del cliente (👤)
    private ArrayList<LugarAComer> nombreLugar;     // lugares VISITADOS por el cliente (📄)
    private ArrayList<LugarAComer> favoritos;       // lugares FAVORITOS del cliente (♥)

    // Contructores - Getters / Setters
    public Cliente() {
    }

    public Cliente(String a, String b, String c) {
    };

    // Metodos

}
