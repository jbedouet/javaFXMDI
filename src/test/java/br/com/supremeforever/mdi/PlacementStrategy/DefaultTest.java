package br.com.supremeforever.mdi.PlacementStrategy;

import br.com.supremeforever.mdi.MDICanvas;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.loadui.testfx.GuiTest;

/**
 *
 */
public class DefaultTest extends GuiTest {
    
    private MDICanvas mdi;

    private final int testCanvasWidth = 800;
    private final int testCanvasHeight = 600;
    
    @Override
    public Parent getRootNode() {
        this.mdi = new MDICanvas(MDICanvas.Theme.DEFAULT);
        this.mdi.setPrefWidth(this.testCanvasWidth);
        this.mdi.setPrefHeight(this.testCanvasHeight);
        return this.mdi;
    }

    /**
     * Test of generateNextPlacementPointFrom method, of class Default.
     */
    @Test
    public void testGenerateNextPlacementPointFrom() {
        Point2D placeAt = new Point2D(10, 10);
        Default strategy = new Default(mdi);
        Point2D expResult = new Point2D(10, 10);
        Point2D result = strategy.generateNextPlacementPointFrom(placeAt);
        assertEquals(expResult, result);
    }
    
}
