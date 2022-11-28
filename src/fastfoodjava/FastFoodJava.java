package fastfoodjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FastFoodJava {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArchivoCliente c1 = new ArchivoCliente();
        ArchivoRestaurante r1 = new ArchivoRestaurante();
        ArchivoPension p1 = new ArchivoPension();
        ArchivoQuiosco q1 = new ArchivoQuiosco();

        Registro registroFastFood = new Registro(c1, r1, p1, q1);
        registroFastFood.login("Luis Gabriel");
        registroFastFood.mostrarVisitados();
        registroFastFood.mostrarFavoritos();

        registroFastFood.masBarato();
        registroFastFood.masCerca();
        registroFastFood.masValorado();
        registroFastFood.masVisitados();

        registroFastFood.buscarLugar("Pollos Copacabana");
        registroFastFood.buscar("Salchipapa");

        registroFastFood.lugaresPrecioIgualQue(5);
        registroFastFood.lugaresPrecioMayorQue(15);
        registroFastFood.lugaresPrecioMenorQue(15);
        registroFastFood.comparar(r1.getElement(0), p1.getElement(2));





        /*
        Pension res = new Pension("Capitan Ravelo", "Comidas3", 4.1,
                -16.504959170234667,
                -68.12872827253949, new Menu());

        Quiosco qui = new Quiosco("Zapata", "Tucumanas1", 3.7, -16.505040224852618, -68.12932968537913, false, true,
                false, true, 5);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nombre precio");
            String sol = sc.nextLine();
            if (sol.equals("")) {
                System.out.println("Salir");
                break;
            }
            res.agregarOpcion(new Comida(sol.split("  ")[0], Double.parseDouble(sol.split("  ")[1])));
        }
         */
        //p1.agregar(res);
        //p1.listarFormat();

        // System.out.println(res.mostrarString());
        // r1.listar();
        // registroFastFood.login("Luis Gabriel");
        // registroFastFood.mostrarLogin();
        // registroFastFood.agregarFavorito(r1.getElement(0));
        // registroFastFood.agregarVisitado(r1.getElement(1));

        // registroFastFood.mostrarFavoritos();
        // registroFastFood.mostrarVisitados();
        // registroFastFood.mostrarFavoritos();
        // registroFastFood.mostrarLoginFormat();
        // registroFastFood.mostrarClientesFormat();

    }

}
