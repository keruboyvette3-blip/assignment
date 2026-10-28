

import javax.swing.*;
import java.awt.*;

public class assignment extends JFrame {

    private JLabel imageLabel;

    public assignment() {
        setTitle("RadioButtonDemo");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel for radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));

        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton pigButton = new JRadioButton("Pig");

        // Group buttons so only one can be selected
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Label to display the selected pet
        imageLabel = new JLabel("Select a pet", SwingConstants.CENTER);
        imageLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Event listeners

        birdButton.addActionListener(e -> {
            showPet("Bird");
            JOptionPane.showMessageDialog(this, "You selected Bird!");
        });

        catButton.addActionListener(e -> {
            showPet("Cat");
            JOptionPane.showMessageDialog(this, "You selected Cat!");
        });

        dogButton.addActionListener(e -> {
            showPet("Dog");
            JOptionPane.showMessageDialog(this, "You selected Dog!");
        });

        rabbitButton.addActionListener(e -> {
            showPet("Rabbit");
            JOptionPane.showMessageDialog(this, "You selected Rabbit!");
        });

        pigButton.addActionListener(e -> {
            showPet("Pig");
            JOptionPane.showMessageDialog(this, "You selected Pig!");
        });


        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        // Default selection
        pigButton.setSelected(true);
        showPet("Pig");

        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void showPet(String pet) {
        String filename = "src/images/" + pet.toLowerCase() + ".JPG";

        ImageIcon icon = new ImageIcon(filename);

        if (icon.getIconWidth() == -1) {
            imageLabel.setText("Image not found: " + filename);
            imageLabel.setIcon(null);
            return;
        }

        Image image = icon.getImage().getScaledInstance(
                300, 250, Image.SCALE_SMOOTH
        );

        imageLabel.setText("");
        imageLabel.setIcon(new ImageIcon(image));
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(assignment::new);
    }
}
