import java.awt.event.*;

public class LaunchingChair
{
  //Launch angle
  private static int angle=0;
  //Speed, in both x, y, and total
  private static double xa=0.0; 
  private static double ya=0.0;
  private static int speed=15;
  //Boolean to tell whether or not it should be passed
  private static boolean launch;
  private static boolean ability;
  
   
  //Returns the x-axis speed
  public static double getXa()
  {
    xa=speed*Math.cos(angle * Math.PI / 180);
    return xa;
  }
  
  //Returns the y-axis speed
  public static double getYa()
  {
    ya=speed*Math.sin(angle * Math.PI / 180);
    return ya;
  }
  
  //Returns launch
  public static boolean getLaunch()
  {
    return launch;
  }
  
  public static int getAngle()
  {
    return angle;
  }
  
  public static int getSpeed()
  {
    return speed;
  }
  
  public static boolean getAbility()
  {
    return ability;
  }
  
  public static void reset()
  {
    angle=0;
    xa=0.0; 
    ya=0.0;
    speed=15;
    launch = false;
    ability = false;
  }
  
  //Keypad commands to tilt up, down, and to increase or decrease power
  public static void keyPressed(KeyEvent e) 
  {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      if (speed<29&&!launch)
      {
      speed++;
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      if (speed>15&&!launch)
      {
      speed--;
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      if (angle<80&&!launch)
      {
      angle++;
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      if (angle>0&&!launch)
      {
      angle--;
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      ya=getYa();
      xa=getXa();
      launch=true;
    }
    
    if (e.getKeyCode() == KeyEvent.VK_ENTER)
    {
      if (launch)
        ability=true;
    }
  }
}