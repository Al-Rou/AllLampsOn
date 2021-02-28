package firstStepLampsGame;

import javax.swing.*;

public class LampsGame {
    public static void main(String [] args){
        String requestedInput = JOptionPane.showInputDialog(null, "From 2 to 20, how large?",
                "Start", JOptionPane.QUESTION_MESSAGE);
        int requestedSize = Integer.parseInt(requestedInput);
        BoardDesign.boardConstruction(requestedSize);
    }
}
