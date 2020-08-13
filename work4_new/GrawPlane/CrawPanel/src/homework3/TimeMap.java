package homework3;

import java.awt.Color;
import java.awt.Graphics;

import Map.Map;
import Map.TestDraw;

public class TimeMap implements Map{
    private static final int x = 240,y = 240;
    private double HourAngle,MinAngle,SecAngle;
    private double hourx=240,houry=180,minsx=240,minsy=150,secx=240,secy=140;

    public TimeMap(MyTime mytime){
        this.HourAngle = 0;
        this.MinAngle = 0;
        this.SecAngle = 0;
    }
    public TimeMap(){
        this.HourAngle = 0;
        this.MinAngle = 0;
        this.SecAngle = 0;
    }
    public void renewTimeMAp(MyTime mytime){
        this.SecAngle = mytime.second*6;
        this.MinAngle = mytime.minute*6+mytime.second*0.1;
        this.HourAngle = mytime.hour*30+mytime.second*0.1+mytime.minute/60;
        this.hourx = x+60*Math.sin((double)this.HourAngle/180*Math.PI);
        this.houry = y-60*Math.cos((double)this.HourAngle/180*Math.PI);
        this.minsx = x+90*Math.sin((double)this.MinAngle/180*Math.PI);
        this.minsy = y-90*Math.cos((double)this.MinAngle/180*Math.PI);
        this.secx = x+100*Math.sin((double)this.SecAngle/180*Math.PI);
        this.secy = y- 100*Math.cos((double)this.SecAngle/180*Math.PI);
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(120, 120, 240, 240);
         int anglex= 0;
         for(int i = 12;i>=1;i--){
            String t = String.valueOf(i);
            int xx = (int)(235 - Math.round(110*Math.sin((double)anglex/180*Math.PI)));
            int yy = (int)(245 - Math.round(110*Math.cos((double)anglex/180*Math.PI)));
            g.drawString(t, xx, yy);
             anglex += 30;
         }
        g.drawString(TestDraw.mytime.hour+":"+TestDraw.mytime.minute+":"+TestDraw.mytime.second, 230,400);
        g.setColor(Color.BLUE);
        g.drawLine(240, 240, (int)(this.hourx),(int)(this.houry));
        g.setColor(Color.red);
        g.drawLine(240, 240, (int)(this.secx),(int)(this.secy));
        g.setColor(Color.GREEN);
        g.drawLine(240, 240, (int)(this.minsx),(int)(this.minsy));
    }

    @Override
    public String area() {
        return "该图形无法求面积！";
    }
}