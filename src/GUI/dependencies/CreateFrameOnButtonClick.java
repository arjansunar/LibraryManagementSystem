//helper class CreateFrameOnButtonClick that creates a new frame
//on a button click and also disposes previous frame
package GUI.dependencies;

import javax.swing.JFrame;

public class CreateFrameOnButtonClick {
  public static JFrame createFrame(CreateFrame frame, String text, int  height) {
    //disposes previous frame
    frame.dispose();
    //returns back a new frame
    return new CreateFrame(550,height,text);
  }
}
