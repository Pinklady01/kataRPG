package fr.esgi;

public class Characters {
    protected String name;
    protected int health = 100;
    protected int maxHealth = 100;
    protected boolean status = true;
    protected String job;
    protected Faction faction;

    public Characters(String name, String job) {
        this.name = name;
        this.job = job;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int verifFaction(Characters chara){
        if(this.faction == null){
            //pas de faction
            return 0;
        }else if(this.faction.equals(chara.faction)){
            //même faction
            return 1;
        }else{
            // factions différentes
            return 2;
        }
    }

    public void attack(Characters ennemy){
        if(ennemy != this){
            if(ennemy.status){
                if(this.verifFaction(ennemy) != 1){
                    System.out.println("Vous attaquez le joueur "+ennemy.getName());
                    ennemy.takeDamage(1);
                    if(ennemy.health == 0){
                        System.out.println("Vous avez tué le joueur "+ennemy.getName());
                    }
                }
            }else {
                System.out.println("Le joueur "+ennemy.getName()+" est déjà mort !");
            }
        }

     }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void heal(Characters chara){
        if (this.verifFaction(chara) != 2){
            if(chara.status){
                System.out.println("Vous healez le joueur "+chara.getName());
                chara.healing(1);
            }else {
                System.out.println("Le joueur "+chara.getName()+" est déjà mort !");
            }
        }
    }

    public void healing(int number){
        if(this.status){
            this.health += number;
            if (this.health > maxHealth){
                this.health = maxHealth;
            }
        }
    }

     public void takeDamage(int damage){
        if(this.status){
            this.health -= damage;
            if (this.health == 0){
                this.setStatus(false);
            }
        }
     }


}
