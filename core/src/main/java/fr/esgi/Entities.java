package fr.esgi;

public class Entities {
    protected String name;
    protected int currentHealth;
    protected int xpGiven;

    public int getXpGiven() { return xpGiven; }

    public void setXpGiven(int xpGiven) { this.xpGiven = xpGiven; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Entities(String name, int currentHealth, int xpGiven) {
        this.name = name;
        this.currentHealth = currentHealth;
    }

    public void takeDamage(int damage) {
        this.setCurrentHealth(this.getCurrentHealth() - damage);
        if(this.getCurrentHealth() < 0){
            this.setCurrentHealth(0);
        }
    }
}
