import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Calc extends JFrame {
JLabel L0;
JButton numButton[];		//数値ボタン
JButton decimalButton;	//小数点ボタン 
JButton opeButton[];		//演算ボタン
JButton cButton;				//クリアボタン
JButton acButton;			//オールクリアボタン
JButton rquButton;			//=ボタン
String ope="*/-+";
JLabel test;
public Calc(){
	this.setSize(330,520);						//Windowサイズ
	this.setLayout(null);						//レイアウトレイアウト無効
	this.setResizable(false);					//Windowサイズ固定
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Window閉じる処理
	L0=new JLabel();							//数字表示部

	//ボタン押下イベント取得先のクラス作成
	ActionAdapter actionadapter =new ActionAdapter();
	
	Font f=new Font("Serif",Font.PLAIN,24);	//ボタン表示のフォント
	Font f2=new Font("Serif",Font.PLAIN,46);	//数字表示部のフォント

	L0.setFont(f2);							//数字表示部のフォント指定
	L0.setBounds(0, 0, 300, 50);	//数字表示部のサイズ指定
	actionadapter.setLabel(L0);	//数字表示部の設定
	this.add(L0);
	

	acButton = new JButton();					//「AC」ボタン作成
	acButton.setFont(f);							//「AC」ボタンフォント指定
	acButton.setText("AC");						//「AC」ボタン表記
	acButton.setBounds(0, 50, 80, 80);		//「AC」ボタン表示位置、サイズ指定
	acButton.setActionCommand("AC");	//ボタンイベントにより返る文字列を「AC」に設定
	acButton.addActionListener(actionadapter);	//イベント受け先指定
	this.add(acButton);								//ボタン表示
	
	cButton = new JButton();					//「C」ボタン作成
	cButton.setFont(f);
	cButton.setText("C");
	cButton.setBounds(80, 50, 80, 80);
	cButton.setActionCommand("C");
	cButton.addActionListener(actionadapter);
	this.add(cButton);


	numButton =new JButton[10];						//数字ボタン作成
	for(int i=0;i<10;i++){
		numButton[i]=new JButton();
		numButton[i].setFont(f);
		numButton[i].setText(""+i);						//数字ボタン表記
		//数字ボタン配置位置、大きさ指定
		numButton[i].setBounds(80*((9-i)%3),130+80*((9-i)/3), 80, 80);	
		numButton[i].setActionCommand(""+i);
		numButton[i].addActionListener(actionadapter);	//数字ボタンイベント
		this.add(numButton[i]);
	}
	

	decimalButton=new JButton();			//少数点ボタン作成;
	decimalButton.setFont(f);
	decimalButton.setText(".");
	decimalButton.setBounds(80,130+80*3, 80, 80);
	decimalButton.setActionCommand(".");
	decimalButton.addActionListener(actionadapter);
	this.add(decimalButton);
	
	opeButton = new JButton[4];							//演算子ボタン作成
	for(int i=0;i<4;i++){
		opeButton[i] = new JButton();
		opeButton[i].setFont(f);
		opeButton[i].setText(ope.substring(i,i+1));	//演算子記号設定
		opeButton[i].setActionCommand(ope.substring(i,i+1));
		opeButton[i].setBounds(240,50+80*i, 80, 80);
		opeButton[i].addActionListener(actionadapter);
		this.add(opeButton[i]);
		
	}


	rquButton = new JButton();
	rquButton.setFont(f);
	rquButton.setText("＝");
	rquButton.setBounds(160, 370, 160, 80);
	rquButton.setActionCommand("=");
	rquButton.addActionListener(actionadapter);
	this.add(rquButton);

	this.setVisible(true);
}
public static void main(String[] args){
	new Calc();
}
}
