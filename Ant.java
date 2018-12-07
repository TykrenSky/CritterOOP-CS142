//Tieran Rashid
//3/5/18
//CSE142A
//TA: Michael Sulistio
//Assignment #8
//
//This is an ant critter that walks in a zig-zag north or south
//It looks like a red % and always picks SCRATCH in a fight
import java.awt.*;

public class Ant extends Critter {
   private boolean walkSouth;
   private char nextDirection;
   
   //Constructs the ant with a north or south zig-zag based on its walkSouth parameter
   public Ant(boolean walkSouth) {
      this.walkSouth = walkSouth;
      if (walkSouth) {
         nextDirection = 'S';
      } else {
         nextDirection = 'N';
      }
   }
   
   //Displays itself as a %
   public String toString() {
      return "%";
   }
   
   //Displays itself as red
   public Color getColor() {
      return Color.RED;
   }
   
   //Always returns SCRATCH in a fight
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }
   
   //returns the direction it needs to go, zig-zagging either southeast or northeast
   public Direction getMove() {
      if (nextDirection == 'N') {
         nextDirection = 'E';
         return Direction.NORTH;
      } else if (nextDirection == 'S') {
         nextDirection = 'E';
         return Direction.SOUTH;
      } else {
         if (walkSouth) {
            nextDirection = 'S';
         } else {
            nextDirection = 'N';
         }
         return Direction.EAST;
      }
   }
   
   //Always returns true for eating
   public boolean eat() {
      return true;
   }
}