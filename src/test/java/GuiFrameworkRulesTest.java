import com.javacodegeeks.drools.ProblemAnalyzer;
import com.javacodegeeks.drools.tasks.GuiFrameworkTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by Ruslan on 12/13/2016.
 */
public class GuiFrameworkRulesTest {
    KieSession kSession;
    GuiFrameworkTask guiFrameworkTask;
    String problem = null;
    ProblemAnalyzer problemAnalyzer;
    @Before
    public void init(){
        loadRuleEngine();
        problem = "gui java framework";
        problemAnalyzer = new ProblemAnalyzer();
    }
    @Test
    public void test(){
        guiFrameworkTask = (GuiFrameworkTask) problemAnalyzer.analyzerProblemDefinition(problem);
        kSession.insert(guiFrameworkTask);
        kSession.fireAllRules();
        Assert.assertEquals("JavaFx",guiFrameworkTask.getFramework().getName());
        System.out.println(guiFrameworkTask.getFramework().getName());
        System.out.println("Reasoning: "+guiFrameworkTask.getReason());
    }
    public void loadRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
