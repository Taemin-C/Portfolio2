package com.ctm.project;

import android.graphics.drawable.Drawable;

public class InvenItem {
    Drawable iconDrawable;
    String titleStr;
    String dateStr;

    public void setIcon(Drawable icon){
        iconDrawable = icon;
    }
    public void setTitle(String title) {
        titleStr = title;
    }
    public void setDate(String date) {
        dateStr = date;
    }
    public Drawable getIcon() {
        return this.iconDrawable;
    }
    public String getTitle() {
        return this.titleStr;
    }
    public String getDate() {
        return this.dateStr;
    }

}