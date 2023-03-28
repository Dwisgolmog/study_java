public class test{
	public static void main(String[] args) {
		System.out.println("hello world!!\n");
		
		String[][] mem = new String[5][5];
		
		for (int i = 0; i < mem.length; i++) {
		    for (int j = 0; j < mem[i].length; j++) {
		    	if(mem[i][j] == null) {
		    		System.out.println("null!!\n");
		    	}else {
		    		System.out.println("not null\n");
		    	}
		    }
		}
		
		
	}
}