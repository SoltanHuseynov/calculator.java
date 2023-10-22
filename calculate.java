// here use a java.awt library
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calculate extends Frame{
	calculate(){
		Panel panel;
		Button[] numButton= new Button[10];
		Button[] funButton=new Button[7];
		Button addBtn,subBtn,mulBtn,divBtn,delBtn,decBtn;
		Button equBtn;
		//font issue.
		Font textfont=new Font("SansSerif",Font.BOLD,40);
		// create fun btn
		addBtn=new Button("+");
		subBtn=new Button("-");
		mulBtn=new Button("x");
		divBtn=new Button("/");
		delBtn=new Button("DEL");
		decBtn=new Button(".");
		equBtn=new Button("=");
		//these are add into funbutton.
		funButton[0]=addBtn;
		funButton[1]=subBtn;
		funButton[2]=mulBtn;
		funButton[3]=divBtn;
		funButton[4]=delBtn;
		funButton[5]=decBtn;
		funButton[6]=equBtn;
		//set a spaceific size for the equbutton
		//equBtn.setPreferredSize(new Dimension(100,50));
		//part 3
		for(int i=0;i<7;i++){
			// funButton[i].addActionListener(this);
			funButton[i].setFocusable(false);
			funButton[i].setFont(textfont);
		}
		// part 4 number buttons
		for(int i=0;i<10;i++){
			numButton[i]=new Button(String.valueOf(i));
			numButton[i].setFocusable(false);
			numButton[i].setFont(textfont);
		}
		//...
		// to create panel
		panel=new Panel();
		panel.setLayout(new GridLayout(5,5,10,10));
		panel.setBounds(65,250,360,360);
		//these are add into panel
		panel.add(numButton[1]);
		panel.add(numButton[2]);
		panel.add(numButton[3]);
		panel.add(addBtn);
		panel.add(numButton[4]);
		panel.add(numButton[5]);
		panel.add(numButton[6]);
		panel.add(subBtn);
		panel.add(numButton[7]);
		panel.add(numButton[8]);
		panel.add(numButton[9]);
		panel.add(mulBtn);
		panel.add(delBtn);
		panel.add(decBtn);
		panel.add(numButton[0]);
		panel.add(divBtn);
		panel.add(equBtn);
		//window closing
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//creating a text field
		JTextField text=new JTextField(20);
		text.setBounds(10,50,480,120);
		text.setFont(textfont);
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setEditable(false);
		// add button and textfiled
		EventButtons(numButton,funButton,text);
		//adding button,layouts and other into frame
		add(text);
		add(panel);
		// add(equBtn);
		
	}
	public static void main(String args[]){
			calculate core=new calculate();
			core.setTitle("Calculate");
			//window size
			core.setSize(500,700);
			core.setLayout(null);
			core.setResizable(false);
			//frame will ve visible,by default it is not visible
			core.setVisible(true);
																	
	}
	public static void EventButtons(Button[] numbtn,Button[] funbtn,JTextField text){
		 ActionListener buttonListener = new ActionListener() {
		 	char operator;
			double num1=0,num2=0,answer=0;    
			public void actionPerformed(ActionEvent e) {
		 	    	for(int i=0;i<10;i++){
		 	    		if(e.getSource()==numbtn[i]){
		 	    			text.setText(text.getText().concat(String.valueOf(i)));
		 	    			  	
		 	    		}
		 	    	}
		 	    	if(e.getSource()==funbtn[5]){
		 	    			if(text.getText().length()<=0){
		 	    				System.out.println(true);
		 	    			}else{
		 	    				text.setText(text.getText().concat("."));
		 	    			}
		 	    	}
		 	    	if(e.getSource()==funbtn[0]){
		 	    		num1=Double.parseDouble(text.getText());
		 	    		operator='+';	
		 	    		text.setText("");
		 	    
		 	    	}
		 	    	if(e.getSource()==funbtn[1]){
		 	    		num1=Double.parseDouble(text.getText());
		 	    		operator='-';
		 	    		text.setText("");
		 	    	}
		 	    	if(e.getSource()==funbtn[2]){
		 	    		num1=Double.parseDouble(text.getText());
		 	    		operator='x';
		 	    		text.setText("");
		 	    	}
		 	    	if(e.getSource()==funbtn[3]){
		 	    		num1=Double.parseDouble(text.getText());
		 	    		operator='/';
		 	    		text.setText("");
		 	    	}
		 	    	if(e.getSource()==funbtn[4]){
		 	    		text.setText("");
		 	    	}
		 	    	if(e.getSource()==funbtn[6]){
		 	    		num2=Double.parseDouble(text.getText());
		 	    		switch(operator){
		 	    			case '+':
		 	    				answer=num1+num2;
		 	    				break;
		 	    			case '-':
		 	    				answer=num1-num2;
		 	    				break;
		 	    			case 'x':
		 	    				answer=num1*num2;
		 	    				break;
		 	    			case '/':
		 	    				answer=num1/num2;
		 	    				break;
		 	    		}
		 	    		text.setText(String.valueOf(answer));
		 	    			
		 	    	}
		 	    }
		 };
		 for(int i=0;i<10;i++){
		 	numbtn[i].addActionListener(buttonListener);	
		 }
		 for(int i=0;i<7;i++){
		 	funbtn[i].addActionListener(buttonListener);
		 }
		
	}

}
