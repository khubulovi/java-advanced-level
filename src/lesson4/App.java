package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;

    private final JTextArea log;
    private final JPanel panelTop;
    private final JPanel panelBottom;
    private final JTextField textFieldMessage;
    private final JButton buttonSend;

    public App() {
        log = new JTextArea();
        panelTop = new JPanel(new GridLayout(2, 3));
        panelBottom = new JPanel(new BorderLayout());
        textFieldMessage = new JTextField();
        buttonSend = new JButton("Send");

        setTitle("Simple chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        JScrollPane scrollLog = new JScrollPane(log);

        buttonSend.addActionListener(e -> {
            if (!textFieldMessage.getText().equals("")) {
                log.append(textFieldMessage.getText() + "\n");
                textFieldMessage.setText("");
            }
        });

        textFieldMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!textFieldMessage.getText().equals("") && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    log.append(textFieldMessage.getText() + "\n");
                    textFieldMessage.setText("");
                }
            }
        });

        log.setEditable(false);
        panelBottom.add(textFieldMessage, BorderLayout.CENTER);
        panelBottom.add(buttonSend, BorderLayout.EAST);
        add(scrollLog, BorderLayout.CENTER);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }
}
