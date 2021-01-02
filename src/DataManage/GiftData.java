package DataManage;

public class GiftData {
	public static String[] giftIds = new String[5000];
	public static String[] giftNames = new String[5000];
	public static int[] giftScores = new int[5000];
	public static int[] giftCounts = new int[5000];

	public static void initGifts() {
		giftIds[0] = "1001";
		giftNames[0] = "铲子";
		giftScores[0] = 20;
		giftCounts[0] = 5;

		giftIds[1] = "1002";
		giftNames[1] = "垫子";
		giftScores[1] = 15;
		giftCounts[1] = 4;

		giftIds[2] = "1003";
		giftNames[2] = "毯子";
		giftScores[2] = 30;
		giftCounts[2] = 3;

		giftIds[3] = "1004";
		giftNames[3] = "杯子";
		giftScores[3] = 20;
		giftCounts[3] = 2;
	}


}
