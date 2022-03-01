package tttinfinite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class GameFrame1 extends JFrame implements ActionListener{
ArrayList<MyButton> buttons = new ArrayList<>();
Boolean flag = false;
Integer counter = 1;
Integer tempRow = -1;  //current row of the button that was just pressed
Integer tempCol = -1;  //current column of the button that was just pressed
Integer BoardSize = 20; 
int prev = 1;
int count;
    public GameFrame1(){
        super("Game");
        setPreferredSize(new Dimension(1000,1000));
        setSize(1000,1000);
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(500,500));
        GridLayout layout = new GridLayout(BoardSize, 0, 0, 0);
        panel.setLayout(layout);
        add(panel);
        for (Integer i = 0; i < BoardSize * BoardSize; i++) {
            MyButton btn1 = new MyButton((int)i/BoardSize, i % BoardSize);
        btn1.setVisible(true);
       
        btn1.addActionListener(this);
        buttons.add(btn1);        
        }
        for (Integer i = 0; i < BoardSize * BoardSize; i++) {
            
            panel.add(buttons.get(i));
            
        }       
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
       
        MyButton b = (MyButton) e.getSource();
        if (b.getBackground() == Color.YELLOW){
      
        }
        
        b.setBackground(Color.YELLOW);
        tempRow = b.getButtonRow();
        tempCol = b.getButtonCol();
       // we try to put the current sign. It depends on the oddness of the turn number
       if (counter % 2 == 1 && !"X".equals(b.getText()) && b.getText() != "O"){
            b.setText("X");
            counter+=1;    
        }
        else if(counter%2 == 0 && b.getText() != "X" && b.getText() != "O"){
            b.setText("O");
        counter+=1;
        }
checkVert(b.getText());
checkHor(b.getText());
checkDiag(b.getText());
checkDiag2(b.getText());
            
    }  

    
    

 public void checkVert(String s){
count = 1;
try{
for(int i = 2; i <5; i++){
prev = count;
System.out.println(tempRow*i+tempCol+(BoardSize*i));
System.out.println(tempRow*i+tempCol);
if(buttons.get(tempRow*i+tempCol+(BoardSize*i)).getText().equals( buttons.get(tempRow*i+tempCol).getText() )){
count++;
}
if(count == prev){
break;
}
}
for(int i = 2; i <5; i++){
prev = count;
System.out.println(tempRow*i+tempCol+(BoardSize*i));
System.out.println(tempRow*i+tempCol);
if(buttons.get(tempRow*i+tempCol-(BoardSize*i)).getText().equals( buttons.get(tempRow*i+tempCol).getText() )){
count++;
}
if(count == prev){
break;
}
}

}
catch(ArrayIndexOutOfBoundsException e){}

if (count >= 5){
            winStop(s);
          
       }
       
}

public void checkHor(String s){
count = 1;
try{    
for(int i = 2; i <5; i++){
prev = count;
if(buttons.get(tempRow+tempCol*i+(BoardSize*i)).getText().equals( buttons.get(tempRow+tempCol*i).getText() )){
count++;
}

}


for(int i = 2; i <5; i++){
prev = count;
if(buttons.get(tempRow*+tempCol-(BoardSize*i)).getText().equals( buttons.get(tempRow+tempCol*i).getText() )){
count++;
}
if(count == prev){
break;
}
}}
catch(ArrayIndexOutOfBoundsException e){}

if (count >= 5){
            winStop("X / O");
          
       }
       
}

    
 public void checkDiag(String s){
count = 1;
try{
for(int i = 2; i <5; i++){
prev = count;
if(buttons.get(tempRow*i+tempCol+(BoardSize*i)+i).getText().equals( buttons.get(tempRow*i+tempCol).getText() )){
count++;
}
if(count == prev){
break;
}
}
for(int i = 2; i <5; i++){
prev = count;
if(buttons.get(tempRow*i+tempCol-(BoardSize*i)-i).getText().equals( buttons.get(tempRow*i+tempCol).getText() )){
count++;
}
if(count == prev){
break;
}
}
}
catch(ArrayIndexOutOfBoundsException e){};
if (count >= 5){
            winStop("X / O");
          
       }
       
 }
   public void checkDiag2(String s){
count = 1;
for(int i = 2; i <5; i++){
    prev = count;
    if(buttons.get(tempRow*i+tempCol-(BoardSize*i)+i).getText().equals( buttons.get(tempRow*i+tempCol).getText() )){
        count++;
    }
    if(count == prev){
        break;
    }
}
for(int i = 2; i <5; i++){
    prev = count;
    if(buttons.get(tempRow*i+tempCol-(BoardSize*i)+i).getText().equals( buttons.get(tempRow*i+tempCol).getText() )){
        count++;
    }
    if(count == prev){
        break;
    }
    }
if (count >= 5){
            winStop("X / O");
          
       }
       
}
    
    
    
    
      public void winStop(String s){
           JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, s + " WINS!");
            //System.exit(0);
            for(int i = 0; i < buttons.size();i++){
            buttons.get(i).setText(" ");
            buttons.get(i).setBackground(Color.CYAN);
            }
            counter = 1;
    }
}
