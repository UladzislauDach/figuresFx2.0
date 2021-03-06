package com.dach.figuresfx.controller;

import com.dach.figuresfx.Figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private List<Figure> figures = new ArrayList<>();
    private Random random;


    @FXML
    private Canvas canvas;

    @FXML
    private Button clean;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert clean != null : "fx:id=\"clean\" was not injected: check your FXML file 'MainScreenView.fxml'.";
        random = new Random(System.currentTimeMillis());
        clean.setOnAction(event -> {
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            figures.clear();
        });
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (createFigureException e) {
            System.out.println("Ошибка. Подробности в логах");
        }
        repaint();

    }

    private Figure createFigure(double x, double y) throws createFigureException {
        Figure figure = null;
        int create = random.nextInt(10);

        if (create < 0 || create > 5)
            throw new createFigureException(create, "Ошибка. Попытка обращения к несуществующей фигуре:");


        switch (create) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(4), Color.GREEN, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(4), Color.RED, random.nextInt(80), random.nextInt(80));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(4), Color.BLUE, random.nextInt(70));
                break;
            case Figure.FIGURE_TYPE_MYFIGURE:
                figure = new MyFigure(x, y, random.nextInt(4), Color.BLACK, random.nextInt(60));
                break;
            case Figure.FIGURE_TYPE_STAR:
                figure = new Star(x, y, random.nextInt(4), Color.YELLOW, random.nextInt(60));
                break;

        }

        return figure;
    }

    private void addFigure(Figure figure) {
        figures.add(figure);

    }

    private void repaint() {
        canvas.getGraphicsContext2D()
                .clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.drawFigures(canvas.getGraphicsContext2D());
    }
}
