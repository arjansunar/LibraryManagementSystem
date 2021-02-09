package GUI.dependencies;

import javax.swing.JFrame;

public class CreateFrameOnButtonClick {
  public static JFrame createFrame(CreateFrame frame, String text, int  height) {
    frame.dispose();
    return new CreateFrame(550,height,text);
  }
}
