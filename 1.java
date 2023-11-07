import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author 22cseb40
 */
public class JavaApplication15 {

     private static Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    private static int colorIndex = 0;
    public static void main(String[] args) {
        // TODO code application logic here
      JFrame frame = new JFrame("Background Color Toggle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        final JPanel panel = new JPanel();
        frame.add(panel);

        JButton toggleButton = new JButton("Toggle Background Color");
        panel.add(toggleButton);

        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle the background color
                colorIndex = (colorIndex + 1) % colors.length;
                panel.setBackground(colors[colorIndex]);
            }
        });

        frame.setVisible(true);
    }
}
