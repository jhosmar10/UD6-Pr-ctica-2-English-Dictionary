import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);

        Diccionario diccionario = new Diccionario();
        System.out.println("¡Bienvenido al diccionario de Duolingo!");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Añadir palabra");
            System.out.println("2. Eliminar palabra");
            System.out.println("3. Existe palabra");
            System.out.println("4. Mostrar iniciales disponibles");
            System.out.println("5. Ver palabras por inicial");
            System.out.println("6. Cerrar programa");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el entero

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la palabra a añadir:");
                    String palabraAñadir = scanner.nextLine();
                    diccionario.añadirPalabra(palabraAñadir);
                    System.out.println("Palabra añadida correctamente.");
                    break;
                case 2:
                    System.out.println("Ingrese la palabra a eliminar:");
                    String palabraEliminar = scanner.nextLine();
                    if (diccionario.eliminarPalabra(palabraEliminar)) {
                        System.out.println("Palabra eliminada correctamente.");
                    } else {
                        System.out.println("La palabra no estaba en el diccionario.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la palabra a buscar:");
                    String palabraBuscar = scanner.nextLine();
                    if (diccionario.existePalabra(palabraBuscar)) {
                        System.out.println("La palabra está en el diccionario.");
                    } else {
                        System.out.println("La palabra no está en el diccionario.");
                    }
                    break;
                case 4:
                    System.out.println("Iniciales disponibles:");
                    Set<Character> iniciales = diccionario.getInicialesDisponibles();
                    for (char inicial : iniciales) {
                        System.out.print(inicial + " ");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Ingrese la inicial:");
                    char inicial = scanner.nextLine().charAt(0);
                    Set<String> palabrasIniciales = diccionario.getPalabrasPorInicial(inicial);
                    System.out.println("Palabras que empiezan con '" + inicial + "': " + palabrasIniciales);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}
