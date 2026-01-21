
package passwordmanagercreatorap;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHandler {
  
    private static final String DB_URL = "databse url";
    private static final String DB_USER = "databse user name";
    private static final String DB_PASSWORD = "database aassword";

    public void savePasswordDetails(String password, String websiteName, String userName, String email) {
        try (Connection connector = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connector.prepareStatement(
                     "INSERT INTO PasswordsAndDetails(_Password, _websiteName_URL, _UserName, _Email) VALUES (?, ?, ?, ?)")) {

            //java doesnt play nice makes me see python in a new light
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, websiteName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, email);

            int rowsInserted = preparedStatement.executeUpdate();

            
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("No rows were inserted.");
            }
        } catch (SQLException e) {
            System.out.println("Oops, there is an issue: " + e.getMessage());
        }
    }
        //locked down for now 
        public ObservableList<PasswordEntry> getAllFromDB() {
        // Initialize an ObservableList for the TableView
        ObservableList<PasswordEntry> passwords = FXCollections.observableArrayList();
        String query = "SELECT _Password, _websiteName_URL, _UserName, _Email FROM PasswordsAndDetails";

        try (Connection connector = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connector.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String password = resultSet.getString("_Password");
                String websiteName = resultSet.getString("_websiteName_URL");
                String userName = resultSet.getString("_UserName");
                String email = resultSet.getString("_Email");

                // Add to the ObservableList
                passwords.add(new PasswordEntry(password, websiteName, userName, email));
            }
        } catch (SQLException e) {
            System.out.println("Oops, there is an issue: " + e.getMessage());
        }

        return passwords; // Return the ObservableList

}
}

