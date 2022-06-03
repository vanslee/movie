import com.ldx.utils.MD5Utils;
import org.junit.jupiter.api.Test;

public class MD5 {
    @Test
    public void test01() {
        System.out.println(MD5Utils.encrypByMd5("123456"));
    }
}
