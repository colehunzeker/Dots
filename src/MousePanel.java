import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MousePanel extends JPanel {

    private Point location;
    private ArrayList<Dot> dotList;

    public MousePanel() {
        setPreferredSize(new Dimension(500,500));
        dotList = new ArrayList<>();
        MousePlay mp = new MousePlay();
        addMouseListener(mp);
        addMouseMotionListener(mp);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (location != null) {
            Dot d = new Dot(location);
            d.paint(g);
        }
        else{
            repaint();
        }
        for (Dot d:dotList){
            d.paint(g);
        }
    }



    private class MousePlay implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("MouseClicked");
            location  =e.getPoint();
            System.out.println(location);
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("MousePressed");
            location  =e.getPoint();
            for (Dot d: dotList) {
                if (location.x <= d.center.x + d.radius && location.y <= d.center.y+d.radius) {
                    repaint();

                }
            }
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Dot d = new Dot(e.getPoint());
            dotList.add(d);
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("MouseEntered");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("MouseExited");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            location  =e.getPoint();
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}