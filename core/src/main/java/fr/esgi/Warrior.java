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

    public void attackCharacter(Characters chara) {
        if (chara.isStatus()) {
            if (this.verifFaction(chara) != 1 || this.equals(chara)) {
                int random = (int) (Math.random() * (this.getMaxDamage() - this.getMinDamage())) + this.getMinDamage();
                chara.takeDamage(random);
                if(!this.equals(chara)){
                    if(chara.getHealth() ==0){
                        this.obtainXp(chara.getXpGiven());
                    }
                }
            }
        }
    }

    public void heal() {
            if (this.isStatus()) {
                this.healing(1);
            }
    }
}

