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
		// ��¼����
		do {
			System.out.println("*****��ӭ�������˳齱ϵͳ*****");
			System.out.println("        1��ע��");
			System.out.println("        2����¼");
			System.out.println("        3���齱");
			System.out.println("        4���˳�");
			System.out.println("*************************");
			System.out.println("��ѡ��˵���");
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			switch (num) {
			case 1: // ע��
				System.out.println("[���˳齱ϵͳ>ע��]");
				System.out.println("����д����ע����Ϣ��");
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						index = i;
					}
				}
				System.out.println("�û�����");
				names[index] = input.next();
				System.out.println("���룺");
				passes[index] = input.next();
				vips[index] = (int) (Math.random() * 10);
				System.out.println("ע��ɹ�����Ǻ����Ļ�Ա���ţ�");
				System.out.println("�û���\t����\t����");
				System.out.println(names[index] + "\t" + passes[index] + "\t" + vips[index]);
				break;
			case 2: // ��¼
				System.out.println("[���˳齱ϵͳ>��¼]");
				System.out.println("�������û�����");
				String name1 = input.next();
				System.out.println("���������룺");
				String password1 = input.next();
				boolean flag = false;
				for (int i = 0; i < names.length; i++) {
					if (name1.equals(names[i]) && password1.equals(passes[i])) {
						System.out.println("��ӭ����" + names[i]);
						flag = true;
					}
				}
				if (flag) {

				} else {
					do {
						System.out.println("��¼ʧ�ܣ�");
						System.out.println("�����������û�����");
						String name_a = input.next();
						System.out.println("�������������룺");
						String password_a = input.next();
						for (int j = 0; j < names.length; j++) {

							if (name_a.equals(names[j]) && password_a.equals(passes[j])) {
								System.out.println("��ӭ����" + names[j]);
							} else {
								count++;
							}
						}
					} while (count % 3 != 0);
				}
				break;
			case 3: // �齱
				System.out.println("[���˳齱ϵͳ>�齱]");
				System.out.println("���Ŀ��ţ�");
				int vip1 = input.nextInt();
				int[] cards = new int[5];
				// ���������
				for (int i = 0; i < cards.length; i++) {
					cards[i] = (int) (Math.random() * 10);
					for (int j = 0; j < i; j++) {
						while (cards[i] == cards[j]) {
							i--;
						}
					}
				}
				// ��ӡ�����
				System.out.println("��������������ǣ�");
				for (int i = 0; i < cards.length; i++) {
					System.out.print(cards[i] + "\t");
				}
				// �ж��н�
				boolean flag1 = false;
				for (int i = 0; i < cards.length; i++) {
					if (vip1 == cards[i]) {
						flag1 = true;
					}
				}
				if (flag1)
					System.out.println("��ϲ�������ǽ��յ����˻�Ա��");
				else
					System.out.println("��Ǹ�������ǽ��յ����˻�Ա��");

				break;
			case 4: // �˳�
				System.exit(-1);
				break;

			default:
				System.out.println("������������");
				break;
			}

			System.out.println("������(y/n):");
			yn = input.next();
		} while (yn.equals("y"));
		System.out.println("ϵͳ�˳���ллʹ�ã�");

	}
}
