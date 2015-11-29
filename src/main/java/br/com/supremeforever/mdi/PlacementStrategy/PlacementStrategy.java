package br.com.supremeforever.mdi.PlacementStrategy;

import br.com.supremeforever.mdi.MDICanvas;
import javafx.geometry.Point2D;

/**
 *
 */
public interface PlacementStrategy {
    
    public Point2D generateNextPlacementPointFrom(Point2D point);
}
