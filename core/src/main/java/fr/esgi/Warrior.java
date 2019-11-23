package fr.esgi;

public class Warrior extends Characters {
    private int maxDamage = 9;
    private int minDamage = 0;

    public Warrior(String name, String job) {
        super(name, job);
    }

    public int getMaxDamage() { return maxDamage; }

    public void setMaxDamage(int maxDamage) { this.maxDamage = maxDamage; }

    public int getMinDamage() { return minDamage; }

    public void setMinDamage(int minDamage) { this.minDamage = minDamage; }

    public void attack(Characters chara) {
        if (chara.isStatus()) {
            if (this.verifFaction(chara) != 1 || this.equals(chara)) {
                System.out.println("You ara attacking the player " + chara.getName());
                int random = (int) (Math.random() * (this.getMaxDamage() - this.getMinDamage())) + this.getMinDamage();
                chara.takeDamage(random);
                if (chara.getHealth() == 0) {
                    System.out.println("You killed the player " + chara.getName());
                }
            } else {
                System.out.println("The player " + chara.getName() + " is already dead !");
            }
        }
    }

    public void heal() {
            if (this.isStatus()) {
                System.out.println("You are healing yourself");
                this.healing(1);
            } else {
                System.out.println("Too late!!! you are already dead !");
            }
    }
}

