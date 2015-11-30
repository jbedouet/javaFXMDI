package br.com.supremeforever.mdi.PlacementStrategy;

import br.com.supremeforever.mdi.MDICanvas;
import javafx.geometry.Point2D;

/**
 *
 */
public class Cascading implements PlacementStrategy {
    
    private final MDICanvas canvas;
    
    private final Point2D offset = new Point2D(20, 20);

    public Cascading(MDICanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Point2D generateNextPlacementPointFrom(Point2D point) {
        //@TODO take advantage of Java8 Optional
        if(this.canvas.getLastPlacedWindow() == null) {
            return point;
        }
        
        //@TODO design API to easily get important points from MDIWindow
        Point2D topLeft = new Point2D(
                this.canvas.getLastPlacedWindow().getLayoutX(),
                this.canvas.getLastPlacedWindow().getLayoutY()
        );
        return topLeft.add(this.offset);
    }
    
}
