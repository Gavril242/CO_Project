import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        try {
            // Load the custom icon image
            Image icon = ImageIO.read(new File("Pictures/icon4.jpg"));

            // Create the JFrame and set its properties
            JFrame frame = new JFrame("Benckmark");
            frame.setSize(700, 500);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            // Set the custom icon for the JFrame
            frame.setIconImage(icon);

            // Create and add a JLabel to the JFrame
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon("Pictures/bk.png"));
            label.setLayout(new BorderLayout());
            label.setVisible(true);
            frame.setContentPane(label);

            // Create a JPanel for the buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.setOpaque(false);

            // Create the buttons and add them to the panel
            JButton startButton = new JButton(new ImageIcon("Pictures/start.png"));
            startButton.setContentAreaFilled(false); // make button background transparent
            startButton.setBorderPainted(false); // remove button border
            JButton openLogButton = new JButton(new ImageIcon("Pictures/log.png"));
            openLogButton.setContentAreaFilled(false); // make button background transparent
            openLogButton.setBorderPainted(false); // remove button border
            JButton cancelButton = new JButton(new ImageIcon("Pictures/pause.png"));
            cancelButton.setContentAreaFilled(false); // make button background transparent
            cancelButton.setBorderPainted(false); // remove button border
            JButton exitButton = new JButton(new ImageIcon("Pictures/exit.png"));
            exitButton.setContentAreaFilled(false); // make button background transparent
            exitButton.setBorderPainted(false); // remove button border

            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Set the button icon to the small icon
                    startButton.setIcon(new ImageIcon("Pictures/start_small.png"));

                    // Create a Timer to change the button icon back to normal after 200ms
                    Timer timer = new Timer(200, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            startButton.setIcon(new ImageIcon("Pictures/start.png"));
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                    System.out.println("start clicked");
                }
            });

            openLogButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Set the button icon to the small icon
                    openLogButton.setIcon(new ImageIcon("Pictures/log_small.png"));

                    // Create a Timer to change the button icon back to normal after 200ms
                    Timer timer = new Timer(200, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            openLogButton.setIcon(new ImageIcon("Pictures/log.png"));
                        }

                    });
                    timer.setRepeats(false);
                    timer.start();
                    System.out.println("log clicked");
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Set the button icon to the small icon
                    cancelButton.setIcon(new ImageIcon("Pictures/pause_small.png"));

                    // Create a Timer to change the button icon back to normal after 200ms
                    Timer timer = new Timer(200, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cancelButton.setIcon(new ImageIcon("Pictures/pause.png"));
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                    System.out.println("pause clicked");
                }
            });

            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Set the button icon to the small icon
                    exitButton.setIcon(new ImageIcon("Pictures/exit_small.png"));

                    // Create a Timer to change the button icon back to normal after 200ms
                    Timer timer = new Timer(200, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            exitButton.setIcon(new ImageIcon("Pictures/exit.png"));
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                    System.out.println("exit clicked");
                    System.out.println("Shutting down...");
                    System.exit(0);
                }
            });



            buttonPanel.add(Box.createVerticalGlue());
            buttonPanel.add(startButton);
            buttonPanel.add(Box.createVerticalStrut(10));
            buttonPanel.add(openLogButton);
            buttonPanel.add(Box.createVerticalStrut(10));
            buttonPanel.add(cancelButton);
            buttonPanel.add(Box.createVerticalStrut(10));
            buttonPanel.add(exitButton);
            buttonPanel.add(Box.createVerticalGlue());

            // Add the button panel to the right side of the content pane
            frame.getContentPane().add(buttonPanel, BorderLayout.EAST);

            // Add a version and author label to the bottom left corner
            JLabel versionLabel = new JLabel("Veriosn Beta 0.1 Developed by: -Pirvulescu Anisia  -Zvinca Alex -Pavel Cristina -Neag Malina -Nistora Octiviam -Prindii Lucian");
            JLabel authorLabel = new JLabel("");

            JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            labelPanel.setOpaque(false);

            labelPanel.add(versionLabel);
            labelPanel.add(Box.createHorizontalStrut(1));
            labelPanel.add(authorLabel);

            // Set the font and foreground color of the version and author labels
            Font font = versionLabel.getFont().deriveFont(Font.PLAIN,  versionLabel.getFont().getSize() - 2);
            versionLabel.setFont(font);
            authorLabel.setFont(font);
            versionLabel.setForeground(Color.WHITE);
            authorLabel.setForeground(Color.WHITE);


            frame.getContentPane().add(labelPanel, BorderLayout.SOUTH);

            // Show the JFrame
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
