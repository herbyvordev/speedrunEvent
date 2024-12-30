package me.herbyvor.speedrun.Misc;

import org.bukkit.Material;

import java.util.ArrayList;

public class Team {

    public String name;
    public String color;
    public String prefix;

    public Material guiBlock;

    public ArrayList<EventPlayer> eventPlayers = new ArrayList<EventPlayer>();

    public Team(String name, String color, String prefix){
        this.name = name;
        this.color = color;
        this.prefix = prefix;
        switch (color){
            case "bleu":
                guiBlock = Material.BLUE_CONCRETE;
                break;
            case "rouge":
                guiBlock = Material.RED_CONCRETE;
                break;
            case "vert":
                guiBlock = Material.GREEN_CONCRETE;
                break;
            case "jaune":
                guiBlock = Material.YELLOW_CONCRETE;
                break;
            case "spectateurs":
                guiBlock = Material.GRAY_CONCRETE;
                break;
            default:
                guiBlock = Material.WHITE_CONCRETE;
                break;
        }
    }

    public Team(String name, String color){
        this(name, color, color);
    }

    public void addPlayer(EventPlayer eventPlayer){
        eventPlayers.add(eventPlayer);
    }

    public void removePlayer(EventPlayer eventPlayer){
        eventPlayers.remove(eventPlayer);
    }

    public ArrayList<EventPlayer> getPlayers(){
        return eventPlayers;
    }

    public void DisbandTeam(){
        for(EventPlayer eventPlayer : eventPlayers){
            eventPlayer.setTeam("null"); //met tt le monde en team spectator vue que y'a pas de team null
        }
    }

    //getters

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public String getPrefix(){
        return prefix;
    }

    public Material getGuiBlock() {
        return guiBlock;
    }

    //setters

    public void setName(String name){
        this.name = name;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public void setGuiBlock(Material guiBlock) {
        this.guiBlock = guiBlock;
    }

}
