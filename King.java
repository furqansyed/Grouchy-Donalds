import javax.imageio.*;
import java.io.*;

public class King extends Yahoo
{
  public King(int x, int y)
  {
    this.x = x;
    this.y = y;
    hitCount = 1;
    
    try {
      img = ImageIO.read(new File("king.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
}