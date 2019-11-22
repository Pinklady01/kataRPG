package fr.esgi;

public class Warrior extends Characters {
    private int maxDamage = 9;
    private int minDamage = 0;

    public Warrior(String name, String job) {
        super(name, job);

    }

    public void attack(Characters chara) {
        if (chara.status) {
            if (this.verifFaction(chara) != 1 || this.equals(chara)) {
                System.out.println("Vous attaquez le joueur " + chara.getName());
                int random = (int) (Math.random() * (this.maxDamage - this.minDamage)) + this.minDamage;
                chara.takeDamage(random);
                if (chara.health == 0) {
                    System.out.println("Vous avez tué le joueur " + chara.getName());
                }
            } else {
                System.out.println("Le joueur " + chara.getName() + " est déjà mort !");
            }
        }
    }

    public void heal(Characters chara) {
        if (chara == this) {
            if (chara.status) {
                System.out.println("Vous healez le joueur " + chara.getName());
                chara.healing(1);
            } else {
                System.out.println("Le joueur " + chara.getName() + " est déjà mort !");
            }
        } else {
            System.out.println("Vous ne pouvez que vous soigner");
        }
    }
}

