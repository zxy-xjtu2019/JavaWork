package homework3;

import java.awt.Color;
import java.awt.Graphics;

import MAP.Map;

public class TimeMap implements Map{
    private static final int x = 120,y = 120;
    private double HourAngle,MinAngle,SecAngle;
    private double hourx=100,houry=140,minsx=100,minsy=160,secx=100,secy=190;

    public TimeMap(MyTime mytime){
        this.HourAngle = 0;
        this.MinAngle = 0;
        this.SecAngle = 0;
    }
    public void renewTimeMAp(MyTime mytime){
        this.SecAngle = mytime.second*6;
        this.MinAngle = mytime.minute*6+mytime.second*0.1;
        this.HourAngle = mytime.hour*6+mytime.second*0.1+mytime.minute/60;
        this.hourx = x+40*Math.sin(this.HourAngle);
        this.houry = y+40*Math.cos(this.HourAngle);
        this.minsx = x+60*Math.sin(this.MinAngle);
        this.minsy = y+60*Math.cos(this.MinAngle);
        this.secx = x+ 90*Math.sin(this.SecAngle);
        this.secy = y+ 90*Math.cos(this.SecAngle);
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(120, 120, 240, 240);
         int anglex= 0;
         for(int i = 1;i<=12;i++){
            String t = String.valueOf(i);
            int xx = (int)(235 + Math.round(110*Math.sin(anglex)));
            int yy = (int)(245 + Math.round(110*Math.cos(anglex)));
            g.drawString(t, xx, yy);
            System.out.print(xx+" ");
            System.out.println(yy);
             anglex += (int)();
         }
        // g.setColor(Color.BLUE);
        // g.drawLine(120, 120, Integer.parseInt(String.valueOf(this.hourx)),Integer.parseInt(String.valueOf(this.houry)));
        // g.setColor(Color.red);
        // g.drawLine(120, 120, Integer.parseInt(String.valueOf(this.minsx)),Integer.parseInt(String.valueOf(this.minsy)));
        // g.setColor(Color.GREEN);
        // g.drawLine(120, 120, Integer.parseInt(String.valueOf(this.secx)),Integer.parseInt(String.valueOf(this.secy)));
    }

    @Override
    public String area() {
        return "该图形无法求面积！";
    }
}