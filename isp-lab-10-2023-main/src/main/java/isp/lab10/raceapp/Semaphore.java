
package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;

class SemaphoreThread extends Thread {
    private SemaphorePanel semaphorePanel;

    public SemaphoreThread(SemaphorePanel semaphorePanel) {
        this.semaphorePanel = semaphorePanel;
    }

    public void run() {
        try {
            semaphorePanel.setRed();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            semaphorePanel.setYellow();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            semaphorePanel.setGreen();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SemaphorePanel extends JPanel {
    private Color color;

    public SemaphorePanel() {
        setPreferredSize(new Dimension(100, 300));
        color = Color.GRAY;
    }

    public void setRed() {
        color = Color.RED;
        repaint();
    }

    public void setYellow() {
        color = Color.YELLOW;
        repaint();
    }

    public void setGreen() {
        color = Color.GREEN;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = Math.min(getWidth(), getHeight()) - 20;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);

        g.setColor(Color.BLACK);
        g.drawOval(x, y, diameter, diameter);
    }
}
