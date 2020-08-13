package homework3;

import javax.swing.JPanel;

import Map.Map;

import java.awt.Color;
import java.awt.Graphics;

public class DrawPanel extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Map map;
    private int type;
    // private static final int NONE = 0;
    private static final int MAP = 1;
    private static final int NULL = 2;
  //  private static final int NOTARRAY = 3;
    
    public DrawPanel(Map map){
        setBackground(Color.WHITE);
        if( map == null ){
            type = DrawPanel.NULL;
            return ;
        }
        this.map = map;
        type = DrawPanel.MAP;
    }
    public DrawPanel() {
        setBackground(Color.BLACK);
        this.type = 0;
      }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        switch(this.type){
            case DrawPanel.MAP:
                    map.draw(g);
                break;
            case DrawPanel.NULL:
                g.drawString("在DrawPanel的构造函数中，你传递的引用参数是NULL!",50,50);
                break;
            // case DrawPanel.NOTARRAY:
            //     g.drawString("在DrawPranel的构造函数中，你传递的参数必须是某个形状的数组类型", 50, 50);
            //     break;
        }
    }
    
}