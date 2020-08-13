import java.awt.Color;
import javax.swing.JFrame;

import MAP.Map;

import java.util.Random;
import java.util.Scanner;

import homework3.DrawPanel;
import homework3.MyCircle;
import homework3.MyRectangle;
import homework3.MyTime;
import homework3.TimeMap;
public class TestDraw {
    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel(generateClock());
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(480, 480);
        application.setVisible(true);
    }
    // public static Map[] generateLines(){
    //     Random randomNumber = new Random();
    //     Map[] lines;
    //     lines = new MyCircle[ 5 + randomNumber.nextInt(5)];
    //     for (int count = 0; count < lines.length; count++){
    //         int x1 = randomNumber.nextInt(100);
    //         int y1 = randomNumber.nextInt(100);
    //         int y2 = randomNumber.nextInt(100);
    //         Color color = new Color( randomNumber.nextInt(256),
    //         randomNumber.nextInt(256), randomNumber.nextInt(256));
    //         lines[count] = new MyCircle(x1, y1, y2, color);
    //     }
    //     return lines;
    // }
    public static Map generateClock(){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入现在的时间：（12 00 23，则表示12点0分23秒）");
        MyTime mytime = new MyTime(in.nextInt(),in.nextInt(),in.nextInt());
        TimeMap Clock = new TimeMap(mytime);
        in.close();
        return Clock;
    }
}