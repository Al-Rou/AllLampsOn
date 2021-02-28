package firstStepLampsGame;

import javax.swing.JButton;
import java.awt.*;

public class BoardButtons extends JButton {
    private int xCoord;
    private int yCoord;
    public Boolean buttonStatus;

    public void changeStatus(){
        buttonStatus = !buttonStatus;
    }
    public void setStatus () {
        buttonStatus = false;
    }
    public void resetStatus () {
        buttonStatus = true;
    }
    public boolean getStatus(){
        return (buttonStatus);
    }
    public void setXCoord (int a){
        xCoord = a;
    }
    public void setYCoord (int a){
        yCoord = a;
    }
    public int getXCoord (){
        return (xCoord);
    }
    public int getYCoord (){
        return (yCoord);
    }
    public void setColour (boolean a){
        if (a == true) {
            setBackground(new Color(50, 200, 255));
        }
        else if (a == false) {
            setBackground(new Color(200, 50, 255));
        }
        }
}
