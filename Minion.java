import javax.imageio.*;
import java.io.*;

public class Minion extends Yahoo
{
  public Minion(int x, int y)
  {
    this.x = x;
    this.y = y;
    hitCount = 1;
    
    try {
      img = ImageIO.read(new File("minion.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
}