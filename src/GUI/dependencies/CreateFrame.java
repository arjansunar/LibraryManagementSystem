package GUI.dependencies;

import javax.swing.JFrame;
import java.awt.FlowLayout;

public class CreateFrame extends JFrame {
  public CreateFrame(int width,int height,String title){
    setSize(width,height);
    setVisible(true);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle(title);
  }
}
