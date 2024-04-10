import java.util.ArrayList;

public class Player implements Contract {

    int locationX;
    int locationY;
    ArrayList<String> inventory;
    int height;

    public Player(int height) {
        this.locationX = 1;
        this.locationY = 1;
        this.height = height;
        this.inventory = new ArrayList<String>();
    }

    public void grab(String item) {
        System.out.println(item + " added to your inventory");
        this.inventory.add(item);
    }

    public String drop(String item) {
        this.inventory.remove(item);
        return "The item has been dropped, and destroyed. Whoops!";
    }

    public void examine(String item) {

    }

    public void use(String item) {

    }

    public boolean walk(String direction) {
        if (direction.toLowerCase() == "north") {
            this.locationY += 1; 
        }
        if (direction.toLowerCase() == "south") {
            this.locationY -= 1; 
        }
        if (direction.toLowerCase() == "east") {
            this.locationX += 1; 
        }
        if (direction.toLowerCase() == "west") {
            this.locationX -= 1; 
        }
        System.out.println("You walked " + direction + ". Your new coordinates are (" + locationX + ", " + locationY + ").");

        return true;
    }

    public boolean fly(int x, int y) {

    }

    public Number shrink() {
        System.out.println("Woah! Your height is now " + height);
        height -= 10;
        return height;
    }

    public Number grow() {
        System.out.println("Wowza! Your height is now " + height);
        height += 10;
        return height;

    }

    public void rest() {

    }

    public void undo() {

    }

}
