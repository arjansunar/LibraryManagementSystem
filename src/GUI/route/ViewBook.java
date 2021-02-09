//ViewBook class
//this class represents the frame where user is able to view all the books
//and make changes to it

package GUI.route;

//database imports
import database.Database;
import database.model.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

//Gui imports
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Dimension;

import GUI.dependencies.CreateFrame;
import GUI.dependencies.CreateFrameOnButtonClick;
import GUI.dependencies.GoHomeButton;

public class ViewBook {
  public static void createViewBook(CreateFrame frame, String text, Database db) throws SQLException {

    //creating the viewFrame and disabling the previous frame
    var viewFrame = CreateFrameOnButtonClick.createFrame(frame, text, 400);
    var homeButton = GoHomeButton.createButton(viewFrame, frame);

    JTable table;
    JScrollPane scrollPane;

    var deleteButton = new JButton("Delete");
    var updateButton = new JButton("Update");
    var finalPanel = new JPanel();
    var panel = new JPanel();
    var buttonPanel = new JPanel();

    //getting all the books stored in the database
    ArrayList<Book> books = db.viewBook();
    String[] column = {"Book ID", "Name", "Price", "Available", "Author"};
    String[][] rows = new String[books.size()][5];

    //adding the books values to row
    for (int i = 0; i < rows.length; i++) {
      Book book = books.get(i);
      rows[i][0] = book.getBookId();
      rows[i][1] = book.getName();
      rows[i][2] = String.valueOf(book.getPrice());
      rows[i][3] = String.valueOf(book.isAvailable());
      rows[i][4] = book.getAuthor();
    }

    //creating table model
    MyTableModel model = new MyTableModel(rows, column);
    table = new JTable(model);
    scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(500, 200));

    buttonPanel.add(updateButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(homeButton);

    panel.setLayout(new GridLayout(0, 1, 0, 40));
    panel.add(scrollPane);
    panel.add(buttonPanel);

    finalPanel.add(panel);
    viewFrame.add(finalPanel);

    //button click events
    deleteButton.addActionListener(e -> {

      //getting all the book Ids
      String[] bookIDs = new String[rows.length];
      for (int i = 0; i < rows.length; i++) {
        bookIDs[i] = rows[i][0];
      }

      //if no cell are selected then allowing users to delete according to book Id
      if (table.getSelectedColumn() == -1) {
        String bookIDField = JOptionPane.showInputDialog("Enter Book ID to delete:");
        if (bookIDField == null) return;
        if (!Arrays.toString(bookIDs).contains(bookIDField)) {
          JOptionPane.showMessageDialog(viewFrame, "Enter correct book ID");
        } else {
          try {

            //deletes the row with the provied book ID from the database
            db.deleteBook(bookIDField);
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
        }
      } else {
        String bookID = rows[table.getSelectedRow()][0];
        try {
          db.deleteBook(bookID);
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      try {
        //updating the UI
        viewFrame.dispose();
        createViewBook(frame, "view book",db);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    });

    updateButton.addActionListener(e -> {

      //getting the selected cell
      int selectedRow = table.getSelectedRow();
      int selectedCol = table.getSelectedColumn();
      String bookId = rows[selectedRow][0];
      String columnName = column[selectedCol];

      //checking the column name and creating logic accordingly
      if (columnName.equalsIgnoreCase("price")) {
        String value = JOptionPane.showInputDialog("Set price to:");
        if (value == null) return;
        try {

          //updates price
          db.updateBook(bookId, Integer.parseInt(value));
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      } else if (columnName.equalsIgnoreCase("available")) {
        String value = JOptionPane.showInputDialog("Set available to:");
        if (value == null) return;
        try {

          //updates availability of the book
          db.updateBook(bookId, Boolean.parseBoolean(value));
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      } else if (columnName.equalsIgnoreCase("name")) {
        String value = JOptionPane.showInputDialog("Set book name to:");
        if (value == null) return;
        try {

          //updates book name
          db.updateBookName(bookId, value);
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      } else {
        String value = JOptionPane.showInputDialog("Set author name to:");
        if (value == null) return;
        try {

          //updates author name
          db.updateBookAuthor(bookId, value);
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      try {

        //updating the UI according to the changes in database
        viewFrame.dispose();
        createViewBook(frame, "view book",db);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    });

  }

}

//table model with cell edits disabled
class MyTableModel extends DefaultTableModel {
  public MyTableModel(String[][] rows,String[] cols){
    super(rows,cols);
  }

  @Override
  public boolean isCellEditable(int row,int col){
    return false;
  }
}
