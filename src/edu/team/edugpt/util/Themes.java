
package edu.team.edugpt.util;

public enum Themes {
    LIGHT,
    DARK,
    DEFAULT;

    private static Themes currentTheme = DARK;

    public static void setTheme(Themes theme) {
        currentTheme = theme;
    }

    public static Themes getTheme() {
        return currentTheme;
    }

    public static boolean isDark() {
        return currentTheme == DARK;
    }

    public static boolean isLight() {
        return currentTheme == LIGHT;
    }

    public static boolean isDefault() {
        return currentTheme == DEFAULT;
    }
}
