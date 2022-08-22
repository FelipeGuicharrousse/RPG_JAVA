
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a The legend of Morio");
        System.out.println("Comenzaras como el Dungeon Master");
        System.out.println("Esto significa que primero crearas el mundo");
        System.out.println("Te preguntare terreno por terreno las caracteristicas de este");
        System.out.println("Primero ingresa el tamaño del mundo");
        Scanner entradaEscaner = new Scanner(System.in); 
        int tamano_mundo = entradaEscaner.nextInt();
        entradaEscaner.nextLine(); 
        System.out.println();
        System.out.println();
        List<Tierra> mundo;
        mundo = new ArrayList<Tierra>();
        //----------------------------------
        // Aqui comienza a crearse el mundo
        for (int posicion_tierra = 0; posicion_tierra < tamano_mundo; posicion_tierra++) {
            System.out.println("¿Qué tipo de tierra es?");
            System.out.println("    1. Montaña");
            System.out.println("    2. Planicie");
            System.out.println("    3. Bosque");
            int respuesta;
            
            respuesta = entradaEscaner.nextInt();
            entradaEscaner.nextLine();
            System.out.println("La probabilidad de que un Enemigo aparezca");

            float probabilidad = entradaEscaner.nextFloat();
            Tierra casilla = null;

            if (respuesta == 1){
                casilla = new Montana(probabilidad);
            } else if(respuesta == 2){
                casilla = new Planicie(probabilidad);
            }else {
                casilla = new Bosque(probabilidad);
            }

            System.out.println("Qué tipo de Enemigo podría aparecer");
            System.out.println("    1. Monstruo");
            System.out.println("    2. Jefe Final");
            int enemigo = entradaEscaner.nextInt();
            entradaEscaner.nextLine();

            switch (enemigo) {
                case 1:
                    System.out.println("Ingresar la vida del Monstruo");
                    int vida_monstruo = entradaEscaner.nextInt();
                    entradaEscaner.nextLine();
                    System.out.println("Ingresar el daño del Monstruo");
                    int dano_monstruo = entradaEscaner.nextInt();
                    entradaEscaner.nextLine();
                    casilla.set_monstruo(vida_monstruo, dano_monstruo);
                    break;
                
                case 2:
                    System.out.println("Ingresar el nombre del Jefe Final");
                    String nombre_jefe_final = entradaEscaner.nextLine();
                    System.out.println("Ingresar la vida del Jefe Final");
                    int vida = entradaEscaner.nextInt();
                    entradaEscaner.nextLine();
                    System.out.println("Ingresar el daño del Jefe Final");
                    int dano_base = entradaEscaner.nextInt();
                    entradaEscaner.nextLine();
                    casilla.set_jefe_final(dano_base, vida, nombre_jefe_final);
                    break;
            }

            System.out.println("Habra un NPC en la casilla?");
            System.out.println("    1. Si");
            System.out.println("    2. No");
            int npc = entradaEscaner.nextInt();
            entradaEscaner.nextLine();

            if (npc == 1) {
                System.out.println("Que tipo de NPC sera");
                System.out.println("    1. Bueno");
                System.out.println("    2. Malo");
                System.out.println("    3. Neutro");
                int tipo = entradaEscaner.nextInt();
                entradaEscaner.nextLine();

                System.out.println("Ingresar el nombre del NPC");
                String nombre = entradaEscaner.nextLine();
                if (tipo == 1) {

                    System.out.println("Ingresar el atributo del NPC");
                    System.out.println("    vida");
                    System.out.println("    xp");
                    System.out.println("    energia");
                    System.out.println("    mana");
                    String atributo = entradaEscaner.nextLine();

                    System.out.println("Ingresar la cantidad de " + atributo + " a incrementar");
                    int cantidad = entradaEscaner.nextInt();
                    entradaEscaner.nextLine();

                    casilla.set_npc_bueno(nombre, atributo, cantidad);
                } else if (tipo == 2){
                
                    System.out.println("Ingresar la cantidad de energia a disminuiur");
                    int cantidad_energia = entradaEscaner.nextInt(); 
                    entradaEscaner.nextLine();

                    System.out.println("Ingresar la cantidad de mana a disminuiur");
                    int cantidad_mana = entradaEscaner.nextInt(); 
                    entradaEscaner.nextLine();
                    casilla.set_npc_malo(nombre, cantidad_energia, cantidad_mana);
                } else {
    

                    System.out.println("Ingresar el requisito de la mision");
                    System.out.println("    v) LLegar a una cordenada especifica");
                    System.out.println("    m) Matar a un numero determinado de monstruos");
                    char requisito = entradaEscaner.next().charAt(0);

                    if (requisito == 'v'){
                        System.out.println("Ingresar la coordenada especifica");
                    } else {
                        System.out.println("Ingresar la cantidad a matar");
                    }
                    int valor = entradaEscaner.nextInt();
                    entradaEscaner.nextLine();

                    System.out.println("Ingresar la cantidad de XP a ganar por la mision");
                    int recompensa = entradaEscaner.nextInt();
                    entradaEscaner.nextLine();

                    casilla.set_npc_neutro(nombre, requisito, valor, recompensa);
                }
            }

            casilla.set_posicion_tierra(posicion_tierra);
            mundo.add(casilla);
            
            System.out.println();
        }

        //FIN DE LA CREACION DEL MUNDO
        //----------------------------

        System.out.println();
        System.out.println("Ahora crearemos a tu personaje!!");
        System.out.println("Hay 3 tipos de clases para jugar. Selecciona una");
        System.out.println("    1. Guerrero");
        System.out.println("    2. Mago");
        System.out.println("    3. Druida");
        int tipo_jugador = entradaEscaner.nextInt();
        entradaEscaner.nextLine();
        System.out.println("Ingrese el nombre del Jugador");
        String nombre_jugador = entradaEscaner.nextLine();

        Jugador jugador = null;

        if (tipo_jugador == 1) {
            jugador = new Guerrero(nombre_jugador);
        } else if (tipo_jugador == 2) {
            jugador = new Mago(nombre_jugador);
        } else {
            jugador = new Druida(nombre_jugador);
        }

        System.out.println("Ingresar la posicion a iniciar");
        System.out.println("Recuerde que las posiciones van desde el 0 al " + (tamano_mundo-1));
        int posicion = entradaEscaner.nextInt();
        
        jugador.set_posicion(posicion);

        if (mundo.get(posicion).accion(jugador) == false){
            if (jugador.get_vida() <= 0) {
                System.out.println("FIN DEL JUEGO");
            } else {
                System.out.println("No pudiste llegar a esta casilla :c");
            }
        }

        while (jugador.get_ganar() != 1 && jugador.get_vida() > 0){
            
            if (posicion == 0){
                System.out.println("Hacia donde te quieres mover");
                System.out.println("    1. Izquierda");
                System.out.println("    2. Derecha");
                int eleccion = entradaEscaner.nextInt();
                entradaEscaner.nextLine();
                if (eleccion == 1) {
                    posicion = tamano_mundo-1;
                } else {
                    if (tamano_mundo == 1){
                        posicion = 0;
                    }else {
                        posicion++;
                    }
                    
                }
            } else if (posicion == tamano_mundo-1) {
                System.out.println("Hacia donde te quieres mover");
                System.out.println("    1. Izquierda");
                System.out.println("    2. Derecha");
                int eleccion = entradaEscaner.nextInt();
                entradaEscaner.nextLine();
                if (eleccion == 1) {
                    posicion--;
                } else {
                    posicion = 0;
                }
            } else {
                System.out.println("Hacia donde te quieres mover");
                System.out.println("    1. Izquierda");
                System.out.println("    2. Derecha");
                int eleccion = entradaEscaner.nextInt();
                entradaEscaner.nextLine();
                if (eleccion == 1){
                    posicion--;
                } else {
                    posicion++;
                }
                
            }

            if (mundo.get(posicion).accion(jugador) == false){
                if (jugador.get_vida() <= 0) {
                    System.out.println("FIN DEL JUEGO");
                    break;
                } else {
                    System.out.println("No pudiste llegar a esta casilla :c");
                    continue;
                }
            }
            if (jugador.get_ganar() == 1) {
                break;
            }
        }

        entradaEscaner.close();

    }

}