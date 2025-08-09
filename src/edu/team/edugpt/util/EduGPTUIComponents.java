package edu.team.edugpt.util;

import com.formdev.flatlaf.FlatClientProperties;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class EduGPTUIComponents {

    private EduGPTUIComponents() {
    }

    public static void selectedButton(JButton button) {
        button.setFont(EduGPTFonts.SEMIBOLD.getFont(16));
        button.setForeground(EduGPTColorPalette.BOTH_WHITE.getColor());
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.putClientProperty(FlatClientProperties.BUTTON_TYPE, "roundRect");

        button.setUI(new GradientButtonUI());

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.putClientProperty("hovered", true);
                button.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.putClientProperty("hovered", false);
                button.repaint();
            }
        });
    }

    public static void deselectedSideBarButton(JButton button) {
        button.setFont(EduGPTFonts.SEMIBOLD.getFont(14f));
        button.setForeground(EduGPTColorPalette.MAIN_TEXT.getColor());
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        button.putClientProperty(FlatClientProperties.BUTTON_TYPE, "roundRect");

        button.setUI(new HoverBackgroundButtonUI());

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.putClientProperty("hovered", true);
                button.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.putClientProperty("hovered", false);
                button.repaint();
            }
        });
    }

    public static void deselectedButton(JButton button) {
        button.setFont(EduGPTFonts.SEMIBOLD.getFont(14f));
        button.setForeground(EduGPTColorPalette.MAIN_TEXT.getColor());
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        button.putClientProperty(FlatClientProperties.BUTTON_TYPE, "roundRect");
    }

    public static void inputField(JTextField input, String placeholder, Icon rawIcon) {
        input.setFont(EduGPTFonts.SEMIBOLD.getFont(16f));
        input.setOpaque(true);

        input.setForeground(EduGPTColorPalette.MAIN_TEXT.getColor());
        input.setBackground(EduGPTColorPalette.FADED_DIALOG_BACKGROUND.getColor());
        input.setCaretColor(EduGPTColorPalette.MAIN_TEXT.getColor());

        input.setMargin(new Insets(0, 0, 0, 0));

        input.putClientProperty(FlatClientProperties.STYLE,
                "arc: 12;"
                + "borderWidth: 0.4;"
                + "focusWidth: 1;"
                + "focusColor: " + toHex(new Color(160, 32, 240)) + ";"
                + "background: " + toHex(EduGPTColorPalette.INPUT_BACKGROUND.getColor()) + ";"
                + "borderColor: " + toHex(EduGPTColorPalette.BORDER.getColor()) + ";"
                + "iconTextGap: 7;"
        );

        input.putClientProperty("JTextField.placeholderText", placeholder);
        input.putClientProperty("JTextField.placeholderForeground", EduGPTColorPalette.FADED_DIALOG_BACKGROUND.getColor());

        input.putClientProperty("JTextField.leadingIcon", rawIcon);

        input.setBorder(BorderFactory.createCompoundBorder(
                input.getBorder(),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
    }

    private static String toHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    private static class GradientButtonUI extends BasicButtonUI {

        @Override
        public void paint(Graphics g, JComponent c) {
            if (c instanceof JButton button) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = button.getWidth();
                int height = button.getHeight();

                boolean isHovered = Boolean.TRUE.equals(button.getClientProperty("hovered"));
                if (isHovered) {
                    Color glowColor = new Color(186, 85, 211, 80);
                    g2d.setColor(glowColor);
                    g2d.fillRoundRect(-4, -4, width + 8, height + 8, 28, 28);
                }

                GradientPaint gradient = new GradientPaint(
                        0, 0, EduGPTColorPalette.BUTTON_GRADIENT_START.getColor(),
                        width, 0, EduGPTColorPalette.BUTTON_GRADIENT_END.getColor()
                );

                g2d.setPaint(gradient);
                g2d.fillRoundRect(0, 0, width, height, 20, 20);

                g2d.dispose();
            }

            super.paint(g, c);
        }
    }

    private static class HoverBackgroundButtonUI extends BasicButtonUI {

        @Override
        public void paint(Graphics g, JComponent c) {
            if (c instanceof JButton button) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = button.getWidth();
                int height = button.getHeight();

                boolean isHovered = Boolean.TRUE.equals(button.getClientProperty("hovered"));
                if (isHovered) {
                    g2d.setColor(EduGPTColorPalette.LOGIN_STAFF_LIST_HOVER_BG.getColor());
                    g2d.fillRoundRect(0, 0, width, height, 20, 20);
                }

                g2d.dispose();
            }

            super.paint(g, c);
        }
    }

    public static void setBorder(JComponent component) {
        Color borderColor = EduGPTColorPalette.BORDER.getColor();
        int borderWidth = 1;

        component.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, borderWidth),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
    }
}

class EmptyBorderIcon implements Icon {

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
