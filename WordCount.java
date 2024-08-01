package wordcount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordCount extends JFrame implements ActionListener {
    
    private JTextArea textArea;
    private JButton countButton;
    private JLabel countLabel;

    public WordCount() {
        super("Word Counter");

        textArea = new JTextArea(10, 30);
        countButton = new JButton("Count");

        countLabel = new JLabel("Word count: 0");

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(textArea));
        panel.add(countButton);
        panel.add(countLabel);
        add(panel);

        countButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String text = textArea.getText();

        String[] words = text.trim().split("\\s+");

        int count = (text.isEmpty()) ? 0 : words.length;

        countLabel.setText("Word count: " + count);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCount());
    }
}
