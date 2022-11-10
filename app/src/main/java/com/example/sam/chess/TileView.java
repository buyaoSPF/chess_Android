package com.example.sam.chess;

import android.content.Context;
import android.util.AttributeSet;
/**
 * @author Le Tao, Rui Kuang
 */

public class TileView extends android.support.v7.widget.AppCompatImageView {
    public String currentPiece;
    public String label;

    public TileView(Context givenContext) {
        super(givenContext);
        this.currentPiece = "empty";
        this.label = "nowhere";
    }

    public TileView(Context givenContext, AttributeSet givenAttrs) {
        super(givenContext, givenAttrs);
        this.currentPiece = "empty";
        this.label = "nowhere";
    }

    public TileView(Context givenContext, AttributeSet givenAttrs, int givenStyleAttr) {
        super(givenContext, givenAttrs, givenStyleAttr);
        this.currentPiece = "empty";
        this.label = "nowhere";
    }



}
