import javax.imageio.*;
import java.io.*;

public class Corporal extends Yahoo
{
  public Corporal(int x, int y)
  {
    this.x = x;
    this.y = y;
    hitCount = 5;
    
    try {
      img = ImageIO.read(new File("corporal.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
  
  public void setHitCount()
  {
    hitCount-=1;
    if(hitCount<5)
    {
      try {
        img = ImageIO.read(new File("injuredCorporal.png"));
      } 
      catch (IOException e) 
      {
        System.out.println("No Image");
      } 
    }
    if(hitCount<=0)
      alive--;
  }  
}