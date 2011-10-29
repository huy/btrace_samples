public class Hello {

	public static void main(String argv[]){
		System.out.println("Hello World");

		//before this point, the program is executed by original code
		//sleep here, so btrace can attach to the process at this point
		if (argv.length > 0)
			sleep(Integer.parseInt(argv[0])); 
		// assuming that btrace has attached and instrumented desired classes here then 
                // the following line will be executed by code being instrumented
		System.out.println("Hello Moon"); 
	}

	public static void sleep(int secs){
		try {
			Thread.sleep(secs*1000);
		}
		catch(InterruptedException ex){
		}
	}
}
