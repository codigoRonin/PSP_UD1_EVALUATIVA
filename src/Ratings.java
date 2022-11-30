
public class Ratings {

	public static void main(String[] args) {
		int aprobadas = 0;
		if (args.length == 0){
			System.err.println("Debes introducir al menos una nota");
			System.exit(-1);
		}
		String calificaciones[] = args[0].split(" ");
		for (int i = 0; i < calificaciones.length; i++) {
			try {
				if (Integer.parseInt(calificaciones[i]) >= 5)
					aprobadas++;
			} catch (NumberFormatException e) {
				System.err.println("Todos las notas deben ser números enteros");
				System.exit(-1);
			}

		}

		if (aprobadas == calificaciones.length) {
			System.out.println("Enhorabuena todo aprobado");

		} else if (aprobadas == 0) {
			System.out.println("Dedicate a otra cosa");

		} else {
			System.out.println("Toca aplicarse no tienes todo aprobado");

		}
	}
}
