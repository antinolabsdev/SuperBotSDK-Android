package com.example.sdkbotlibraray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post  {

    @SerializedName("base_url")
    @Expose
    private String baseUrl;
    @SerializedName("widget_url")
    @Expose
    private String widgetUrl;
    @SerializedName("main_color")
    @Expose
    private String mainColor;
    @SerializedName("text_color")
    @Expose
    private String textColor;
    @SerializedName("header_title")
    @Expose
    private String headerTitle;
    @SerializedName("header_subtitle")
    @Expose
    private String headerSubtitle;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("chat_box_bubble")
    @Expose
    private String chatBoxBubble;
    @SerializedName("widget_position")
    @Expose
    private String widgetPosition;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getWidgetUrl() {
        return widgetUrl;
    }

    public void setWidgetUrl(String widgetUrl) {
        this.widgetUrl = widgetUrl;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getHeaderSubtitle() {
        return headerSubtitle;
    }

    public void setHeaderSubtitle(String headerSubtitle) {
        this.headerSubtitle = headerSubtitle;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getChatBoxBubble() {
        return chatBoxBubble;
    }

    public void setChatBoxBubble(String chatBoxBubble) {
        this.chatBoxBubble = chatBoxBubble;
    }

    public String getWidgetPosition() {
        return widgetPosition;
    }

    public void setWidgetPosition(String widgetPosition) {
        this.widgetPosition = widgetPosition;
    }

}