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
                System.out.println("You are healin the player" + chara.getName() + " of " + random);
                chara.healing(random);
            } else {
                System.out.println("The player " + chara.getName() + " is already dead !");
            }
        }
    }

    public void attack(Characters ennemy) {
        System.out.println("You can't attack!");
    }

}

