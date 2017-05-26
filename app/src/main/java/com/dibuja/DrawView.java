package com.dibuja;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

public class DrawView extends View {
	Paint paint = new Paint();

	public DrawView(Context context) {
		super(context);
	}

	@Override
	public void onDraw(Canvas canvas) {
	   //.drawRect(left, top, right, bottom, paint)
        paint.setColor(Color.RED);
		canvas.drawRect(30, 30, 80, 80, paint);
	    paint.setColor(Color.CYAN);
		canvas.drawRect(33, 60, 77, 77, paint);
		paint.setColor(Color.YELLOW);
		canvas.drawRect(33, 33, 77, 60, paint);
		
		//.drawCircle(cx, cy, radius, paint);
		paint.setColor(Color.RED);
		canvas.drawCircle(100, 100, 20, paint);
		
		//.drawText(text, x, y, paint)
		canvas.drawText("Texto con CANVAS", 200, 30, paint);
		
		//.drawLine(startX, startY, stopX, stopY, paint)
        paint.setColor(Color.BLUE);
        canvas.drawLine(0, 0, 350, 100, paint);


        Path trazo = new Path();
        trazo.addCircle(150, 450, 100, Path.Direction.CCW);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(trazo, paint);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(20);
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawTextOnPath("Cecyt 9 \"Juan de Dios Bátiz\" graficos en Android ", trazo, 150, 40, paint);

		//para crear un octagono en la excena
		Path octagono = new Path();
		octagono.moveTo(500,400);
		octagono.lineTo(600,400);

		octagono.moveTo(600,400);
		octagono.lineTo(700,500);

		octagono.moveTo(700,500);
		octagono.lineTo(700,600);

		octagono.moveTo(700,600);
		octagono.lineTo(600,700);

		octagono.moveTo(600,700);
		octagono.lineTo(500,700);

		octagono.moveTo(500,700);
		octagono.lineTo(400,600);

		octagono.moveTo(400,600);
		octagono.lineTo(400,500);

		octagono.moveTo(400,500);
		octagono.lineTo(500,400);

		paint.setColor(Color.GREEN);
		paint.setStrokeWidth(8);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawPath(octagono,paint);

		//para dibujar una estrella en la pantalla
		Path estrella = new Path();
		estrella.moveTo(100,800);
		estrella.lineTo(150,500);
		estrella.lineTo(200,800);
		estrella.lineTo(50,600);
		estrella.lineTo(250,600);
		estrella.lineTo(100,800);

		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(8);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawPath(estrella,paint);

		//para dibujar figura apachurrada con texto
		Path p1 = new Path();
		Path p2 = new Path();
		Path p3 = new Path();
		p1.addOval(250,200,300,400, Path.Direction.CCW);
		p2.addOval(275,250,375,375, Path.Direction.CCW);
		p3.addOval(350,200,400,400, Path.Direction.CCW);
		p1.op(p2,Path.Op.UNION);
		p1.op(p3,Path.Op.UNION);
		paint.setColor(Color.MAGENTA);
		paint.setStrokeWidth(8);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawPath(p1,paint);

		paint.setStrokeWidth(1);
		paint.setStyle(Paint.Style.FILL);
		paint.setTextSize(20);
		paint.setTypeface(Typeface.SANS_SERIF);
		canvas.drawTextOnPath("Fernando Daniel Castillo Barron - 6IM7", p1, 150, 40, paint);
	}

}
