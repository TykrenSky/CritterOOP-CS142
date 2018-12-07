//Tieran Rashid
//3/5/18
//CSE142A
//TA: Michael Sulistio
//Assignment #8
//
//This is a bird Critter that flies in a clockwise circle, looking like a < facing its 
//direction of movement, never eats, and roars against % and pounces on any other opponent
import java.awt.*;

public class Bird extends Critter {
   private Direction direction;
   private int steps;
   
   //Constructs a bird to begin facing NORTH
   public Bird() {
      steps = 3;
      direction = Direction.NORTH;
   }
   
   //Flies the bird in a clockwise circle of three steps at a time
   public Direction getMove() {
      if (steps > 0) {
         steps--;
      } else {
         steps = 2;
         if (direction == Direction.NORTH) {
            direction = Direction.EAST;
         } else if (direction == Direction.EAST) {
            direction = Direction.SOUTH;
         } else if (direction == Direction.SOUTH) {
            direction = Direction.WEST;
         } else if (direction == Direction.WEST) {
            direction = Direction.NORTH;
         }
      }
      return direction;
   }
   
   //Roars if the opponent is a %, otherwise pounces
   public Attack fight(String opponent) {
      if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
   }
   
   //Displays blue
   public Color getColor() {
      return Color.BLUE;
   }
   
   //Displays a < facing in the birds current direction of motion
   public String toString() {
      if (direction == Direction.NORTH) {
         return "^";
      } else if (direction == Direction.SOUTH) {
         return "V";
      } else if (direction == Direction.EAST) {
         return ">";
      } else if (direction == Direction.WEST) {
         return "<";
      }
      return "^";
   }
}