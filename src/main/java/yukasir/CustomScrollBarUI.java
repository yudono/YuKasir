/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yukasir;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {

    private int scrollBarWidth;
    private final Dimension thumbSize = new Dimension(scrollBarWidth, 40);
    
    public CustomScrollBarUI(int scrollWidth){
        this.scrollBarWidth = scrollWidth;
    }

    @Override
    protected void configureScrollBarColors() {
        thumbColor = Color.GRAY;
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(thumbColor);
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            g.fillRect(thumbBounds.x, thumbBounds.y, scrollBarWidth, thumbBounds.height);
        }else{
            g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, scrollBarWidth);
        }
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(Color.LIGHT_GRAY);
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            g.fillRect(trackBounds.x, trackBounds.y, scrollBarWidth, trackBounds.height);
        }else{
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, scrollBarWidth);
        }
    }

    protected Dimension getThumbSize() {
        return thumbSize;
    }
}
