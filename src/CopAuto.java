//Sailesh Sai Sirigineedi
//10/22/19
//CopAuto class for Assignment5
import java.awt.*;

public class CopAuto extends Auto{
    private static int xRatio;
    private static int yRatio;
    private int ownXRatio;
    private int ownYRatio;
    private boolean wentOut = false;
    public CopAuto(){
        super("CopAuto",5000,new Engine("V8",30,100),"/Users/sai2468/IdeaProjects/Assignment4/src/cop-auto.jpg");
        super.fillUp();
        xRatio = (int)(Math.random()*11) - 5;
        yRatio = (int)(Math.random()*11) - 5;
    }
//    public void update(Graphics g){
//        this.drive(20,xRatio,yRatio);
////        this.setX(this.getX()+this.xRatio);
////        this.setY(this.getY()+this.yRatio);
//        g.drawImage(this.getImage(),this.getX(),this.getY(),60,60,null);
//    }
    public static int getxRatio(){
        return xRatio;
    }
    public static int getyRatio(){
        return yRatio;
    }
    public int getOwnXRatio(){
        return ownXRatio;
    }
    public int getOwnYRatio(){
        return ownYRatio;
    }
    public void setOwnXRatio(int num){
        ownXRatio = num;
    }
    public void setOwnYRatio(int num){
        ownYRatio = num;
    }
    public void updateState(int width, int height){
        if(!wentOut){
            ownXRatio = xRatio;
            ownYRatio = yRatio;
        }
        if(this.getX() >= width || this.getX() <=0){
            this.ownXRatio = -this.ownXRatio;
            wentOut = true;
        }
        else if(this.getY()>=height || this.getY()<=0){
            this.ownYRatio = -this.ownYRatio;
            wentOut = true;
        }
        this.drive(2,ownXRatio,ownYRatio);
    }
    public void updateImage(Graphics g){
        g.drawImage(this.getImage(),this.getX(),this.getY(),60,60,null);
    }
}
