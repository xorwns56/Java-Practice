import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		ArrayList<String> result = new ArrayList<String>();
		result.add("abc");
		result.add("---");
		result.add("aa--");
		result.add("567");
		result.add("---122");
		result.add("edf");
		ArrayList<String> result2 = new ArrayList<String>();
		ArrayList<String> result3 = new ArrayList<String>();
		for(int i=result.size()-1;i>=0;i--) {
			String s = result.get(i);

			char tmp[] = s.toCharArray();
			boolean isAllAlp = true;
			boolean isAllNum = true;
			boolean isHyphenExist = false;
			for(int j=0;j<tmp.length;j++) {
				if(!isHyphenExist&&tmp[j]=='-') isHyphenExist = true;
				if(isAllNum&&!isBetween(tmp[j],'0','9')) isAllNum = false;
				if(isAllAlp&&!(isBetween(tmp[j],'a','z')||isBetween(tmp[j],'A','Z'))) isAllAlp = false;
			}
			if(isAllAlp) result2.add(s);
			if(isAllNum) result3.add(s);
			if(isHyphenExist) result.remove(s);
			
			/*
			 정규식 표현 사용 시
			if(s.matches("^[a-zA-Z]+$")) result2.add(s);
			if(s.matches("^[1-9]+$")) result3.add(s);
			if(s.matches("^.*[-]+.*$")) result.remove(s);
			*/
		}
		System.out.print("하이픈이 없는 : ");
		printList(result);
		System.out.print("모두 알파벳 : ");
		printList(result2);
		System.out.print("모두 숫자 : ");
		printList(result3);
		
	}
	
	static void printList(ArrayList<String> stringList) {
		for(int i=0;i<stringList.size();i++){
			System.out.print(stringList.get(i) + " ");
		}
		System.out.println();
	}
	
	static boolean isBetween(char x, char a, char b) {
		return a<=x&&x<=b;
	}
}
