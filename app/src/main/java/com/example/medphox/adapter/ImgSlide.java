package com.example.medphox.adapter;

public class ImgSlide {
    private int image;
    private String imgtitle;

    public ImgSlide(int image, String imgtitle) {
        this.image = image;
        this.imgtitle = imgtitle;
    }

    public int getImage() {
        return image;
    }

    public String getImgtitle() {
        return imgtitle;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setImgtitle(String imgtitle) {
        this.imgtitle = imgtitle;
    }
}
