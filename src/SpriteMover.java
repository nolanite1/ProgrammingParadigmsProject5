//Sailesh Sai Sirigineedi
//10/22/19
//SpriteMover class for Assignment5

public class SpriteMover implements Runnable {
    private Model model;
    private View view;
    public SpriteMover(Model model, View view){
        this.model = model;
        this.view = view;
    }
    public void run(){
        while(true){
            model.updateScene(view.getWidth(),view.getHeight());
            view.repaint();
            try{
                Thread.sleep(2);
            }catch (InterruptedException e){}
        }
    }

}
