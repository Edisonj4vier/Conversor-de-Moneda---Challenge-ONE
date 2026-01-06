import Service.ConsultaApi;

import java.util.Scanner;

public class Main {
    private static ConsultaApi servicioAPI = new ConsultaApi();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("   CONVERSOR DE MONEDAS");
        System.out.println("===========================================\n");

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    convertirDolarAPeso();
                    break;
                case 2:
                    convertirPesoADolar();
                    break;
                case 3:
                    convertirDolarAPesoArgentino();
                    break;
                case 4:
                    convertirPesoArgentinoADolar();
                    break;
                case 5:
                    convertirDolarAReal();
                    break;
                case 6:
                    convertirRealADolar();
                    break;
                case 7:
                    conversionPersonalizada();
                    break;
                case 8:
                    continuar = false;
                    System.out.println("\n¡Gracias por usar el conversor! Hasta pronto.");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intenta de nuevo.\n");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("Selecciona una opción:");
        System.out.println("1. Dólar (USD) → Peso Colombiano (COP)");
        System.out.println("2. Peso Colombiano (COP) → Dólar (USD)");
        System.out.println("3. Dólar (USD) → Peso Argentino (ARS)");
        System.out.println("4. Peso Argentino (ARS) → Dólar (USD)");
        System.out.println("5. Dólar (USD) → Real Brasileño (BRL)");
        System.out.println("6. Real Brasileño (BRL) → Dólar (USD)");
        System.out.println("7. Conversión personalizada");
        System.out.println("8. Salir");
        System.out.print("\nTu opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void convertirDolarAPeso() {
        realizarConversion("USD", "COP", "Dólar", "Peso Colombiano");
    }

    private static void convertirPesoADolar() {
        realizarConversion("COP", "USD", "Peso Colombiano", "Dólar");
    }

    private static void convertirDolarAPesoArgentino() {
        realizarConversion("USD", "ARS", "Dólar", "Peso Argentino");
    }

    private static void convertirPesoArgentinoADolar() {
        realizarConversion("ARS", "USD", "Peso Argentino", "Dólar");
    }

    private static void convertirDolarAReal() {
        realizarConversion("USD", "BRL", "Dólar", "Real Brasileño");
    }

    private static void convertirRealADolar() {
        realizarConversion("BRL", "USD", "Real Brasileño", "Dólar");
    }

    private static void conversionPersonalizada() {
        System.out.print("\nIngresa el código de la moneda origen (ej: USD, EUR, JPY): ");
        String monedaOrigen = scanner.nextLine().toUpperCase();

        System.out.print("Ingresa el código de la moneda destino: ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        realizarConversion(monedaOrigen, monedaDestino, monedaOrigen, monedaDestino);
    }

    private static void realizarConversion(String codigoOrigen, String codigoDestino,
                                           String nombreOrigen, String nombreDestino) {
        System.out.print("\nIngresa la cantidad en " + nombreOrigen + ": ");

        try {
            double cantidad = Double.parseDouble(scanner.nextLine());

            if (cantidad < 0) {
                System.out.println("\nLa cantidad no puede ser negativa.\n");
                return;
            }

            System.out.println("\nConvirtiendo...");
            double resultado = servicioAPI.convertirMoneda(codigoOrigen, codigoDestino, cantidad);
            double tasa = servicioAPI.obtenerTasa(codigoOrigen, codigoDestino);

            System.out.println("\n===========================================");
            System.out.printf("%.2f %s = %.2f %s%n", cantidad, codigoOrigen, resultado, codigoDestino);
            System.out.printf("Tasa de cambio: 1 %s = %.4f %s%n", codigoOrigen, tasa, codigoDestino);
            System.out.println("===========================================\n");

        } catch (NumberFormatException e) {
            System.out.println("\nEntrada inválida. Ingresa un número válido.\n");
        } catch (Exception e) {
            System.out.println("\nError al realizar la conversión: " + e.getMessage());
            System.out.println("Verifica que los códigos de moneda sean válidos.\n");
        }
    }
}