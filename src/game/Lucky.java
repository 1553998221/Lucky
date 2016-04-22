package game;

import java.util.Random;
import java.util.Scanner;

public class Lucky {
	public static void main(String[] args) {
		String[] names = new String[10];
		String[] passes = new String[10];
		int[] vips = new int[10];
		int index = 0;
		int count = 0;
		String yn = null;
		// 登录界面
		do {
			System.out.println("*****欢迎进入幸运抽奖系统*****");
			System.out.println("        1、注册");
			System.out.println("        2、登录");
			System.out.println("        3、抽奖");
			System.out.println("        4、退出");
			System.out.println("*************************");
			System.out.println("请选择菜单：");
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			switch (num) {
			case 1: // 注册
				System.out.println("[幸运抽奖系统>注册]");
				System.out.println("请填写个人注册信息：");
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						index = i;
					}
				}
				System.out.println("用户名：");
				names[index] = input.next();
				System.out.println("密码：");
				passes[index] = input.next();
				vips[index] = (int) (Math.random() * 10);
				System.out.println("注册成功，请记好您的会员卡号！");
				System.out.println("用户名\t密码\t卡号");
				System.out.println(names[index] + "\t" + passes[index] + "\t" + vips[index]);
				break;
			case 2: // 登录
				System.out.println("[幸运抽奖系统>登录]");
				System.out.println("请输入用户名：");
				String name1 = input.next();
				System.out.println("请输入密码：");
				String password1 = input.next();
				boolean flag = false;
				for (int i = 0; i < names.length; i++) {
					if (name1.equals(names[i]) && password1.equals(passes[i])) {
						System.out.println("欢迎您：" + names[i]);
						flag = true;
					}
				}
				if (flag) {

				} else {
					do {
						System.out.println("登录失败！");
						System.out.println("请重新输入用户名：");
						String name_a = input.next();
						System.out.println("请重新输入密码：");
						String password_a = input.next();
						for (int j = 0; j < names.length; j++) {

							if (name_a.equals(names[j]) && password_a.equals(passes[j])) {
								System.out.println("欢迎您：" + names[j]);
							} else {
								count++;
							}
						}
					} while (count % 3 != 0);
				}
				break;
			case 3: // 抽奖
				System.out.println("[幸运抽奖系统>抽奖]");
				System.out.println("您的卡号：");
				int vip1 = input.nextInt();
				int[] cards = new int[5];
				// 生成随机数
				for (int i = 0; i < cards.length; i++) {
					cards[i] = (int) (Math.random() * 10);
					for (int j = 0; j < i; j++) {
						while (cards[i] == cards[j]) {
							i--;
						}
					}
				}
				// 打印随机数
				System.out.println("今天的幸运数字是：");
				for (int i = 0; i < cards.length; i++) {
					System.out.print(cards[i] + "\t");
				}
				// 判断中奖
				boolean flag1 = false;
				for (int i = 0; i < cards.length; i++) {
					if (vip1 == cards[i]) {
						flag1 = true;
					}
				}
				if (flag1)
					System.out.println("恭喜您！您是今日的幸运会员！");
				else
					System.out.println("抱歉！您不是今日的幸运会员！");

				break;
			case 4: // 退出
				System.exit(-1);
				break;

			default:
				System.out.println("您的输入有误！");
				break;
			}

			System.out.println("继续吗？(y/n):");
			yn = input.next();
		} while (yn.equals("y"));
		System.out.println("系统退出，谢谢使用！");

	}
}
