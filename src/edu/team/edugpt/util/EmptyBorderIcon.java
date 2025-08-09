package edu.team.edugpt.util;

import javax.swing.*;
import java.awt.*;

public class EmptyBorderIcon implements Icon {
    private final Icon icon;
    private final Insets insets;

    public EmptyBorderIcon(Icon icon, int top, int left, int bottom, int right) {
        this.icon = icon;
        this.insets = new Insets(top, left, bottom, right);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        icon.paintIcon(c, g, x + insets.left, y + insets.top);
    }

    @Override
    public int getIconWidth() {
        return icon.getIconWidth() + insets.left + insets.right;
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight() + insets.top + insets.bottom;
    }
}
