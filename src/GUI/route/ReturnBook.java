package GUI.route;

import GUI.CreateFrame;
import GUI.dependencies.CreateFrameOnButtonClick;
import GUI.dependencies.GoHomeButton;

public class ReturnBook {
  public static void createIssueBook(CreateFrame frame, String text){
    var issueFrame= CreateFrameOnButtonClick.createFrame(frame,text);
    GoHomeButton.createButton(issueFrame,frame);
  }
}
