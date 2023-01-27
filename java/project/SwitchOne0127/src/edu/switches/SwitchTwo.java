package edu.switches;

public class SwitchTwo {
	
	public static void main(String[] args) {
		whoIsIt("ȣ����");
		whoIsIt("����");
		whoIsIt("������");
		whoIsIt("����");
		whoIsIt("����");
		whoIsIt("�Ѹ�Ȥ���׸���");
	}	// end of main()

	/* �Լ� ���� ��
	static void whoIsIt(String bio) {
		String kind = switch(bio) {
		case "ȣ����", "����": {
			yield "������";
		}
		case "������", "����": {
			yield "����";
		}
		case "����", "����": {
			yield "���";
		}
		default: {
			yield null;
		}
		};
		
		System.out.printf("%s��(��) " +
											(kind == null ? "���� �Ӹ�" : "%s�̴�") + "\n", bio, kind);
		
	}
	*/
	/* �Լ� ���� �� 2
		String kind;
		switch(bio) {
		case "ȣ����", "����" -> kind = "������";
		case "������", "����" -> kind = "����";
		case "����", "����" -> kind = "���";
		default -> kind = null;
		};
		
		System.out.printf("%s�� " +
											(kind == null ? "���� �Ӹ�" : "%s�̴�") + "\n", bio, kind);

	}	*/
	static void whoIsIt(String bio) {
		String kind = switch(bio) {
		case "ȣ����", "����": {yield "������";}
		case "������", "����": {yield "����";}
		case "����", "����": {yield "���";}
		default: {yield null;}
		};
		
		System.out.printf("%s�� " +
											(kind == null ? "���� �Ӹ�" : "%s�̴�") + "\n", bio, kind);

	}

}
