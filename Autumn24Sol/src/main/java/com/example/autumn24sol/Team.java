package com.example.autumn24sol;

import java.util.ArrayList;

public class Team {
    String teamName;
    ArrayList<Player> players;

    public Team(String teamName, ArrayList<Player> players) {
        this.teamName = teamName;
        this.players = players;
    }

    void showTeam(){
        System.out.println("Team Name: " + this.teamName);
        for (Player p: players){
            System.out.println(p.name + "-" + p.position);
        }
    }
}
