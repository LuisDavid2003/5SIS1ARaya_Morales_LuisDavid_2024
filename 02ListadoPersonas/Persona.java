import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Persona {

    private static List<Persona> personas = new ArrayList<>();
    private static int idCount = 1; // Variable para asignar automáticamente IDs

    private int id;
    private String nombre;
    private int edad;

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        registrarPersona(scanner);
                        break;
                    case 2:
                        mostrarPersonas();
                        break;
                    case 3:
                        eliminarPersona(scanner);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                opcion = -1;
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Registrar Persona");
        System.out.println("2. Mostrar Personas");
        System.out.println("3. Eliminar Persona");
        System.out.println("0. Salir");
        System.out.print("Ingrese la opción: ");
    }

    private static void registrarPersona(Scanner scanner) {
        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        personas.add(new Persona(id, nombre, edad));
        System.out.println("Persona registrada exitosamente.");
    }

    private static void mostrarPersonas() {
        System.out.println("Personas Registradas:");
        for (Persona persona : personas) {
            System.out.println("ID: " + persona.getId() + ", Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
        }
    }

    private static void eliminarPersona(Scanner scanner) {
        System.out.print("Ingrese el ID de la persona a eliminar: ");
        if (scanner.hasNextInt()) {
            int idEliminacion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            Iterator<Persona> iterator = personas.iterator();
            while (iterator.hasNext()) {
                Persona persona = iterator.next();
                if (persona.getId() == idEliminacion) {
                    iterator.remove();
                    System.out.println("Persona eliminada exitosamente.");
                    return;
                }
            }

            System.out.println("Persona no encontrada.");
        } else {
            System.out.println("Por favor, ingrese un ID válido.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
    }
}



}
