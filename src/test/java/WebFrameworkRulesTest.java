import com.javacodegeeks.drools.LibrariesRepository;
import com.javacodegeeks.drools.frameworks.Framework;
import com.javacodegeeks.drools.tasks.WebFrameworkTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * Created by Ruslan on 12/3/2016.
 */
public class WebFrameworkRulesTest {

    List<Framework> webFrameworkList;
    WebFrameworkTask webFrameworkTask;
    KieSession kSession;

    @Before
    public void init(){
        loadRuleEngine();
        webFrameworkList = LibrariesRepository.getInstance().getWebFrameworks();
        webFrameworkTask = new WebFrameworkTask();
    }

    @Test
    public void webFrameworkTaskTest(){
        kSession.setGlobal("webFrameworkList",webFrameworkList);
        kSession.insert(webFrameworkTask);
        kSession.fireAllRules();
        Assert.assertEquals("Grails", webFrameworkTask.getFramework().getName());
    }

    public void loadRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
