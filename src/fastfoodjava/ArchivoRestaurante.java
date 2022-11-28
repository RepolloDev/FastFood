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

public class ArchivoRestaurante {
    private String nomArch;

    public ArchivoRestaurante() {
        this.nomArch = "./src/Persistencia/Restaurante.obj";
    }

    public ArchivoRestaurante(String nom) {
        this.nomArch = nom;
    }

    public void crear() throws FileNotFoundException, IOException {
        ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(this.nomArch));
        archivo.close();
        System.out.println("Archivo creado exitosamente");
    }

    public void agregar(Restaurante nuevoRestaurante) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                temporal.writeObject(resTemp);
            }
        } catch (Exception e) {
            temporal.writeObject(nuevoRestaurante);
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
                Restaurante resTemp = (Restaurante) archivo.readObject();
                temporal.writeObject(resTemp);
            }
        } catch (Exception e) {
            temporal.writeObject(new Restaurante(nombre));
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto adicionado");
        }
    }

    public void eliminar(Restaurante RestauranteEliminar) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                if (RestauranteEliminar.getNombre().equals(resTemp.getNombre())
                        && RestauranteEliminar.getUbicacion().equals(resTemp.getUbicacion())) {
                    continue;
                }
                temporal.writeObject(resTemp);
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
                Restaurante resTemp = (Restaurante) archivo.readObject();
                if (resTemp.getNombre().equals(nombre) && resTemp.getUbicacion().equals(ubicacion)) {
                    continue;
                }
                temporal.writeObject(resTemp);
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
                Restaurante resTemp = (Restaurante) archivo.readObject();
                if (con == index) {
                    continue;
                }
                temporal.writeObject(resTemp);
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

    public void editar(String nombre, String ubicacion, Restaurante RestauranteEdit)
            throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                if (resTemp.getNombre().equals(nombre) && resTemp.getUbicacion().equals(ubicacion)) {
                    resTemp = RestauranteEdit;
                }
                temporal.writeObject(resTemp);
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

    public void editar(int index, Restaurante RestauranteEdit)
            throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                if (con == index) {
                    resTemp = RestauranteEdit;
                }
                temporal.writeObject(resTemp);
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
                Restaurante resTemp = (Restaurante) archivo.readObject();
                resTemp.mostrar();
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
                Restaurante resTemp = (Restaurante) archivo.readObject();
                System.out.println(con + " " + resTemp.mostrarString());
                con++;
            }
        } catch (Exception e) {
            // System.out.println("Error: " + e);
        } finally {
            archivo.close();
        }
    }

    public Restaurante getElement(int index) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                if (con == index) {
                    archivo.close();
                    return resTemp;
                }
                con++;
            }
        } catch (Exception e) {
            archivo.close();
        }
        return null;
    }

    public Restaurante getElement(String nombre, String ubicacion) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                if (resTemp.getNombre().equals(nombre) && resTemp.getUbicacion().equals(ubicacion)) {
                    archivo.close();
                    return resTemp;
                }
            }
        } catch (Exception e) {
            archivo.close();
        }
        return new Restaurante();
    }

    public ArrayList<Restaurante> getRestaurantes() throws FileNotFoundException, IOException {
        ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                lista.add(resTemp);
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

    public Restaurante masBarato() throws FileNotFoundException, IOException {
        ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Restaurante minRes = lista.get(0);
        double minPrecio = minRes.minimoComida();

        for (Restaurante i : lista) {
            if (i.minimoComida() < minPrecio) {
                minRes = i;
                minPrecio = i.minimoComida();
            }
        }
        return minRes;
    }

    public Restaurante masCerca(double[] coord) throws FileNotFoundException, IOException {
        ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Restaurante minRes = lista.get(0);
        double minDistancia = Math
                .sqrt(Math.pow((coord[0] + minRes.getCoord()[0]), 2) + Math.pow((coord[1] + minRes.getCoord()[1]), 2));

        for (Restaurante i : lista) {
            double distancia_i = Math
                    .sqrt(Math.pow((coord[0] + minRes.getCoord()[0]), 2)
                            + Math.pow((coord[1] + minRes.getCoord()[1]), 2));
            if (distancia_i < minDistancia) {
                minRes = i;
                minDistancia = distancia_i;
            }
        }

        return minRes;
    }

    public Restaurante masValorado() throws FileNotFoundException, IOException {
        ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Restaurante minRes = lista.get(0);
        double minVal = minRes.getCalificacion();

        for (Restaurante i : lista) {
            if (i.minimoComida() > minVal) {
                minRes = i;
                minVal = i.getCalificacion();
            }
        }
        return minRes;
    }

    public ArrayList<Restaurante> buscarNombre(String nombre) throws FileNotFoundException, IOException {
        ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante resTemp = (Restaurante) archivo.readObject();
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
        ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante quiTemp = (Restaurante) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Restaurante i : lista) {
            i.precioMayorQue(a);
        }
    }

    public void precioMenorQue(double a) throws IOException {
        ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante quiTemp = (Restaurante) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Restaurante i : lista) {
            i.precioMenorQue(a);
        }
    }

    public void precioIgualQue(double a) throws IOException {
        ArrayList<Restaurante> lista = new ArrayList<Restaurante>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Restaurante quiTemp = (Restaurante) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Restaurante i : lista) {
            i.precioIgualQue(a);
        }
    }

}
