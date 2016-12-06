import com.javacodegeeks.drools.Questionnaire;
import com.javacodegeeks.drools.enums.TaskType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Ruslan on 12/7/2016.
 */
public class QuestionnaireTest {

    Questionnaire questionnaire;

    @Before
    public void init(){
        questionnaire = new Questionnaire(TaskType.JSON_PARSER);
    }

    @Test
    public void testQuestioner(){
        System.out.println(questionnaire);
        questionnaire.getQuestions().forEach(question -> {
            System.out.println(Arrays.asList(question.getAnswer()));
        });
        Assert.assertEquals("featurePriority", questionnaire.getTaskProperties().get(0));
    }
}
