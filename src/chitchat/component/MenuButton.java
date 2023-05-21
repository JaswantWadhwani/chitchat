/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.component;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author Jatin Wadhwani
 */
public class MenuButton extends JButton {

    private Icon simpleIcon;
    private Icon iconSelected;

    public Icon getSimpleIcon() {
        return simpleIcon;
    }

    public void setSimpleIcon(Icon simpleIcon) {
        this.simpleIcon = simpleIcon;
    }

    public Icon getIconSelected() {
        return iconSelected;
    }

    public void setIconSelected(Icon iconSelected) {
        this.iconSelected = iconSelected;
    }
    
    public MenuButton() {
        setContentAreaFilled(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    
    @Override
    public void setSelected(boolean bin) {
        super.setSelected(bin);
        if(bin) {
            setIcon(iconSelected);
        }
        else {
            setIcon(simpleIcon);
        }
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if(isSelected()) {
            graphics.setColor(new Color(110,213,255));
            graphics.fillRect(0, getHeight()-5, getWidth(), getHeight());
        }
    }
}
