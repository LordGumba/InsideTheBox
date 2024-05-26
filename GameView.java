// GameView.java changing to test
package com.example.ballgame;

// Import the android libraries
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

// Sets variables
public class GameView extends View {
    private Paint paint;
    private float ballX, ballY, ballRadius;
    private float ballSpeedX, ballSpeedY;
    private int screenWidth, screenHeight;

    public GameView(Context context) {
        super(context);
        paint = new Paint();
        ballRadius = 20;
        ballX = ballRadius;
        ballY = ballRadius;
        ballSpeedX = 5;
        ballSpeedY = 5;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        // Draw the ball
        paint.setColor(Color.WHITE);
        canvas.drawCircle(ballX, ballY, ballRadius, paint);

        // Update ball position
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Check for collision with walls
        if (ballX <= ballRadius || ballX >= screenWidth - ballRadius) {
            gameOver();
        }
        if (ballY <= ballRadius || ballY >= screenHeight - ballRadius) {
            ballSpeedY = -ballSpeedY;
        }

        // Invalidate to request a redraw
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float touchX = event.getX();
            float touchY = event.getY();

            // Reflect the ball if touched in front of it
            if (Math.abs(touchX - ballX) < ballRadius && touchY < ballY) {
                ballSpeedY = -ballSpeedY;
            }
        }
        return true;
    }

    private void gameOver() {
        ballSpeedX = 0;
        ballSpeedY = 0;
        // Display game over message or handle game over logic
    }
}