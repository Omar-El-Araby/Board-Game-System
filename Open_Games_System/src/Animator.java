import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Animator implements Runnable{
    GraphicsContext gc;
    Image bg;
    Token tkn1, tkn2;
    Movement mv1, mv2;
    AnimationTimer ani = new AnimationTimer() {
        @Override
        public void handle(long now) {
            gc.drawImage(bg,0,0, Main.resolution, Main.resolution);
            gc.drawImage(tkn1.getImage(), mv1.moveX(), mv1.moveY(), (double) Main.resolution/10, (double) Main.resolution/10);
            gc.drawImage(tkn2.getImage(), mv2.moveX(), mv2.moveY(), (double) Main.resolution/10, (double) Main.resolution/10);
        }
    };
    public Animator(GraphicsContext gc, Image bg, Token tkn1, Token tkn2, Movement mv1, Movement mv2) {
        this.gc = gc;
        this.bg = bg;
        this.tkn1 = tkn1;
        this.tkn2 = tkn2;
        this.mv1 = mv1;
        this.mv2 = mv2;
    }
    @Override
    public void run() {
        ani.start();
    }
}
