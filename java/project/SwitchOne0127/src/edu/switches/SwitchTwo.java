package edu.switches;

public class SwitchTwo {
	
	public static void main(String[] args) {
		whoIsIt("호랑이");
		whoIsIt("사자");
		whoIsIt("독수리");
		whoIsIt("참새");
		whoIsIt("고등어");
		whoIsIt("뿌리혹박테리아");
	}	// end of main()

	/* 함수 였던 것
	static void whoIsIt(String bio) {
		String kind = switch(bio) {
		case "호랑이", "사자": {
			yield "포유류";
		}
		case "독수리", "참새": {
			yield "조류";
		}
		case "고등어", "연어": {
			yield "어류";
		}
		default: {
			yield null;
		}
		};
		
		System.out.printf("%s은(는) " +
											(kind == null ? "몰라 임마" : "%s이다") + "\n", bio, kind);
		
	}
	*/
	/* 함수 였던 것 2
		String kind;
		switch(bio) {
		case "호랑이", "사자" -> kind = "포유류";
		case "독수리", "참새" -> kind = "조류";
		case "고등어", "연어" -> kind = "어류";
		default -> kind = null;
		};
		
		System.out.printf("%s는 " +
											(kind == null ? "몰라 임마" : "%s이다") + "\n", bio, kind);

	}	*/
	static void whoIsIt(String bio) {
		String kind = switch(bio) {
		case "호랑이", "사자": {yield "포유류";}
		case "독수리", "참새": {yield "조류";}
		case "고등어", "연어": {yield "어류";}
		default: {yield null;}
		};
		
		System.out.printf("%s는 " +
											(kind == null ? "몰라 임마" : "%s이다") + "\n", bio, kind);

	}

}
