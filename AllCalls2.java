import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace public class AllCalls2 {
    @OnMethod(clazz="java.io.PrintStream", method="println",
              location=@Location(value=Kind.CALL, clazz="/.*/", method="/.*/"))
    public static void m(@ProbeMethodName(fqn=true) String probeMethod,
			@TargetMethodOrField String method, 
			String text) { // all calls to the methods with signature "(String)"
        println(Strings.strcat("Context: ", probeMethod));
        println(Strings.strcat("Method: ", method));
        println(Strings.strcat("Args: ", text));
    }
} 
