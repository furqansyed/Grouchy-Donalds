import javax.imageio.*;
import java.io.*;

public class Yellow extends Donalds
{
  public Yellow(int x, int y)
  {
    this.x=x;
    this.y=y;
    try 
    {
      img = ImageIO.read(new File("yellowDonald.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No image");
    }
  }
  public void performAbility()
  {
    if (!usedability)
    {
      xa=xa*2.5;
      ya=ya*2.5;
      usedability=true;
    }
  }
}