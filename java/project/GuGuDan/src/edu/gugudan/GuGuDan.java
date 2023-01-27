package edu.gugudan;

public class GuGuDan {

	public static void main(String[] args) {
		
	    final int columns = 4;  // 1줄에 몇 단씩 출력할지를 결정(이 값을 바꿔도 정상 작동함)
		int dan_head = 2, dan = 2, val = 1;
		
		// 줄의 첫 머리에 오는 단
        for(dan_head = 2; dan_head <= 9; dan_head += columns){
            
            for(val = 1; val <= 9; ++val){
                
                for(dan = dan_head;
                    dan < dan_head+columns && dan <= 9;
                    ++dan){
                    System.out.printf("%d × %d = %2d\t", dan, val, dan*val);
                }
                    
                System.out.println();
            }
            
            System.out.println();
        }
	}

}
