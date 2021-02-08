package GUI.dependencies;

import javax.swing.JFrame;

public class CreateFrameOnButtonClick {
  public static JFrame createFrame(CreateFrame frame, String text, int  height){
    frame.dispose();
    CreateFrame bookFrame= new CreateFrame(550,height,text);
    System.out.println(text);
    return bookFrame;
  }
}
