package athread.bubble;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChatRightBubble1 extends JPanel{

    private int strokeThickness = 3;
    private int radius = 10;
    private int arrowSize = 12;
    private int padding = strokeThickness / 2;
    @Override
    protected void paintComponent(final Graphics g) {
        this.setAlignmentX(SwingConstants.RIGHT);
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255,255,51));
        int bottomLineY = getHeight() - strokeThickness;
        int width = getWidth()- arrowSize - (strokeThickness * 2);
        //말풍선 채우기
        g2d.fillRect(padding, padding, width, bottomLineY);
        //둥글게 굴리기
        RoundRectangle2D.Double rect = new RoundRectangle2D.Double(padding, padding, width, bottomLineY,  radius, radius);
        Polygon arrow = new Polygon();
        arrow.addPoint(width, 8);
        arrow.addPoint(width + arrowSize, 10);
        arrow.addPoint(width, 12);
        Area area = new Area(rect);
        area.add(new Area(arrow));
        g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        g2d.setStroke(new BasicStroke(strokeThickness));
        g2d.draw(area);
    }
}

