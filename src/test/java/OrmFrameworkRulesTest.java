import com.javacodegeeks.drools.LibrariesRepository;
import org.junit.Test;

/**
 * Created by Ruslan on 12/13/2016.
 */
public class OrmFrameworkRulesTest {
    @Test
    public void test(){
        LibrariesRepository.getInstance().getOrmFrameworksFromFile();
    }
}
