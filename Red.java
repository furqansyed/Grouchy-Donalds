import javax.imageio.*;
import java.io.*;
public class Red extends Donalds
{
  public Red(int x, int y)
  {
    this.x=x;
    this.y=y;
    try 
    {
      img = ImageIO.read(new File("redDonald.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No image");
    }
  }
}