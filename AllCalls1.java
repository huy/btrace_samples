import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace public class AllCalls1 {
    @OnMethod(clazz="java.io.PrintStream", method="println",
              location=@Location(value=Kind.CALL, clazz="/.*/", method="/.*/"))
    public static void m(@Self Object self, 
        @TargetInstance Object instance,
	@TargetMethodOrField(fqn=true) String method, 
	@ProbeMethodName(fqn=true) String probeMethod) { 
        println(Strings.strcat("call ", 
        	Strings.strcat(method, 
		Strings.strcat(" in ",probeMethod))));
    }
}
