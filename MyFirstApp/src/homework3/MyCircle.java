package homework3;


import java.awt.Color;
import java.awt.Graphics;


public class MyCircle {
        private int x,y,d;
        private Color color;

        public MyCircle(){
            this(30,30,30,Color.red);
        }
        public MyCircle(MyCircle m){
            this(m.x,m.y,m.d,m.color);
        }
        public MyCircle(int x,int y){
            this(x,y,30,Color.red);
        }
        public MyCircle(int x){
            this(x,x,30,Color.red);
        }
        public MyCircle(int x,int y,int d){
            this(x,y,d,Color.red);
        }
        public MyCircle(Color color){
            this(30,30,30,color);
        }
        public MyCircle(int x,int y,int d,Color color){
            this.color = color;
            this.x = x;
            this.y = y;
            this.d = d;
        }
        public void draw(Graphics g){
            g.setColor(color);
            g.drawOval(x, y, d, d);
        }

}