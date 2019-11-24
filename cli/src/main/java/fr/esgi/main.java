package fr.esgi;
import fr.esgi.Characters;
import fr.esgi.Entities;
import fr.esgi.Mage;
import fr.esgi.Warrior;
import fr.esgi.Faction;

public class main {
    public static void main(String[] args) {
        play();
    }

    static void play() {
        Mage scarlet = new Mage("Erza", "chasseuse de dragon");
        Warrior monkey = new Warrior("Luffy", "pirate");
        Characters pnj = new Characters("PNJ SUPER PUISSANT", "PNJ");
        Faction tail = new Faction("fairy tail");
        Faction mu = new Faction("mugiwara");
        Entities d = new Entities("Dragon des océans infernal", 10000, 200);
        attackPlayer(scarlet, monkey);
        monkey.attackEntities(d);
        mu.joinFaction(monkey);
        mu.becomeFriend(tail);
        attackPlayer(scarlet,monkey);
        buy1Armor(monkey);

    }

    public static void attackPlayer(Characters player, Characters chara) {
        if (chara.isStatus()) {
            if (player.equals(chara)) {
                System.out.println("Do you know that you are attacking yourself ?! Just to be sure...\n");
            }
            System.out.println("You want to attack the player" + chara.getName() + "\n");
            player.attackCharacter(chara);
            if (chara.getHealth() == 0) {
                System.out.println("You killed the player " + chara.getName()+ " You have a bright futur! You can steal his monney if you want!\n");
            }
        }else {
            System.out.println("The player " + chara.getName() + " is already dead ! You can now relax and STOP ATTACKING HIM!\n");
        }
    }

    public static void attackEntity(Characters player, Entities entity) {
        if(entity.getCurrentHealth() > 0) {
            System.out.println("You are attacking " + entity.getName()+ " Yes, time to prove you are right! \n");
            player.attackEntities(entity);
            if (entity.getCurrentHealth() == 0) {
                System.out.println("You killed " + entity.getName()
                        + ". You feel more confident in your abilities right now. This entity shouldn't have cross your path! \n");

            }
        }else {
            System.out.println("The "+entity.getName()+" is already dead... Stop...don't try anymore... That's strange.. \n");
        }
    }

    public static void heal(Characters healer, Characters chara){
            if(chara.isStatus()){
                if(healer.equals(chara)){
                    System.out.println("You are healing yourself \n");
                }else{
                    System.out.println("You want to heal "+chara.getName()+ "\n");
                }
                healer.heal(chara);
                System.out.println("The HP of "+chara.getName()+ " are " + chara.getHealth()+ "\n");
            }else {
                System.out.println("The player "+chara.getName()+" is already dead ! Too late...." + "\n");
            }
    }

    public static void joinFaction(Characters player, Faction faction){
        if(!faction.containsMember(player)){
            faction.joinFaction(player);
            System.out.printf("You joined the faction " + faction.getFactionName()
                    +". Then it's time to make a blood pact... Together until you reach the valhallas\n");
        }else {
            System.out.printf("You already are a member of the faction " + faction.getFactionName()
                    + " but they are really proud that you choose to reniew your bonds with their ideologies\n");
        }
    }

    public static void leaveFaction(Characters player, Faction faction){
        if(faction.containsMember(player)){
            faction.leaveFaction(player);
            System.out.printf("You leaved the faction " + faction.getFactionName()
                    + "... Oh! This was really easy.. 'I' thought they would not let you leave alive...\n");
        }else {
            System.out.printf("You are not a member of the faction " + faction.getFactionName()
                    + " Maybe that's a good thing... think about if\n");
        }
    }

    public static void factionsBecomingAllies(Faction faction1,Faction faction2){
        if(!faction1.isFriends(faction2)){
            faction1.becomeFriend(faction2);
            System.out.println("The faction "+faction1.getFactionName()+" and the Faction "+faction2.getFactionName()
                    +" are now ALLIES! Let's stop this absurd battle! they say to each other...Let's celebrate!!\n");
        }else {
            System.out.println("The faction "+faction1.getFactionName()+" and the Faction "+faction2.getFactionName()
                    +" are already ALLIES. But they renew their beautiful bond... so beautiful...\n");
        }
    }

    public static void factionsBecomingEnnemy(Faction faction1, Faction faction2){
        if(faction1.isFriends(faction2)){
            faction1.becomeEnnemy(faction2);
            System.out.println("The faction "+faction1.getFactionName()+" and the Faction "+faction2.getFactionName()
                    +" are now ENNEMIES! Let's fight!! Time to swim into their blood and use their skull to drink !!\n");
        }else {
            System.out.println("The faction "+faction1.getFactionName()+" and the Faction "+faction2.getFactionName()
                    +" are already ENNEMIES. You should never forget the ones who died during this war!! RIP\n");
        }
    }

    public static void searchACorps(Characters player, Characters chara){
        if(!chara.isStatus() && chara.getSousous() != 0){
            System.out.printf("MMMMHHHHHHhhhhh you just needed to tend the arm to take:"+chara.getSousous()+" silvers.\n");
            player.lootFromPlayer(chara);
        }else if(chara.isStatus()){
            System.out.printf("I think you are mistaking... It's not a corps. He is still alive. Try to give him some hits! \n");
        }else {
            System.out.printf("The corps is already decomposing.. There is nothing left. Except some juicy meat \n");
        }
    }

    public static void buy1Armor(Characters player){
        if(player.getSousous()>100){
            player.buyArmor();
            System.out.println("I knew you were afraid of having your finger cut! That's why you bought a sewing dice for your finger!\n");
        }else{
            System.out.println("You are not rich enough to buy the more resist equipment ever!!!!\n");
        }
    }

}







