//Sailesh Sai Sirigineedi
//10/22/19
//Bank class for Assignment5
import java.awt.*;

public class Bank extends Sprite {
    public Bank(){
        super("/Users/sai2468/IdeaProjects/Assignment5/src/bank.png");
        this.setX(300);
        this.setY(300);
    }
    public void updateImage(Graphics g){
        g.drawImage(getImage(), getX(), getY(), 60, 60, null);
    }
}
