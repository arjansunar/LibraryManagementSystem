//this class represents the frame that is seen when the application
//first runs
package GUI.route;

import GUI.dependencies.CreateFrame;
import database.Database;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.sql.SQLException;

public class Home {
  static Database db;

  static {
    try {
      db = new Database();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public static void createHomePage(){
    //buttons
    var addBookButton = new JButton("Add book");
    var viewBookButton = new JButton("View books");

    // text objects
    var heading = new JLabel("Welcome to the Library");
    heading.setFont(new Font("Ariel",Font.BOLD,17));
    var headingPanel= new JPanel();
    headingPanel.setLayout(new FlowLayout());
    headingPanel.add(heading);

    // panel with all the buttons
    var buttonGroup = new JPanel();
    buttonGroup.setLayout(new GridLayout(5,1,0,5));

    //adding buttons to panel
    buttonGroup.add(addBookButton);
    buttonGroup.add(viewBookButton);


    var homePanel= new JPanel();

    homePanel.setPreferredSize(new Dimension(200,300));
    homePanel.setLayout( new BoxLayout(homePanel,BoxLayout.Y_AXIS));
    homePanel.add(headingPanel);
    homePanel.add(buttonGroup);

    CreateFrame frame = new CreateFrame(500,300,"Library management system");
    frame.add(homePanel);

    //adding action listener
    addBookButton.addActionListener(e -> {
      try {
        AddBook.createAddBook(frame,"add book", db);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    });
    viewBookButton.addActionListener(e -> {
      try {
        ViewBook.createViewBook(frame,"view book",db);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    });

  }
}
