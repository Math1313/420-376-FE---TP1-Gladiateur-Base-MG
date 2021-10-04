/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

/**
 *
 * @author ETI
 */
public class Mirmillon extends Personnage{
    
    final String classe = "Mirmillon";
    final int maxIni = 30;
    
    public Mirmillon(String nom, int attaqueMax, int defense, int pvs, int ini)
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
}
