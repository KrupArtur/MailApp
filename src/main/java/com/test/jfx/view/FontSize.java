package com.test.jfx.view;

public enum FontSize {
    SMALL,
    MEDIUM,
    BIG;

    public static String getCssPath(FontSize fontSize){
        switch (fontSize){
            case BIG -> {
                return "css/fontBig.css";
            }
            case SMALL -> {
                return "css/fontSmall.css";
            }
            case MEDIUM -> {
                return "css/fontMedium.css";
            }
            default -> {
                return null;
            }
        }

    }
}
