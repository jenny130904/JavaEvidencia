import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad();
        Estudiante estudiante = new Estudiante();

        String nombre, nombreMateria, opc;
        int edad, respuesta, opcion1, opcion2;
        double calificacion;
        do {
            do {
                System.out.println("Selecciona una opcion: ");
                System.out.println("1. Agregar datos de alumnos");
                System.out.println("2. Agregar materia y calificacion");
                System.out.println("3. Ver lista de materias");
                System.out.println("4. Ver lista de estudiantes");
                respuesta = scanner.nextInt();
            } while (respuesta > 4 || respuesta < 1);
            switch (respuesta) {
                case 1:
                    int b = 0;
                    System.out.print("¿Cuantas alumnos deseas ingresar? ");
                    opcion1 = scanner.nextInt();
                    scanner.nextLine();
                    while (b < opcion1) {
                        System.out.print("Ingresa el nombre del alumno: ");
                        nombre = scanner.nextLine();
                        Estudiante alumno = new Estudiante(nombre);
                        universidad.agregarAlumnos(alumno);
                        System.out.print("Ingresa la edad del alumno: ");
                        edad = scanner.nextInt();
                        scanner.nextLine();
                        b++;
                    }
                    break;
                case 2:
                    int i = 0;
                    System.out.print("¿Cuantas calificaciones deseas ingresar? ");
                    opcion2 = scanner.nextInt();
                    scanner.nextLine();
                    while (i < opcion2) {
                        System.out.print("Ingresa el nombre de la materia: ");
                        nombreMateria = scanner.nextLine();
                        Materia materia = new Materia(nombreMateria);
                        universidad.agregarMaterias(materia);
                        System.out.print("Ingresa la calificacion: ");
                        calificacion = scanner.nextDouble();
                        Materia cali = new Materia(nombreMateria, calificacion);
                        estudiante.agregarCalificacion(cali); //Agrega calificacion
                        scanner.nextLine();
                        i++;
                    }
                    break;
                case 3:
                    System.out.println("Lista de materias");
                    universidad.mostrarListaAlum();
                    break;
                case 4:
                    System.out.println("Lista de estudiantes");
                    universidad.mostraListaMater();
                    break;
                default:
                    break;
            }
            System.out.println("¿Desea realizar otra operacion? s/n ");
            opc = scanner.nextLine();
        }while (opc.equalsIgnoreCase("S"));
        estudiante.displayInfo();//muestra informacion
    }
}