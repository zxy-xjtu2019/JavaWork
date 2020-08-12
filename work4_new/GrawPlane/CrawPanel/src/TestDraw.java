import java.awt.Color;
import javax.swing.JFrame;

import Map.Map;

import java.util.Random;
import homework3.DrawPanel;
import homework3.MyCircle;
import homework3.MyRectangle;
public class TestDraw {
    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel(generateLines());
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
    public static Map[] generateLines(){
        Random randomNumber = new Random();
        Map[] lines;
        lines = new MyCircle[ 5 + randomNumber.nextInt(5)];
        for (int count = 0; count < lines.length; count++){
            int x1 = randomNumber.nextInt(100);
            int y1 = randomNumber.nextInt(100);
            int y2 = randomNumber.nextInt(100);
            Color color = new Color( randomNumber.nextInt(256),
            randomNumber.nextInt(256), randomNumber.nextInt(256));
            lines[count] = new MyCircle(x1, y1, y2, color);
        }
        return lines;
    }
}