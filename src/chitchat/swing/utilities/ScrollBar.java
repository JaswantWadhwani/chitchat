/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.swing.utilities;

import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author Jatin Wadhwani
 */
public class ScrollBar extends JScrollBar{
    public ScrollBar() {
//        Changing UI of scrollbar 
        setUI(new ModernScrollBarUI());
//        Setting size
        setPreferredSize(new Dimension(5,5));
//        Setting speed or the number of items which will be scrolled using mouse 
        setUnitIncrement(20);
    }
}
