import java.lang.reflect.Constructor;

public class PR431Main {
    public static void main(String[] args) {
        PR431Objecte[] arrayObjectes = new PR431Objecte[3];

        System.out.println("Inicialitzant 0...");
        PR431Objecte pepe = getNewDestroyedInstance("Pepe","Ruiz", 20);
        arrayObjectes[0] = pepe;

        System.out.println("Inicialitzant 1...");
        PR431Objecte maria = getNewDestroyedInstance("Maria","Antonieta", 30);
        arrayObjectes[1] = maria;

        System.out.println("Inicialitzant 2...");
        PR431Objecte victor = getNewDestroyedInstance("Victor","Rojas", 27);
        arrayObjectes[2] = victor;

        for (PR431Objecte ob: arrayObjectes) {
            System.out.println(ob.toString());
        }
    }

    static PR431Objecte getNewDestroyedInstance (String nom, String cognom, int edat) {
        
        PR431Objecte result = null;
        try {
            Constructor<?>[] constructors = PR431Objecte.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                result = (PR431Objecte) constructor.newInstance(nom, cognom, edat);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Creacion del delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

final class PR431Objecte {
    private static PR431Objecte instance;
    private String nom;
    private String cognom;
    private int edat;

    private PR431Objecte(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        
    }

    public static PR431Objecte getInstance(String nom, String cognom, int edat) {        
        // Creacion del delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        if (instance == null) {
            instance = new PR431Objecte(nom, cognom, edat);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + "   Cognom: " + cognom + "   edat: " + edat;
    }
    
}