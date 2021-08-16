import javax.swing.*;
import java.awt.*;

public class TTTView {
    Tile[] tiles;
    // Array created in order to add tiles to graphical interface
    boolean alternatingTile = true;
    // Boolean variable for alternation between X and O
    int line = 0;

    // Integer variable to set number of times interface can be clicked
    public TTTView() {

        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {
                        JPanel mainPanel = new JPanel();
                        mainPanel.setLayout(new GridLayout(3, 3));
                        tiles = new Tile[9];
                        for (int i = 0; i < tiles.length; i++) {
                            tiles[i] = new Tile(TTTView.this, i);
                            mainPanel.add(tiles[i].getLabel());
                            // For loop takes length of array and adds tiles.length number of tiles to the JPanel
                        }
                        JFrame mainFrame = new JFrame();
                        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        mainFrame.getContentPane().add(mainPanel);
                        mainFrame.pack();
                        mainFrame.setVisible(true);
                        // This block of code is so that the JFrame is visible

                    }

                });

    }

    public String checkWinner() {
        // Method to check whether there are 3 X's or O's in a certain sequence
        String winner = null;
        // String variable that currently is not assigned to any string, but will be if specific case is fulfilled
        for (int a = 0; a < 8; a++) {
            // For loop considers all possible cases to be considered, as it ranges from 0-7
            String line = null;
            // String variable will be given a string value when a case has occurred
            switch (a) {
                // Switch used in order to detect which case is true
                case 0:
                    line = tiles[0].getLabel().getText() + tiles[1].getLabel().getText() + tiles[2].getLabel().getText();
                    // Line is assigned to string values at top left, middle, right
                    break;
                // Break stops the block of code from executing
                case 1:
                    line = tiles[3].getLabel().getText() + tiles[4].getLabel().getText() + tiles[5].getLabel().getText();
                    // Line is assigned to string values at middle left, middle, right
                    break;
                case 2:
                    line = tiles[6].getLabel().getText() + tiles[7].getLabel().getText() + tiles[8].getLabel().getText();
                    // Line is assigned to string values at bottom left, middle, right
                    break;
                case 3:
                    line = tiles[0].getLabel().getText() + tiles[3].getLabel().getText() + tiles[6].getLabel().getText();
                    // Line is assigned to string values at left top, middle, bottom
                    break;
                case 4:
                    line = tiles[1].getLabel().getText() + tiles[4].getLabel().getText() + tiles[7].getLabel().getText();
                    // Line is assigned to string values at middle top, middle, bottom
                    break;
                case 5:
                    line = tiles[2].getLabel().getText() + tiles[5].getLabel().getText() + tiles[8].getLabel().getText();
                    // Line is assigned to string values at right top, middle, bottom
                    break;
                case 6:
                    line = tiles[0].getLabel().getText() + tiles[4].getLabel().getText() + tiles[8].getLabel().getText();
                    // Line is assigned to string values from left top to right bottom diagonally
                    break;
                case 7:
                    line = tiles[2].getLabel().getText() + tiles[4].getLabel().getText() + tiles[6].getLabel().getText();
                    // Line is assigned to string values from right top to left bottom diagonally
                    break;
            }
            if (line.equals("XXX")) {
                winner = "X";
            }
            // If any line has the characters XXX assigned from the 7 cases, X will be assigned to the winner variable
            else if (line.equals("OOO")) {
                winner = "O";
            }
            // If any line has the characters OOO assigned from the 7 cases, O will be assigned to the winner variable

        }
        return winner;
        // Winner is returned so that it can be used to test who won
    }

    public int tileClicked(int tileSelected) {
        // Method to select tile is made void because no return is needed
        //tileSelected(taken from id in Tile class) is used as a parameter to determine which tile was clicked
        if (tiles[tileSelected].getLabel().getText() == "") {
            //All tiles start with "", so when a tile is selected, its text will change to either "X" or "O"
            if (line < 9) {
                // Sets the max. number of times that the interface can be pressed to 9(number of tiles)
                if (alternatingTile) {
                    tiles[tileSelected].getLabel().setText("X");
                    //Tile text set to X
                    alternatingTile = false;
                    //alternatingTile set to false so that the else conditional code will be in effect(O's turn)
                    tiles[tileSelected].getLabel().disable();
                    //tile is disabled so that it can't be selected again
                    line = line + 1;
                    //counter used to keep within the threshold of 9 clicks
                } else {
                    tiles[tileSelected].getLabel().setText("O");
                    //Tile text set to O
                    alternatingTile = true;
                    //alternatingTile set to true so that the if conditional code will be in effect(X's turn)
                    tiles[tileSelected].getLabel().disable();
                    line = line + 1;
                    //counter used to keep within the threshold of 9 clicks
                }
            }
        }
        winnerDisplay();
        tieDetermination(line);
        //after text has been added to the tile, methods will assess whether a win or tie has occurred
        return line;
        //returns line so that it can be utilized in tieDetermination method
    }

    private void tieDetermination(int line) {
        boolean tie = false;
        if (line == 9) {
            //if grid is filled with X's or O's
            tie = true;
            //tie will become true because the grid is filled and a win hasn't occurred
        }
        if (tie) {
            System.out.println("tie game");
            System.exit(0);
            //program will forcefully end
        }
    }

    private void winnerDisplay() {
        //variable is assigned to the value that checkWinner method has returned
        if (checkWinner() != null) {
            //if theWinner is either X or Y(only two options other than null), winner will be printed
            System.out.println(checkWinner() + " has won!");
            System.exit(0);
            //program will forcefully end
        }
    }
}



