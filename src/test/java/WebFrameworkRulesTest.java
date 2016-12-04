import com.javacodegeeks.drools.LibrariesRepository;
import com.javacodegeeks.drools.enums.Features;
import com.javacodegeeks.drools.enums.WebApplicationType;
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
    WebFrameworkTask webFrameworkTask2;
    KieSession kSession;

    @Before
    public void init(){
        loadRuleEngine();
        webFrameworkList = LibrariesRepository.getInstance().getWebFrameworks();
        webFrameworkTask = new WebFrameworkTask();
        webFrameworkTask2 = new WebFrameworkTask();
        webFrameworkTask2.setFeaturePriority(Features.EASE_OF_USE);
        webFrameworkTask2.setWebApplicationType(WebApplicationType.COMPONENT_BASED);
    }

    @Test
    public void webFrameworkTaskTest(){
        kSession.setGlobal("webFrameworkList", webFrameworkList);
        kSession.insert(webFrameworkTask);
        kSession.insert(webFrameworkTask2);
        kSession.fireAllRules();
        Assert.assertEquals("Grails", webFrameworkTask.getFramework().getName());
        Assert.assertEquals("JSF",webFrameworkTask2.getFramework().getName());
    }

    public void loadRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
