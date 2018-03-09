import java.awt.* ;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public abstract class Donalds
{
  protected int x;
  protected int y;
  static protected double xa;
  static protected double ya;
  protected double oldx;
  protected double oldy;
  protected int height=40;
  protected int length=40;
  protected boolean moving=true;
  protected boolean usedability=false;
  protected int alive=2;
  protected BufferedImage img = null;
  
  public void setXa(double a)
  {
    xa=a;
  }
  
  public void setYa(double a)
  {
    ya=a;
  }
  
  public static double getXa()
  {
    return xa;
  }
  
  public static double getYa()
  {
    return ya;
  }
  
  public void move()
  {
    if (moving)
    {
      oldx=x;
      oldy=y;
      x=x+(int)xa;
      ya=ya-0.981;
      y=y-((int)(ya));
    }
    else if(!moving)
    {
      xa=0;
      ya=0;
    }
  }
  
  public void collisions(Boundary[] b)
  {
    if (x>1000||x+length<0||y+height<-400)
    {
      vanish();
      usedability=true;
    }
    for(int i=0;i<b.length;i++)
    {
      //Checking the ground
      if (y+height>=500)
      {
        xa=xa*0.9;
        ya=(-ya)*0.7;
        if (y+height>=500&&ya<2&&ya>-2)
        {
          vanish();
        }
        usedability=true;
      }
      //Collision check left-right of boundary
      if ((x+length>=b[i].getX()&&y+height>b[i].getY()&&oldx+length<b[i].getX()&&y<b[i].getY()+b[i].getHeight())||(x<=b[i].getX()+b[i].getWidth()&&y+height>b[i].getY()&&oldx>b[i].getX()+b[i].getWidth()&&y<b[i].getY()+b[i].getHeight()))
      {
        xa=(-xa)*0.8;
        ya=ya*0.8;
        usedability=true;
      }
      //Collision check up-down boundary
      if (x+length>b[i].getX()&&y+height>=b[i].getY()&&oldy+height<b[i].getY()&&x<b[i].getX()+b[i].getWidth())
      {
        xa=xa*0.8;
        ya=(-ya)*0.8;
        usedability=true;
        if (y+height>=b[i].getY()&&ya<3&&ya>-3)
        {
          vanish();
        }
      }
      if(y<=b[i].getY()+b[i].getHeight()&&x<b[i].getX()+b[i].getWidth()&&x+length>b[i].getX()&&oldy>b[i].getY()+b[i].getHeight())
      {
        xa=xa*0.8;
        ya=(-ya)*0.8;
        usedability=true;
      }
    }
  }
  
  protected void vanish()
  {
    moving=false;
    try 
    {
      img = ImageIO.read(new File("vanish.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No image");
    }
    alive=1;
  }
  
  public void performAbility()
  {
  }
  
  public void setX(int x)
  {
    this.x = x;
  }
  
  public void setY(int y)
  {
    this.y = y;
  }
  
  public int getX()
  {
    return x;
  }
  
  public int getY()
  {
    return y;
  }
  
  public void paint(Graphics2D g)
  {
    if(alive==2)
      g.drawImage(img, x, y, null);
    if(alive==1)
    {
      g.drawImage(img, x, y, null);
      alive=0;
    }
  }
}