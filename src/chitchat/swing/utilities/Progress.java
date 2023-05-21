/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.swing.utilities;

/**
 *
 * @author Jatin Wadhwani
 */
import javax.swing.Icon;
import javax.swing.JProgressBar;

public class Progress extends JProgressBar {
    private ProgressType progressType = ProgressType.NONE;

    public ProgressType getProgressType() {
        return progressType;
    }

    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
        repaint();
    }
    public Progress() {
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
    
    public static enum ProgressType {
        NONE , DOWNLOADFiLe , CANCELDOWNLOAD , FILE
    }
}