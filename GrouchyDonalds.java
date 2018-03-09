import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class GrouchyDonalds extends JPanel
{
  //Booleans used by Keylistener
  private static int screen; //1-Menu; 2-Level Select; 3-Tutorial; 4-in Game
  private static int levelNum;
  private boolean inAir = false;
  private static BufferedImage level;
  private BufferedImage victoryMessage;
  private BufferedImage loseMessage;
  private static int win = 0;
  private Boolean fullWin;
  
  //Used to set Donalds in Chair
  private static int donaldsNum = 0;
  
  //Used to set Donalds Position
  private static int firstX;
  private static int firstY;
  private static JFrame frame;
  
  //Lists of Level Yahoos
  public static Yahoo[] YahooList = new Yahoo[0];
  public static Donalds[] DonaldsList = new Donalds[0];
  private static Boundary[] BoundaryList; 
  
  public GrouchyDonalds()
  {
    levelNum = 0;
    screen = 1;
    try {
      level = ImageIO.read(new File("mainMenu.png"));
      loseMessage = ImageIO.read(new File("failMessage.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
    
    //Keyboard Listener
    KeyListener listener = new KeyListener()
    {
      public void keyTyped(KeyEvent e)
      {
      }
      
      public void keyPressed(KeyEvent e)
      {  
        if(e.getKeyCode() == KeyEvent.VK_Q)
          System.exit(0);
                
        if(screen == 1)
        {
          if(e.getKeyCode() == KeyEvent.VK_ENTER)
          {                                                                                                                      
            levelSelect(); 
            screen = 2;
          }
        }
        if(screen == 2)
        {
          if(e.getKeyCode() == KeyEvent.VK_1)
          {
            tutorial();
            screen = 3;
          }
          else if(e.getKeyCode() == KeyEvent.VK_2)
          {
            level2();
            levelNum = 2;
            screen = 4;
          }
          else if(e.getKeyCode() == KeyEvent.VK_3)
          {
            level3(); 
            levelNum = 3;
            screen = 4;
          }
          else if(e.getKeyCode() == KeyEvent.VK_4)
          {
            level4(); 
            levelNum = 4;
            screen = 4;
          }
          else if(e.getKeyCode() == KeyEvent.VK_5)
          {
            level5();
            levelNum = 5;
            screen = 4;
          }
        }
        if(screen == 3)
        {
          if(e.getKeyCode() == KeyEvent.VK_ENTER)
          {    
            level1();
            levelNum = 1;
            screen = 4;
          }
        }
        if(screen == 4)
        {
          if(e.getKeyCode() == KeyEvent.VK_R)
          {
            LaunchingChair.reset();
            levelSet();
            DonaldSet();
          }
          if(e.getKeyCode() == KeyEvent.VK_L)
          {
            levelSelect();
            screen = 2;
            YahooList = new Yahoo[0];
            DonaldsList = new Donalds[0];
          }
          if(!inAir)
            LaunchingChair.keyPressed(e); 
          
          if(inAir)
          {
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
              LaunchingChair.keyPressed(e);
            }
          }
        }
      }
      
      public void keyReleased(KeyEvent e) 
      {   
      }
    };
    addKeyListener(listener);
    setFocusable(true);
  }
  
  private static void levelSelect()
  {
    donaldsNum = 0;
    try {
      level = ImageIO.read(new File("levelSelect.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
  
  private void tutorial()
  {
    try {
      level = ImageIO.read(new File("tutorialScreen.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
  
  private static void level1()
  {
    YahooList = new Yahoo[3];
    YahooList[0] = new Minion(560, 360);
    YahooList[1] = new Minion(640, 310);
    YahooList[2] = new Minion(730, 260);
    
    //donalds not in the launching chair will be stacked on top of each other like a snowman    
    DonaldsList = new Donalds[3];
    DonaldsList[0] = new Red(93, 430);
    DonaldsList[1] = new Red(30, 420);
    DonaldsList[2] = new Red(30, 460);
    
    donaldsNum = 0;
    levelNum=1;
    win = 0;
    firstX = 93;
    firstY = 430;
    
    BoundaryList = new Boundary[3];
    BoundaryList[0] = new Boundary(558, 404, 40, 100);
    BoundaryList[1] = new Boundary(640, 350, 40, 150);
    BoundaryList[2] = new Boundary(730, 300, 40, 200);
    
    
    try {
      level = ImageIO.read(new File("level1.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
  
  private static void level2()
  {
    YahooList = new Yahoo[3];
    YahooList[0] = new Minion(511, 360);
    YahooList[1] = new Minion(594, 264);
    YahooList[2] = new Minion(926, 360);
    
    DonaldsList = new Donalds[3];
    DonaldsList[0] = new Yellow(93, 430);
    DonaldsList[1] = new Red(30, 420);
    DonaldsList[2] = new Red(30, 460);
    
    donaldsNum = 0;
    levelNum=2;
    firstX = 93;
    firstY = 430;
    
    BoundaryList = new Boundary[3];
    BoundaryList[0] = new Boundary(511, 404, 40, 100);
    BoundaryList[1] = new Boundary(594, 304, 40, 200);
    BoundaryList[2] = new Boundary(926, 404, 40, 100);
    
    try {
      level = ImageIO.read(new File("level2.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
  
  private static void level3()
  {
    YahooList = new Yahoo[5];
    YahooList[0] = new Minion(503, 396);
    YahooList[1] = new Minion(562, 337);
    YahooList[2] = new Corporal(622, 282);
    YahooList[3] = new Minion(681, 220);
    YahooList[4] = new Minion(850, 456);
    
    DonaldsList = new Donalds[4];
    DonaldsList[0] = new Yellow(100, 430);
    DonaldsList[1] = new Red(30, 380);
    DonaldsList[2] = new Yellow(30, 420);
    DonaldsList[3] = new Red(30, 460);
    
    donaldsNum = 0;
    levelNum=3;
    firstX = 100;
    firstY = 430;
    
    BoundaryList = new Boundary[5];
    BoundaryList[0] = new Boundary(493, 440, 60, 60);
    BoundaryList[1] = new Boundary(552, 381, 60, 60);
    BoundaryList[2] = new Boundary(612, 322, 60, 60);
    BoundaryList[3] = new Boundary(671, 264, 60, 240);
    BoundaryList[4] = new Boundary(959, 137, 40, 363);
    
    try {
      level = ImageIO.read(new File("level3.png"));
    } 
    catch (IOException e)
    {
      System.out.println("No Image");
    }
  }
  
  private static void level4()
  {
    YahooList = new Yahoo[6];
    YahooList[0] = new Minion(449, 396);
    YahooList[1] = new Minion(510, 396);
    YahooList[2] = new Corporal(566, 340);
    YahooList[3] = new Minion(641, 456);
    YahooList[4] = new Minion(696, 456);
    YahooList[5] = new King(855, 460);
    
    DonaldsList = new Donalds[4];
    DonaldsList[0] = new Yellow(100, 430);
    DonaldsList[1] = new Yellow(30, 380);
    DonaldsList[2] = new Yellow(30, 420);
    DonaldsList[3] = new Red(30, 460);
    
    donaldsNum = 0;
    levelNum=4;
    firstX = 100;
    firstY = 430;
    
    BoundaryList = new Boundary[4];
    BoundaryList[0] = new Boundary(439, 440, 120, 60);
    BoundaryList[1] = new Boundary(556, 381, 60, 120);
    BoundaryList[2] = new Boundary(750, 291, 40, 210);
    BoundaryList[3] = new Boundary(959, 137, 40, 363);
    
    try {
      level = ImageIO.read(new File("level4.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
  
  private static void level5()
  {
    YahooList = new Yahoo[5];
    YahooList[0] = new Corporal(479, 289);
    YahooList[1] = new King(539, 441);
    YahooList[2] = new Corporal(732, 289);
    YahooList[3] = new Minion(824, 460);
    YahooList[4] = new Minion(874, 460);
    
    DonaldsList = new Donalds[4];
    DonaldsList[0] = new Yellow(108, 430);
    DonaldsList[1] = new Yellow(30, 380);
    DonaldsList[2] = new Yellow(30, 420);
    DonaldsList[3] = new Red(30, 460);
    
    donaldsNum = 0;
    levelNum=5;
    firstX = 108;
    firstY = 430;
    
    BoundaryList = new Boundary[6];
    BoundaryList[0] = new Boundary(474, 0, 50, 184);
    BoundaryList[1] = new Boundary(469, 329, 60, 170);
    BoundaryList[2] = new Boundary(529, 388, 66, 40);
    BoundaryList[3] = new Boundary(529, 483, 193, 17);
    BoundaryList[4] = new Boundary(722, 329, 60, 180);
    BoundaryList[5] = new Boundary(960, 0, 40, 500);
    
    try {
      level = ImageIO.read(new File("level5.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("No Image");
    }
  }
  
  private void winCheck()
  {
    fullWin = true;
    for(int i=0; i<YahooList.length; i++)
    {
      if(YahooList[i].alive > 0)
        fullWin = false;
    }
    if(fullWin)
        win = 2;
    else if(donaldsNum>=DonaldsList.length)
      win = 1;
  }
  
  private static void levelSet()
  {
    LaunchingChair.reset();
    win=0;
    if(levelNum == 1)
      level1();
    else if(levelNum == 2)
      level2();
    else if(levelNum == 3)
      level3();
    else if(levelNum == 4)
      level4();
    else if(levelNum == 5)
      level5();
  }
  
  private static void DonaldSet()
  {
    if(screen==2)
    {
      DonaldsList = new Donalds[0];
      YahooList = new Yahoo[0];
    }
    if(donaldsNum > 0 && donaldsNum < DonaldsList.length)
    {
      DonaldsList[donaldsNum].setX(firstX);
      DonaldsList[donaldsNum].setY(firstY); 
    }
  }
  
  public void paint(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawImage(level, 0, 0, null);
    for(int i=0; i<YahooList.length; i++)
      YahooList[i].paint(g2d);
    for(int i=0; i<DonaldsList.length; i++)
      DonaldsList[i].paint(g2d);
    
    if(screen==4)
    {
      g2d.setColor(Color.RED);
      g.setFont(new Font("default", Font.BOLD, 33));
      g.drawString(""+LaunchingChair.getAngle(), 95, 90);
      
      int length = ((LaunchingChair.getSpeed()-15)*14)+4;
      g.setColor(Color.RED);
      g.fillRect(96, 31, length, 15);
    }
    
    if(win==2)
    {
      if(levelNum == 5)
      {
        try {
          victoryMessage = ImageIO.read(new File("finalVictoryMessage.png"));
        } 
        catch (IOException e) 
        {
          System.out.println("No Image");
        }
        g.drawImage(victoryMessage, 0, 0, null);
      }
      else
      {
        try {
          victoryMessage = ImageIO.read(new File("victoryMessage.png"));
        } 
        catch (IOException e) 
        {
          System.out.println("No Image");
        }
        g.drawImage(victoryMessage, 0, 0, null);
      }
    }
    else if(win == 1)
      
      g.drawImage(loseMessage, 0, 0, null);
  }
  
  private void move() 
  {
    if (!LaunchingChair.getLaunch())
    {
      DonaldsList[donaldsNum].setYa(LaunchingChair.getYa());
      DonaldsList[donaldsNum].setXa(LaunchingChair.getXa());
    }
    
    if (LaunchingChair.getLaunch())
    {
      DonaldsList[donaldsNum].collisions(BoundaryList);
      DonaldsList[donaldsNum].move();
      
      for(int i=0; i<YahooList.length; i++)
        YahooList[i].collisions(DonaldsList);
         
      if(LaunchingChair.getAbility())
        DonaldsList[donaldsNum].performAbility();
      
      if(DonaldsList[donaldsNum].moving==false && donaldsNum<DonaldsList.length)
      {
        LaunchingChair.reset();
        donaldsNum++;
        DonaldSet();
      }
      winCheck();
    }
  }
  
  public static void main(String []args) throws InterruptedException
  {
    frame = new JFrame("Grouchy Donalds");
    frame.setSize(1000, 624);
    frame.setResizable(false);
    GrouchyDonalds GD = new GrouchyDonalds();
    frame.add(GD);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    while(true)
    {
      GD.repaint();
      Thread.sleep(50);
      if(screen==4)
      {
        if(win==0 && DonaldsList[donaldsNum]!=null)
          GD.move();
        else if(win==1)
        {
          Thread.sleep(3000);
          levelSet();
        }
        else
        {
          Thread.sleep(3000);
          if(levelNum==5)
          {
            win=0;
            screen = 2;
            LaunchingChair.reset();
            DonaldSet();
            levelSelect();
          }
          else
          {
            levelNum++;
            levelSet();
          }
        }
      }
    }
  }
}