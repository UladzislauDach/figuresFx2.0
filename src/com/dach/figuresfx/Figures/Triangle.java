package com.dach.figuresfx.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Figure {
    private double base;

    private Triangle(double cx, double cy, double lineWidth, Color color) {
        super(Figure.FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double base) {
        this(cx, cy, lineWidth, color);
        this.base = base < 10 ? 10 : base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return Double.compare(triangle.base, base) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(base);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(
                new double[]{cx, cx + base / 2, cx - base / 2},
                new double[]{cy - base / 2, cy + base / 2, cy + base / 2},
                3);

    }
}