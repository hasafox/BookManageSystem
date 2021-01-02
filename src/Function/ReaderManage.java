package Function;

import DataManage.ReaderData;

import java.util.Scanner;

public class ReaderManage {
	public static void ReaderManageUI() {
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("欢迎进入书籍管理系统");
			System.out.println("1.查看读者信息");
			System.out.println("2.增加读者信息");
			System.out.println("3.删除读者信息");
			System.out.println("4.修改读者信息");
			System.out.println("5.返回主菜单");
			System.out.println("请选择");
			//获取用户键盘输入的内容
			int num  = scanner.nextInt();
			if(num==1){
//				System.out.println("进入查看读者信息操作");
				//加载书籍的信息并且打印在控制台
				ReaderManage.ShowReaders();
			}else if(num==2){
//				System.out.println("进入增加读者信息操作");
				ReaderManage.AddReader();
			}else if(num==3){
//				System.out.println("进入删除读者信息操作");
				ReaderManage.DeleteReader();
			}else if(num==4){
//				System.out.println("进入修改读者信息操作");
				ReaderManage.ModifyReader();
			}else if(num==5){
				//结束这个循环，返回主菜单
				break;
			}else{
				System.out.println("输入有误，请重新输入");
			}
		}while(true);
		MainMenu.mainMenu();
		scanner.close();
	}

	private static void ShowReaders() {
		String[] readerIds = ReaderData.readerIds;
		String[] readerNames = ReaderData.readerNames;
		int[] readerScores = ReaderData.readerScores;
		int[] readerBorrows = ReaderData.readerBorrows;
		System.out.println("读者列表");
		//利用循环去遍历所有读者的信息
		for(int i=0;i<readerIds.length;i++){
			//如果是空的元素，就不需要遍历了
			if(readerIds[i]==null){
				break;
			}
			System.out.println("编号："+readerIds[i]+"\t"+"人名："+readerNames[i]+"\t"
					+"积分："+readerScores[i]+"\t"+"已借书籍数量："+readerBorrows[i]);
		}
	}

	private static void AddReader() {
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("请输入增加读者编号");
			String readerId = scanner.next();
			System.out.println("请输入增加读者姓名");
			String readerName = scanner.next();
			System.out.println("请输入增加读者积分");
			int readerScore = scanner.nextInt();
			int readerBorrow = 0;
			if(ReaderData.addReader(readerId, readerName, readerScore, readerBorrow)){
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
			System.out.println("是否继续（Y/N）?");
			String choose = scanner.next();
			if(choose.equals("n") || choose.equals("N")){
				break;
			}
		}while (true);
		ReaderManage.ReaderManageUI();
		scanner.close();
	}

	private static void DeleteReader() {
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("请输入删除读者编号");
			String readerId = scanner.next();
			System.out.println("请输入删除读者姓名");
			String readerName = scanner.next();
			int[] result;
			result = ReaderData.deleteReader(readerId, readerName);
			if(result[0]==1){
				System.out.println("你要删除的是第"+ result[1] +"个人");
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
			System.out.println("是否继续（Y/N）?");
			String choose = scanner.next();
			if(choose.equals("n") || choose.equals("N")){
				break;
			}
		}while (true);
		ReaderManageUI();
		scanner.close();
	}

	private static void ModifyReader() {
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("请输入要修改读者编号");
			String oldReaderId = scanner.next();
			System.out.println("请输入修改后读者编号");
			String newReaderId = scanner.next();
			System.out.println("请输入修改后读者姓名");
			String readerName = scanner.next();
			System.out.println("请输入修改后读者积分");
			int readerScore = scanner.nextInt();
			System.out.println("请输入修改后书籍上限");
			int readerBorrow = scanner.nextInt();
			if(ReaderData.modifyReader(oldReaderId, newReaderId, readerName, readerScore, readerBorrow)){
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
			System.out.println("是否继续（Y/N）?");
			String choose = scanner.next();
			if(choose.equals("n") || choose.equals("N")){
				break;
			}
		}while (true);
		ReaderManageUI();
		scanner.close();
	}
}
