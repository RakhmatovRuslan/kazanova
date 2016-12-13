import com.javacodegeeks.drools.ProblemAnalyzer;
import com.javacodegeeks.drools.tasks.ApplicationServerTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by Ruslan on 12/14/2016.
 */
public class ApplicationServerRulesTest {
    KieSession kSession;
    ApplicationServerTask serverTask;
    String problem = null;
    ProblemAnalyzer problemAnalyzer;
    @Before
    public void init(){
        loadRuleEngine();
        problem = "application server java ";
        problemAnalyzer = new ProblemAnalyzer();
    }

    @Test
    public void test(){
        serverTask = (ApplicationServerTask) problemAnalyzer.analyzerProblemDefinition(problem);
        kSession.insert(serverTask);
        kSession.fireAllRules();
        Assert.assertEquals("Tomcat", serverTask.getFramework().getName());
        System.out.println(serverTask.getFramework().getName());
        System.out.println("Reasoning: "+ serverTask.getReason());
    }

    public void loadRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
