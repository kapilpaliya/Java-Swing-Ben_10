//Import Statements
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;
import java.awt.event.ActionEvent;
//Result Count Temp Class
class result{
    static int win=0,lost=0,match=0;
}
public class Ben_10 extends JFrame implements ActionListener {
    //Variable Declaration.
    Timer time;     int angle=0;        JWindow w;
    String[] img1 = {
            "image\\arti.png","image\\canalbold.png","image\\dimond.png","image\\feedback.png","image\\ghost.png",
            "image\\gray.png","image\\gravattack.png","image\\stinkfly.png","image\\clock.png","image\\shock.png",
            "image\\upchuck.png","image\\bigchill.png","image\\jetray.png","image\\echo.png","image\\fast.png",
            "image\\xlr8.png","image\\AX.png","image\\bran.png","image\\fire.png","image\\for.png",
            "image\\heat.png","image\\reth.png","image\\spider.png","image\\upgrade.png","image\\sor.png",
            "image\\mut.png","image\\rip.png","image\\waybig.png"};
    String[] name = {
            "Arctiguana","Cannonbolt","Diamondhead","Feadback","Ghostfreak",
            "Grey_Metter","Gravattack","Stinkfly","Clockwork","Shocksquatch",
            "Upchuck","Big_Chill","Jetray","Echo_Echo","Fasttrac",
            "XLR8","Alien-X","Brainstom","Swngfire","Forarms",
            "Heatblast","Rath","Spidermonkey","Upgrade","Humangasor",
            "Wildmutt","Ripjaws","WayBig"};
    Random r = new Random();        Container c;        ImageIcon img;      JLabel l, l1, l3;
    JButton[] btn = new JButton[4];         int random = r.nextInt(0,name.length);
    ImageIcon logo = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\logo.png")));


    Ben_10(){
        //Welcome Screen Classing
        welcomeScreen();

        //Frame Creation.
        setTitle("Ban_10");
        setBounds(300,100,660,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(logo.getImage());
        setResizable(false);

        //Container Creating.
        c = getContentPane();
        c.setBackground(Color.GREEN);
        c.setLayout(null);

        //Call All Image's
        img = new ImageIcon(Objects.requireNonNull(getClass().getResource(img1[random])));

        //Font Style Declaration.
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,20);
        Font font1 = new Font(Font.SANS_SERIF,Font.BOLD,30);

        //Label Staring Label Display.
        l = new JLabel("Who Is That Alien?");
        l.setBounds(290,5,280,50);
        l.setFont(font1);
        c.add(l);

        //Add All Image's In One By One.
        l1 = new JLabel(img);
        l1.setBounds(0,10,img.getIconWidth(),img.getIconHeight());
        l1.setBackground(Color.darkGray);
        c.add(l1);

        //Button 1 Position.
        btn[0] = new JButton("Q");
        btn[0].setBounds(210,70,180,50);
        btn[0].setFont(font);
        btn[0].setForeground(Color.green);
        btn[0].setBackground(Color.black);
        btn[0].setBorder(null);
        btn[0].addActionListener(this);
        c.add(btn[0]);

        //Button 2 Position.
        btn[1] = new JButton("Q");
        btn[1].setBounds(450,70,180,50);
        btn[1].setFont(font);
        btn[1].setForeground(Color.green);
        btn[1].setBackground(Color.black);
        btn[1].setBorder(null);
        btn[1].addActionListener(this);
        c.add(btn[1]);

        //Button 3 Position.
        btn[2] = new JButton("Q");
        btn[2].setBounds(210,170,180,50);
        btn[2].setFont(font);
        btn[2].setForeground(Color.green);
        btn[2].setBackground(Color.black);
        btn[2].setBorder(null);
        btn[2].addActionListener(this);
        c.add(btn[2]);

        //Button 3 Position.
        btn[3] = new JButton("Q");
        btn[3].setBounds(450,170,180,50);
        btn[3].setFont(font);
        btn[3].setForeground(Color.green);
        btn[3].setBackground(Color.black);
        btn[3].setBorder(null);
        btn[3].addActionListener(this);
        c.add(btn[3]);

        //Result Bar Display.
        l3 = new JLabel("Win : "+result.win+" | Lost : "+result.lost+" | Match : "+result.match);
        l3.setBounds(200,250,450,50);
        l3.setFont(font1);
        c.add(l3);

        //Call Function To Set Text In Randomly.
        setTextValue();
    }

