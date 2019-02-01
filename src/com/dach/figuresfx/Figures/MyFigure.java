package com.dach.figuresfx.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class MyFigure extends Figure {
    private double a;


    private MyFigure(double cx, double cy, double lineWidth, Color color) {
        super(Figure.FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public MyFigure(double cx, double cy, double lineWidth, Color color, double a) {
        this(cx, cy, lineWidth, color);
        this.a = a < 10 ? 10 : a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyFigure myFigure = (MyFigure) o;
        return Double.compare(myFigure.a, a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "MyFigure{" +
                "a=" + a +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(
                new double[]{cx + a / 3, cx + a / 1.5, cx - a / 1.5, cx - a / 3},
                new double[]{cy - a / 2, cy + a / 2, cy + a / 2, cy - a / 2},
                4);

    }
}