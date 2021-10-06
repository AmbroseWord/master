import java.math.BigDecimal;
import java.math.RoundingMode;


public class CalcModel {
	private int mode=0;			//状態変数
	private int count=0;
	private int decimalcount=0;	//少数点以下
	private int operator;
	private double line;
	private double buffer;
	////////////////////////////////////////
	//数値をStringに変換して返す
	public String getLineString(){
		BigDecimal src = BigDecimal.valueOf(line);
		if(line==0.0f){
			return "0";
		}else{
			if(src.setScale(0, RoundingMode.DOWN).toPlainString().length()>8){
				mode=3;
				return "E";
			}else{
				return src.stripTrailingZeros().toPlainString();
			}
		}
		

		}
	///////////////////////////////////////////////////////
	//各モード毎の処理
	//引数は押されたキー
	  void MainMode(String cmd){
			switch (mode) {
			case 0:
				//モード０：最初の数値入力
				//演算子が入力された場合Mode１へ遷移
				mode_0(cmd);
				break;
			case 1:
				//モード１：演算子が入力された場合
				mode_1(cmd);
				break;
			case 2:
				//モード１：演算子が入力された場合
				mode_2(cmd);
				break;
			case 3:
				//モード１：演算子が入力された場合
				mode_3(cmd);
				break;
			default:
				break;
			}

	}
	  //////////////////////////////////////////////
	  //モード0の場合の、処理
	 
