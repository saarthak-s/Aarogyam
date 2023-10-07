package com.vigyat.fitnessappprototype;

public class GovtHelpLineModal {

    int image;
    String helplineName;
    String url;

    public GovtHelpLineModal(int image, String helplineName, String url) {
        this.image = image;
        this.helplineName = helplineName;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHelplineName() {
        return helplineName;
    }

    public void setHelplineName(String helplineName) {
        this.helplineName = helplineName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
