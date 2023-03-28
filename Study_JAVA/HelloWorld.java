public class HelloWorld{
	public static void main(String[] args) {
		System.out.println("hello world!!\n");
		
		String[][] mem = {};
		
		for (int i = 0; i < mem.length; i++) {
		    for (int j = 0; j < mem[i].length; j++) {
		        if (mem[i][j] == null) {
		            System.out.println("빈 곳: " + i + ", " + j);
		        }else {
		        	System.out.println(mem[i][j]);
		        }
		    }
		}
	}
}