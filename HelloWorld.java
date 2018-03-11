import javax.swing.*;

public class HelloWorld extends JFrame{

public static void main(String[] args)
{
  new HelloWorld();
}

public HelloWorld()
  {
    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel("Hello, World, this is my first Java program on Ubuntu Linux");
    JButton b1 = new JButton("BUTTONNNNN");
    panel1.add(label1);
    panel1.add(b1);
    this.add(panel1);
    this.setTitle("Hello World");
    this.setSize(500,500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

  }
}
public class init(){
  this.addKeyListener(new keyb());

}

public void keyTyped(KeyEvent e) {
  if (e.getKeyCode() == KeyEvent.VK_UP) {

  }
  if (e.getKeyCode() == KeyEvent.VK_DOWN) {

  }
  if (e.getKeyCode() == KeyEvent.VK_LEFT) {

  }
  if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

  }
}
