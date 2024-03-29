package fr.esgi;

public class Mage extends Characters {
    private int maxHeal = 5;
    private int minHeal = 10;

    public Mage(String name, String job) {
        super(name, job);
    }

    public int getMaxHeal() { return maxHeal; }

    public void setMaxHeal(int maxHeal) { this.maxHeal = maxHeal; }

    public int getMinHeal() { return minHeal; }

    public void setMinHeal(int minHeal) { this.minHeal = minHeal; }

    public void heal(Characters chara) {
        if (this.verifFaction(chara) != 2){
            if (chara.isStatus()) {
                int random = (int) (Math.random() * (this.getMaxHeal() - this.getMinHeal())) + this.getMinHeal();
                chara.healing(random);
                if(random > 8){
                    this.obtainXp(10);
                }
            }
        }
    }

    public void attackCharacter(Characters ennemy) {
        System.out.println("You can't attack!");
    }

}

