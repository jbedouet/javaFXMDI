package br.com.supremeforever.mdi.PlacementStrategy;

import br.com.supremeforever.mdi.MDICanvas;
import javafx.geometry.Point2D;

/**
 * Generates point for next window without adjustments.
 * 
 */
public class Default implements PlacementStrategy {
    
    private final MDICanvas canvas;
    
    public Default(MDICanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Point2D generateNextPlacementPointFrom(Point2D point) {
        return point;
    }
    
}
