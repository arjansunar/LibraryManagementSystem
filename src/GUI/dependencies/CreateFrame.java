//helper class that creates a predefined Jframe

package GUI.dependencies;

import database.Database;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

public class CreateFrame extends JFrame {
  public CreateFrame(int width,int height,String title)  {
    setSize(width,height);
    setVisible(true);
    setLayout(new FlowLayout());

    //changing the default close operation to close the database connection
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        try {

          //closes connection
          Database.closeConnection();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }

        try {

          //kills the program
          Runtime.getRuntime().exec("taskkill /f /im java.exe");
        } catch (IOException e4) {
          e4.printStackTrace();
        }
      }
    });

    //centers frame
    setLocationRelativeTo(null);
    setTitle(title);
  }
}
