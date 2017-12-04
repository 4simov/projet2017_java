package nombres;

public abstract class Nombre {

    public int[] numerateur;
    public int[] denominateur;

    int base;

    public Nombre(int base) {
        this.base = base;
    }

    public String convertDeToBase(int[] valeur, int base) {
        int n = 0;
        String res = "";
        int rem;
        char lettre[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'i',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < valeur.length; i++) {
            n += valeur[i] * Math.pow(10, (double) (valeur.length - 1 - i));
        }
        System.out.println(n);

        while (n > 0) {
            rem = n % base;
            if (base > 10) {
                res += lettre[rem];
            } else {
                res += rem;
            }

            n = n / base;
        }

        System.out.println(res);
        return res;
    }

    public static int convertAnyToDecimal(String valeur, int base) {
        /*int i;
        int[] res = new int[valeur.length];
        char lettre[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'i',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};*/

        int v = 0;
        int total = 0;
        int pow = 0;
        valeur = valeur.toUpperCase();
        for (int i = valeur.length() - 1; i >= 0; i--) {
            char c = valeur.charAt(i);
            if (c >= '0' && c <= '9') {
                v = c - '0';
            } else if (c >= 'A' && c <= 'Z') {
                v = 10 + (c - 'A');
            }
            total += v * Math.pow(base, pow);
            pow++;
        }
        return total;
    }

    /**
     *
     * @param valeur
     * @return
     */
    public static int[] convertStringToTab(String valeur) {
        int[] tab = new int[valeur.length()];

        for (int i = 0; i < valeur.length(); i++) {
            tab[i] = valeur.charAt(i) - '0';
        }

        return tab;
    }

    public static String convertTabToString(int[] valeur) {
        String n = "";
        for (int i = 0; i < valeur.length; i++) {
            n += valeur[i];
        }
        System.out.println("String :" + n);
        return n;
    }

    /**
     *
     * @param valeur
     * @return
     */
    public static int[] invertTab(int valeur[]) {
        //affiche le tableau de base
        System.out.print("n : ");
        for (int str : valeur) {
            System.out.print(str);
        }
        System.out.println();
        //inversion
        int tab[] = new int[valeur.length];
        int i;
        for (i = 0; i < valeur.length; i++) {
            tab[i] = valeur[valeur.length - 1 - i];
        }
        //affiche la sortie
        System.out.print("nInvert : ");
        for (int str : tab) {
            System.out.print(str);
        }
        System.out.println();
        return tab;
    }

}
