//Sailesh Sai Sirigineedi
//10/22/19
//Model class for Assignment5
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Model
{
    private static int count = 0;
    private ArrayList<Sprite> spriteList;
    Model() throws IOException {
        spriteList = new ArrayList<>();
        spriteList.add(new Bank());
        // this.addSprite(0,0);
    }
    synchronized public void initialize(){
        for(Iterator<Sprite> it = spriteList.iterator();it.hasNext();){
            Sprite s = it.next();
            it.remove();
            }
        RobberAuto.setCountCaptured(0);
        RobberAuto.setCountEscaped(0);
        spriteList.add(new Bank());


    }
    synchronized public void addSprite(int x, int y){
        count++;
        if(count%2==1){
            spriteList.add(new CopAuto());
            spriteList.get(spriteList.size()-1).setX(x);
            spriteList.get(spriteList.size()-1).setY(y);
            for(Sprite sprite: spriteList){
                if(sprite instanceof CopAuto){
                    ((CopAuto) sprite).setOwnXRatio(CopAuto.getxRatio());
                    ((CopAuto) sprite).setOwnYRatio(CopAuto.getyRatio());
                }
            }
        }
        else{
            spriteList.add(new RobberAuto());

        }
    }
    synchronized public void update(Graphics g) {
        for(Sprite sprite: spriteList){
            sprite.updateImage(g);
        }
    }
    synchronized public void updateScene(int width, int height){
        for(Iterator<Sprite> it = spriteList.iterator();it.hasNext();){
            Sprite s = it.next();
            if(s instanceof RobberAuto){
                if(((RobberAuto)s).hasEscaped()){
                    it.remove();
                    System.out.println("I'm free!");
                }
            }
        }
        for(Sprite sprite: spriteList){
            sprite.updateState(width, height);
            if(sprite instanceof CopAuto){
                for(Sprite sprite1: spriteList){
                    if(sprite1 instanceof RobberAuto){
                        if(sprite.overlaps(sprite1)&&!((RobberAuto) sprite1).isCaptured()){
                            ((RobberAuto) sprite1).captured();
                        }
                    }
                }
            }
        }
    }
//    public void fill(){
//        for(Sprite sprite: spriteList){
//            ((Auto)sprite).fillUp();
//        }
//    }
}
