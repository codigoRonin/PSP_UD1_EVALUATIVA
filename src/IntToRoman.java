public class IntToRoman {
    public static void main(String[] args) {
        int entero = 0;
        if (args.length == 0){
			System.err.println("Debes introducir al menos un número entero");
			System.exit(-1);
		}
        try {
            entero = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Solo convertimos a romano números enteros del 1 al 3999.");
            System.exit(-1);

        }
        if (entero < 1 || entero > 3999) {
            System.err.println("Solo convertimos a romano números del 1 al 3999.");
            System.exit(-1);
        }

        System.out.println(intToRoman(entero));

    }

    public static String intToRoman(int entero) {
        String[] millares = { "", "M", "MM", "MMM" };
        String[] centenas = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCC", "CM" };
        String[] decenas = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] unidades = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

        return "El numero " + entero + " en romano es " + millares[entero / 1000] + centenas[entero % 1000 / 100]
                + decenas[entero % 100 / 10] + unidades[entero % 10];
    }
}
