package net.pyrix25633.ncis.gui;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.client.KeyboardListener;
import net.pyrix25633.ncis.component.Component;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final GUIHelper helper;

    /**
     * Constructor
     * @param helper The <code>GUIHelper</code>
     */
    public GamePanel(GUIHelper helper) {
        super();
        this.helper = helper;
        addKeyListener(new KeyboardListener());
    }

    /**
     * Method called to paint the <code>GamePanel</code>
     * @param g The <code>Graphics</code>
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Component c : Main.gameServer.getWorld()) {
            c.paintComponent(g, helper);
        }
    }
}