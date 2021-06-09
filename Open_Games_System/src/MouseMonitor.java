import javafx.scene.input.MouseEvent;

public final class MouseMonitor{
    private static double x;
    private static double y;
    private static int tileX;
    private static int tileY;
    public static void getPos(MouseEvent event){
        x = event.getX();
        y = event.getY();
        System.out.printf("X: %f\tY: %f\n",x,y);
    }
    public static int calcX(){
        int tmp = (int)x;

        for(tileX = 0 ; tileX < Main.divX ; tileX++) {
            //System.out.printf("does: %f > %d > %f\n",(tileX + 1)* Main.width,tmp,(tileX - 1)* Main.width);
            if (tmp > (tileX - 1) * Main.width && tmp < (tileX + 1) * Main.width) return tileX;
        }
        return 0;
    }
    public static int calcY(){
        int tmp = (int)y;

        for(tileY = 0 ; tileX < Main.divY ; tileY++) {
            //System.out.printf("does: %f > %d > %f\n",(tileY + 1)* Main.height,tmp,(tileY - 1)* Main.height);
            if (tmp > (tileY - 1) * Main.height && tmp < (tileY + 1) * Main.height) return tileY;
        }
        return 0;
    }
}
