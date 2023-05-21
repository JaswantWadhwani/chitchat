/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.swing.utilities;

import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Jatin Wadhwani
 */
public class Line extends JLabel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground());
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
    }
}