    //Create Function To Set Text In Randomly.
    public void setTextValue(){
        boolean arr=true;
        int con=0;
        int[] a = new int[4];
        while(arr){
            if((a[0]!=a[1]&&a[0]!=a[2]&&a[0]!=a[3])&&(a[1]!=a[0]&&a[1]!=a[2]&&a[1]!=a[3])&&
                    (a[2]!=a[0]&&a[2]!=a[1]&&a[2]!=a[3])&&(a[3]!=a[0]&&a[3]!=a[1]&&a[3]!=a[2])){
                arr=false;
            }
            else{
                for(int i=0;i<4;i++){
                    a[i]=r.nextInt(0,name.length);
                }
            }
        }
        for(int i=0;i<4;i++){
            if(a[i]==random){
                con++;
            }
            btn[i].setText(name[a[i]]);
        }
        if(con==0){
            int ram = r.nextInt(0,4);
            btn[ram].setText(name[random]);
        }
    }

    //Override ActionListener Function.
    @Override
    public void actionPerformed(ActionEvent e){
        String str="";
        //Button 1 Click Condition's
        if(e.getSource()==btn[0]){
            str=btn[0].getText();
            if(str==name[random]){
                result.win++;
            }
            else{
                result.lost++;
            }
            result.match++;
            setVisible(false);
            new Ben_10();
        }
        //Button 2 Click Condition's
        else if(e.getSource()==btn[1]){
            str=btn[1].getText();
            if(str==name[random]){
                result.win++;
            }
            else{
                result.lost++;
            }
            result.match++;
            setVisible(false);
            new Ben_10();
        }
        //Button 3 Click Condition's
        else if(e.getSource()==btn[2]){
            str=btn[2].getText();
            if(str==name[random]){
                result.win++;
            }
            else{
                result.lost++;
            }
            result.match++;
            setVisible(false);
            new Ben_10();
        }
        //Button 4 Click Condition's
        else if(e.getSource()==btn[3]){
            str=btn[3].getText();
            if(str==name[random]){
                result.win++;
            }
            else{
                result.lost++;
            }
            result.match++;
            setVisible(false);
            new Ben_10();
        }
    }

    //Welcome Screen Function Creation.
    void welcomeScreen(){
        //Welcomes Windows Declarations.
        w = new JWindow(this);
        w.setBounds(300,100,660,350);
        w.setForeground(Color.black);
        w.setVisible(true);

        JPanel p = new JPanel();
        p.setBackground(Color.black);
        p.setBorder(BorderFactory.createLineBorder(Color.white));
        w.add(p);

        //Welcome Screen Logo Image
        ImageIcon welcom = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\background.png")));

        //Add Rotate Ban_10 Watch Icon.
        w.add(new JPanel(){
           public void paint(Graphics g){
               super.paint(g);
               welcom.paintIcon(this,g,0,0);
               g.setColor(Color.green);
               g.fillArc(180,25,300,300,angle,60);
               g.fillArc(180,25,300,300,angle+180,60);
               g.setColor(Color.white);
               g.drawArc(180,25,300,300,0,360);
               angle = (angle-60)%360;
               try{
                   Thread.sleep(200);
               }
               catch(Exception e){
                   System.out.println(e);
               }
               g.setColor(Color.white);
               g.drawString("It's Hero Time!",200,0);
               repaint();
           }
        });

        //Set ProgressBar In Bottom Declaration.
        JProgressBar pb = new JProgressBar(0,100);
        pb.setForeground(Color.green);
        w.add(pb, BorderLayout.PAGE_END);

        //Set Delay Of Opening In Main Game Panel.
        time = new Timer(20,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = pb.getValue();
                if(x==100){
                    w.dispose();
                    Ben_10.this.setVisible(true);
                    time.stop();
                }
                else{
                   pb.setValue(x+10);
                }
            }
        });

        //Time Started In Program Running.
        time.start();

        //Revalidate Or ReOpen The Windows.
        w.revalidate();
    }

    //Main Methode To Used In Run The Code.
    public static void main(String[] args) {
        new Ben_10();
    }
}
