package GUI.dependencies;

import GUI.CreateFrame;

import javax.swing.*;

public class CreateFrameOnButtonClick {
  public static JFrame createFrame(CreateFrame frame, String text){
    frame.dispose();
    CreateFrame bookFrame= new CreateFrame(500,500,text);
    var title= new JLabel(text);
    bookFrame.add(title);
    System.out.println(text);
    return bookFrame;
  }
}
