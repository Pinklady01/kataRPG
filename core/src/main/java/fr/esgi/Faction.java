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

    public void setMembers(ArrayList<Characters> members) {
        this.members = members;
    }

    public void leaveFaction(Characters chara){ this.getMembers().remove(chara); }

    public void joinFaction(Characters chara){ this.getMembers().remove(chara); }

    public void containsChara(Characters chara){
        //Returns true if this list contains the specified element.
        this.getMembers().contains(chara);
    }
}
