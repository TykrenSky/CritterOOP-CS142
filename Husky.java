//Tieran Rashid
//3/5/18
//CSE142A
//TA: Michael Sulistio
//Assignment #8
//
//This is an awesome Husky creature that tries to be smart by looking for food and mates
//and only risking its life if it is worthless. also knows the art of disguise
import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   private int steps;
   private Direction direction;
   private boolean impotent;
   private boolean confident;
   private String disguise;
   private Random rand;
   private int confCount;
   
   public Husky() {
      steps = 3;
      rand = new Random();
      impotent = false;
      confident = true;
      disguise = "H";
      newDirection();
      confCount = 3;
   }
   
   public Attack fight(String opponent) {
      if (confident) {
         int i = -1;
         try {
            i = Integer.parseInt(opponent);
         } catch (Exception e) {}
         if (opponent.equals("%")) {
            return Attack.ROAR;
         } else if (opponent.equals("^") || opponent.equals("<") || opponent.equals(">") || 
               opponent.equals("V")) {
            return Attack.SCRATCH;     
         } else if (opponent.equals("S")) {
            return Attack.POUNCE;
         } else if (i >= 0) {
            return Attack.ROAR;
         } else if (i == 0) {
            return Attack.SCRATCH;
         }
      } else if (disguise == "11" && confident) {
         return Attack.POUNCE;
      }
      int choice = rand.nextInt(3);
      if (choice == 0) {
         return Attack.ROAR;
      } else if (choice == 1) {
         return Attack.SCRATCH;
      } else {
         return Attack.POUNCE;
      }
      
   }
   
   public Color getColor() {
      if (!impotent) {
         return Color.RED;
      } else {
         return Color.BLUE;
      }
   }
   
   public String toString() {
      String[] surroundings = {getNeighbor(Direction.NORTH), getNeighbor(Direction.EAST), // 0
            getNeighbor(Direction.SOUTH), getNeighbor(Direction.WEST) };                  //3  1
                                                                                          //  2
      int enemyAt = -1;
      int safeHuskyAt = -1;
      int foodAt = -1;
      int safeExit = -1;
      for (int i = 0; i < surroundings.length; i++) {
         if (surroundings[i].equals("T")) {
            safeHuskyAt = i;
         } else if (surroundings[i].equals(".")) {
            foodAt = i;
         } else if (!surroundings[i].equals(" ") && !surroundings[i].equals("11")
               && !surroundings[i].equals("t")) {
            enemyAt = i;
         } else if (surroundings[i].equals(" ")) {
            safeExit = i;
         }
      }
      
      if (enemyAt >= 0) {
         disguise = "11";
      } else if (impotent) {
         disguise = "t";
      } else {
         disguise = "T";
      }
      
      if (confCount > 0) {
         confCount--;
         confident = true;
      } else {
         confCount = 3;
         confident = false;
      }
      return disguise;
   }
   
   public Direction getMove() {
      String[] surroundings = {getNeighbor(Direction.NORTH), getNeighbor(Direction.EAST), // 0
            getNeighbor(Direction.SOUTH), getNeighbor(Direction.WEST) };                  //3  1
                                                                                          //  2
      int enemyAt = -1;
      int safeHuskyAt = -1;
      int foodAt = -1;
      int safeExit = -1;
      for (int i = 0; i < surroundings.length; i++) {
         if (surroundings[i].equals("T")) {
            safeHuskyAt = i;
         } else if (surroundings[i].equals(".")) {
            foodAt = i;
         } else if (!surroundings[i].equals(" ") && !surroundings[i].equals("11")
               && !surroundings[i].equals("t")) {
            enemyAt = i;
         } else if (surroundings[i].equals(" ")) {
            safeExit = i;
         }
      }
      
      
      
      if (enemyAt >= 0) {
         if (!impotent) {
            if (safeExit != -1) {
               newDirection(safeExit);            
            } else if (foodAt != -1) {
               newDirection(foodAt);
            } else if (safeHuskyAt != -1) {
               newDirection(safeHuskyAt);
            } else {
               newDirection((enemyAt + 2) % 4);
            }
         } else {
            newDirection(enemyAt);
         }
      } else if (safeHuskyAt >= 0 && !impotent) {
         newDirection(safeHuskyAt);
      } else if (foodAt >= 0) {
         newDirection(foodAt);
      } else {
         if (steps > 0) {
            steps--;
         } else {
            steps = 2;
            newDirection();
         }
      }
      return direction;
   }
   
   public boolean eat() {
      String[] surroundings = {getNeighbor(Direction.NORTH), getNeighbor(Direction.EAST), // 0
            getNeighbor(Direction.SOUTH), getNeighbor(Direction.WEST) };                  //3  1
                                                                                          //  2
      int enemyAt = -1;
      int safeHuskyAt = -1;
      int foodAt = -1;
      int safeExit = -1;
      for (int i = 0; i < surroundings.length; i++) {
         if (surroundings[i].equals("T")) {
            safeHuskyAt = i;
         } else if (surroundings[i].equals(".")) {
            foodAt = i;
         } else if (!surroundings[i].equals(" ") && !surroundings[i].equals("11")
               && !surroundings[i].equals("t")) {
            enemyAt = i;
         } else if (surroundings[i].equals(" ")) {
            safeExit = i;
         }
      }
      
      return enemyAt == -1;
   }
   
   public void mate() {
      impotent = true;
   }
   
   private void newDirection() {
      int determine = rand.nextInt(4);
      newDirection(determine);
   }
   
   private void newDirection(int determine) {
      if (determine == 0) {
         direction = Direction.NORTH;
      } else if (determine == 1) {
         direction = Direction.EAST;
      } else if (determine == 2) {
         direction = Direction.SOUTH;
      } else {
         direction = Direction.WEST;
      }
   }
}