	void mode_0(String in){
			switch (in) {
			///////////////////////////////////////////////////
			case "AC":
				//「AC」押下でmode0で表示も０で初期化
				mode =0;
				line=0f;
				count=0;
				buffer=0;
				decimalcount=0;
				break;
				///////////////////////////////////////////////////
			case "C":
				//「C」押下で表示されている数値のみ0で初期化
				line=0f;
				count=0;
				decimalcount=0;
				break;
				///////////////////////////////////////////////////
				//数値入力
			case"0":
			case"1":
			case"2":
			case"3":
			case"4":
			case"5":
			case"6":
			case"7":
			case"8":
			case"9":
				//8桁以降は無効
				if(count<=7){
					if(decimalcount==0){
						line = line*10+Integer.parseInt(in);
						count++;
					}else{
						if(decimalcount<=6){
							line=line+Double.parseDouble(in)*(double)(Math.pow(10, -1*decimalcount));
							decimalcount++;
							count++;
						}
					}
				}
				break;
			case ".":
				decimalcount=1;
				break;
				///////////////////////////////////////////////////
			case"+":
				operator=1;
				buffer=line;
				count=0;
				decimalcount=0;
				mode=1;
				break;
			case"-":
				operator=2;
					buffer=line;
					count=0;
					decimalcount=0;
					mode=1;
				break;
			case"*":
				operator=3;
				buffer=line;
				count=0;
				decimalcount=0;
				mode=1;
				break;
			case"/":
				operator=4;
				buffer=line;
				count=0;
				decimalcount=0;
				mode=1;	
				break;
			default:
				break;
			}
			
		}
	///////////////////////////////////////////////////
	//モード1
	void mode_1(String in){
		switch (in) {
		///////////////////////////////////////////
		case "AC":
			//「AC」押下でmode0で表示も０で初期化
			mode =0;
			line=0f;
			count=0;
			buffer=0;
			decimalcount=0;
			break;
			///////////////////////////////////////////
		case "C":
			//「C」押下で表示されている数値のみ0で初期化
			line=0f;
			count=0;
			decimalcount=0;
			break;
			///////////////////////////////////////////
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			//8桁以降は無効
			if(count==0)line=0;
			if(count<=7){
				if(decimalcount==0){
					line = line*10+Integer.parseInt(in);
					count++;
				}else{
					if(decimalcount<=6){
						line=line+Double.parseDouble(in)*(double)(Math.pow(10, -1*decimalcount));
						decimalcount++;
						count++;
					}
				}
			}
			break;
		case ".":
			decimalcount=1;
			break;
		case"=":
			line=(operat(buffer, line, operator));
			//buffer=line;
			count=0;
			decimalcount=0;
			mode=2;
			break;
		case"+":
			if(count!=0){
				line=(operat(buffer, line, operator));
			}
			operator=1;
			buffer=line;
			count=0;
			decimalcount=0;
			mode=2;
			break;
		case"-":
			if(count!=0){
				line=(operat(buffer, line, operator));
			}
			operator=2;
			buffer=line;
			count=0;
			decimalcount=0;
			mode=2;
			break;
		case"*":
			if(count!=0){
				line=(operat(buffer, line, operator));
			}
			operator=3;
			buffer=line;
			count=0;
			decimalcount=0;
			mode=2;
			break;
		case"/":
			if(count!=0){
				line=(operat(buffer, line, operator));
			}
			operator=4;
			buffer=line;
			count=0;
			decimalcount=0;
			mode=2;
			break;
		default:
			break;
		}

	}
	///////////////////////////////////////////////////
	//モード2
	void mode_2(String in){
		switch (in) {
		///////////////////////////////////////////
		case "AC":
			//「AC」押下でmode0で表示も０で初期化
			mode =0;
			line=0f;
			count=0;
			buffer=0;
			decimalcount=0;
			break;
			///////////////////////////////////////////
		case "C":
			//「C」押下で表示されている数値のみ0で初期化
			line=0f;
			count=0;
			decimalcount=0;
			break;
			///////////////////////////////////////////
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			//8桁以降は無効
			if(count==0)line=0;
			if(count<=7){
				if(decimalcount==0){
					line = line*10+Integer.parseInt(in);
					count++;
				}else{
					if(decimalcount<=6){
						line=line+Double.parseDouble(in)*(double)(Math.pow(10, -1*decimalcount));
						decimalcount++;
						count++;
					}
				}
			}
			break;
		case ".":
			decimalcount=1;
			break;
		case"=":
			line=(operat(buffer, line, operator));
			//operator=0;
			//buffer=line;
			count=0;
			decimalcount=0;
			mode=1;
			break;
		case"+":
			if(count!=0){
				line=(operat(buffer, line, operator));
			}
			operator=1;
			buffer=line;
			count=0;
			decimalcount=0;
			mode=1;
			break;
		case"-":
			if(count!=0){
				line=(operat(buffer, line, operator));
			}
			operator=2;
			buffer=line;
			count=0;
			decimalcount=0;
			mode=1;
			break;
		case"*":
			if(count!=0){
				line=(operat(buffer, line, operator));
			}
			operator=3;
			buffer=line;
			count=0;
			decimalcount=0;
			mode=1;
			break;
		case"/":
			if(count!=0){
				line=(operat(buffer, line, operator));
			}
			operator=4;
			buffer=line;
			count=0;
			decimalcount=0;
			mode=1;
			break;
		default:
			break;
		}

	}
	///////////////////////////////////////////////////
	//モード2
	void mode_3(String in){
		switch (in) {
		///////////////////////////////////////////
		case "AC":
			//「AC」押下でmode0で表示も０で初期化
			mode =0;
			line=0f;
			count=0;
			buffer=0;
			decimalcount=0;
			break;
			///////////////////////////////////////////
		case "C":
			//「C」押下で表示されている数値のみ0で初期化
			line=0f;
			count=0;
			decimalcount=0;
			mode=0;
			break;
		}
	}
	///////////////////////////////////////////////////
	//実際の演算処理
	double operat(double x,double y,int op){
		double work=0;
		switch (op) {
		case 1:
			work=x+y;
			break;
		case 2:
			work=x-y;
			break;
		case 3:
			work=x*y;
			break;
		case 4:
			work=x/y;
			break;
		default:
			break;
			}
		return work;
	}
	int figures(){
		int count;
		String str = BigDecimal.valueOf(line).toPlainString();
		int dcount=str.indexOf(".");
		int lcount=str.length()-dcount-1;
		count = dcount+lcount;
		
		
		return count;
	}
}
