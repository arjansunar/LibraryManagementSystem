package GUI.dependencies;

import javax.swing.JFrame;
import javax.swing.JButton;

public class GoHomeButton {
  public static JButton createButton(JFrame currentFrame,JFrame homePage){
    var home = new JButton("Go Home");
    home.addActionListener(al -> {
      currentFrame.dispose();
      homePage.setVisible(true);
    });
    return home;
  }
}
