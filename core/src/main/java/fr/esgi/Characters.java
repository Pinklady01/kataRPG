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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public int verifFaction(Characters chara) {
        if (this.getFaction() == null) {
            //no faction
            return 0;
        } else if (this.getFaction().equals(chara.faction)) {
            //same faction
            return 1;
        } else {
            //different faction
            return 2;
        }
    }

    public void attackCharacter(Characters ennemy) {
        if (ennemy != this) {
            if (ennemy.isStatus()) {
                if (this.verifFaction(ennemy) != 1) {
                    System.out.println("You are attacking the player " + ennemy.getName());
                    ennemy.takeDamage(1);
                    if (ennemy.getHealth() == 0) {
                        System.out.println("You killed the player " + ennemy.getName());
                    }
                }
            } else {
                System.out.println("The player " + ennemy.getName() + " is already dead !");
            }
        }
    }

    public void attackEntities(Entities entity) {
        if (entity.getCurrentHealth() > 0) {
            System.out.println("You are attacking " + entity.getName());
            entity.takeDamage(1);
        }else {
            System.out.println("The "+entity.getName()+" is already dead");
        }
            if (entity.getCurrentHealth() == 0) {
                System.out.println("You killed " + entity.getName());
            }
    }

    public void heal(Characters chara){
        if (this.verifFaction(chara) != 2){
            if(chara.isStatus()){
                System.out.println("You are healing "+chara.getName());
                chara.healing(1);
            }else {
                System.out.println("The player "+chara.getName()+" is already dead !");
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


