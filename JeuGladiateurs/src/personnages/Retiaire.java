/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;
import java.util.Random;

/**
 *
 * @author ETI
 */
public class Retiaire extends Personnage{
        
    final String classe = "Rétiaire";
    final int maxIni = 100;
    private boolean aSonFilet = true;
    private boolean aAtteintCible;
    
    public Retiaire(String nom, int attaqueMax, int defense, int pvs, int ini)
    {
        super(nom, attaqueMax, defense, pvs, ini);
    }
    
    @Override
    public void afficherInfosPersonnage()
    {
        super.afficherInfosPersonnage();
        System.out.println("    Classe : " + classe);
    }
    
    public void setNewInitiativeRandom()
    {
        super.setNewInitiativeRandom(maxIni);
    }
    
    private int chanceFilet()
    {
        Random rand = new Random();
        int chanceFilet = rand.nextInt(10 - 1) + 1;
        
        return chanceFilet;
    }
    
    @Override
    public void frapperPersonnage(Personnage personnageCible)
    {
        if(aSonFilet)
        {
            System.out.println(super.getNom() + " lance son filet.");
            
            aAtteintCible = chanceFilet() == 1;
            
            if(aAtteintCible)
            {
                System.out.println("Son filet attrape " + personnageCible.getNom() + " et il l'empale sauvagement avec sa lance.");
                personnageCible.setPointsDeVie(0);
            }
            else
            {
                System.out.println("Le filet n'atteint pas sa cible.");
            }
            
            aSonFilet = false;
        }
        else
        {
            System.out.println(super.getNom() + " ramasse son filet et en profite pour l'attaquer.");
            super.frapperPersonnage(personnageCible);
            aSonFilet = true;
        }
    }
}
