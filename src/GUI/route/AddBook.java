//this class represents the frame where
// user is able to add books to the system

package GUI.route;

//Database imports
import database.Database;
import database.model.Book;

//Gui imports
import GUI.dependencies.CreateFrame;
import GUI.dependencies.CreateFrameOnButtonClick;
import GUI.dependencies.GoHomeButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.Dimension;

import java.sql.SQLException;

public class AddBook {
  public static void createAddBook(CreateFrame frame, String text, Database db) throws SQLException {

    //creating the addFrame and disabling the previous frame
    var addFrame= CreateFrameOnButtonClick.createFrame(frame,text,300);
    var homeButton =GoHomeButton.createButton(addFrame,frame);

    var leftPanel= new JPanel();
    var rightPanel= new JPanel();
    var panel= new JPanel();
    var buttonPanel = new JPanel();
    var finalPanel= new JPanel();

    var bookIdLabel = new JLabel("ID");
    var bookIdTextField= new JTextField(10);

    var bookLabel = new JLabel("Name");
    var bookTextField= new JTextField(10);
    var bookPriceLabel = new JLabel("Price");
    var bookPriceTextField= new JTextField(5);
    var bookAuthorLabel = new JLabel("Author");
    var bookAuthorTextField= new JTextField(10);

    var buttonGroup = new ButtonGroup();
    var availableButton= new JRadioButton("Available");
    var notAvailableButton = new JRadioButton("Not Available");
    var addBookButton= new JButton("Add Book");

    buttonGroup.add(availableButton);
    buttonGroup.add(notAvailableButton);

    leftPanel.setLayout(new GridLayout(0,2,5,10));
    rightPanel.setLayout(new GridLayout(0,2,5,10));
    panel.setLayout(new GridLayout(0,2,15,1));

    //adding action listeners
    addBookButton.addActionListener(e->{
      //checking if no values are passed
      if (!( bookIdTextField.getText().equals("")
              || bookTextField.getText().equals("")
              || bookPriceTextField.getText().equals("")
              || bookAuthorTextField.getText().equals(""))) {
        String bookId = bookIdTextField.getText();
        String name= bookTextField.getText();
        int price= Integer.parseInt(bookPriceTextField.getText());
        boolean available =availableButton.isSelected();
        String author = bookAuthorTextField.getText();

        Book book = new Book(bookId, name, price, available, author);
        System.out.println(book);
        try {
          db.addBook(book);
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }else{
        JOptionPane.showMessageDialog(addFrame,"enter the values");
      }

    });

    // adding components to containers
    leftPanel.add(bookIdLabel);
    leftPanel.add(bookIdTextField);
    leftPanel.add(bookLabel);
    leftPanel.add(bookTextField);
    leftPanel.add(bookPriceLabel);
    leftPanel.add(bookPriceTextField);

    rightPanel.add(bookAuthorLabel);
    rightPanel.add(bookAuthorTextField);
    rightPanel.add(availableButton);

    var p5= new JPanel();
    rightPanel.add(p5);
    rightPanel.add(notAvailableButton);

    buttonPanel.add(addBookButton);
    buttonPanel.add(homeButton);

    panel.add(leftPanel);
    panel.add(rightPanel);

    finalPanel.setLayout(new BoxLayout(finalPanel,BoxLayout.Y_AXIS));

    //dummy panel to center the add view
    var p1= new JPanel();
    p1.setPreferredSize(new Dimension(400,50));
    var p2= new JPanel();

    finalPanel.add(p1);
    finalPanel.add(panel);
    finalPanel.add(p2);
    finalPanel.add(buttonPanel);

    addFrame.add(finalPanel);
  }
}
