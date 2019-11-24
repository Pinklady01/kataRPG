package fr.esgi;
import fr.esgi.Characters;
import fr.esgi.Entities;
import fr.esgi.Mage;
import fr.esgi.Warrior;
import fr.esgi.Faction;

public class main {

    public static void main(String[] args){

        Mage Lior = new Mage("Lior", "développeur");
        Mage Marion = new Mage("Marion", "dev");
        Lior.attackCharacter(Marion);

    }
}
