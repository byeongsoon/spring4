package survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView form(Model model) {
    ModelAndView mav = new ModelAndView();
    List<Question> questions = createQuestions();
    mav.addObject("questions", questions);
    mav.setViewName("survey/surveyForm");
    return mav;
//    model.addAttribute("questions", questions);
//    return "survey/surveyForm";
  }

  private List<Question> createQuestions() {
    Question q1 = new Question("당신의 역할은 무엇입니까", Arrays.asList("서버","프론트","풀스택"));
    Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?", Arrays.asList("이클립스", "인텔리J", "서브라임"));
    Question q3 = new Question("하고싶은 말을 적어주세요.");

    return Arrays.asList(q1, q2, q3);
  }


  @RequestMapping(method = RequestMethod.POST)
  public String submit(@ModelAttribute("ansData") AnsweredData data) {
    return "survey/submitted";
  }

}
