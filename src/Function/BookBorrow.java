package Function;

import DataManage.BookData;
import DataManage.ReaderData;

import java.util.Scanner;

public class BookBorrow {
	public static void BookBorrowManage() {
		String[] ReaderIds = ReaderData.readerIds;
		String[] ReaderNames = ReaderData.readerNames;
		int[] ReaderBorrows = ReaderData.readerBorrows;
		int[] ReaderScores = ReaderData.readerScores;

		String[] BookIds = BookData.bookIds;
		String[] BookNames = BookData.bookNames;
		int[] BookMarks = BookData.bookMarks;
		boolean[] BookExists = BookData.bookExists;

		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("请输入你的编号");
			String ReaderId = scanner.next();
			System.out.println("请输入要借阅的书籍编号");
			String BookId = scanner.next();

			int ReaderIndex=-1, BookIndex=-1;
			for(int i=0;i<ReaderIds.length;i++){
				if(ReaderIds[i]==null){
					break;
				}
				if(ReaderId.equals(ReaderIds[i])){
					ReaderIndex = i;
					break;
				}
			}

			for(int i=0;i<BookIds.length;i++){
				if(BookIds[i]==null){
					break;
				}
				if(BookId.equals(BookIds[i])&&BookExists[i]){
					BookIndex = i;
					break;
				}
			}
			if(ReaderIndex!=-1&&BookIndex!=-1) {
				System.out.println("你要借阅的是否是："+BookNames[BookIndex]);
				System.out.println("Y/N");
				String choose = scanner.next();
				if(choose.equals("Y")||choose.equals("y")) {
					ReaderScores[ReaderIndex] += BookMarks[BookIndex];
					ReaderBorrows[ReaderIndex] += 1;
					BookExists[BookIndex] = false;
					System.out.println(ReaderNames[ReaderIndex] + "你的积分加了" + BookMarks[BookIndex] + "\t" +
							"现积分为：" + ReaderScores[ReaderIndex] + "\t" + "已借书籍" + ReaderBorrows[ReaderIndex]);
					System.out.println("借阅成功");
				}else{
					System.out.println("借阅取消");
				}
			}else{
				System.out.println("读者编号或者书籍编号出错");
			}
			System.out.println("是否继续（Y/N）?");
			String choose = scanner.next();
			if(choose.equals("n") || choose.equals("N")){
				break;
			}
		}while (true);
//		scanner.close();
		MainMenu.mainMenu();
	}

}
