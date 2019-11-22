package fr.esgi;

public class Mage extends Characters {
    private int maxHeal = 5;
    private int minHeal = 10;

    public Mage(String name, String job) {
        super(name, job);
    }

    public void heal(Characters chara) {
        if (this.verifFaction(chara) != 2){
            if (chara.status) {
                int random = (int) (Math.random() * (this.maxHeal - this.minHeal)) + this.minHeal;
                System.out.println("Vous healez le joueur " + chara.getName() + " de " + random);
                chara.healing(1);
            } else {
                System.out.println("Le joueur " + chara.getName() + " est déjà mort !");
            }
        }
    }

    public void attack(Characters ennemy) {
        System.out.println("Vous ne pouvez attaquer!");
    }

}

