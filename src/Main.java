import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Music PLayer");
        new Main().setIcon(window);

        window.add(new MyMusicPanel());
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void setIcon(JFrame window) {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("icons/app_icon.png"));
        window.setIconImage(icon.getImage());
    }
}