package fr.esgi;

import java.util.ArrayList;

public class Faction {
    protected String factionName;
    protected ArrayList<Characters> members = new ArrayList<Characters>();

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

    public void joinFaction(Characters chara){
        this.members.add(chara);
    }
    public void leaveFaction(Characters chara){
        this.members.remove(chara);
    }

}
