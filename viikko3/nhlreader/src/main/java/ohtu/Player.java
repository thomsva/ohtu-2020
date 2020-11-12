package ohtu;

public class Player implements Comparable<Player>{

    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;



    public int getTotal() {
        return assists + goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }

    public int getPenalties() {
        return penalties;
    }

    public String getTeam() {
        return team;
    }

    public int getGames() {
        return games;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return name + " team: " + team + " goals:" + goals + " assists:" + assists;
    }

    @Override
    public int compareTo(Player p) {
        return (p.getTotal()-this.getTotal());
    }

}
