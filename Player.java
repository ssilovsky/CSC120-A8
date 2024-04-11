import java.util.ArrayList;
import java.util.Random;

public class Player implements Contract {

    private int locationX;
    private int locationY;
    private ArrayList<String> inventory;
    private int height;
    private boolean isMoving;

    /**
     * Class constructor.
     */
    public Player(int height) {
        this.locationX = 1;
        this.locationY = 1;
        this.height = height;
        this.inventory = new ArrayList<String>();
        this.isMoving = false;
    }

    /**
     * Getter for user's coordinates
     */
    public void getLocation() {
        System.out.println("Your coordinates are (" + this.locationX + ", " + this.locationY + ").");
    }

    /**
     * Getter for items in inventory
     */
    public void inventoryItems() {
        if (this.inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Items in your inventory: " + this.inventory.toString());
        }
    }

    /**
     * 
     * Places item in inventory
     * 
     * @param item String, item user wants in inventory
     * 
     */
    public void grab(String item) {
        System.out.println(item + " added to your inventory.");
        this.inventory.add(item);
    }

    /**
     * 
     * Removes item from inventory
     * 
     * @param item String, item user wants to remove from inventory
     * @return String, the item dropped
     */
    public String drop(String item) {
        if (this.inventory.contains(item)) {
            this.inventory.remove(item);
            System.out.println(item + " has been dropped. It is no longer in your inventory.");
        } else {
            System.out.println("Hm you do not seem to have the " + item + " in your inventory.");
        }

        return item;
    }

    /**
     * 
     * Describes item with random descriptors
     * 
     * @param item String, item user wants to examine
     * 
     */
    public void examine(String item) {
        Random randNum = new Random();
        String sizeDescriptors[];
        sizeDescriptors = new String[] { "large", "small", "miniscule", "humongous" };
        String colorDescriptors[];
        colorDescriptors = new String[] { "green", "red", "blue", "pink" };

        System.out.println("You see a " + sizeDescriptors[randNum.nextInt(sizeDescriptors.length)] + ", "
                + colorDescriptors[randNum.nextInt(colorDescriptors.length)] + " " + item + ".");

    }

    /**
     * 
     * Uses item in inventory
     * 
     * @param item String, item user wants to use
     * 
     */
    public void use(String item) {
        if (this.inventory.contains(item)) {
            this.inventory.remove(item);
            System.out.println("Success! You have used the " + item + ".");
        } else {
            System.out.println("Hmm the " + item + " is not in your inventory. Have you grabbed it yet?");
        }

    }

    /**
     * 
     * Moves the user in the direction they want by one point
     * 
     * @param direction Which direction the user is walking
     * @return boolean, whether the user is moving
     * 
     */
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
        System.out
                .println("You walked " + direction + ". Your coordinates are (" + this.locationX + ", " + this.locationY
                        + ").");

        this.isMoving = true;
        return this.isMoving;
    }

    /**
     * 
     * Moves the user by the points inputed
     * 
     * @param x int, the number of x point the user wants to move
     * @param y int, the number of y points the user wants to move
     * @return boolean, whether the user is moving
     * 
     */
    public boolean fly(int x, int y) {
        this.locationX += x;
        this.locationY += y;
        System.out.println(
                "You flew across the map! Your new coordinates are (" + this.locationX + ", " + this.locationY + ").");

        this.isMoving = true;
        return this.isMoving;

    }

    /**
     * 
     * Decreases the user's height by 10
     * 
     * @return Number, the user's new height
     * 
     */
    public Number shrink() {
        this.height -= 10;
        System.out.println("Woah you shrunk! Your height is now " + this.height + ".");
        return this.height;
    }

    /**
     * 
     * Increases the user's height by 10
     * 
     * @return Number, the user's new height
     * 
     */
    public Number grow() {
        this.height += 10;
        System.out.println("Wowza you grew! Your height is now " + this.height + ".");
        return this.height;

    }

    /**
     * 
     * Let's the user rest and has them stop moving
     * 
     */
    public void rest() {
        this.isMoving = false;
        System.out.println("You are resting!");
    }

    /**
     * 
     * Undos the user's location and inventory so all progress is undone, besides
     * height
     * 
     */
    public void undo() {
        this.inventory.clear();
        this.locationX = 1;
        this.locationY = 1;
        this.isMoving = false;
        System.out.println(
                "You have an empty inventory and your coordinates are back at (" + locationX + ", " + locationY + ").");

    }

    public static void main(String[] args) {
        Player p = new Player(54);
        p.grab("hairbrush");
        p.grab("pencil");
        p.inventoryItems();
        p.drop("pencil");
        p.fly(2, 4);
        p.walk("east");
        p.shrink();
        p.grow();
        p.examine("pen");
        p.use("pen");
        p.drop("pen");
        p.use("hairbrush");
        p.rest();
        p.undo();
    }

}
