package game;

public class Tile {
    // Variables
    final private String name;
    final private String flavorText;
    private int points;
    final private boolean extraTurn;

    // Constructor
    public Tile (String iName, String iFlavorText, int iPoints, boolean iExtraTurn){
        name = iName;
        flavorText = iFlavorText;
        points = iPoints;
        extraTurn = iExtraTurn;
    }

    // Get the point value of the tile
    public int getPoints () { return this.points; }

    // Set the point value of the tile (not relevant to CDIO2)
    public void setPoints (int add) { this.points = this.points + add; }

    // Get name of the tile
    public String getName () { return this.name; }

    // Get flavor text
    public String getFlavorText () { return this.flavorText; }
}
