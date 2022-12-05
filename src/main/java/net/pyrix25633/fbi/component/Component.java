package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.gui.GUIHelper;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class Component extends JComponent {
    protected final UUID uuid;
    protected final Position.Float position;
    protected final HitBox.Float hitBox;

    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position</code>
     * @param hitBox The <code>HitBox</code>
     */
    public Component(UUID uuid, Position.Float position, HitBox.Float hitBox) {
        this.uuid = (uuid != null) ? uuid : Main.generateUUID(this);
        this.position = position;
        this.hitBox = hitBox;
    }

    /**
     * Method to paint the component
     * @param g The <code>Graphics</code>
     * @param helper The <code>GUIHelper</code>
     */
    public void paintComponent(Graphics g, GUIHelper helper) {
        super.paintComponent(g);

        HitBox.Integer calculatedHitBox = helper.calculateHitBox(hitBox);
        Position.Integer calculatedPosition = helper.calculateWorldWindowPosition(position, calculatedHitBox);

        g.fill3DRect(calculatedPosition.getX(), calculatedPosition.getY(),
                calculatedHitBox.getWidth(), calculatedHitBox.getHeight(), false);
    }

    /**
     * Method to get the UUID
     * @return The <code>UUID</code>
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * Method to get the <code>Position</code>
     * @return The <code>Position</code>
     */
    public Position.Float getPosition() {
        return position;
    }

    /**
     * Method to get the <code>HitBox</code>
     * @return The <code>HitBox</code>
     */
    public HitBox.Float getHitBox() {
        return hitBox;
    }
}