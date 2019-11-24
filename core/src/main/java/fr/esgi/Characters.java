package fr.esgi;

import java.util.ArrayList;

public class Characters {
    protected String name;
    protected int health = 100;
    protected int maxHealth = 100;
    protected boolean status = true;
    protected String job;
    protected ArrayList<Faction> factions = new ArrayList<Faction>();
    protected int sousous = 15;
    protected int xp = 0;
    protected int xpGiven = 40;
    protected int lvl = 1;
    protected int xpNeeded = 20;
    protected int armor = 0;
    protected int damage = 1;


    public Characters(String name, String job) {
        this.name = name;
        this.job = job;
        System.out.printf(name+" is born !!! (｡◕‿◕｡) \n");
    }

    public int getXpNeeded() { return xpNeeded; }

    public void setXpNeeded(int xpNeeded) { this.xpNeeded = xpNeeded; }

    public int getXp() { return xp; }

    public void setXp(int xp) { this.xp = xp; }

    public int getXpGiven() { return xpGiven; }

    public void setXpGiven(int xpGiven) { this.xpGiven = xpGiven; }

    public int getLvl() { return lvl; }

    public void setLvl(int lvl) { this.lvl = lvl; }

    public int getSousous() { return sousous; }

    public void setSousous(int sousous) { this.sousous = sousous; }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health; }

    public int getMaxHealth() { return maxHealth; }

    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Faction> getFactions() { return factions; }

    public void setFactions(ArrayList<Faction> factions) { this.factions = factions; }

    public int getArmor() { return armor; }

    public void setArmor(int armor) { this.armor = armor; }

    public int getDamage() { return damage; }

    public void setDamage(int damage) { this.damage = damage; }

    public boolean isFaction(Faction faction) {
        if (this.getFactions().contains(faction)) {
            return true;
        }
        return false;
    }

    public int verifFaction(Characters chara) {
        if (this.getFactions() == null) {
            //no faction
            return 0;
        }
        if(this.equals(chara)){
            // if it's the same character
            return 1;
        }
        for (int i = 0; i < chara.getFactions().size(); i++) {
            for (int j = 0; j < this.getFactions().size(); j++) {
                if(this.isFaction(chara.getFactions().get(i))){
                    // if the two characters have a same faction in commun
                    return 1;
                }
                if (this.getFactions().get(j).isFriends(chara.getFactions().get(i))) {
                    // if one of their faction are allies
                    return 1;
                }
            }
        }
        return 2;
    }

    public void buyArmor(){
        if(this.getSousous()>100){
            this.setArmor(this.getArmor()+1);
            this.setSousous(this.getSousous()-100);
        }
    }

    public void attackCharacter(Characters ennemy) {
        if (ennemy != this) {
            if (ennemy.isStatus()) {
                if (this.verifFaction(ennemy) != 1) {
                    ennemy.takeDamage(this.getDamage());
                    if(ennemy.getHealth() ==0){
                        this.obtainXp(ennemy.getXpGiven());
                    }
                }else {
                    System.out.println("You are allies!! Be careful with your teamate. You could have this poor guy...");
                }
            }
        }
    }

    public void obtainXp(int xp){
        if(this.getXp() + xp >= this.getXpNeeded()){
            this.lvlUp((this.getXp() + xp)/this.getXpNeeded());
            this.setXp((this.getXp() + xp)%this.getXpNeeded());
        }
    }


    public void lvlUp(int lvl){
        this.setLvl(this.getLvl() + lvl);
        this.setXpNeeded((int)(this.getXpNeeded()+lvl*(0.1*this.getXpNeeded())));
        this.setXpGiven(this.getXpGiven()+5);
        System.out.println("The player "+this.getName()+" is now lvl "+this.getLvl()+"!! You should take example!");
        this.healing(this.getMaxHealth());
        System.out.println("The Godness blessed you. youg padawan "+this.getName()+"You are now full healed. ");
    }

    public void lootFromPlayer(Characters chara){
        if(!chara.isStatus() && chara.getSousous() != 0){
            this.setSousous(this.getSousous() + chara.getSousous());
            chara.setSousous(0);
        }

    }

    public void attackEntities(Entities entity) {
        if (entity.getCurrentHealth() > 0) {
            entity.takeDamage(this.getDamage());
            if(entity.getCurrentHealth() == 0){
                this.obtainXp(entity.getXpGiven());
            }
        }
    }

    public void heal(Characters chara){
        if (this.verifFaction(chara) !=2){
            if(chara.isStatus()){
                chara.healing(1);
            }
        }
    }

    public void healing(int number){
        if(this.isStatus()){
            this.setHealth(this.getHealth() + number);
            if (this.getHealth() > this.maxHealth){
                this.setHealth(this.maxHealth);
            }
        }
    }

     public void takeDamage(int damageTaken){
            this.setHealth(this.getHealth() - (damageTaken - this.getArmor()));
            if(this.getHealth() < 0){
                this.setHealth(0);
            }
            if (this.getHealth() == 0){
                this.setStatus(false);
            }
     }
}


