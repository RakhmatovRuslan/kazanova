import com.javacodegeeks.drools.LibrariesRepository;
import com.javacodegeeks.drools.frameworks.Framework;
import com.javacodegeeks.drools.tasks.Task;
import com.javacodegeeks.drools.tasks.WebFrameworkTask;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by RUSLAN on 11.12.2016.
 */
public class TaskCorrelationTaskTest {

    KieSession kSession;
    WebFrameworkTask webFrameworkTask;
    List<Framework> webFrameworkList;

    @Before
    public void init(){
        loadRuleEngine();
        webFrameworkTask = new WebFrameworkTask();
        webFrameworkTask.setFindCorrelation(true);
        webFrameworkList = LibrariesRepository.getInstance().getWebFrameworks();
    }

    @Test
    public void test(){
        kSession.setGlobal("webFrameworkList", webFrameworkList);
        List<Task> correlatedTasks = new ArrayList<>();
        kSession.setGlobal("correlatedTasks",correlatedTasks);
        kSession.insert(webFrameworkTask);
        kSession.fireAllRules();
        System.out.println(correlatedTasks);
    }

    public void loadRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
