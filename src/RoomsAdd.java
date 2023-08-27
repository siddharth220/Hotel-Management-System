import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomsAdd extends JFrame implements ActionListener {

    RoomsAdd() {
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 900, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

    }
    public static void main(String[] args) {
        new RoomsAdd();
    }
}
