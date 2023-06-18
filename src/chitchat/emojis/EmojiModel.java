/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.emojis;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jatin Wadhwani
 */
public class EmojiModel {
    private int id;
    private Icon icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public EmojiModel(int id, Icon icon) {
        this.id = id;
        this.icon = icon;
    }

    public EmojiModel() {
        
    }
    
    public EmojiModel toSize(int x , int y) {
        return new EmojiModel(id,new ImageIcon(((ImageIcon)icon).getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH)));
    }
}
