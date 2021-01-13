package GUI.route;

import GUI.CreateFrame;
import GUI.dependencies.CreateFrameOnButtonClick;
import GUI.dependencies.GoHomeButton;

public class AddBook {
  public static void createAddBook(CreateFrame frame, String text){
    var addFrame= CreateFrameOnButtonClick.createFrame(frame,text);
    GoHomeButton.createButton(addFrame,frame);
  }
}
