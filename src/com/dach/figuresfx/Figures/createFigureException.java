package com.dach.figuresfx.Figures;

import com.dach.figuresfx.controller.MainScreenViewController;
import org.apache.log4j.Logger;

public class createFigureException extends Exception {
     int number;
     String message;
     static final Logger logger = Logger.getLogger(MainScreenViewController.class);

    public createFigureException(int number, String message){
        this.number = number;
        this.message = message;
        logger.warn(message + number);
    }


}
