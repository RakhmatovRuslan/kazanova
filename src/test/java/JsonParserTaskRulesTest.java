import com.javacodegeeks.drools.*;
import com.javacodegeeks.drools.Libraries.Library;
import com.javacodegeeks.drools.Tasks.JsonParserTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class JsonParserTaskRulesTest {

    List<Library> jsonParserLibraries;

    JsonParserTask jsonParserTask2;
    KieSession kSession;

    @Test
    public void rulesTest (){
        System.out.println("************* Fire Rules **************");
        kSession.setGlobal("jsonParserLibraries", jsonParserLibraries);
        jsonParserTask2.askForConditions();
        kSession.insert(jsonParserTask2);
        kSession.fireAllRules();

        Assert.assertEquals(jsonParserTask2.getLibrary(),"google-gson");

        System.out.println("************************************");
        System.out.println("JsonParserTask solution \n" + jsonParserTask2);
    }

    @Before
    public void initData(){
        loadKnowledgeBase();
        jsonParserLibraries = LibrariesRepository.getInstance().getJsonParserLibraries();
        jsonParserTask2 = new JsonParserTask("JSON parser");
    }
    private void loadKnowledgeBase(){
        // load up the knowledge base
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    }
}
