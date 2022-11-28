package fastfoodjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoQuiosco {
    private String nomArch;

    public ArchivoQuiosco() {
        this.nomArch = "./src/Persistencia/Quiosco.obj";
    }

    public ArchivoQuiosco(String nom) {
        this.nomArch = nom;
    }

    public void crear() throws FileNotFoundException, IOException {
        ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(this.nomArch));
        archivo.close();
        System.out.println("Archivo creado exitosamente");
    }

    public void agregar(Quiosco nuevoQuiosco) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                temporal.writeObject(quiTemp);
            }
        } catch (Exception e) {
            temporal.writeObject(nuevoQuiosco);
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto adicionado");
        }
    }

    public void agregar(String nombre) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                temporal.writeObject(quiTemp);
            }
        } catch (Exception e) {
            temporal.writeObject(new Quiosco(nombre));
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto adicionado");
        }
    }

    public void eliminar(Quiosco QuioscoEliminar) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                if (QuioscoEliminar.getNombre().equals(quiTemp.getNombre())
                        && QuioscoEliminar.getUbicacion().equals(quiTemp.getUbicacion())) {
                    continue;
                }
                temporal.writeObject(quiTemp);
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto eliminado");
        }

    }

    public void eliminar(String nombre, String ubicacion) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                if (quiTemp.getNombre().equals(nombre) && quiTemp.getUbicacion().equals(ubicacion)) {
                    continue;
                }
                temporal.writeObject(quiTemp);
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto eliminado");
        }

    }

    public void eliminar(int index) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                if (con == index) {
                    continue;
                }
                temporal.writeObject(quiTemp);
                con++;
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto eliminado");
        }

    }

    public void editar(String nombre, String ubicacion, Quiosco QuioscoEdit)
            throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                if (quiTemp.getNombre().equals(nombre) && quiTemp.getUbicacion().equals(ubicacion)) {
                    quiTemp = QuioscoEdit;
                }
                temporal.writeObject(quiTemp);
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto editado");
        }
    }

    public void editar(int index, Quiosco QuioscoEdit)
            throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                if (con == index) {
                    quiTemp = QuioscoEdit;
                }
                temporal.writeObject(quiTemp);
                con++;
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto editado");
        }
    }

    public void listar() throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                quiTemp.mostrar();
            }
        } catch (Exception e) {
            // System.out.println("Error: " + e);
        } finally {
            archivo.close();
        }
    }

    public void listarFormat() throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                System.out.println(con + " " + quiTemp.mostrarString());
                con++;
            }
        } catch (Exception e) {
            // System.out.println("Error: " + e);
        } finally {
            archivo.close();
        }
    }

    public Quiosco getElement(int index) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                if (con == index) {
                    archivo.close();
                    return quiTemp;
                }
                con++;
            }
        } catch (Exception e) {
            archivo.close();
        }
        return null;
    }

    public Quiosco getElement(String nombre, String ubicacion) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                if (quiTemp.getNombre().equals(nombre) && quiTemp.getUbicacion().equals(ubicacion)) {
                    archivo.close();
                    return quiTemp;
                }
            }
        } catch (Exception e) {
            archivo.close();
        }
        return new Quiosco();
    }

    public ArrayList<Quiosco> getQuioscos() throws FileNotFoundException, IOException {
        ArrayList<Quiosco> lista = new ArrayList<Quiosco>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        return lista;
    }

    public ArrayList<LugarAComer> getLugarAComer() throws FileNotFoundException, IOException {
        ArrayList<LugarAComer> lista = new ArrayList<LugarAComer>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                LugarAComer Temp = (LugarAComer) archivo.readObject();
                lista.add(Temp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        return lista;
    }

    public void BORRARTODO() throws FileNotFoundException, IOException {
        try {
            ObjectOutputStream temporal = new ObjectOutputStream(
                    new FileOutputStream("./src/Persistencia/temporal.obj"));
            ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Se Borro todo");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Quiosco masBarato() throws FileNotFoundException, IOException {
        ArrayList<Quiosco> lista = new ArrayList<Quiosco>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco resTemp = (Quiosco) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Quiosco minQui = lista.get(0);
        double minPrecio = minQui.getPrecio();

        for (Quiosco i : lista) {
            if (i.getPrecio() < minPrecio) {
                minQui = i;
                minPrecio = i.getPrecio();
            }
        }
        return minQui;
    }

    public Quiosco masCerca(double[] coord) throws FileNotFoundException, IOException {
        ArrayList<Quiosco> lista = new ArrayList<Quiosco>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco resTemp = (Quiosco) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Quiosco minQui = lista.get(0);
        double minDistancia = Math
                .sqrt(Math.pow((coord[0] + minQui.getCoord()[0]), 2) + Math.pow((coord[1] + minQui.getCoord()[1]), 2));

        for (Quiosco i : lista) {
            double distancia_i = Math
                    .sqrt(Math.pow((coord[0] + minQui.getCoord()[0]), 2)
                            + Math.pow((coord[1] + minQui.getCoord()[1]), 2));
            if (distancia_i < minDistancia) {
                minQui = i;
                minDistancia = distancia_i;
            }
        }

        return minQui;
    }

    public Quiosco masValorado() throws FileNotFoundException, IOException {
        ArrayList<Quiosco> lista = new ArrayList<Quiosco>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco resTemp = (Quiosco) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Quiosco minQui = lista.get(0);
        double minVal = minQui.getCalificacion();

        for (Quiosco i : lista) {
            if (i.getPrecio() > minVal) {
                minQui = i;
                minVal = i.getCalificacion();
            }
        }
        return minQui;
    }

    public ArrayList<Quiosco> buscarNombre(String nombre) throws FileNotFoundException, IOException {
        ArrayList<Quiosco> lista = new ArrayList<Quiosco>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco resTemp = (Quiosco) archivo.readObject();
                if (resTemp.getNombre().equals(nombre)) {
                    lista.add(resTemp);
                }
            }
        } catch (Exception e) {
            archivo.close();
        }
        return lista;
    }

    public void precioMayorQue(double a) throws IOException {
        ArrayList<Quiosco> lista = new ArrayList<Quiosco>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Quiosco i : lista) {
            i.precioMayorQue(a);
        }
    }

    public void precioMenorQue(double a) throws IOException {
        ArrayList<Quiosco> lista = new ArrayList<Quiosco>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Quiosco i : lista) {
            i.precioMenorQue(a);
        }
    }

    public void precioIgualQue(double a) throws IOException {
        ArrayList<Quiosco> lista = new ArrayList<Quiosco>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Quiosco quiTemp = (Quiosco) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Quiosco i : lista) {
            i.precioIgualQue(a);
        }
    }

}
