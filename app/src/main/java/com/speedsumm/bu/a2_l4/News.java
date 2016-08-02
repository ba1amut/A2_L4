package com.speedsumm.bu.a2_l4;

import android.graphics.Bitmap;

/**
 * Created by bu on 02.08.2016.
 */
public class News {
    private String newsHead;
    private String newsBody;
//    private Bitmap bitmap;

    public News(String newsHead, String newsBody) {
        this.newsHead = newsHead;
        this.newsBody = newsBody;
//        this.bitmap = bitmap;
    }



    public String getNewsHead() {
        return newsHead;
    }

    public void setNewsHead(String newsHead) {
        this.newsHead = newsHead;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

//    public Bitmap getBitmap() {
//        return bitmap;
//    }
//
//    public void setBitmap(Bitmap bitmap) {
//        this.bitmap = bitmap;
//    }
}
