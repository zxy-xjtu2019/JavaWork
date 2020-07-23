package homework3;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle {
        private int width,length,x,y;
        private Color color;
        public MyRectangle(int x,int y,int width,int length,Color color){
            this.width = width;
            this.x = x;
            this.y = y;
            this.length = length;
            this.color = color;
        }
        public MyRectangle(MyRectangle m){
            this(m.x,m.y,m.width,m.length,m.color);
        }
        public MyRectangle(){
            this(100,100,20,20,Color.red);
        }
        public MyRectangle(int width,int length){
            this(100,100,width, length, Color.red);
        }
        public MyRectangle(int width){
            this (100,100,width,width,Color.red);
        }
        public void draw(Graphics g){
            g.setColor(color);
            g.drawRect(x, y, width, length);
        }
}
