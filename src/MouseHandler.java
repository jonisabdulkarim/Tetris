import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseHandler extends MouseAdapter{
    private TetrisView tv;
    private int color;


    MouseHandler(TetrisView tv, int color){
        this.tv = tv;
        this.color = color;

    }

    // checks if mouse is pressed, performs action if true
    public void mousePressed(MouseEvent mouseEvent){
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            Square[] squares = tv.getSquares();
            squares[0].getLeft(squares, tv.getFrame(), color);
        }
        else if (SwingUtilities.isRightMouseButton(mouseEvent)){
            Square[] squares = tv.getSquares();
            squares[0].getRight(squares, tv.getFrame(), color);
        }
    }
}
