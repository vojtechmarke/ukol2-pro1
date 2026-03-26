package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private DisplayPanel displayPanel;

    public MainFrame() {
        // Základní vlastnosti okna
        setTitle("Druhý domácí úkol - Lomená čára");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Vypne program při zavření křížkem
        setSize(800, 600); // Výchozí velikost
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Spustí se přes celou obrazovku
        setLayout(new BorderLayout());

        displayPanel = new DisplayPanel();

        // Tvorba a nastavení levého panelu
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 0)); // Fixní šířka 200px
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Nastavení"));

        // Ovládání tloušťky čáry
        JSlider thicknessSlider = new JSlider(1, 20, 3);
        thicknessSlider.addChangeListener(e -> displayPanel.setLineThickness(thicknessSlider.getValue()));
        leftPanel.add(new JLabel("Tloušťka čáry:"));
        leftPanel.add(thicknessSlider);

        // Ovládání barvy
        JCheckBox colorCheckBox = new JCheckBox("Červená barva (zapnuto)");
        colorCheckBox.addActionListener(e -> displayPanel.setRedColor(colorCheckBox.isSelected()));
        leftPanel.add(colorCheckBox);

        // Tlačítko Zpět
        JButton undoButton = new JButton("Zpět");
        undoButton.addActionListener(e -> displayPanel.undo());
        leftPanel.add(undoButton);

        // Tlačítko Reset
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> displayPanel.clearAll());
        leftPanel.add(resetButton);

        // Umístění vytvořených částí do hlavního okna
        add(leftPanel, BorderLayout.WEST);
        add(displayPanel, BorderLayout.CENTER);
    }
}