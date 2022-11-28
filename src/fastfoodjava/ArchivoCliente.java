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

public class ArchivoCliente {
    private String nomArch;

    public ArchivoCliente() {
        this.nomArch = "./src/Persistencia/Cliente.obj";
    }

    public ArchivoCliente(String nom) {
        this.nomArch = nom;
    }

    public void crear() throws FileNotFoundException, IOException {
        ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(this.nomArch));
        archivo.close();
        System.out.println("Archivo creado exitosamente");
    }

    public void agregar(Cliente nuevoCliente) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Cliente cliTemp = (Cliente) archivo.readObject();
                temporal.writeObject(cliTemp);
            }
        } catch (Exception e) {
            temporal.writeObject(nuevoCliente);
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
                Cliente cliTemp = (Cliente) archivo.readObject();
                temporal.writeObject(cliTemp);
            }
        } catch (Exception e) {
            temporal.writeObject(new Cliente(nombre));
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto adicionado");
        }
    }

    public void eliminar(Cliente ClienteEliminar) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Cliente cliTemp = (Cliente) archivo.readObject();
                if (ClienteEliminar.getNombre().equals(cliTemp.getNombre())) {
                    continue;
                }
                temporal.writeObject(cliTemp);
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

    public void eliminar(String nombre) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Cliente cliTemp = (Cliente) archivo.readObject();
                if (cliTemp.getNombre().equals(nombre)) {
                    continue;
                }
                temporal.writeObject(cliTemp);
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
                Cliente cliTemp = (Cliente) archivo.readObject();
                if (con == index) {
                    continue;
                }
                temporal.writeObject(cliTemp);
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

    public void editar(String nombre, Cliente ClienteEdit)
            throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Cliente cliTemp = (Cliente) archivo.readObject();
                if (cliTemp.getNombre().equals(nombre)) {
                    cliTemp = ClienteEdit;
                }
                temporal.writeObject(cliTemp);
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

    public void editar(int index, Cliente ClienteEdit)
            throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Cliente cliTemp = (Cliente) archivo.readObject();
                if (con == index) {
                    cliTemp = ClienteEdit;
                }
                temporal.writeObject(cliTemp);
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
                Cliente cliTemp = (Cliente) archivo.readObject();
                cliTemp.mostrar();
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
                Cliente cliTemp = (Cliente) archivo.readObject();
                System.out.println(con + " " + cliTemp.mostrarString());
                con++;
            }
        } catch (Exception e) {
            // System.out.println("Error: " + e);
        } finally {
            archivo.close();
        }
    }

    public Cliente getElement(int index) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Cliente cliTemp = (Cliente) archivo.readObject();
                if (con == index) {
                    archivo.close();
                    return cliTemp;
                }
                con++;
            }
        } catch (Exception e) {
            archivo.close();
        }
        return null;
    }

    public Cliente getElement(String nombreCli) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Cliente cliTemp = (Cliente) archivo.readObject();
                if (cliTemp.getNombre().equals(nombreCli)) {
                    archivo.close();
                    return cliTemp;
                }
            }
        } catch (Exception e) {
            archivo.close();
        }
        return new Cliente();
    }

    public ArrayList<Cliente> getClientes() throws FileNotFoundException, IOException {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Cliente cliTemp = (Cliente) archivo.readObject();
                lista.add(cliTemp);
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

}
