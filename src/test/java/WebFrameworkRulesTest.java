import com.javacodegeeks.drools.LibrariesRepository;
import com.javacodegeeks.drools.ProblemAnalyzer;
import com.javacodegeeks.drools.enums.Features;
import com.javacodegeeks.drools.enums.WebApplicationType;
import com.javacodegeeks.drools.frameworks.Framework;
import com.javacodegeeks.drools.tasks.Task;
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
        String problem = "I need a good web-framework";
        Task task = new ProblemAnalyzer().analyzerProblemDefinition(problem);
        WebFrameworkTask frameworkTask = (WebFrameworkTask) task;
        frameworkTask.setFeaturePriority(Features.COMPLEXITY);
        frameworkTask.setWebApplicationType(WebApplicationType.RIA_BASED);
        kSession.insert(frameworkTask);
        kSession.insert(webFrameworkTask);
        kSession.insert(webFrameworkTask2);
        kSession.fireAllRules();

        // Problem Analyzer Test
        Assert.assertEquals("Vaadin",frameworkTask.getFramework().getName());
        // without feature selection and web application type
        Assert.assertEquals("Grails", webFrameworkTask.getFramework().getName());
        // with feature selection and web application type
        Assert.assertEquals("JSF",webFrameworkTask2.getFramework().getName());
    }

    public void loadRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
