/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.emojis;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Jatin Wadhwani
 */
public class Emoji {
    private static Emoji instance;
    public static Emoji getInstance() {
        if(instance == null) {
            instance = new Emoji();
        }
        return instance;
    }
    
    private Emoji() {
        
    }
    
    public List<EmojiModel> getStyle1() {
        List<EmojiModel> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(new EmojiModel(i, new ImageIcon(getClass().getResource("/chitchat/emojis/icons/" + i + ".png"))));
        }
        return list;
    }

    public List<EmojiModel> getStyle2() {
        List<EmojiModel> list = new ArrayList<>();
        for (int i = 21; i <= 40; i++) {
            list.add(new EmojiModel(i, new ImageIcon(getClass().getResource("/chitchat/emojis/icons/" + i + ".png"))));
        }
        return list;
    }

    public EmojiModel getEmoji(int id) {
        return new EmojiModel(id, new ImageIcon(getClass().getResource("/chitchat/emojis/icons/" + id + ".png")));
    }
}
