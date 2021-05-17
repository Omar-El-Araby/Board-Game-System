import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public abstract class Game extends AnimationTimer {
    Canvas canvas;
    Image bg;
    long startNanoTime = System.nanoTime();
    double x;
    double y;
    @Override
    public void handle(long currentNanoTime) {
        double t = (currentNanoTime - startNanoTime) / 1000000000.0;
    }
    public Game(Canvas canvas){
        this.canvas = canvas;
    }
}
