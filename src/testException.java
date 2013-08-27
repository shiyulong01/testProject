
public class testException {
	public static void main(String[] args){
		for(int i=0;i<=10;i++){
			
			try{
				double d=25/i;
				System.out.println("haha i am here");
				System.out.println(d);
			}catch(Exception e){
				System.out.println("第"+(i+1)+"次循环出现异常： "+e.getMessage());
			}
		}
	}

}
