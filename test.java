import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
class test{
	public static void main(String[] args) {
	password obj=new password();
    }
}
class password implements ActionListener,Runnable,ItemListener{
JFrame frame=new JFrame("Password Genarator");
int angel=0;
JPanel panel=new JPanel(){
public void paint(Graphics g){
super.paint(g);
g.setColor(Color.green);
//g.fillArc(350,220,50,50,0,angel);
g.drawString(String.valueOf(calculate),350,220);  
      }
   };
JComboBox jb;
int calculate=0;
int strength=0;
JTextField text_area;
JCheckBox cb1,cb2,cb3,cb4,cb5;
int start=4;
String arr[]=new String[47];
Container c;
String number="0123456789";
String lower_case="abcdefghijklmnopqrstuvwxyz";
String higher_case="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String symbol="~!@#$%^&*`_=<>?;|:.";
String bracket="{}()[]";
String password="";
JButton button,copy_bt;
JLabel label;
Thread t;
int size=0;
Random rand;
int bar_value;
JProgressBar bar;
boolean lower_status,Upper_status,symbol_status,bracket_status,number_status;
password(){
make(); 
rand=new Random();
button=new JButton("Genarate");
button.setBounds(170,220,170,50);
button.setFont(new Font("Arial",Font.BOLD,27));
button.addActionListener(this);
copy_bt=new JButton("Copy");copy_bt.setFont(new Font("Arial",Font.BOLD,10));
copy_bt.setBounds(500,50,60,60);copy_bt.addActionListener(this);
label=new JLabel("Password Size");label.setFont(new Font("Arial",Font.BOLD,18));
label.setBounds(105,50,138,20);label.setForeground(Color.green);
frame.setSize(597,400);
frame.setLocationRelativeTo(null);    
frame.setResizable(false);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
bar=new JProgressBar(0,100);
bar.setBounds(0,300,560,43);
bar.setStringPainted(true);
bar.setString("");bar.setFont(new Font("Arial",Font.BOLD,20));
bar.setForeground(Color.red);
c=frame.getContentPane();
c.setBackground(Color.yellow);
c.setLayout(null);
panel.setSize(560,343);
panel.setLocation(10,10);
panel.setBackground(Color.black);
panel.setLayout(null);
c.add(panel);
panel.add(jb);
panel.add(cb1);
panel.add(cb2);
panel.add(cb3);
panel.add(cb4);
panel.add(cb5);
panel.add(button);
panel.add(label);
panel.add(text_area);
panel.add(bar);
panel.add(copy_bt);
  }
public  void make(){
for(int i=0;i<=46;i++){
arr[i]=Integer.toString(start);
start++;
  }
jb=new JComboBox(arr);
jb.setBounds(243,50,50,20);  jb.setFont(new Font("Arial",Font.BOLD,17));
jb.addActionListener(this);	
text_area=new JTextField("Result Password");
text_area.setHorizontalAlignment(SwingConstants.CENTER);
text_area.setFont(new Font("Arial",Font.BOLD,15));
text_area.setBounds(0,0,560,50);
text_area.setEditable(false);
text_area.setBackground(Color.black);
text_area.setForeground(Color.cyan);
cb1=new JCheckBox("Include Lower Case");cb1.setFont(new Font("Arial",Font.BOLD,16));
cb1.setBounds(70,70,190,50);
cb1.setBackground(Color.black);
cb1.setForeground(Color.green);
cb1.addItemListener(this);cb1.addActionListener(this);
cb2=new JCheckBox("Include Upper Case");cb2.setFont(new Font("Arial",Font.BOLD,16));
cb2.setBounds(260,70,190,50); 
cb2.setBackground(Color.black);
cb2.setForeground(Color.green);
cb2.addItemListener(this);cb2.addActionListener(this);
cb3=new JCheckBox("Include Symbol");cb3.setFont(new Font("Arial",Font.BOLD,16));
cb3.setBounds(70,120,170,50); 
cb3.setBackground(Color.black);
cb3.setForeground(Color.green);
cb3.addItemListener(this);cb3.addActionListener(this);
cb4=new JCheckBox("Include Bracket");cb4.setFont(new Font("Arial",Font.BOLD,16));
cb4.setBounds(260,120,170,50); 
cb4.setBackground(Color.black);
cb4.setForeground(Color.green);
cb4.addItemListener(this);cb4.addActionListener(this);
cb5=new JCheckBox("Include Number");cb5.setFont(new Font("Arial",Font.BOLD,16));
cb5.setBounds(170,170,170,50); 
cb5.setBackground(Color.black);
cb5.setForeground(Color.green);
cb5.addItemListener(this);cb5.addActionListener(this);
cb1.setSelected(true);
cb2.setSelected(true);
cb3.setSelected(true);
cb4.setSelected(true);
cb5.setSelected(true);
  }
public  void itemStateChanged(ItemEvent item){
if(cb1.isSelected())
  lower_status=true;
else
   lower_status=false;
if(cb2.isSelected())
	Upper_status=true;
else
	Upper_status=false;
if(cb3.isSelected())
	symbol_status=true;
else
	symbol_status=false;
if(cb4.isSelected())
	bracket_status=true;
else
	bracket_status=false;
if (cb5.isSelected())
	number_status=true;
else
	number_status=false;
if(cb1.isSelected()==false && cb2.isSelected()==false &&  cb3.isSelected()==false  &&  cb4.isSelected()==false  &&  cb5.isSelected()==false)
	button.setEnabled(false);
  }  
public  void  actionPerformed(ActionEvent action){
bar_value=0;	
bar.setString("");
strength=0;
angel=0;	
calculate=0;
if(action.getSource()== jb){
bar_value=0;
bar.setValue(bar_value);   
  }
if(action.getSource()== button){
	password_maker();
	power();
      }
if(action.getSource()==copy_bt){
StringSelection stringselect=new StringSelection(text_area.getText());
Clipboard board=Toolkit.getDefaultToolkit().getSystemClipboard();
board.setContents(stringselect,null);
      }      
if(cb1.isSelected()==true || cb2.isSelected()==true ||  cb3.isSelected()==true  ||  cb4.isSelected()==true  ||  cb5.isSelected()==true)
	button.setEnabled(true);      
  } 
public  void password_maker(){
text_area.setText("");
password="";	
t=new Thread(this);
t.start();
   }
public  void run(){
size=Integer.parseInt((String)jb.getSelectedItem());	
int i=0;
int upgrade=(100/size)+1;

while(i != size){
int sequance=rand.nextInt(5);	
if(sequance==0 && Upper_status==true){
password=password+higher_case.charAt(rand.nextInt(26));
i++;
bar_value=bar_value+upgrade;
bar.setValue(bar_value);
                }
if(sequance==1 && lower_status==true){
password=password+lower_case.charAt(rand.nextInt(26));
i++;
bar_value=bar_value+upgrade;
bar.setValue(bar_value);
            }
if(sequance==2 && bracket_status==true){
password=password+bracket.charAt(rand.nextInt(6));
i++;
bar_value=bar_value+upgrade;
bar.setValue(bar_value);
            }
if(sequance==3 && symbol_status==true){
password=password+symbol.charAt(rand.nextInt(19));
i++;
bar_value=bar_value+upgrade;
bar.setValue(bar_value);
            }
if(sequance==4 && number_status==true){
password=password+number.charAt(rand.nextInt(10));
i++;
bar_value=bar_value+upgrade;
bar.setValue(bar_value);
            }	
try{Thread.sleep(30);}catch(Exception e){}
text_area.setText(password);
bar.setString("Processing");
       }    
 bar.setString("Processed");   
    }
public void power(){
strength=0;
angel=0;	
calculate=0;
if(cb1.isSelected()  || cb2.isSelected())
	strength=strength+26;
if(cb3.isSelected())
	strength=strength+19;
if(cb4.isSelected())
	strength=strength+6;
if(cb5.isSelected())
    strength=strength+10;
calculate=(int)(size*(Math.round(Math.log(strength)/Math.log(2))));
if(calculate<=28)
angel=90;
if(calculate>=29 && calculate<=35)
angel=180;
if(calculate>=36 && calculate<=59)
angel=270;
if(calculate>=80)
angel=360;
panel.repaint();
   }    
}









