import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;


public class module2{
	
	public static String opcode(String opcode,String param1,String param2) {

		return "fail";
	}
	
	public static String opcode(String opcode,String param1,String param2,String param3) {
		Stack<String> stack = new Stack<>();
		String result;
		
		if(opcode.equals("write")) {
			//스택에 param3값 푸시 
			result = "0011 " + param3 + "\n";
			stack.push(param3);
			
			//메모리주소A에 스택값 저장
			result +="1000 " + param2 + "\n";
			
			//스택 제거
			stack.pop();
			result +="0101\n";
			
			return result;
		}
		return "fail";
	}
	
	public static String opcode(String opcode,String num1) {
		return "fail";
	}

	public static void main(String[] args) {
		//Scanner객체 생성
		Scanner sc = new Scanner(System.in);
		//Stack 객체 생성
		Stack<String> stackRe = new Stack<>();
		Queue<String> queue = new LinkedList<>();
		
		//while문 반복을 위한 bool 변수와 반복횟수를 알기위한 tryNum 변수 생성
		String bool = "yes";
		int tryNum = 0;
		
		//bool값이 false가 될때까지 명령어 입력을 반복
		while(bool.equalsIgnoreCase("yes")){
			//초기화
			String  v1 = null, v2 = null, v3 = null, v4 = null;
			
			//명렁어 입력받기
			String inputCode = sc.nextLine();
			String[] inputs = inputCode.split(" ");
			
			v1 = inputs[0];
			v2 = inputs[1];
			if (inputs.length > 2) {
			    v3 = inputs[2];
			}
			if (inputs.length > 3) {
			    v4 = inputs[3];
			}
			
			//opcode함수에서 연산진행후 그 값을 스택에 저장
			if(!v4.equals(null)) {
				queue.add(opcode(v1,v2,v3,v4));
			}else if(!v3.equals(null)) {
				queue.add(opcode(v1,v2,v3));
			}else {
				queue.add(opcode(v1,v2));
			}
			
			System.out.println("more? yes or no");
			bool = sc.nextLine();
			tryNum++;
		}
		
		//스택에 담겨져있는 결과값을 result에 모두 pop
		String result = "";
		for(int i=0; i<tryNum; i++) {
			result = result + queue.poll();
		}
	
		try {
            // 1. 파일 객체 생성
			File file = new File("modul2.pl");
			
            // 2. 파일 존재여부 체크 및 생성
            if (!file.exists()) {
                file.createNewFile();
            }else {
            	//파일 존재시 삭제후 새로 만듦
            	file.delete();
            	file.createNewFile();
            }
 
            // 3. Buffer를 사용해서 File에 write할 수 있는 BufferedWriter 생성
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
 
            // 4. 파일에 쓰기
            writer.write(result);

            // 5. BufferedWriter close
            writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}