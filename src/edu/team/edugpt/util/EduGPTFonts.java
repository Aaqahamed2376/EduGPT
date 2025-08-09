package edu.team.edugpt.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.Map;

public enum EduGPTFonts {
    
    REGULAR("Inter_18pt-Regular.ttf", Font.PLAIN),
    MEDIUM("Inter_18pt-Medium.ttf", Font.PLAIN),
    SEMIBOLD("Inter_18pt-SemiBold.ttf", Font.PLAIN),
    BOLD("Inter_18pt-Bold.ttf", Font.BOLD),
    LIGHT("Inter_24pt-Light.ttf", Font.PLAIN);

    private static final String FONT_PATH = "/edu/team/edugpt/fonts/";
    private static final Map<EduGPTFonts, Font> loadedFonts = new EnumMap<>(EduGPTFonts.class);
    
    private final int style;

    static {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (EduGPTFonts fontEnum : values()) {
            try (InputStream is = EduGPTFonts.class.getResourceAsStream(FONT_PATH + fontEnum.fileName)) {
                if (is == null) {
                    throw new IOException("Font file not found at path: " + FONT_PATH + fontEnum.fileName);
                }
                Font baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
                ge.registerFont(baseFont);
                loadedFonts.put(fontEnum, baseFont);
            } catch (FontFormatException | IOException e) {
                System.err.println("Error loading font: " + fontEnum.fileName);
                e.printStackTrace();
                loadedFonts.put(fontEnum, new Font("SansSerif", fontEnum.style, 14));
            }
        }
    }

    private final String fileName;

    EduGPTFonts(String fileName, int style) {
        this.fileName = fileName;
        this.style = style;
    }

    public Font getFont(float size) {
        return loadedFonts.get(this).deriveFont(size);
    }

    public Font getFont(int style, float size) {
        return loadedFonts.get(this).deriveFont(style, size);
    }
}