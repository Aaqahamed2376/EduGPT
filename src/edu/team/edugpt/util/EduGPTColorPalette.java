package edu.team.edugpt.util;

import java.awt.Color;

public enum EduGPTColorPalette {

    THEME_BACKGROUND(new Color(0xf4f2ff), new Color(0x1a1a2e)),
    SIDEBARS_BACKGROUND(new Color(0xedefff, true), new Color(0x1a1a2e, true)),
    CARD_BACKGROUND(new Color(0xffffff), new Color(0x252344)),
    INPUT_BACKGROUND(new Color(230, 225, 255, 153), new Color(0, 0, 0, 77)),
    
    TAB_BUTTONS_BACKGROUND(new Color(0, 0, 0, 26), new Color(0, 0, 0, 51)),
    
    DIALOG_BACKGROUND(new Color(0xffffff), new Color(0x252344)),
    FADED_DIALOG_BACKGROUND(new Color(26, 26, 46, 179), new Color(26, 26, 46, 179)),
    
    BUTTON_GRADIENT_START(new Color(0x4527a0), new Color(0x5c3ab8)),
    BUTTON_GRADIENT_END(new Color(0x7e57c2), new Color(0x9a7afc)),
    FOCUS_COLOR(new Color(0x8A2BE2), new Color(0x9a7afc)), 

    MAIN_TEXT(new Color(0x1f1c3a), new Color(0xe0e0e0)),
    SUB_TEXT(new Color(0x5e548e), new Color(0xa9a4c4)),
    
    BOTH_WHITE(new Color(0xffffff), new Color(0xffffff)),
    BOTH_BLACK(new Color(0x000000), new Color(0x000000)),
    
    FEE_STATUS_PAID_TEXT(new Color(0x15803d), new Color(0x4ade80)),
    FEE_STATUS_PAID_BG(new Color(74, 222, 128, 51), new Color(74, 222, 128, 38)),
    
    FEE_STATUS_PENDING_TEXT(new Color(0xa16207), new Color(0xfacc15)),
    FEE_STATUS_PENDING_BG(new Color(250, 204, 21, 77), new Color(250, 204, 21, 38)),
    
    STUDENT_ROW_FREE_CARD_TEXT(new Color(0xa855f7), new Color(0xd8b4fe)),
    STUDENT_ROW_FREE_CARD_BG(new Color(192, 132, 252, 51), new Color(192, 132, 252, 38)),
    STUDENT_ROW_HALF_CARD_TEXT(new Color(0x14b8a6), new Color(0x5eead4)),
    STUDENT_ROW_HALF_CARD_BG(new Color(45, 212, 191, 51), new Color(45, 212, 191, 38)),

    ATTENDANCE_STATUS_PRESENT(new Color(0x16a34a), new Color(0x22c55e)),
    ATTENDANCE_STATUS_ABSENT(new Color(0xdc2626), new Color(0xef4444)),
    
    PAYMENT_STATUS_CASH_TEXT(new Color(0xa16207), new Color(0xfacc15)),
    PAYMENT_STATUS_CASH_BG(new Color(250, 204, 21, 77), new Color(250, 204, 21, 38)),
    PAYMENT_STATUS_OTHER_TEXT(new Color(0x2563eb), new Color(0x60a5fa)),
    PAYMENT_STATUS_OTHER_BG(new Color(96, 165, 250, 51), new Color(96, 165, 250, 38)),
    PAYMENT_STATUS_REVENUE_TEXT(new Color(0x16a34a), new Color(0x4ade80)),
    PAYMENT_STATUS_REVENUE_BG(new Color(74, 222, 128, 51), new Color(74, 222, 128, 38)),
    
    TICKET_STATUS_RESOLVED_TEXT(new Color(0x16a34a), new Color(0x4ade80)),
    TICKET_STATUS_RESOLVED_BG(new Color(74, 222, 128, 51), new Color(74, 222, 128, 38)),
    TICKET_STATUS_IN_PROGRESS_TEXT(new Color(0xa16207), new Color(0xfacc15)),
    TICKET_STATUS_IN_PROGRESS_BG(new Color(250, 204, 21, 77), new Color(250, 204, 21, 38)),
    TICKET_STATUS_OPEN_TEXT(new Color(0xdc2626), new Color(0xf87171)),
    TICKET_STATUS_OPEN_BG(new Color(239, 68, 68, 38), new Color(248, 113, 113, 38)),

    LOGIN_PIN_ERROR_TEXT(new Color(0xef4444), new Color(0xef4444)),
    LOGIN_PIN_SUCCESS_TEXT(new Color(0x22c55e), new Color(0x22c55e)),
    LOGIN_STAFF_LIST_HOVER_BG(new Color(126, 87, 194, 26), new Color(154, 122, 252, 26)),
    LOGIN_STAFF_LIST_SELECTED_BG(new Color(126, 87, 194, 38), new Color(154, 122, 252, 38)),
    LOGOUT_TEXT(new Color(0xf87171), new Color(0xf87171)),
    LOGOUT_HOVER_BG(new Color(239, 68, 68, 26), new Color(239, 68, 68, 26)),

    SCROLLBAR_THUMB(new Color(0x7e57c2), new Color(0x9a7afc)),
    SCROLLBAR_THUMB_HOVER(new Color(0x4527a0), new Color(0x5c3ab8)),

    BORDER(new Color(154, 122, 252, 51) , new Color(154, 122, 252, 51));

    private final Color lightModeColor;
    private final Color darkModeColor;

    EduGPTColorPalette(Color lightModeColor, Color darkModeColor) {
        this.lightModeColor = lightModeColor;
        this.darkModeColor = darkModeColor;
    }

    public Color getColor() {
        switch (Themes.getTheme()) {
            case DARK:
                return darkModeColor;
            case LIGHT:
            case DEFAULT:
            default:
                return lightModeColor;
        }
    }
}
