import java.awt.*;  
import java.awt.event.*;  
public class mouse_color extends Frame implements MouseListener
{
 
    	mouse_color()
	{  
        	addMouseListener(this);
        	setSize(300,300);  
        	setLayout(null);  
        	setVisible(true);  
		show();
    	}  
	public void mouseClicked(MouseEvent e) 
	{  
   		setBackground(Color.pink);  
	}  
    	public void mouseEntered(MouseEvent e) 
	{

	}  
    	public void mouseExited(MouseEvent e) 
	{
    		setBackground(Color.blue);  
	}  
    	public void mousePressed(MouseEvent e) 
	{

	}  
    	public void mouseReleased(MouseEvent e) 
	{
 
	}  
     
	public static void main(String args[]) 
	{  
    		new mouse_color();  
	}  
}
