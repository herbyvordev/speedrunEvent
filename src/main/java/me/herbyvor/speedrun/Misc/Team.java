package me.herbyvor.speedrun.Misc;

import java.util.ArrayList;

public class Team {

    public static String name;
    public static String color;
    public static String prefix;

    public ArrayList<EventPlayer> eventPlayers = new ArrayList<EventPlayer>();

    public Team(String name, String color, String prefix){
        Team.name = name;
        Team.color = color;
        Team.prefix = prefix;
    }

    public Team(String name, String color){
        this(name, color, color);
    }

    //players

    public void addPlayer(EventPlayer eventPlayer){
        eventPlayers.add(eventPlayer);
    }

    public void removePlayer(EventPlayer eventPlayer){
        eventPlayers.remove(eventPlayer);
    }

    public ArrayList<EventPlayer> getPlayers(){
        return eventPlayers;
    }

    //teams

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

    //setters

    public void setName(String name){
        Team.name = name;
    }

    public void setColor(String color){
        Team.color = color;
    }

    public void setPrefix(String prefix){
        Team.prefix = prefix;
    }

}
