package nombres;

import operations.LCI;

public class Naturel extends Nombre implements LCI {

    public Naturel(String valeur, int base) {
        super(base);
        
        this.numerateur = convertStringToTab(valeur);
        this.denominateur = null;
    }
    
    public void addition(Naturel A) {
        int[] resultat = new int[Math.max(this.numerateur.length, A.numerateur.length) + 1];
        
        for(int i = 0; i < Math.max(this.numerateur.length, A.numerateur.length) + 1; i++) {
            resultat[i] =  this.numerateur[i]+A.numerateur[i];
        }

    }

    @Override
    public String toString() {
        String str = "";
        
        for (int i : this.numerateur)
            str += i;
        
        return str;
    }

    @Override
    public void addition(Nombre A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
