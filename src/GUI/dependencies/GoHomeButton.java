package GUI.dependencies;

import javax.swing.*;

public class GoHomeButton {
  public static void createButton(JFrame currentFrame,JFrame homePage){
    var home = new JButton("Go Home");
    currentFrame.add(home);
    home.addActionListener(al -> {
      currentFrame.dispose();
      homePage.setVisible(true);
    });
  }
}
