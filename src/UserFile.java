import java.util.Scanner;

public class UserFile {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String name, surname, bYear, outputString;

		name = stdin.nextLine();
		surname = stdin.nextLine();
		bYear = stdin.nextLine();
		
		stdin.close();
		if (name.trim().length() < 1 || surname.trim().length() < 1 || bYear.trim().length() < 1) {
			System.err.println("La información proporcionada no es correcta");
			System.exit(-1);
		}
		try {
			Integer.parseInt(bYear);
		} catch (NumberFormatException e) {
			System.err.println("La información proporcionada no es correcta");
			System.exit(-1);
		}

		outputString = "______________\r\n" +
				"||   NEW USER  ||\r\n" +
				"---------------\r\n" +
				"\r\n" +
				"Name: " + name + "\r\n" +
				"Surname: " + surname + "\r\n" +
				"Birth date: " + bYear + "\r\n" +
				"---------------\r\n" +
				"";
		System.out.println(outputString);

	}

}
