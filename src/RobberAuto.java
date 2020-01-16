//Sailesh Sai Sirigineedi
//10/22/19
//RobberAuto class for Assignment5
import java.awt.*;

public class RobberAuto extends Auto{
    private static int countCaptured;
    private static int countEscaped;
    private int xRatio;
    private int yRatio;
    private boolean isCaptured = false;
    private boolean escaped = false;
    public RobberAuto(){
        super("RobberAuto",5000,new Engine("V8",20,200),"/Users/sai2468/IdeaProjects/Assignment4/src/red-auto.jpg");
        super.fillUp();
        this.xRatio = (int)(Math.random()*11)-5;
        this.yRatio = (int)(Math.random()*11)-5;
        this.setX(300);
        this.setY(300);
    }
//    public void update(Graphics g){
//        this.drive(40,this.xRatio,this.yRatio);
//        g.drawImage(this.getImage(),this.getX(),this.getY(),60,60,null);
//    }
    public void updateState(int width, int height){
        this.drive(4,this.xRatio,this.yRatio);
        if((this.getX() >= width || this.getX() <=0) &&!escaped){
            countEscaped++;
            escaped = true;
        }
        else if((this.getY()>=height || this.getY()<=0) &&!escaped){
            countEscaped++;
            escaped = true;
        }
    }
    public void updateImage(Graphics g){
        g.drawImage(this.getImage(),this.getX(),this.getY(),60,60,null);
    }
    public void captured(){
        this.setImage("/Users/sai2468/IdeaProjects/Assignment5/src/jail.jpg");
        this.xRatio = 0;
        this.yRatio = 0;
        isCaptured = true;
        countCaptured++;
    }
    public boolean isCaptured(){
        return isCaptured;
    }
    public boolean hasEscaped(){
        return escaped;
    }
    public static int getCountCaptured(){
        return countCaptured;
    }
    public static int getCountEscaped(){
        return countEscaped;
    }
    public static void setCountCaptured(int num){
        countCaptured = num;
    }
    public static void setCountEscaped(int num){
        countEscaped = num;
    }
}
