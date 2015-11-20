import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */

/**
 * @author internous
 *
 */
public class kisokadai2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("数字当てゲームを始めます");
		System.out.println("1-100の範囲で数字を入力して下さい");

           //変数の宣言
		String s1 = null;  //コンソールの入力
        int ran;      //randamの数を生成
        ran = (int)(Math.random()*100+1);
        int a =0;         //コンソールの入力
        int b =0;
        //正解までループ
        while(b==0){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//BufferedReaderで数字の入力待ち
			s1 = br.readLine();
			a = Integer.parseInt(s1);
					if(a>100 || a<=0){
						System.out.println("1-100の範囲で入力してください");
						continue;
					}
			if(ran==a){
				System.out.println("正解です");
				break;
			}else if(ran<a){
				System.out.println("大きいです");
			}else{
				System.out.println("小さいです");
				}
			continue;
		} catch (java.lang.NumberFormatException e) {
			System.out.println("1-100の範囲で入力してください");
        } catch (Exception e) {
			e.printStackTrace();
        }
    }
}
}