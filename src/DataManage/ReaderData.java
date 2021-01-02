package DataManage;

public class ReaderData {
	public static String[] readerIds = new String[5000];
	public static String[] readerNames = new String[5000];
	public static int[] readerScores = new int[5000];
	public static int[] readerBorrows = new int[5000];

	public static void initReaders() {
		readerIds[0] = "1001";
		readerNames[0] = "刘二麻子";
		readerScores[0] = 10;
		readerBorrows[0] = 2;

		readerIds[1] = "1002";
		readerNames[1] = "李狗蛋";
		readerScores[1] = 30;
		readerBorrows[1] = 3;

		readerIds[2] = "1003";
		readerNames[2] = "黄日天";
		readerScores[2] = 50;
		readerBorrows[2] = 4;
	}


	public static boolean addReader(String readerId, String readerName, int readerScore, int readerBorrow) {
	boolean flag = true;
		int i = 0;
		for (;i<readerIds.length;i++) {
			if (readerIds[i] == null) {
				break;
			}
			if (readerId.equals(readerIds[i])) {
				flag = false;
				break;
			}
		}
		if(flag){
			readerIds[i] = readerId;
			readerNames[i] = readerName;
			readerScores[i] = readerScore;
			readerBorrows[i] = readerBorrow;
		}

	return flag;
	}


	public static int[] deleteReader(String readerId, String readerName) {
		int[] result = {0, 0};

		for (int i = 0;i<readerIds.length;i++) {
			if (readerIds[i] == null) {
				break;
			}
			if (readerId.equals(readerIds[i])&&readerName.equals(readerNames[i])) {
				result[0] = 1;
				result[1] = i;
				break;
			}
		}
		if(result[0]==1){
			int j = 0;
			for(int i=0;i<readerIds.length;i++){
				if(readerIds[i]==null){
					break;
				}
				if(i!=result[1]){
					readerIds[j] = readerIds[i];
					readerNames[j] = readerNames[i];
					readerScores[j] = readerScores[i];
					readerBorrows[j] = readerBorrows[i];
					j++;
				}

			}
			readerIds[j] = null;
		}
		return result;
	}

	public static boolean modifyReader(String oldReaderId, String newReaderId, String readerName, int readerScore, int readerBorrow) {
		boolean flag = false;

		for (int i = 0;i<readerIds.length;i++) {
			if (readerIds[i] == null) {
				break;
			}
			if (oldReaderId.equals(readerIds[i])) {
				readerIds[i] = newReaderId;
				readerNames[i] = readerName;
				readerScores[i] = readerScore;
				readerBorrows[i] = readerBorrow;
				flag = true;
				break;
			}
		}
		return flag;
	}
}
