import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estudiante implements Serializable {
    private String nombre;
    private int edad;
    private ArrayList<Materia> calificaciones;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = new ArrayList<>();
    }

    public Estudiante() {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Materia> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Materia> calificaciones) {
        this.calificaciones = (ArrayList<Materia>) calificaciones;
    }

    public void agregarCalificacion(String materia, double calificacion){
        try {
            if (calificacion < 0 || calificacion > 10) {
                throw new CalificacionInvalidaException("La calificación debe estar entre 0 y 10.");
            }
            calificaciones.add(new Materia(materia, calificacion));
        } catch (CalificacionInvalidaException e) {
            System.out.println("Error al agregar calificación: " + e.getMessage());
        }

    }
    public double calculaPromedio(){
        double suma = 0;
        int count = 0;
        for (Materia calificacion : calificaciones){ //Usamos for-each este es mas directo y recorre el arreglo sin necesidad de poner .length
            suma += calificacion.getCalificacion();
            count ++;
        }
        return (count > 0) ? suma / count : 0;
    }

    public void displayInfo(){
        System.out.println("Nombre del alumno: " + nombre);
        System.out.println("Edad del alumno: " + edad);
        if (calificaciones.isEmpty()) {
            System.out.println("Sin calificaciones registradas.");
        } else {
            for (Materia calificacion : calificaciones) {
                System.out.println("| Materia: " + calificacion.getNombreMateria() + "\t| Calificación: " + calificacion.getCalificacion());
            }
        }
        System.out.println("Promedio: " + calculaPromedio());
    }
}