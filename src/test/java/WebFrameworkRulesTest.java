import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by Ruslan on 12/3/2016.
 */
public class WebFrameworkRulesTest {

    KieSession kSession;

    @Before
    public void init(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }

    @Test
    public void webFrameworkTaskTest(){

    }
}
