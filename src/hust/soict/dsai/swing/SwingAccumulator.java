package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    // Constructor to setup the GUI components and event handlers
    public SwingAccumulator() {
        // Thiết lập layout
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        // Thêm các thành phần GUI
        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); // Không cho chỉnh sửa
        cp.add(tfOutput);

        // Thiết lập JFrame
        setTitle("Swing Accumulator");
        setSize(350, 120); // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng cửa sổ khi nhấn X
        setVisible(true); // Hiển thị cửa sổ
    }

    // Điểm vào chương trình
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingAccumulator());
    }

    // Lớp xử lý sự kiện cho JTextField tfInput
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Lấy số từ tfInput, cộng vào tổng, và hiển thị kết quả
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText(""); // Xóa input sau khi xử lý
            tfOutput.setText(sum + ""); // Hiển thị tổng tích lũy
        }
    }
}
