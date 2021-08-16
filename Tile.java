import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// Imported from class library to be used in program
public class Tile {
    int id;
    // Variable created so that when tiles are being created later, the for loop can count the number of tiles created
    private JLabel label;
    // Variable created so that tiles can be attuned to user's needs
    TTTView parent;
    // Variable created to connect TTTView to the Tile constructor
    public Tile(TTTView parent, int id ) {
        this.id = id;
        // Assigns current value of id to id
        this.parent = parent;
        // Assigns current value of parent to parent
        label = new JLabel();
        // Label is assigned to new JLabel so that features can be added
        label.setPreferredSize(new Dimension(100, 100));
        // Size of JLabel is set at 50x50 pixels
        label.setBorder(BorderFactory.createEtchedBorder());
        // Visible border is added to the tile
        label.setHorizontalAlignment(SwingConstants.CENTER);
        // Text is centered
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.tileClicked(id);
                // Computer relays that a tile has been clicked from the Tile to TTTView
                // This is done by accessing parent(which connects the two)
                // This then allows the tileClicked method access to which tile was clicked
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //Adds a clicking feature to the tile

    }

    public JLabel getLabel() {

        return label;
        //Takes everything that was assigned to variable above and condenses it for other classes to use
    }
}
