package nombres;


public abstract class Nombre {
    
    public int[] numerateur;
    public int[] denominateur;
    
    int base;
    
    public Nombre(int base) {
        this.base = base;
    }
    
    public static int[] convertStringToTab(String valeur) {
        int[] tab = new int[valeur.length()];
        
        for (int i = 0; i < valeur.length(); i++)
            tab[i] = valeur.charAt(i) - '0';
        
        return tab;
    }
    
    public abstract String toString();
    
    public static 
    
}
