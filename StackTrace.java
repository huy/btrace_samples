import com.sun.btrace.annotations.*;
import com.sun.btrace.AnyType;
import static com.sun.btrace.BTraceUtils.*;
 
@BTrace public class StackTrace {
    @OnMethod(
	clazz="java.io.PrintStream", method="/.*/"
    )
    public static void method(@ProbeMethodName(fqn=true) String probeMethod,
        AnyType[] arg) {
        println(strcat("entered ", probeMethod));
        println("\twith argument:");
	printArray(arg);
        println("\tstacktrace");
        jstack();
        println("----");
    }
}
