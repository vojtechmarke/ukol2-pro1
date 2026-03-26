package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayPanel extends JPanel {

    // Seznam pro uložení naklikaných bodů
    private List<Point> points = new ArrayList<>();
    // Výchozí vlastnosti čáry
    private int lineThickness = 3;
    private boolean isRedColor = false;

    public DisplayPanel() {
        setBackground(Color.WHITE); // Bílé pozadí

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                points.add(e.getPoint());
                repaint(); // Vynutí překreslení plátna
            }
        });
    }

    // Změna tloušťky
    public void setLineThickness(int thickness) {
        this.lineThickness = thickness;
        repaint();
    }

    // Změna barvy
    public void setRedColor(boolean isRed) {
        this.isRedColor = isRed;
        repaint();
    }

    // Tlačítko Zpět
    public void undo() {
        if (!points.isEmpty()) {
            points.remove(points.size() - 1);
            repaint();
        }
    }

    // Tlačítko Reset
    public void clearAll() {
        points.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics f) {
        super.paintComponent(f); // Vykreslí prázdný podklad
        Graphics2D g = (Graphics2D) f;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(lineThickness)); // Nastavení tloušťky

        // Nastavení barvy
        if (isRedColor) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.GRAY);
        }

        // Vykreslení čar mezi body
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}