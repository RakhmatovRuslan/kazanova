import com.aliasi.test.unit.Asserts;
import com.javacodegeeks.drools.LibrariesRepository;
import com.javacodegeeks.drools.enums.Features;
import com.javacodegeeks.drools.libraries.Framework;
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
    WebFrameworkTask webFrameworkTask;
    KieSession kSession;
    List<Framework> webFrameworkList;

    @Before
    public void init(){
        webFrameworkTask = new WebFrameworkTask();
        webFrameworkTask.setFeaturePriority(Features.NONE);
        webFrameworkList = LibrariesRepository.getInstance().getWebFrameworks();
        loadRuleEngine();

    }

    @Test
    public void webFrameworkTaskTest(){
        kSession.setGlobal("webFrameworkList",webFrameworkList);
        kSession.insert(webFrameworkTask);
        kSession.fireAllRules();
        Assert.assertEquals("Grails",webFrameworkTask.getFramework().getName());
    }

    public void loadRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
