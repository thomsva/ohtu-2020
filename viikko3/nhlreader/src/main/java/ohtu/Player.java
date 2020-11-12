
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties; 
    private String team;
    private int games;
    

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
        return name + " team: " + team + " goals:" + goals + " assists:"+ assists;
    }
      
}
