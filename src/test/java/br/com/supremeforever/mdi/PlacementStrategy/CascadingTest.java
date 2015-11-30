package br.com.supremeforever.mdi.PlacementStrategy;

import br.com.supremeforever.mdi.MDICanvas;
import br.com.supremeforever.mdi.MDIWindow;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import jfxtras.test.TestUtil;
import org.junit.Test;
import static org.junit.Assert.*;
import org.loadui.testfx.GuiTest;

/**
 *
 */
public class CascadingTest extends GuiTest {
    
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
     * Test of generateNextPlacementPointFrom method, of class Cascading.
     */
    @Test
    public void testGenerateCascadingPointActsAsDefaultWhenFirstUsed() {
        // ====== Setup ========
        Cascading strategy = new Cascading(mdi);
        this.mdi.setPlacementStrategy(strategy);
        MDIWindow placedWindow = new MDIWindow(
                "testCascadingExistingWindow",
                new ImageView("/assets/WindowIcon.png"),
                "Placed first ",
                new AnchorPane()
        );
        Point2D position = new Point2D(10, 10);
        
        // ====== Act ==========
        TestUtil.runThenWaitForPaintPulse(() -> this.mdi.addMDIWindow(placedWindow, position));
        
        // ====== Verify =======
        assertEquals("Window's x position should be same as x value of point parameter when Cascading Placement Strategy is first used.",
                position.getX(), placedWindow.layoutXProperty().getValue(), 0
        );
        assertEquals("Window's y position should be same as y value of point parameter when Cascading Placement Strategy is first used.",
                position.getY(), placedWindow.layoutYProperty().getValue(), 0
        );
    }
    
    /**
     * Test of generateNextPlacementPointFrom method, of class Cascading.
     */
    @Test
    public void testGenerateCascadingPointFromExistingWindow() {
        // ====== Setup ========
        Cascading strategy = new Cascading(mdi);
        this.mdi.setPlacementStrategy(strategy);
        MDIWindow existingWindow = new MDIWindow(
                "testCascadingExistingWindow",
                new ImageView("/assets/WindowIcon.png"),
                "Placed first ",
                new AnchorPane()
        );
        Point2D position = new Point2D(10, 10);
        TestUtil.runThenWaitForPaintPulse(() -> this.mdi.addMDIWindow(existingWindow, position));
        
        // ====== Act ==========
        
        Point2D result = strategy.generateNextPlacementPointFrom(position);
        Point2D expected = position.add(20, 20);
        assertEquals(expected, result);
    }
    
}
