import model.Resume;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainReflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Resume r1 = new Resume("uuid1");

        Method myMet = r1.getClass().getMethod("toString");
        System.out.println(myMet.invoke(r1));

    }
}
