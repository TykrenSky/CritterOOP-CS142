//Tieran Rashid
//3/5/18
//CSE142A
//TA: Michael Sulistio
//Assignment #8
//
//This is a hippo Critter that eats a certain number of times before stopping, displaying
//the number of times it will eat, and scratches if hungry and pounces if not
//Walks around randomly
import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
   private int steps;
   private Direction direction;
   private int hunger;
   
   //Constructs a hippo with a starting direction and a hunger value given by its parameter
   public Hippo(int hunger) {
      steps = 5;
      this.hunger = hunger;
      newDirection();
   }
   
   //returns gray if hungry and white if full
   public Color getColor() {
      if (hunger > 0) {
         return Color.GRAY;
      } else {
         return Color.WHITE;
      }
   }
   
   //Returns its current hunger
   public String toString() {
      return "" + hunger;
   }
   
   //If it is hungry it will scratch, otherwise it will pounce
   public Attack fight(String opponent) {
      if (hunger > 0) {
         return Attack.SCRATCH;
      } else {
         return Attack.POUNCE;
      }
   }
   
   //it will eat if hungry and will not if full
   public boolean eat() {
      if (hunger > 0) {
         hunger--;
         return true;
      } else {
         return false;
      }
   }
   
   //Moves in a random direction for 5 steps then switches
   public Direction getMove() {
      if (steps > 0) {
         steps--;
         return direction;
      } else {
         steps = 4;
         newDirection();
         return direction;
      }
      
   }
   
   //assigns a random direction to the hippo
   private void newDirection() {
      Random rand = new Random();
      int determine = rand.nextInt(4);
      if (determine == 0) {
         direction = Direction.NORTH;
      } else if (determine == 1) {
         direction = Direction.EAST;
      } else if (determine == 2) {
         direction = Direction.WEST;
      } else {
         direction = Direction.SOUTH;
      }
   }
}