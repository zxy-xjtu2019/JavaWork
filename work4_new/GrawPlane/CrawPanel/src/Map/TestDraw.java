package Map;

import java.awt.Color;
import javax.swing.JFrame;

import Map.Map;

import java.util.Random;
import java.util.Scanner;

import homework3.DrawPanel;
import homework3.MyCircle;
import homework3.MyRectangle;
import homework3.MyTime;
import homework3.TimeMap;
public class TestDraw {
    public static MyTime mytime = new MyTime();
    public static TimeMap Clock = new TimeMap(mytime);
    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel(generateClock());
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(480, 480);
        application.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                while (true) {
                     try {
                         Thread.sleep(1000); //设置绘制的时间间隔为 1 秒
                     } catch (InterruptedException e) {
                          System.err.println(e);
                      }
                    //正好也可以用来第三次作业中时钟类型的这个方法是否正确
                     mytime.incrementSecond();
                     Clock.renewTimeMAp(mytime);
                    //更新绘制图形面板上的内容（也就是我们绘制的图像）
                     panel.updateUI();
                    }
                }
            };
        t.start();
    }
    public static Map generateClock(){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入现在的时间：（12 00 23，则表示12点0分23秒）");
        mytime = new MyTime(in.nextInt(),in.nextInt(),in.nextInt());
        Clock = new TimeMap(mytime);
        in.close();
        return Clock;
    }
}