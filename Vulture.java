//Tieran Rashid
//3/5/18
//CSE142A
//TA: Michael Sulistio
//Assignment #8
//
//An extention of the Bird class that will eat if hungry, and is made hungry by 
//fighting
import java.awt.*;

public class Vulture extends Bird {
   private boolean hungry;
   private int steps;
   private Direction direction;
   
   //Constructs a vulture starting hungry and initializing its clockwise flight
   public Vulture() {
      hungry = true;
      steps = 3;
      direction = Direction.NORTH;
   }
   
   //Displays black
   public Color getColor() {
      return Color.BLACK;
   }
   
   //Will eat if hungry, and will not if not
   public boolean eat() {
      if (hungry) {
         hungry = false;
         return true;
      } else {
         return false;
      }
   }
   
   //Roars against % and pounces against all other, and makes vulture hungry
   public Attack fight(String opponent) {
      hungry = true;
      if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
   }
}