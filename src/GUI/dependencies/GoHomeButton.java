//helper class GoHomeButton creates a button that disposes
//the frame where its called and redirects to the home frame

package GUI.dependencies;

import javax.swing.JFrame;
import javax.swing.JButton;

public class GoHomeButton {
  public static JButton createButton(JFrame currentFrame,JFrame homePage){
    var home = new JButton("Go Home");
    home.addActionListener(al -> {
      //disposing current frame
      currentFrame.dispose();
      //makes home frame visible
      homePage.setVisible(true);
    });
    return home;
  }
}
