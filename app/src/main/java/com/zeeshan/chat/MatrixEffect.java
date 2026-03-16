package com.zeeshan.chat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Zeeshan chat Z+2: Matrix Animation Engine
 * Khasiyat: Sirf 5MB RAM lega, par 10,000GB scan ka look dega
 */
public class MatrixEffect extends View {
    private Paint paint;
    private int[] yPositions;
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789Z2";

    public MatrixEffect(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setTextSize(30);
        // Tukre System: Screen ke columns ko divide karna
        yPositions = new int[50]; 
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK); // NASA Black Background

        for (int i = 0; i < yPositions.length; i++) {
            // Random characters jo "Data Scanning" dikhayenge
            char text = characters.charAt((int) (Math.random() * characters.length()));
            canvas.drawText("" + text, i * 40, yPositions[i], paint);

            if (yPositions[i] > getHeight() || Math.random() > 0.95) {
                yPositions[i] = 0;
            } else {
                yPositions[i] += 30; // Speed of scanning
            }
        }
        invalidate(); // Loop animation
    }
}

