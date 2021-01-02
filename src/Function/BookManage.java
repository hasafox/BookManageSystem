package Function;

import DataManage.BookData;

import java.util.Scanner;

public class BookManage {
	public static void BookManageUI() {
		//创建Scanner对象
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("欢迎进入书籍管理系统");
			System.out.println("1.查看书籍");
			System.out.println("2.增加书籍");
			System.out.println("3.删除书籍");
			System.out.println("4.修改书籍");
			System.out.println("5.返回主菜单");
			System.out.println("请选择");
			//获取用户键盘输入的内容
			int num = scanner.nextInt();
			if (num == 1) {
//				System.out.println("进入查看书籍操作");
				BookManage.ShowBooks();
			} else if (num == 2) {
//				System.out.println("进入增加书籍操作");
				BookManage.AddBook();
			} else if (num == 3) {
//				System.out.println("进入删除书籍操作");
				BookManage.DeleteBook();
			} else if (num == 4) {
//				System.out.println("进入修改书籍操作");
				BookManage.ModifyBook();
			} else if (num == 5) {
				//结束这个循环，返回主菜单
				break;
			} else {
				System.out.println("输入有误，请重新输入");
			}
		} while (true);
		//scanner.close();
		MainMenu.mainMenu();
	}

	public static void ShowBooks() {
		//加载存放书籍信息的数组
		//将数组引入进来
		String[] bookIds = BookData.bookIds;
		String[] bookNames = BookData.bookNames;
		double[] bookPrices = BookData.bookPrices;
		int[] bookMarks = BookData.bookMarks;
		System.out.println("书籍列表");
		//利用循环去遍历所有书籍的信息
		for (int i = 0; i < bookIds.length; ++i) {
			//如果是空的元素，就不需要遍历了
			if (bookIds[i] == null) {
				break;
			}
			System.out.println("编号：" + bookIds[i] + "\t" + "书名：" + bookNames[i] + "\t"
					+ "价格：" + bookPrices[i] + "\t" + "可值积分：" + bookMarks[i]);
		}
	}

	private static void AddBook() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("请输入增加书籍编号");
			String bookId = scanner.next();
			System.out.println("请输入增加书籍名称");
			String bookName = scanner.next();
			System.out.println("请输入增加书籍价格");
			double bookPrice = scanner.nextDouble();
			System.out.println("请输入增加书籍积分");
			int bookMark = scanner.nextInt();
			if (BookData.addBook(bookId, bookName, bookPrice, bookMark)) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
			System.out.println("是否继续（Y/N）?");
			String choose = scanner.next();
			if (choose.equals("n") || choose.equals("N")) {
				break;
			}
		} while (true);
//		scanner.close();
		BookManage.BookManageUI();
	}

	private static void DeleteBook() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("请输入删除书籍编号");
			String bookId = scanner.next();
			System.out.println("请输入删除书籍名称");
			String bookName = scanner.next();
			if (BookData.deleteBook(bookId, bookName)) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
			System.out.println("是否继续（Y/N）?");
			String choose = scanner.next();
			if (choose.equals("n") || choose.equals("N")) {
				break;
			}
		} while (true);
//		scanner.close();
		BookManage.BookManageUI();
	}

	private static void ModifyBook() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("请输入要修改书籍编号");
			String oldBookId = scanner.next();
			System.out.println("请输入修改后书籍编号");
			String newBookId = scanner.next();
			System.out.println("请输入修改后书籍书名");
			String bookName = scanner.next();
			System.out.println("请输入修改后书籍价格");
			double bookPrice = scanner.nextDouble();
			System.out.println("请输入修改后书籍积分");
			int bookMark = scanner.nextInt();
			if (BookData.modifyBook(oldBookId, newBookId, bookName, bookPrice, bookMark)) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
			System.out.println("是否继续（Y/N）?");
			String choose = scanner.next();
			if (choose.equals("n") || choose.equals("N")) {
				break;
			}
		} while (true);
//		scanner.close();
		BookManage.BookManageUI();
	}
}
