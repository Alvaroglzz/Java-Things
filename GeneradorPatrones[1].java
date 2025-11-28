package com.mycompany.proyectosalvaro;

import java.util.Scanner;

public class GeneradorPatrones {
    
    // Colores ANSI para terminal (opcional, puede no funcionar en todos los terminales)
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    
    /**
     * Genera un rombo con el tamano especificado
     * @param tamano Altura del rombo (debe ser impar para mejor resultado)
     */
    public void generarRombo(int tamano) {
        if (tamano <= 0) {
            System.out.println("Error: El tamano debe ser positivo.");
            return;
        }
        
        // Asegurar que sea impar para simetria perfecta
        if (tamano % 2 == 0) {
            tamano++;
        }
        
        int mitad = tamano / 2;
        
        System.out.println("\n" + BOLD + "=== ROMBO (Tamano: " + tamano + ") ===" + RESET);
        
        // Parte superior del rombo (incluyendo el centro)
        for (int i = 0; i <= mitad; i++) {
            // Calcular espacios iniciales usando formula matematica
            int espacios = mitad - i;
            int asteriscos = 2 * i + 1;
            
            // Imprimir espacios
            for (int j = 0; j < espacios; j++) {
                System.out.print(" ");
            }
            
            // Imprimir asteriscos
            for (int k = 0; k < asteriscos; k++) {
                // Alternar entre asteriscos solidos y huecos
                if (i == 0 || i == mitad || k == 0 || k == asteriscos - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
        }
        
        // Parte inferior del rombo
        for (int i = mitad - 1; i >= 0; i--) {
            int espacios = mitad - i;
            int asteriscos = 2 * i + 1;
            
            for (int j = 0; j < espacios; j++) {
                System.out.print(" ");
            }
            
            for (int k = 0; k < asteriscos; k++) {
                if (i == 0 || k == 0 || k == asteriscos - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
        }
    }
    
    /**
     * Genera un rombo solido (sin huecos)
     * @param tamano Altura del rombo
     */
    public void generarRomboSolido(int tamano) {
        if (tamano <= 0) {
            System.out.println("Error: El tamano debe ser positivo.");
            return;
        }
        
        if (tamano % 2 == 0) {
            tamano++;
        }
        
        int mitad = tamano / 2;
        
        System.out.println("\n" + BOLD + "=== ROMBO SOLIDO (Tamano: " + tamano + ") ===" + RESET);
        
        // Parte superior
        for (int i = 0; i <= mitad; i++) {
            for (int j = 0; j < mitad - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Parte inferior
        for (int i = mitad - 1; i >= 0; i--) {
            for (int j = 0; j < mitad - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    /**
     * Genera un tablero de ajedrez con las dimensiones especificadas
     * @param filas Numero de filas
     * @param columnas Numero de columnas
     */
    public void generarTableroAjedrez(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) {
            System.out.println("Error: Las dimensiones deben ser positivas.");
            return;
        }
        
        System.out.println("\n" + BOLD + "=== TABLERO DE AJEDREZ (" + filas + "x" + columnas + ") ===" + RESET);
        
        // Borde superior
        imprimirBordeHorizontal(columnas);
        
        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            
            for (int j = 0; j < columnas; j++) {
                // Usar operador modulo para alternar
                // Si la suma de indices es par, casilla blanca; si impar, casilla negra
                if ((i + j) % 2 == 0) {
                    System.out.print("   |"); // Casilla blanca (3 espacios)
                } else {
                    System.out.print("###|"); // Casilla negra (3 caracteres)
                }
            }
            
            System.out.println();
            
            // Separador entre filas
            if (i < filas - 1) {
                imprimirSeparadorFila(columnas);
            }
        }
        
        // Borde inferior
        imprimirBordeHorizontal(columnas);
    }
    
    /**
     * Imprime el borde horizontal del tablero
     * @param columnas Numero de columnas
     */
    private void imprimirBordeHorizontal(int columnas) {
        System.out.print("+");
        for (int i = 0; i < columnas; i++) {
            System.out.print("---+");
        }
        System.out.println();
    }
    
    /**
     * Imprime el separador entre filas del tablero
     * @param columnas Numero de columnas
     */
    private void imprimirSeparadorFila(int columnas) {
        System.out.print("|");
        for (int i = 0; i < columnas; i++) {
            System.out.print("---|");
        }
        System.out.println();
    }
    
    /**
     * Genera patrones personalizados con diferentes estilos
     * @param simbolo El simbolo a usar en el patron
     * @param repeticiones Numero de repeticiones o tamano
     */
    public void patronPersonalizado(String simbolo, int repeticiones) {
        if (simbolo == null || simbolo.isEmpty()) {
            simbolo = "*";
        }
        
        if (repeticiones <= 0) {
            System.out.println("Error: Las repeticiones deben ser positivas.");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n" + BOLD + "=== PATRON PERSONALIZADO ===" + RESET);
        System.out.println("Selecciona el estilo de patron:");
        System.out.println("1. Piramide");
        System.out.println("2. Piramide Invertida");
        System.out.println("3. Triangulo Rectangulo");
        System.out.println("4. Escalera Ascendente");
        System.out.println("5. Escalera Descendente");
        System.out.println("6. Cruz");
        System.out.println("7. Circulo (aproximado)");
        System.out.println("8. Corazon");
        System.out.println("9. Flecha");
        System.out.println("10. Ondas");
        System.out.print("\nElige una opcion (1-10): ");
        
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                generarPiramide(simbolo, repeticiones);
                break;
                
            case 2:
                generarPiramideInvertida(simbolo, repeticiones);
                break;
                
            case 3:
                generarTrianguloRectangulo(simbolo, repeticiones);
                break;
                
            case 4:
                generarEscaleraAscendente(simbolo, repeticiones);
                break;
                
            case 5:
                generarEscaleraDescendente(simbolo, repeticiones);
                break;
                
            case 6:
                generarCruz(simbolo, repeticiones);
                break;
                
            case 7:
                generarCirculo(simbolo, repeticiones);
                break;
                
            case 8:
                generarCorazon(simbolo, repeticiones);
                break;
                
            case 9:
                generarFlecha(simbolo, repeticiones);
                break;
                
            case 10:
                generarOndas(simbolo, repeticiones);
                break;
                
            default:
                System.out.println("Opcion no valida. Generando piramide por defecto...");
                generarPiramide(simbolo, repeticiones);
                break;
        }
    }
    
    /**
     * Genera una piramide
     */
    private void generarPiramide(String simbolo, int altura) {
        System.out.println("\n--- Piramide ---");
        
        for (int i = 0; i < altura; i++) {
            // Espacios iniciales
            for (int j = 0; j < altura - i - 1; j++) {
                System.out.print(" ");
            }
            
            // Simbolos
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print(simbolo);
            }
            
            System.out.println();
        }
    }
    
    /**
     * Genera una piramide invertida
     */
    private void generarPiramideInvertida(String simbolo, int altura) {
        System.out.println("\n--- Piramide Invertida ---");
        
        for (int i = altura - 1; i >= 0; i--) {
            for (int j = 0; j < altura - i - 1; j++) {
                System.out.print(" ");
            }
            
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print(simbolo);
            }
            
            System.out.println();
        }
    }
    
    /**
     * Genera un triangulo rectangulo
     */
    private void generarTrianguloRectangulo(String simbolo, int altura) {
        System.out.println("\n--- Triangulo Rectangulo ---");
        
        for (int i = 1; i <= altura; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(simbolo + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Genera una escalera ascendente
     */
    private void generarEscaleraAscendente(String simbolo, int niveles) {
        System.out.println("\n--- Escalera Ascendente ---");
        
        int espacios = 0;
        for (int i = 0; i < niveles; i++) {
            // Espacios antes del escalon
            for (int j = 0; j < espacios; j++) {
                System.out.print(" ");
            }
            
            // Escalon (3 simbolos de ancho)
            for (int k = 0; k < 3; k++) {
                System.out.print(simbolo);
            }
            
            System.out.println();
            espacios += 2;
        }
    }
    
    /**
     * Genera una escalera descendente
     */
    private void generarEscaleraDescendente(String simbolo, int niveles) {
        System.out.println("\n--- Escalera Descendente ---");
        
        int espacios = niveles * 2 - 2;
        for (int i = 0; i < niveles; i++) {
            for (int j = 0; j < espacios; j++) {
                System.out.print(" ");
            }
            
            for (int k = 0; k < 3; k++) {
                System.out.print(simbolo);
            }
            
            System.out.println();
            espacios -= 2;
        }
    }
    
    /**
     * Genera una cruz
     */
    private void generarCruz(String simbolo, int tamano) {
        System.out.println("\n--- Cruz ---");
        
        if (tamano % 2 == 0) {
            tamano++;
        }
        
        int mitad = tamano / 2;
        
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                // Dibujar cruz: linea vertical u horizontal en el centro
                if (i == mitad || j == mitad) {
                    System.out.print(simbolo);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Genera un circulo aproximado usando ASCII
     */
    private void generarCirculo(String simbolo, int radio) {
        System.out.println("\n--- Circulo (aproximado) ---");
        
        int diametro = 2 * radio;
        
        for (int i = 0; i <= diametro; i++) {
            for (int j = 0; j <= diametro; j++) {
                // Calcular distancia desde el centro usando formula de distancia euclidiana
                double distancia = Math.sqrt(Math.pow(i - radio, 2) + Math.pow(j - radio, 2));
                
                // Si la distancia esta cerca del radio, dibujar el simbolo
                if (Math.abs(distancia - radio) < 0.5) {
                    System.out.print(simbolo);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Genera un corazon ASCII
     */
    private void generarCorazon(String simbolo, int tamano) {
        System.out.println("\n--- Corazon ---");
        
        // Parte superior (dos semicirculos)
        for (int i = tamano / 2; i < tamano; i += 2) {
            // Espacios iniciales
            for (int j = 1; j < tamano - i; j += 2) {
                System.out.print(" ");
            }
            
            // Primer semicirculo
            for (int j = 1; j < i + 1; j++) {
                System.out.print(simbolo);
            }
            
            // Espacio entre semicirculos
            for (int j = 1; j < tamano - i + 1; j++) {
                System.out.print(" ");
            }
            
            // Segundo semicirculo
            for (int j = 1; j < i + 1; j++) {
                System.out.print(simbolo);
            }
            
            System.out.println();
        }
        
        // Parte inferior (triangulo invertido)
        for (int i = tamano; i > 0; i--) {
            for (int j = 0; j < tamano - i; j++) {
                System.out.print(" ");
            }
            
            for (int j = 1; j < i * 2; j++) {
                System.out.print(simbolo);
            }
            
            System.out.println();
        }
    }
    
    /**
     * Genera una flecha
     */
    private void generarFlecha(String simbolo, int longitud) {
        System.out.println("\n--- Flecha ---");
        
        // Punta de la flecha
        for (int i = 0; i < longitud; i++) {
            for (int j = 0; j < longitud - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(simbolo);
            }
            System.out.println();
        }
        
        // Cuerpo de la flecha
        int espacios = 1;
        for (int i = 0; i < longitud; i++) {
            for (int j = 0; j < espacios; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < longitud - 2; k++) {
                System.out.print(simbolo);
            }
            System.out.println();
        }
    }
    
    /**
     * Genera un patron de ondas sinusoidales
     */
    private void generarOndas(String simbolo, int longitud) {
        System.out.println("\n--- Ondas ---");
        
        int amplitud = 5;
        int contador = 0;
        
        while (contador < longitud) {
            // Calcular posicion vertical usando funcion seno
            int posicion = (int) (amplitud * Math.sin(contador * 0.5) + amplitud);
            
            // Imprimir espacios hasta la posicion
            for (int i = 0; i < posicion; i++) {
                System.out.print(" ");
            }
            
            System.out.println(simbolo);
            contador++;
        }
    }
    
    /**
     * Menu principal interactivo
     */
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println(BOLD + "     GENERADOR DE PATRONES ASCII ART" + RESET);
            System.out.println("=".repeat(60));
            System.out.println("1. Generar Rombo");
            System.out.println("2. Generar Rombo Solido");
            System.out.println("3. Generar Tablero de Ajedrez");
            System.out.println("4. Patron Personalizado");
            System.out.println("5. Galeria de Patrones (Todos)");
            System.out.println("0. Salir");
            System.out.println("=".repeat(60));
            System.out.print("Selecciona una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    System.out.print("\nIngresa el tamano del rombo: ");
                    int tamanoRombo = scanner.nextInt();
                    generarRombo(tamanoRombo);
                    break;
                    
                case 2:
                    System.out.print("\nIngresa el tamano del rombo solido: ");
                    int tamanoSolido = scanner.nextInt();
                    generarRomboSolido(tamanoSolido);
                    break;
                    
                case 3:
                    System.out.print("\nIngresa el numero de filas: ");
                    int filas = scanner.nextInt();
                    System.out.print("Ingresa el numero de columnas: ");
                    int columnas = scanner.nextInt();
                    generarTableroAjedrez(filas, columnas);
                    break;
                    
                case 4:
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("\nIngresa el simbolo a usar: ");
                    String simbolo = scanner.nextLine();
                    System.out.print("Ingresa el tamano/repeticiones: ");
                    int repeticiones = scanner.nextInt();
                    patronPersonalizado(simbolo, repeticiones);
                    break;
                    
                case 5:
                    mostrarGaleria();
                    break;
                    
                case 0:
                    continuar = false;
                    System.out.println("\nGracias por usar el Generador de Patrones ASCII!");
                    break;
                    
                default:
                    System.out.println("\nOpcion no valida. Intenta de nuevo.");
                    break;
            }
            
            if (continuar && opcion != 0) {
                System.out.print("\nPresiona Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra una galeria con todos los patrones
     */
    private void mostrarGaleria() {
        System.out.println("\n" + BOLD + "=== GALERIA DE PATRONES ===" + RESET);
        
        generarRombo(7);
        generarTableroAjedrez(4, 4);
        generarPiramide("*", 5);
        generarCorazon("♥", 6);
    }
    
    // Metodo main
    public static void main(String[] args) {
        GeneradorPatrones generador = new GeneradorPatrones();
        generador.menuPrincipal();
    }
}