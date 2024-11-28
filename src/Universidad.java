import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Universidad implements Imprimible{
    private HashMap<String, Estudiante> listaAlumnos;
    private HashMap<String, Materia> listaMaterias;

    public void escribirDatosByteStream(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(listaAlumnos);
        } catch (IOException e) {
            System.out.println("Error al escribir los datos: " + e.getMessage());
        }
    }

    public void leerDatosByteStream(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            listaAlumnos = (HashMap<String, Estudiante>) ois.readObject();
            System.out.println("Datos leídos exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los datos: " + e.getMessage());
        }
    }

    public Universidad(){
        this.listaAlumnos = new HashMap<>();
        this.listaMaterias = new HashMap<>();
    }

    public Estudiante buscarAlumno(String nombre) {
        return listaAlumnos.get(nombre);
    }

    public void agregarAlumnos(Estudiante estudiante) {
        if (listaAlumnos.containsKey(estudiante.getNombre())) {
            System.out.println("El alumno ya está registrado.");
        } else {
            listaAlumnos.put(estudiante.getNombre(), estudiante);
        }
    }


    public void agregarMaterias(Materia materia){
        listaMaterias.put(materia.getNombreMateria(), materia);
    }
    public void mostrarListaAlum(){
        if (listaAlumnos.isEmpty()){
            System.out.println("No hay registro de alumnos");
        }else{
            listaAlumnos.values().forEach(estudiante -> estudiante.displayInfo());
        }
    }

    @Override
    public void imprimir(){
        System.out.println("LISTA DE ALUMNOS");
        mostrarListaAlum();
    }
}
