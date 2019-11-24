package fr.esgi;

import java.util.ArrayList;

public class Faction {
    protected String factionName;
    protected ArrayList<Characters> members = new ArrayList<Characters>();
    protected ArrayList<Faction> friends = new ArrayList<Faction>();

    public Faction(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public ArrayList<Characters> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Characters> members) { this.members = members; }

    public void leaveFaction(Characters chara){
        if(this.containsMember(chara)){
            this.getMembers().remove(chara);
            chara.getFactions().remove(this);
        }
    }

    public void joinFaction(Characters chara){
        if(!this.containsMember(chara)){
            this.getMembers().add(chara);
            chara.getFactions().add(this);
        }
    }

    public boolean containsMember(Characters chara){
        if(this.getMembers().contains(chara)){
            return true;
        }
        return false;
    }


    public void becomeFriend(Faction faction){
        if(!this.isFriends(faction)){
            this.getFriends().add(faction);
            faction.getFriends().add(this);
        }
    }

    public void becomeEnnemy(Faction faction){
        if(this.isFriends(faction)){
            this.getFriends().remove(faction);
            faction.getFriends().remove(this);
        }
    }

    public ArrayList<Faction> getFriends() {
        return friends;
    }

    public boolean isFriends(Faction friends) {
        if (this.getFriends().contains(friends)) {
            return true;
        }
        return false;
    }
}
