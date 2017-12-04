package nombres;

import java.util.Arrays;
import operations.LCI;

/**
 *
 * @author coco
 */
public class Naturel extends Nombre implements LCI {

    /**
     *
     * @param valeur
     * @param base
     */
    public Naturel(String valeur, int base) {
        super(base);

        this.numerateur = convertStringToTab(valeur);
        this.denominateur = null;
    }

    /**
     *
     * @param A
     */
    public void addition(Naturel A) {
        int lmax = Math.max(this.numerateur.length, A.numerateur.length) + 1;//détermine la longueur du tableau contenant le résultat
        int i;
        int tab[] = new int[lmax];
        int retenu = 1;

        //Dans le cas ou on est en hexadecimal
        // inversion des tableaux
        this.numerateur = invertTab(this.numerateur);
        A.numerateur = invertTab(A.numerateur);

        if (this.base == A.base) { //dans le cas où les deux bases sont similaire
            for (i = 0; i < lmax - 1; i++) {
                if (i < this.numerateur.length && i < A.numerateur.length) {
                    if (this.numerateur[i] + A.numerateur[i] + tab[i] >= base) {//gère la retenue
                        tab[i] += this.numerateur[i] + A.numerateur[i] - base;
                        tab[i + 1] += 1;
                    } else {// s'il n'y a pas de retenu
                        tab[i] += this.numerateur[i] + A.numerateur[i];

                    }
                } else if (this.numerateur.length < A.numerateur.length) {
                    if (tab[i] == retenu) {
                        if (tab[i] + A.numerateur[i] > base - 1) {
                            tab[i] += A.numerateur[i] - base;
                            tab[i + 1] = retenu;
                        } else {
                            tab[i] = A.numerateur[i];
                        }
                    } else {
                        tab[i] = A.numerateur[i];
                    }

                } else {
                    if (tab[i] == retenu) {
                        if (tab[i] + this.numerateur[i] > base - 1) {
                            tab[i] += this.numerateur[i] - base;
                            tab[i + 1] = retenu;
                        } else {
                            tab[i] += this.numerateur[i];
                        }
                    } else {
                        tab[i] = this.numerateur[i];
                    }
                }
                System.out.println("i: " + i);
            }
        } else if (this.base != A.base) {

        }

        tab = invertTab(tab);
        for (int str : tab) { //affiche résultat
            System.out.print(str);
        }

    }

    public void soustraction(Naturel A) {
        int lmax = Math.max(this.numerateur.length, A.numerateur.length) + 1;//détermine la longueur du tableau contenant le résultat
        int lmin = Math.min(this.numerateur.length, A.numerateur.length);
        int i;
        int tab[] = new int[lmax];
        int retenu = 1;

        //Dans le cas ou on est en hexadecimal
        // inversion des tableaux
        this.numerateur = invertTab(this.numerateur);
        A.numerateur = invertTab(A.numerateur);

        if (this.base == A.base) { //dans le cas où les deux bases sont similaire
            for (i = 0; i < lmax - 1; i++) {
                if (i < this.numerateur.length && i < A.numerateur.length) {
                    if (this.numerateur.length < A.numerateur.length) {
                        if (this.numerateur[i] > A.numerateur[i]) {// soustraction où la différence est négative
                            tab[i] = A.numerateur[i] + base - this.numerateur[i];
                            this.numerateur[i + 1] += 1;
                        } else {// différence positive
                            tab[i] += A.numerateur[i] - this.numerateur[i];
                        }
                    } else {
                        if (A.numerateur[i] > this.numerateur[i]) {// soustraction où la différence est négative
                            if (i + 1 < A.numerateur.length) {
                                tab[i] = this.numerateur[i] + base - A.numerateur[i];
                                A.numerateur[i + 1] += 1;
                            } else {
                                tab[i] = this.numerateur[i] - A.numerateur[i];
                            }
                        } else {
                            tab[i] += this.numerateur[i] - A.numerateur[i];
                        }
                    }
                } else if (this.numerateur.length < A.numerateur.length) {
                    tab[i] = A.numerateur[i];
                } else {
                    tab[i] = this.numerateur[i];
                }
            }
            tab = invertTab(tab);
            for (int n : tab) {
                System.out.print(n);
            }
        }

    }

    @Override
    public void addition(Nombre A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
