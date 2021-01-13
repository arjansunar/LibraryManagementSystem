package GUI.route;

import GUI.CreateFrame;
import GUI.dependencies.CreateFrameOnButtonClick;
import GUI.dependencies.GoHomeButton;

public class DeleteBook{
  public static void createDeleteBook(CreateFrame frame, String text){
    var deleteFrame= CreateFrameOnButtonClick.createFrame(frame,text);
    GoHomeButton.createButton(deleteFrame,frame);
  }
}
