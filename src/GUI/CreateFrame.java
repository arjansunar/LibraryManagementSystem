package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateFrame extends JFrame {
  public CreateFrame(int width,int height,String title){
    setSize(width,height);
    setVisible(true);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle(title);
  }
}
