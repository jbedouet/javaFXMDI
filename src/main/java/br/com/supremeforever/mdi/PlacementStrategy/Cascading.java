package br.com.supremeforever.mdi.PlacementStrategy;

import br.com.supremeforever.mdi.MDICanvas;
import javafx.geometry.Point2D;

/**
 *
 */
public class Cascading implements PlacementStrategy {
    
    private final MDICanvas canvas;
    
    private final Point2D offset = new Point2D(10, 10);

    public Cascading(MDICanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Point2D generateNextPlacementPointFrom(Point2D point) {
        return point.add(this.offset);
    }
    
}
