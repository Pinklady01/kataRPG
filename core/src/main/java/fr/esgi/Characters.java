package fr.esgi;

import java.util.ArrayList;

public class Characters {
    protected String name;
    protected int health = 100;
    protected int maxHealth = 100;
    protected boolean status = true;
    protected String job;
    protected ArrayList<Faction> factions = new ArrayList<Faction>();

    public Characters(String name, String job) {
        this.name = name;
        this.job = job;
        System.out.printf("You are born !!! (｡◕‿◕｡) \n");
    }

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

    public void attackCharacter(Characters ennemy) {
        if (ennemy != this) {
            if (ennemy.isStatus()) {
                if (this.verifFaction(ennemy) != 1) {
                    ennemy.takeDamage(1);
                }
            }
        }
    }

    public void attackEntities(Entities entity) {
        if (entity.getCurrentHealth() > 0) {
            entity.takeDamage(1);
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

     public void takeDamage(int damage){
            this.setHealth(this.getHealth() - damage);
            if(this.getHealth() < 0){
                this.setHealth(0);
            }
            if (this.getHealth() == 0){
                this.setStatus(false);
            }
     }
}


