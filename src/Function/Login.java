package Function;

import DataManage.ManagerData;

public class Login {
	public static void login(String username, String password) {
		String[] name = ManagerData.names;
		String[] pwd = ManagerData.pwds;

		boolean flag = false;

		for(int i=0;i< name.length;i++) {
			if(name[i]==null){
				break;
			}
			if(username.equals(name[i]) && password.equals(pwd[i])){
				flag = true;
				break;
			}
		}

		if(flag) {
			MainMenu.mainMenu();
		}else{
			System.out.println("用户名或密码不正确，请重新输入！");
		}
	}
}
