import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public abstract class Yahoo
{
  protected int hitCount;
  protected int alive = 2;
  protected int x;
  protected int y;
  protected BufferedImage img;
   
  public void setHitCount()
  {
    hitCount-=1;
    if(hitCount==0)
      alive = 1;
  }
  
  public void paint(Graphics2D g)
  {
    if(alive==2)
      g.drawImage(img, x, y, null);
    if(alive==1)
    {
      try 
      {
        img = ImageIO.read(new File("vanish.png"));
      } 
      catch (IOException e) 
      {
        System.out.println("No image");
      }
      g.drawImage(img, x, y, null);
      alive=0;
    }
  }
  
  public void collisions(Donalds[] DonaldsList)
  {
    for(int i=0; i<DonaldsList.length; i++)
    {
      if((DonaldsList[i].getX()>x && DonaldsList[i].getX()<x+40)
           ||(DonaldsList[i].getX()+40>x && DonaldsList[i].getX()+40<x+40))
      {
        if((DonaldsList[i].getY()>y && DonaldsList[i].getY()<y+40)
           ||(DonaldsList[i].getY()+40>y && DonaldsList[i].getY()+40<y+40))
          setHitCount();
      }
        
    }
  }
}