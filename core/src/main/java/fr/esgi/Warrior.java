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
                System.out.println("You ara attacking the player " + chara.getName());
                int random = (int) (Math.random() * (this.maxDamage - this.minDamage)) + this.minDamage;
                chara.takeDamage(random);
                if (chara.health == 0) {
                    System.out.println("You killed the player " + chara.getName());
                }
            } else {
                System.out.println("The player " + chara.getName() + " is already dead !");
            }
        }
    }

    public void heal(Characters chara) {
        if (chara == this) {
            if (chara.status) {
                System.out.println("You are healing yourself");
                chara.healing(1);
            } else {
                System.out.println("You are already dead !");
            }
        } else {
            System.out.println("You can only heal yourself");
        }
    }
}

