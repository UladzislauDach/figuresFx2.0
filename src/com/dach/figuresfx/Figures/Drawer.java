package com.dach.figuresfx.Figures;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer<T extends Figure & Drawable> {
    List<T> figures;

    public Drawer(List<T> figures) {
        this.figures = figures;
    }

    public void drawFigures(GraphicsContext gs) {
        for (T figure : figures) {
            if (figure != null) {
                figure.draw(gs);
            }
        }

    }

}
//"лок фо джи" добавить библиотеку  и добавить исключительные ситуации в проект
// (подумать куда добавить (фигура не равноа налл и где в свич кейсе перебираем ситуации) исключительная ситу
// будет моим собственным мсключением.