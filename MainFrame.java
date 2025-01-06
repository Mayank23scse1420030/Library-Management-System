import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        add(new BookPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
