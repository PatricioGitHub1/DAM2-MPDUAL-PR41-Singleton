public class PR430Main {
    public static void main(String[] args) {
        PR430Objecte[] arrayObjectes = new PR430Objecte[3];

        System.out.println("Inicialitzant 0...");
        PR430Objecte pepe = PR430Objecte.getInstance("Pepe","Ruiz", 20);
        arrayObjectes[0] = pepe;

        System.out.println("Inicialitzant 1...");
        PR430Objecte maria = PR430Objecte.getInstance("Maria","Antonieta", 30);
        arrayObjectes[1] = maria;

        System.out.println("Inicialitzant 2...");
        PR430Objecte jhon = PR430Objecte.getInstance("Victor","Rojas", 27);
        arrayObjectes[2] = jhon;

        for (PR430Objecte ob: arrayObjectes) {
            System.out.println(ob.toString());
        }
    }
}

final class PR430Objecte {
    private static PR430Objecte instance;
    private String nom;
    private String cognom;
    private int edat;

    private PR430Objecte(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        
    }

    public static PR430Objecte getInstance(String nom, String cognom, int edat) {        
        // Creacion del delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        if (instance == null) {
            instance = new PR430Objecte(nom, cognom, edat);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + "   Cognom: " + cognom + "   edat: " + edat;
    }
    
}
