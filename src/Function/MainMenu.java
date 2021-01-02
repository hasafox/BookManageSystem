package Function;

import DataManage.BookData;
import DataManage.GiftData;
import DataManage.ManagerData;
import DataManage.ReaderData;

import java.util.Scanner;

public class MainMenu {
	public static void BookManageSystemUI(){
		ManagerData.initManagers();
		BookData.initBooks();
		ReaderData.initReaders();
		GiftData.initGifts();
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("欢迎进入青年管理系统");
			System.out.println("1 登录");
			System.out.println("2 退出");
			System.out.println("请选择");
			//获取用户键盘输入的数字
			int num = scanner.nextInt();
			if(num==1){
				//调用登录界面
				login();
			}else if(num==2){
				//结束循环，退出
				break;
			}else{
				//错误输入
				System.out.println("您输入有误，请重新输入");
			}
		}while(true);
	}

	public static void login(){
		//创建一个Scanner对象
		Scanner scanner = new Scanner(System.in);
		//提示用户输入用户名
		System.out.println("请输入用户名:");
		//获取用户输入的用户名
		String name = scanner.next();
		//提示用户输入密码
		System.out.println("请输入密码:");
		//获取用户输入的密码
		String password = scanner.next();
		/*
		 * 调用一个方法去判断用户名和密码是否正确
		 */
		Login.login(name, password);
	}

	public static void mainMenu(){
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("欢迎使用三毛书籍管理系统");
			System.out.println("1 书籍管理");
			System.out.println("2 读者管理");
			System.out.println("3 书籍借阅");
			System.out.println("4 积分兑换");
			System.out.println("5 退出");
			System.out.println("请选择:");
			//获取用户键盘输入的内容
			int num  = scanner.nextInt();
			if(num==1){
//				System.out.println("进入书籍管理模块");
				BookManage.BookManageUI();
			}else if(num==2){
//				System.out.println("进入读者管理模块");
				ReaderManage.ReaderManageUI();
			}else if(num==3){
//				System.out.println("进入书籍借阅模块");
				BookBorrow.BookBorrowManage();
			}else if(num==4){
//				System.out.println("进入积分兑换");
				ScoreConvert.ScoreConvertUI();
			}else if(num==5){
				//结束这个循环
				break;
			}else{
				System.out.println("输入有误，请重新输入");
			}
		}while(true);
		scanner.close();
		System.exit(0);
	}
}
