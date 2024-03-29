import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Frame {
    public static void main(String[] args) {

        // Create Frame and  Panel
        JFrame frame = new JFrame("Age Converter");
        JPanel agePanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        // Create labels and textFields
        JLabel birthLabel = new JLabel("Birthdate: ");
        JTextField birthField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        ageField.setEditable(false);

        // Initialize birthField with empty text and set as editable for user input
        birthField.setText("");
        birthField.setEditable(true);


        //add elements to panel
        agePanel.add(birthLabel);
        agePanel.add(birthField);
        agePanel.add(ageLabel);
        agePanel.add(ageField);

        //create submit button
        JButton submitButton = new JButton("Submit");

        // Add action listener to submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //grab input from birthField textField
                String userInput = birthField.getText();

                // format expected input as mm/dd/yy
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

                // Parse input from string so that it can be used for calculation
                LocalDate birthDate = LocalDate.parse(userInput, formatter);

                //extract just the year value from birthDate
                int birthYear = birthDate.getYear();

                //grab current year from system clock
                int currentYear = LocalDate.now().getYear();

                // Subtract current year from birthYear to find user's age
                int age = currentYear - birthYear;

                //Display age to user in ageField
                ageField.setText(Integer.toString(age) + " years old.");
                submitButton.setForeground(Color.RED);
                submitButton.setText("Calculated");
            }
        });

        buttonPanel.add(submitButton);

        // Layout for Frame and Panel and styling
        frame.setLayout(new GridLayout(2, 1));
        frame.add(agePanel);
        frame.add(buttonPanel);
        agePanel.setLayout(new GridLayout(3, 1));
        Dimension minWidth = frame.getSize();
        minWidth.width = 300;
        frame.setMinimumSize(minWidth);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        submitButton.setForeground(Color.BLUE);
        submitButton.setFont(new Font("Arial",Font.BOLD, 16));


    }
}
