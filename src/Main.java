import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad();

        universidad.leerDatosByteStream("alumnos.dat");

        String nombre, nombreMateria, opc;
        int edad, respuesta, opcion1, opcion2;
        double calificacion = 0;
        do {
            //Menú
            do {
                System.out.println("Selecciona una opcion: ");
                System.out.println("1. Agregar un Alumno");
                System.out.println("2. Buscar un Alumno");
                System.out.println("3. Mostrar Alumnos");
                System.out.println("4. Salir");
                respuesta = scanner.nextInt();
            } while (respuesta > 4 || respuesta < 1);
            switch (respuesta) {
                case 1:
                    System.out.print("¿Cuantas alumnos deseas ingresar? ");
                    opcion1 = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < opcion1; i++) {
                        System.out.print("Ingresa el nombre del alumno: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingresa la edad del alumno: ");
                        edad = scanner.nextInt();
                        scanner.nextLine();

                        //Se crea el estudiante y se agrega a la universidad
                        Estudiante alumno = new Estudiante(nombre, edad);

                        //Agregar calificaciones
                        System.out.print("¿Cuantas calificaciones deseas ingresar? ");
                        opcion2 = scanner.nextInt();
                        scanner.nextLine();
                        for (int b = 0; b < opcion2; b++) {
                            System.out.print("Ingresa el nombre de la materia: ");
                            nombreMateria = scanner.nextLine();
                            System.out.print("Ingresa la calificacion: ");
                            calificacion = scanner.nextDouble();
                            scanner.nextLine();
                            alumno.agregarCalificacion(nombreMateria, calificacion);
                        }
                        universidad.agregarAlumnos(alumno);
                    }
                    break;
                case 2:
                    System.out.print("Ingresa el nombre del alumno: ");
                    scanner.nextLine();
                    nombre = scanner.nextLine();

                    //Validar si el estudiante existe
                    Estudiante estudiante = universidad.buscarAlumno(nombre);
                    if (estudiante == null) {
                        System.out.println("El alumno no está registrado.");
                    }else{
                        estudiante.displayInfo();
                    }
                    break;
                case 3:
                    System.out.println("Lista de alumnos");
                    universidad.mostrarListaAlum();
                    break;
                case 4:
                    universidad.escribirDatosByteStream("alumnos.dat");
                    System.out.println("Saliste del programa");
                    break;
                default:
                    break;
            }
            System.out.println("¿Desea realizar otra operacion? (s/n): ");
            opc = scanner.nextLine();
        }while (opc.equalsIgnoreCase("S"));
        scanner.close();
    }
}