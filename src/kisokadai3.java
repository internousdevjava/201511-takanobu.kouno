import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 * @author internous
 *
 */
public class kisokadai3 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("フォルダ.ファイルを作成してください");
		String FF =buf.readLine();  //FF(ファイル・フォルダ)のコンソール入力

		//ファイルパスの指定
	        File newfile = new File(FF);
		//ディレクトリパスを習得
		   File dir=new File(newfile.getParent());

		   //フォルダの作成
			if(!dir.exists()){    //!（否定　意味の逆転）　ディレクトリなかった場合
				System.out.println("フォルダがありません。:"+newfile.getAbsolutePath());
				dir.mkdirs();
				System.out.println("フォルダを新規作成しました。");
				}else{
				System.out.println("フォルダは作成済みです。");
				}
	    //ファイルの作成
	    if(newfile.exists()){
	        System.out.println("ファイルは作成済みです"+ newfile.getAbsolutePath());
	    }else{
	       System.out.println("ファイルはありません"+ newfile.getAbsolutePath());
	    }
           try{
               if (newfile.createNewFile() ) {
                   System.out.println("ファイルを作成しました");
               }else{
                   // ファイルの作成に失敗
                   System.out.println("ファイルは作成済みです");
               }
           }catch(FileNotFoundException e){
        	   System.out.println(e);
           }catch(IOException e){
               // 例外処理
               System.out.println("例外が発生しました。");
               System.out.println(e);
           }

		int end = 0;
		while(end==0){

			System.out.println("--メニュー--");
			System.out.println("1:読み込み");
			System.out.println("2:書き込み");
			System.out.println("99:終了入力してください");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			int n = 0;

			if(str.matches("^[0-9]+$")){
				n=Integer.parseInt(str);
			}else{
				System.out.println("------数値でメニューを選択してください。\n------");
			}

			if(n==99){
				System.out.println("終了");
				break;
			}
			if(n==1){
				System.out.println("ファイルを読む");
				try{
					FileReader filereader = new FileReader(newfile.getAbsolutePath());

					int ch;
					while((ch = filereader.read()) != -1){
						System.out.print((char)ch);
					}

					filereader.close();
				}catch(FileNotFoundException e){
					System.out.println(e);
				}catch(IOException e){
					System.out.println(e);
				}
			}
			if(n==2){
				System.out.println("ファイルを書く");
				try {
					boolean mode = false;
					System.out.println("モードの設定。1:追記");
					System.out.println("モードの設定。2:上書き");
					BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
					String str2 = br2.readLine();
					// モードを決める
					switch (str2) {
					case "1":
						mode = true;
						break;
					case "2":
						mode = false;
					default:
						break;
					}
					//出力先を作成する
					FileWriter fw = new FileWriter(newfile.getAbsolutePath(), mode);
					PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

					//内容を指定する
					BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
					String str3 = br3.readLine();
					pw.println(str3);

					//ファイルに書き出す
					pw.close();

					//終了メッセージを画面に出力する
					System.out.println("出力しました。");

				} catch (IOException ex) {
					//例外時処理
					ex.printStackTrace();
				}

			}
		}
		System.out.println("--処理終了--");
	}
}

