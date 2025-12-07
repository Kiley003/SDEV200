import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//* create table Temp(num1 double, num2 double, num3 double)*//

public class Module6Assignment(2) extends JFrame {
    private DBConnectionPanel connectionPanel;
    private JButton connectButton;
    private JButton insertWithoutBatchButton;
    private JButton insertWithBatchButton;
    private JTextArea outputArea;

    public Module6Assignment(2)() {

        connectionPanel = new DBConnectionPanel();
        connectButton = new JButton("connect database");
        insertWithoutBatchButton = new JButton("Insert without batch");
        insertWithBatchButton = new JButton("Insert with batch");
        outputArea = new JTextArea(20, 60);
        outputArea.setEditable(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(connectButton);
        buttonPanel.add(insertWithoutBatchButton);
        buttonPanel.add(insertWithBatchButton);

        setLayout(new BorderLayout());
        add(connectionPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        connectButton.addActionListener(e -> connectToDatabase());
        insertWithoutBatchButton.addActionListener(e -> insertWithoutBatch());
        insertWithBatchButton.addActionListener(e -> insertWithBatch());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            connection = connectionPanel.getConnection();
            outputArea.append("Connect to database successfully.\n");
        } catch (Exception ex) {
            outputArea.append("Connection failed: " + ex.getMessage() + "\n");
        }
    }

    private void insertWithoutBatch() {
        try {
            long start = System.currentTimeMillis();
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)"
            );

            for (int i = 0; i < 1000; i++) {
                ps.setDouble(1, Math.random());
                ps.setDouble(2, Math.random());
                ps.setDouble(3, Math.random());
                ps.executeUpdate();
            }

            long end = System.currentTimeMillis();
            outputArea.append("Inserted 1000 records WITHOUT batch in " + (end - start) + " ms.\n");
        } catch (SQLException ex) {
            outputArea.append("Error: " + ex.getMessage() + "\n");
        }
    }

    private void insertWithBatch() {
        try {
            long start = System.currentTimeMillis();
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)"
            );

            for (int i = 0; i < 1000; i++) {
                ps.setDouble(1, Math.random());
                ps.setDouble(2, Math.random());
                ps.setDouble(3, Math.random());
                ps.addBatch();
            }

            ps.executeBatch();
            long end = System.currentTimeMillis();
            outputArea.append("Inserted 100 records in batch " + (end - start) + " ms.\n");
        } catch (SQLException ex) {
            outputArea.append("Error: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BatchInsertDemo::new);
    }
}
