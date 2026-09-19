import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Personaje> personajes = new ArrayList<>();
        int opcion = 0;

        do {
            try {
                System.out.println("========== MENU DEL VIDEOJUEGO==========");
                System.out.println("1. Registrar personaje");
                System.out.println("2. Mostrar personajes");
                System.out.println("3. Buscar personaje por id");
                System.out.println("4. Salir");
                System.out.print("Ingrese una opcion: ");
                
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Elegir tipo (1=Guerrero, 2=Mago): ");
                        int tipo = sc.nextInt();
                        if (tipo != 1 & tipo != 2) {
                            System.out.println("Tipo no valido.");
                            break;
                        }

                        System.out.print("Ingresar ID: ");
                        int id = sc.nextInt();
                        System.out.print("Ingresar Nombre: ");
                        String nombre = sc.next();
                        System.out.print("Ingresar Nivel (1-100): ");
                        int nivel = sc.nextInt();

                        if (id <= 0 | nombre.isEmpty() | nivel < 1 | nivel > 100) {
                            System.out.println("Incorrecto. No se pudo registrar personaje");
                            break;
                        }

                        if (tipo == 1) {
                            personajes.add(new Guerrero(id, nombre, nivel));
                        } else {
                            personajes.add(new Mago(id, nombre, nivel));
                        }
                        System.out.println("El personaje se registro exitosamente");
                        break;

                    case 2:
                        if (personajes.isEmpty()) {
                            System.out.println("La lista esta vacia.");
                        } else {
                            for (Personaje p : personajes) {
                                p.mostrarInfo();
                                System.out.println("Accion: " + p.realizarAccion());
                            }
                        }
                        break;

                    case 3:
                        if (personajes.isEmpty()) {
                            System.out.println("La lista esta vacia.");
                            break;
                        }
                        System.out.print("Ingrese Id a buscar: ");
                        int idBuscar = sc.nextInt();
                        boolean encontrado = false;

                        for (Personaje p : personajes) {
                            if (p.getId() == idBuscar) {
                                p.mostrarInfo();
                                System.out.println("Accion: " + p.realizarAccion());
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Personaje no encontrado");
                        }
                        break;

                    case 4:
                        System.out.println("Acabando el videojuego...chao");
                        break;

                    default:
                        System.out.println("Opcion invalida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingreso invalido. Debe escribir un numero.");
                sc.nextLine();
            }
        } while (opcion != 4);

        sc.close();
    }
}