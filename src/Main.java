import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static final int CONVERTIR_A_ROMANO = 1;
	private static final int CREAR_FICHERO_USUARIO = 2;
	private static final int COMPROBAR_NOTAS = 3;
	private static final int HACER_PING = 4;
	private static final int SALIR = 5;

	public static void main(String[] args) {
		int opcion = -1;
		Scanner stdin = new Scanner(System.in);

		do {
			try {
				opcion = printMenu(stdin);
				doMenu(stdin, opcion);
			} catch (InputMismatchException e) {
				System.err.println("Debe seleccionar una opción adecuada, un numero entre 1 y 5");
				stdin = new Scanner(System.in);
			}
		} while (opcion != SALIR);

		stdin.close();

	}

	private static void doMenu(Scanner stdin, int opcion) {

		switch (opcion) {
			case CONVERTIR_A_ROMANO:
				intToRoman(stdin);
				break;
			case CREAR_FICHERO_USUARIO:
				userFile(stdin);
				break;
			case COMPROBAR_NOTAS:
				ratings(stdin);
				break;
			case HACER_PING:
				ping(stdin);
				break;
			case SALIR:
				System.out.println("\nHasta pronto!!!");
				break;
			default:
				System.err.println("Debe seleccionar una opción adecuada, un número entre 1 y 5");
				break;
		}

	}

	private static int printMenu(Scanner stdin) {

		System.out.print("\nAFIANZANDO PROCESOS [Evaluable]\n" +
				"-------------------------------\n" +
				"1. Convertir a números romanos\n" +
				"2. Crear fichero de usuario\n" +
				"3. Comprobar calificaciones\n" +
				"4. Hacer Ping\n" +
				"5. Salir\n\n" +
				"Seleccione una opción (1-5): ");

		return stdin.nextInt();
	}

	private static void pressAnyKeyToContinue() {
		System.out.println("Pulse cualquier tecla para continuar");
		try {
			/*
			 * El método System.in.read() lee un caracter y devuelve el caracter leido o
			 * bien -1 si no hay más caracteres por leer.
			 * La lectura de la entrada estandar bloquea la ejecución del programa hasta que
			 * tiene una indicación de que la entrada esta completa (carácter de fin de
			 * entrada).
			 */
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void intToRoman(Scanner stdin) {
		stdin.nextLine();
		System.out.println("Introduzca un número entero del 1 al 3999");
		String inputString = stdin.next();
		ProcessBuilder pb = new ProcessBuilder("java", "IntToRoman", inputString);
		pb.directory(new File("./bin"));
		Process p;
		try {
			InputStream is = null;
			int c = 0;
			p = pb.start();
			int exitValue = p.waitFor();
			if (exitValue != 0) {
				is = p.getErrorStream();
				while ((c = is.read()) != -1) {
					System.err.print((char) c);
				}

			} else {
				is = p.getInputStream();
				while ((c = is.read()) != -1) {
					System.out.print((char) c);
				}
			}
			is.close();
			p.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pressAnyKeyToContinue();
	}

	private static void userFile(Scanner stdin) {
		stdin.nextLine();
		String name, surname, bYear;
		System.out.print("Introduzca su nombre: ");
		name = stdin.nextLine();
		System.out.print("Introduzca su apellido: ");
		surname = stdin.nextLine();
		System.out.print("Introduzca su anio de nacimiento: ");
		bYear = stdin.nextLine();
		String outputFileName = name + "_" + surname + ".txt";
		String errorFileName = "[ERROR]" + name + "_" + surname + ".txt";
		ProcessBuilder pb = new ProcessBuilder("java", "UserFile");
		pb.directory(new File("./bin"));
		pb.redirectError(new File("./resources/" + errorFileName));
		pb.redirectOutput(new File("./resources/" + outputFileName));
		try {
			Process p = pb.start();
			OutputStream os = p.getOutputStream();
			name += "\n";
			surname += "\n";
			bYear += "\n";
			os.write(name.getBytes());
			os.write(surname.getBytes());
			os.write(bYear.getBytes());
			os.flush();
			os.close();
			p.waitFor();
			p.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void ratings(Scanner stdin) {
		stdin.nextLine();
		String inputString;
		String notas = "";
		System.out.println("Introduzca sus notas para finalizar pulse *");
		while (!(inputString = stdin.nextLine()).equals("*")) {
			notas += inputString + " ";
		}

		ProcessBuilder pb = new ProcessBuilder("java", "Ratings", notas);
		pb.directory(new File("./bin"));
		Process p = null;

		try {
			InputStream is = null;
			int c = 0;
			p = pb.start();
			int exitValue = p.waitFor();
			if (exitValue != 0) {
				is = p.getErrorStream();
				while ((c = is.read()) != -1) {
					System.err.print((char) c);
				}
			} else {
				is = p.getInputStream();
				while ((c = is.read()) != -1) {
					System.out.print((char) c);
				}
			}
			System.out.println();
			is.close();
			p.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pressAnyKeyToContinue();
	}

	private static void ping(Scanner stdin) {
		stdin.nextLine();
		String name;
		int times = 0;
		System.out.print("Introduzca una dirección: ");
		name = stdin.nextLine();
		System.out.println("Introduzca un número entero:");
		try {
			times = stdin.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Debe introducir un número entero");
		}
		ProcessBuilder pb = new ProcessBuilder("java", "Ping", name);
		pb.directory(new File("./bin"));
		for (int i = 0; i < times; i++) {
			try {
				Process p = pb.start();
				InputStream is = null;
				int c = 0;
				p = pb.start();
				int exitValue = p.waitFor();
				if (exitValue != 0) {
					is = p.getErrorStream();
					while ((c = is.read()) != -1) {
						System.err.print((char) c);
					}
				} else {
					is = p.getInputStream();
					while ((c = is.read()) != -1) {
						System.out.print((char) c);
					}
				}
				is.close();
				System.out.println();
				p.destroy();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		pressAnyKeyToContinue();
	}

}
