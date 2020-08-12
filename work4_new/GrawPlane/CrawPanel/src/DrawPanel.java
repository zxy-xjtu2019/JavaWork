import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


public class DrawPanel extends JPanel{
    private Map[] maps;
    private int type;
    private static final int NONE = 0;
    private static final int MAP = 1;
    private static final int NULL = 2;
    private static final int NOTARRAY = 3;
    
    public DrawPanel(Map[] maps){
        setBackground(Color.WHITE);
        if( maps == null ){
            type = DrawPanel.NULL;
            return ;
        }else if(!maps.getClass().isArray()){
            type = DrawPanel.NOTARRAY;
            return;
        }
        this.maps = maps;
        type = DrawPanel.MAP;
    }

    public void PaintComponent(Graphics g){
        super.paintComponent(g);
        switch(this.type){
            case DrawPanel.MAP:
                for(Map map:maps)
                    map.draw();
                break;
            case DrawPanel.NULL:
                g.drawString("在DrawPanel的构造函数中，你传递的引用参数是NULL!",50,50);
                break;
            case DrawPanel.NOTARRAY:
                g.drawString("在DrawPranel的构造函数中，你传递的参数必须是某个形状的数组类型", 50, 50)
                break;
        }
    }
    
}