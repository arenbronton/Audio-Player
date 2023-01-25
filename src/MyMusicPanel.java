import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMusicPanel extends JPanel {

    //TODO: PANELS
    JPanel centerPanel;
    JPanel rightPanel;
    JPanel topBar;

    // TODO: BUTTONS
    JButton myMusicTabButton;
    JButton myPlaylistsTabButton;
    JButton settingsTabButton;

    public MyMusicPanel() {
        setPreferredSize(new Dimension(800, 600));
        Sound.playSound("November Rain.wav");

        System.out.println(DataManager.getSongs().get(0).getFilePath());

        setLayout(new BorderLayout());

        setupPanels();
    }

    public void setupPanels() {
        // TODO: TOP BAR
        topBar = new JPanel();
        topBar.setBackground(Color.LIGHT_GRAY);
        topBar.setLayout(new GridBagLayout());
        topBar.setPreferredSize(new Dimension(0, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 0, 10);

        Font topBarButtonFont = new Font("DIALOG", Font.BOLD, 20);

        myMusicTabButton = new JButton("My Music");
        myMusicTabButton.setFocusable(false);
        myMusicTabButton.setBorder(null);
        myMusicTabButton.setFont(topBarButtonFont);
        myMusicTabButton.setBackground(null);

        myPlaylistsTabButton = new JButton("My Playlists");
        myPlaylistsTabButton.setFocusable(false);
        myPlaylistsTabButton.setBorder(null);
        myPlaylistsTabButton.setFont(topBarButtonFont);
        myPlaylistsTabButton.setBackground(null);

        settingsTabButton = new JButton("Settings");
        settingsTabButton.setFocusable(false);
        settingsTabButton.setBorder(null);
        settingsTabButton.setFont(topBarButtonFont);
        settingsTabButton.setBackground(null);

        gbc.gridy = 0;
        gbc.gridx = 0;
        topBar.add(myMusicTabButton, gbc);
        gbc.gridx = 1;
        topBar.add(myPlaylistsTabButton, gbc);
        gbc.gridx = 2;
        topBar.add(settingsTabButton, gbc);

        add(topBar, BorderLayout.NORTH);

        setupTopBarListeners();

        // TODO: CENTER PANEL
        centerPanel = new JPanel();
        //add(centerPanel, BorderLayout.CENTER);



        // TODO: RIGHT PANEL
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        add(rightPanel, BorderLayout.EAST);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(DataManager.getSongs().get(0).getAlbumCover(), 50, 50, null);

        repaint();
    }




    public void setupTopBarListeners() {
        myMusicTabButton.addMouseListener(new MouseHoverDarkenListener(myMusicTabButton));
        myPlaylistsTabButton.addMouseListener(new MouseHoverDarkenListener(myPlaylistsTabButton));
        settingsTabButton.addMouseListener(new MouseHoverDarkenListener(settingsTabButton));
    }

    public class MouseHoverDarkenListener extends MouseAdapter {

        JButton button;
        public MouseHoverDarkenListener(JButton button) {
            this.button = button;
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.setBackground(Color.GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            button.setBackground(null);
        }
    }


}
