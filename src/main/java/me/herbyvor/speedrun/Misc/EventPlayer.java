package me.herbyvor.speedrun.Misc;

import me.herbyvor.speedrun.Speedrun;

import java.util.UUID;

public class EventPlayer {

    private static final Speedrun main = Speedrun.getPlugin(Speedrun.class);

    private UUID uuid;
    private String name;
    private Team team;

    public EventPlayer(UUID uuid, Team team){
        this.uuid = uuid;
        this.team = team;
        team.addPlayer(this);
    }

    public EventPlayer(UUID uuid){
        this.uuid = uuid;
        this.team = null;
    }

    public void setTeam(Team team){
        if(this.team != null){
            this.team.removePlayer(this);
        }
        this.team = team;
        if(team != null){
            team.addPlayer(this);
        }
    }

    public void setTeam(String team){
        setTeam(main.getTeamFromName(team));
    }

    public Team getTeam(){
        return team;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
