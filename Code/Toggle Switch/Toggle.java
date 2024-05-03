import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Toggle implements ItemListener {
    static JLabel text;

    // Driver function
    public static void main(String args[]) {
        // Create a frame
        JFrame frame = new JFrame("Toggle Button");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);

        // Create an object Toggle
        Toggle obj = new Toggle();

        // Create a Toggle Button
        JToggleButton button = new JToggleButton("ToggleButton");
        button.setBounds(150, 100, 200, 100);
        button.addItemListener(obj);
        frame.add(button);

        // Create a label
        text = new JLabel();
        text.setBounds(150, 250, 300, 100);
        text.setText("Click on the Toggle Button");
        frame.add(text);

        // Display the frame
        frame.setVisible(true);
    }

    // TOGGLE SWITCH
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED)
            text.setText("Status of Toggle Button :SELECTED");
        else
            text.setText("Status of Toggle Button :DESELECTED");
    }
}
