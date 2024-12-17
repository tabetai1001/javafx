package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(300, 300);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }
    // private class ButtonClickListener implements ActionListener {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // String buttonText = e.getActionCommand(); // Lấy text của nút được nhấn
    // if (buttonText.equals("Clear")) {
    // tfDisplay.setText(""); // Xóa nội dung trong tfDisplay
    // } else {
    // tfDisplay.setText(tfDisplay.getText() + buttonText); // Thêm số vào tfDisplay
    // }
    // }
    // }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = e.getActionCommand(); // Get the text of the pressed button
            if (buttonText.equals("C")) {
                tfDisplay.setText(""); // Clear the text in tfDisplay
            } else if (buttonText.equals("DEL")) {
                // Handle "DEL" case (delete last character)
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1)); // Remove last character
                }
            } else {
                // Append the number to the text field
                tfDisplay.setText(tfDisplay.getText() + buttonText);
            }
        }
    }

    // // Hàm main để chạy ứng dụng
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGrid());
    }
}