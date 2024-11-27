import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Materia{
    private String nombre;
    private int edad;
    private List<Materia> calificaciones = new ArrayList<>();

    public Estudiante(String nombreMateria, double calificacion, String nombre, List<Materia> calificaciones, int edad) {
        super(nombreMateria, calificacion);
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();;
        this.edad = edad;
    }

    public Estudiante(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Estudiante() {
        this.nombre = "";
        this.edad = 0;
        this.calificaciones = new ArrayList<>();;
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
        this.calificaciones = calificaciones;
    }

    public void agregarCalificacion(Materia calificacion){
        calificaciones.add(calificacion);

    }
    public double calculaPromedio(){
        double suma = 0;
        int count = 0;
        for (Materia calificacion : calificaciones){ //Usamos for-each este es mas directo y recorre el arreglo sin necesidad de poner .length
            suma += calificacion.getCalificacion();
            count ++;
        }
        return suma / count;
    }

    public void displayInfo(){
        System.out.println("Nombre del alumno " + nombre);
        System.out.println("Edad del alumno " + edad);
        for (Materia calificacion : calificaciones){
            System.out.println("| Materia: "+ calificacion.getNombreMateria() + "\t| Calificacion "+ calificacion.getCalificacion() + "\t|");
        }
        double promedio = calculaPromedio();
        System.out.println("Promedio: " + promedio);
        //Problemas
        //No muestra nombre ni edad
    }
}