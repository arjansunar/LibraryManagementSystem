package GUI.dependencies;

import database.Database;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

public class CreateFrame extends JFrame {
  public CreateFrame(int width,int height,String title)  {
    setSize(width,height);
    setVisible(true);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        try {
          Database.closeConnection();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }

        try {

          Runtime.getRuntime().exec("taskkill /f /im java.exe");

        } catch (IOException e4) {
          // TODO Auto-generated catch block
          e4.printStackTrace();
        }
      }

    });
    setLocationRelativeTo(null);
    setTitle(title);
  }
}
