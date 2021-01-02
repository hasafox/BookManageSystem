package Function;

import DataManage.GiftData;
import DataManage.ReaderData;

import java.util.Scanner;

public class ScoreConvert {

	public static void ScoreConvertUI() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("欢迎进入书籍管理系统");
			System.out.println("1.兑换礼品");
			System.out.println("2.礼品清单");
			System.out.println("3.返回主菜单");
			System.out.println("请选择");
			//获取用户键盘输入的内容
			int num = scanner.nextInt();
			if (num == 1) {
				ScoreConvert.getGifts();
			} else if (num == 2) {
				ScoreConvert.showGifts();
			} else if (num == 3) {
				break;
			} else {
				System.out.println("输入有误，请重新输入");
			}
		} while (true);
		MainMenu.mainMenu();
		scanner.close();
	}

	private static void getGifts() {
		String[] ReaderIds = ReaderData.readerIds;
		String[] ReaderNames = ReaderData.readerNames;
//		int[] ReaderBorrows = ReaderData.readerBorrows;
		int[] ReaderScores = ReaderData.readerScores;

		String[] giftIds = GiftData.giftIds;
		String[] giftNames = GiftData.giftNames;
		int[] giftScores = GiftData.giftScores;
		int[] giftCounts = GiftData.giftCounts;

		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("请输入你的读者编号");
			String ReaderId = scanner.next();
			System.out.println("请输入你要兑换的礼品编号");
			String GiftId = scanner.next();
			int ReaderIndex = -1, GiftIndex = -1;

			for (int i = 0; i < ReaderIds.length; ++i) {
				if (ReaderIds[i] == null) {
					break;
				}
				if (ReaderId.equals(ReaderIds[i])) {
					ReaderIndex = i;
				}
			}

			for (int i = 0; i < giftIds.length; ++i) {
				if (giftIds[i] == null) {
					break;
				}
				if (GiftId.equals(giftIds[i])) {
					GiftIndex = i;
				}
			}

			if(ReaderIndex!=-1&&GiftIndex!=-1) {
				System.out.println("人名："+ReaderNames[ReaderIndex]+"\t"+"积分："+ReaderScores[ReaderIndex]+"\n"
						+ "你是否要兑换："+giftNames[GiftIndex]+"\t"+"此物需要："+giftScores[GiftIndex]+"积分");
				System.out.println("Y/N");
				String choose = scanner.next();
				if (choose.equals("y") || choose.equals("Y")) {
					if(ReaderScores[ReaderIndex]>=giftScores[GiftIndex]){
						ReaderScores[ReaderIndex]-=giftScores[GiftIndex];
						giftCounts[GiftIndex] -= 1;
						System.out.println(ReaderNames[ReaderIndex]+"你的积分现在为："+ReaderScores[ReaderIndex]);
					} else {
						System.out.println("积分不够，无法兑换");
						System.out.println("兑换失败");
					}
				} else {
					System.out.println("兑换取消");
				}
			}
			else {
				System.out.println("读者编号或者礼物编号出错");
			}

			System.out.println("是否继续（Y/N）?");
			String choose = scanner.next();
			if (choose.equals("n") || choose.equals("N")) {
				break;
			}
		} while (true);
		ScoreConvert.ScoreConvertUI();
		scanner.close();
	}

	private static void showGifts() {
		String[] giftIds = GiftData.giftIds;
		String[] giftNames = GiftData.giftNames;
		int[] giftScores = GiftData.giftScores;
		int[] giftCounts = GiftData.giftCounts;
		System.out.println("礼品列表");
		for (int i = 0; i < giftIds.length; ++i) {
			if (giftIds[i] == null){
				break;
			}
			System.out.println("礼品编号："+giftIds[i]+"\t"+"礼品名字："+giftNames[i]+"\t"
					+"礼品值多少积分："+giftScores[i]+"\t"+"礼品数量："+giftCounts[i]);
		}
	}
}
