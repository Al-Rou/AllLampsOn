package firstStepLampsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardDesign extends JFrame {
    private static int boardLength;
    private static int numberOfButtons;
    public static BoardButtons [][] buttonDesign;
    private static JButton onButton;
    private static JButton offButton;
    private static JButton resetButton;
    private static JButton explanationButton;
    private static JLabel endMessage1;
    private static JLabel endMessage2;
    private static int counterResult = 0;

    public BoardDesign (){
        boardLength = 550;
        onButton = new JButton ("ON");
        offButton = new JButton ("OFF");
        resetButton = new JButton ("Reset");
        explanationButton = new JButton ("Explain");
    }
    public static void boardConstruction (int inputNumber){
        numberOfButtons = inputNumber;
        buttonDesign = new BoardButtons [numberOfButtons][numberOfButtons];
        BoardDesign playBoard = new BoardDesign ();
        playBoard.setLayout(null);
        playBoard.setSize(boardLength+20, boardLength+150);
        resetButton.setBounds(50, boardLength+25, 100, 50);
        resetButton.setActionCommand("R");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton firstButton = (JButton) e.getSource();
                BoardDesign anFrame = (BoardDesign) firstButton.getRootPane().getParent();
                String comm1 = firstButton.getActionCommand();
                if (comm1.equalsIgnoreCase("R")){
                    anFrame.resetAllBoard ();
                }
            }
        });
        explanationButton.setBounds(boardLength-150, boardLength+25, 100, 50);
        explanationButton.setActionCommand("E");
        explanationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton secondButton = (JButton) e.getSource();
                BoardDesign anFrame = (BoardDesign) secondButton.getRootPane().getParent();
                String comm2 = secondButton.getActionCommand();
                if (comm2.equalsIgnoreCase("E")){
                    anFrame.explanationBoard ();
                }
            }
        });
        onButton.setBounds(180, boardLength+25, 70, 50);
        offButton.setBounds(260, boardLength+25, 70, 50);
        onButton.setBackground(new Color(50, 200, 255));
        offButton.setBackground(new Color(200, 50, 255));
        playBoard.add(resetButton);
        playBoard.add(explanationButton);
        playBoard.add(onButton);
        playBoard.add(offButton);
        BoardDesign endPlayBoard = new BoardDesign ();
        endPlayBoard.setLayout(null);
        endPlayBoard.setSize(400, 300);
        for (int i = 0; i < numberOfButtons; i++){
            for (int j = 0; j < numberOfButtons; j++){
                buttonDesign [i][j] = new BoardButtons();
                buttonDesign [i][j].setStatus();
                buttonDesign [i][j].setBackground(new Color(200, 50, 255));
                buttonDesign [i][j].setXCoord(j);
                buttonDesign [i][j].setYCoord(i);
                buttonDesign [i][j].setBounds(j*boardLength/numberOfButtons,
                        i*boardLength/numberOfButtons, boardLength/numberOfButtons,
                        boardLength/numberOfButtons);
                buttonDesign [i][j].setActionCommand("P");
                buttonDesign [i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BoardButtons anyButton = (BoardButtons) e.getSource();
                        String comm2 = anyButton.getActionCommand();
                        if (comm2.equalsIgnoreCase("P")){
                            anyButton.changeStatus();
                            anyButton.setColour(anyButton.getStatus());
                            if (anyButton.getXCoord()-1 >= 0){
                                buttonDesign [anyButton.getYCoord()][anyButton.getXCoord()-1].changeStatus();
                                buttonDesign [anyButton.getYCoord()][anyButton.getXCoord()-1].setColour(
                                        buttonDesign [anyButton.getYCoord()][anyButton.getXCoord()-1].getStatus());
                            }
                            if (anyButton.getXCoord()+1 < numberOfButtons){
                                buttonDesign [anyButton.getYCoord()][anyButton.getXCoord()+1].changeStatus();
                                buttonDesign [anyButton.getYCoord()][anyButton.getXCoord()+1].setColour(
                                        buttonDesign [anyButton.getYCoord()][anyButton.getXCoord()+1].getStatus());
                            }
                            if (anyButton.getYCoord()-1 >= 0){
                                buttonDesign [anyButton.getYCoord()-1][anyButton.getXCoord()].changeStatus();
                                buttonDesign [anyButton.getYCoord()-1][anyButton.getXCoord()].setColour(
                                        buttonDesign [anyButton.getYCoord()-1][anyButton.getXCoord()].getStatus());
                            }
                            if (anyButton.getYCoord()+1 < numberOfButtons){
                                buttonDesign [anyButton.getYCoord()+1][anyButton.getXCoord()].changeStatus();
                                buttonDesign [anyButton.getYCoord()+1][anyButton.getXCoord()].setColour(
                                        buttonDesign [anyButton.getYCoord()+1][anyButton.getXCoord()].getStatus());
                            }
                            int z = 0;
                            counterResult++;
                            for (int m = 0; m < numberOfButtons; m++){
                                for (int n = 0; n < numberOfButtons; n++){
                                    if (!buttonDesign [m][n].getStatus()){
                                        z++;
                                    }
                                }
                            }
                            if (z == 0){
                                endMessage2 = new JLabel(String.format("%d", counterResult));
                                endMessage2.setBounds(50, 125, 300, 50);
                                endPlayBoard.add(endMessage2);
                                endPlayBoard.setVisible(true);
                            }
                        }
                    }
                });
                playBoard.add(buttonDesign [i][j]);
            }
        }
        playBoard.setVisible(true);
        String mseS = String.format("Your chosen play board is %d", numberOfButtons);
        mseS = mseS + String.format("x%d", numberOfButtons);
        playBoard.setTitle(mseS);
        endPlayBoard.setVisible(false);
        playBoard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        endPlayBoard.setTitle("Finished!");
        endMessage1 = new JLabel ("Congratulations! Your moves: ");
        endMessage1.setBounds(50, 75, 300, 50);
        endPlayBoard.add(endMessage1);
        endPlayBoard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void resetAllBoard (){
        for (int i = 0; i < numberOfButtons; i++){
            for (int j = 0; j < numberOfButtons; j++){
                buttonDesign [i][j].setStatus();
                buttonDesign [i][j].setBackground(new Color(200, 50, 255));
            }
        }
    }
    public void explanationBoard (){
        BoardDesign explBoa = new BoardDesign();
        explBoa.setLayout(null);
        explBoa.setSize(400, 400);
        explBoa.setTitle("Explanation");
        String sText1 = "";
        String sText2 = "";
        sText1 = sText1 + "This game is so user-friendly!";
        sText2 = sText2 + "So, play to learn!";
        JLabel exLabel1 = new JLabel();
        JLabel exLabel2 = new JLabel();
        exLabel1.setBounds(25, 50, 350, 100);
        exLabel2.setBounds(25, 200, 350, 100);
        exLabel1.setText(sText1);
        exLabel2.setText(sText2);
        explBoa.add(exLabel1);
        explBoa.add(exLabel2);
        explBoa.setVisible(true);
        explBoa.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
