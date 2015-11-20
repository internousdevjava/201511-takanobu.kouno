import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *


/**
 * @author internous
 *
 */
public class KisoKadai1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = null;
		String s2 = null;
        int a =0;
        int b =0;
        int c =0;
        while(c==0){                    //while文開始
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//BufferedReaderでXの値の入力待ち
			System.out.println("Xの値を入力してください:");
			s1 = br.readLine();
			//BufferedReaderでYの値の入力待ち
			 System.out.println("Yの値を入力してください:");
			s2 = br.readLine();
			a = Integer.parseInt(s1);
			b = Integer.parseInt(s2);
			if(a>100 || a<=0 || b>100 || b<=0){
				System.out.println("1-100の範囲で入力してください");
				continue;
			}else{
				break;
			}
           //例外処理 a<=0 a>100 . b<=0 b>100)の場合 再度入力を求める
		} catch (Exception e) {
			e.printStackTrace();
		}      //catch文終了
        }      //while文終了
			a = Integer.parseInt(s1);
			b = Integer.parseInt(s2);

		//九九の計算処理 1-100
    for(int x=1; x<=a; x++){
    	for(int y=1; y<=b; y++){
    		int kotae = x*y;
    	System.out.print(String.format("%1$5d",kotae));
    }
    System.out.println("");
    }
  }
}

