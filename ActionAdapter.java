import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;


public class ActionAdapter implements ActionListener{
	
	CalcModel calcmodel;		//計算機 
	JLabel work;						//結果表示用JLabel
	ActionAdapter(){					//コンストラクタ
		calcmodel =new CalcModel();	//計算機生成
		}
	

	//表示用Jlabel設定
	void setLabel(JLabel jl){
		work=jl;
		work.setText(calcmodel.getLineString());
	}
	//クリックが発生した場合
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//クリックしたボタンの文字の取得
		String cmd = e.getActionCommand();	//押下ボタン取得
		calcmodel.MainMode(cmd);						//ボタン毎の処理
		work.setText(calcmodel.getLineString());	//結果表示
	}

}