package DataManage;

public class BookData {

	//定义一个数组去存放书籍编号
	public static String[] bookIds = new String[50000];
	//定义一个数组去存放书籍
	public static String[] bookNames = new String[50000];
	//定义一个数组去存放书籍价格
	public static double[] bookPrices = new double[50000];
	//定义一个数组去存放书籍所值积分
	public static int[] bookMarks = new int[50000];

	public static boolean[] bookExists = new boolean[50000];

	/*
	 * 初始化书籍的信息
	 */
	public static void initBooks() {

		bookIds[0] = "1001";
		bookNames[0] = "三国演义";
		bookPrices[0] = 18.8;
		bookMarks[0] = 10;
		bookExists[0] = true;

		bookIds[1] = "1002";
		bookNames[1] = "西游记";
		bookPrices[1] = 28.8;
		bookMarks[1] = 20;
		bookExists[1] = true;

		bookIds[2] = "1003";
		bookNames[2] = "红楼梦";
		bookPrices[2] = 38.8;
		bookMarks[2] = 38;
		bookExists[2] = true;

		bookIds[3] = "1004";
		bookNames[3] = "水浒传";
		bookPrices[3] = 48.8;
		bookMarks[3] = 40;
		bookExists[3] = true;
	}

	/*
	* 添加书籍，需要先判定书籍编号，不能有重复的书籍编号
	 */
	public static boolean addBook(String bookId, String bookName, double bookPrice, int bookMark) {
		boolean flag = true;
		int i = 0;
		for (;i<bookIds.length;i++) {
			if (bookIds[i] == null) {
				break;
			}
			if (bookId.equals(bookIds[i])) {
				flag = false;
				break;
			}
		}
		if(flag){
			bookIds[i] = bookId;
			bookNames[i] = bookName;
			bookPrices[i] = bookPrice;
			bookMarks[i] = bookMark;
			bookExists[i] = true;
		}
		return flag;
	}

	public static boolean deleteBook(String bookId, String bookName) {
		boolean flag = false;
		int temp = 0;
		for (int i=0; i < bookIds.length; i++) {
			if (bookIds[i] == null) {
				break;
			}
			if (bookId.equals(bookIds[i])&&(bookName.equals(bookNames[i]))) {
				flag = true;
				temp = i;
				break;
			}
		}

		if(flag){
			int j = 0;
			for(int i=0;i<bookIds.length;i++){
				if(bookIds[i]==null){
					break;
				}
				if(i!=temp){
					bookIds[j]=bookIds[i];
					bookNames[j] = bookNames[i];
					bookPrices[j] = bookPrices[i];
					bookPrices[j] = bookPrices[i];
					bookExists[j] = bookExists[i];
					j++;
				}
			}
			bookIds[j] = null;
		}

		return flag;
	}

	public static boolean modifyBook(String oldBookId, String newBookId, String bookName, double bookPrice, int bookMark) {
	boolean flag = false;
		for (int i=0; i < bookIds.length; i++) {
			if (bookIds[i] == null) {
				break;
			}
			if (oldBookId.equals(bookIds[i])) {
				flag = true;
				bookIds[i] = newBookId;
				bookNames[i] = bookName;
				bookPrices[i] = bookPrice;
				bookMarks[i] = bookMark;
				break;
			}
		}
	return flag;
	}
}
