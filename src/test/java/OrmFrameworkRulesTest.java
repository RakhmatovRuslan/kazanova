import com.javacodegeeks.drools.LibrariesRepository;
import com.javacodegeeks.drools.ProblemAnalyzer;
import com.javacodegeeks.drools.enums.Features;
import com.javacodegeeks.drools.frameworks.Framework;
import com.javacodegeeks.drools.frameworks.OrmFramework;
import com.javacodegeeks.drools.tasks.OrmFrameworkTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * Created by Ruslan on 12/13/2016.
 */
public class OrmFrameworkRulesTest {
    KieSession kSession;
    List<Framework> ormFrameworks;
    OrmFramework ormFramework;
    OrmFrameworkTask ormFrameworkTask;
    String problem = null;
    @Before
    public void init(){
        loadRuleEngine();
        ormFrameworks = LibrariesRepository.getInstance().getOrmFrameworks();
        problem = "orm framework java";
    }

    @Test
    public void test(){
        kSession.setGlobal("ormFrameworks",ormFrameworks);
        ProblemAnalyzer problemAnalyzer = new ProblemAnalyzer();
        ormFrameworkTask = (OrmFrameworkTask) problemAnalyzer.analyzerProblemDefinition(problem);
        ormFrameworkTask.setFeaturePriority(Features.POPULARITY);
        kSession.insert(ormFrameworkTask);
        kSession.fireAllRules();
        Assert.assertEquals("Hibernate",ormFrameworkTask.getFramework().getName());
        System.out.println(ormFrameworkTask.getFramework());
    }

    public void loadRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
