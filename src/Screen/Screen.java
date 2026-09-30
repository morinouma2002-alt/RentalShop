package Screen;

import java.util.Scanner;

import Guest.Guest2;

public interface Screen {

	Scanner sc = new Scanner(System.in);

	default void print(Guest2 g) {

		boolean found = true;
		String textBlock = """
				1,レンタル
				2,返却
				3,商品検索
				を選んでください
				""";

		System.out.println(textBlock);

		int n = sc.nextInt();

		while (found) {
			
			switch (n) {
			
			case 1:
				rental(g);
				found = false;
				break;
				
			case 2:
				return11(g);
				found = false;
				break;

			case 3:
				System.out.println("検索が終わるまで、検索し続けます");
				search(g);

				System.out.println("ループを抜けたいので、１はレンタル　２は返却　それ以外は何もしない　の数字を入力してください");
				n = sc.nextInt();
				break;

			default:
				System.out.println("何もしませんでした");
				found=false;
			}
		}
	}

	public abstract void rental(Guest2 g);

	public abstract void return11(Guest2 g);

	public abstract void search(Guest2 g);
}
