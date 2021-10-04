package personnages;
import java.util.Random;



public class Personnage {

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Attributs">
   private String nom;
   private int pointsDeVie;
   private int valeurMaxAttaque;
   private int valeurDefense;
   private int initiative;
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Constructeurs et initialisation">
    public Personnage(String nom, int attaqueMax, int defense, int pvs, int ini) {
        // TODO : Constructeur AVEC paramètres
        this.nom = nom;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.pointsDeVie = pvs;
        this.initiative = ini;
    }

    public Personnage() {
        // TODO : Constructeur SANS paramètres qui initialise à ZÉRO ou à ""
        this.nom = "";
        this.valeurMaxAttaque = 0;
        this.valeurDefense = 0;
        this.pointsDeVie = 0;
        this.initiative = 0;
    }
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Getters et setters">
    public int getInitiative() {    
        return initiative;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getValeurMaxAttaque() {
        return valeurMaxAttaque;
    }

    public int getValeurDefense() {
        return valeurDefense;
    }
    
    public void setNom(String nom) {    
        this.nom = nom;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void setValeurMaxAttaque(int valeurMaxAttaque) {
        this.valeurMaxAttaque = valeurMaxAttaque;
    }

    public void setValeurDefense(int valeurDefense) {
        this.valeurDefense = valeurDefense;
    }


    public void setInitiative(int initiative) {    
        this.initiative = initiative;
    }

    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de jeu">
    public void afficherInfosPersonnage() {
        
        String statut;
        if (pointsDeVie <= 0){
            statut = "Mort";
        }
        else{
            statut = "Vivant";
        }
        
        System.out.println();
        System.out.println(nom);
        System.out.println("    Attaque : " + valeurMaxAttaque);
        System.out.println("    Défense : " + valeurDefense);
        System.out.println("    Points de vie : " + pointsDeVie);
        System.out.println("    Initiative : " + initiative);
        System.out.println("    Statut : " + statut);
    }

    private int attaqueCalcul() {
        Random rand = new Random();
        int minValue = 0;
        int maxValue = valeurMaxAttaque + 1;
        int attaqueReel = rand.nextInt(maxValue - minValue) + minValue;
        
        return attaqueReel;
    }

    public void frapperPersonnage(Personnage personnageCible) {
        int forceDeFrappe = attaqueCalcul();
        int valeurDefense = personnageCible.valeurDefense;
        int dommages = forceDeFrappe - valeurDefense;
        if(dommages < 0)
        {
            dommages = 0;
        }
        
        personnageCible.setPointsDeVie(personnageCible.pointsDeVie - dommages);
        if(personnageCible.getPointsDeVie() < 0)
        {
            personnageCible.setPointsDeVie(0);
        }
        
        System.out.println(nom + " attaque avec une puissance de : " + forceDeFrappe);
        System.out.println(personnageCible.getNom() + " a une défense de : " + valeurDefense);
        System.out.println("Les dommages sont donc de : " + dommages);
    }

    public void setNewInitiativeRandom(int maxIni) {
        Random rand = new Random();
        int minValue = 0;
        int initiative = rand.nextInt(maxIni - minValue) + minValue;
        setInitiative(initiative);
    }
    // </editor-fold>
}
