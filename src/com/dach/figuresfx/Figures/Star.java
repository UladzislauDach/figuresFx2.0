package com.dach.figuresfx.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Star extends Figure {
    private double a;


    private Star(double cx, double cy, double lineWidth, Color color) {
        super(Figure.FIGURE_TYPE_STAR, cx, cy, lineWidth, color);
    }

    public Star(double cx, double cy, double lineWidth, Color color, double a) {
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
        Star star = (Star) o;
        return Double.compare(star.a, a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "Star{" +
                "a=" + a +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(
                new double[]{0 + cx, 50 + cx, -80 + cx, 80 + cx,
                        -50 + cx, 0 + cx},
                new double[]{-80 + cy, 68 + cy, -26 + cy, -26 + cy,
                        68 + cy, -80 + cy},
                6);

    }

}
