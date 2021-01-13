package GUI.route;

import GUI.CreateFrame;
import GUI.dependencies.CreateFrameOnButtonClick;
import GUI.dependencies.GoHomeButton;

public class ViewBook {
  public static void createViewBook(CreateFrame frame, String text){
    var viewFrame= CreateFrameOnButtonClick.createFrame(frame,text);
    GoHomeButton.createButton(viewFrame,frame);
  }
}
