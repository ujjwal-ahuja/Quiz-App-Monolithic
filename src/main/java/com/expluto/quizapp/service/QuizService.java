package com.expluto.quizapp.service;

import com.expluto.quizapp.dao.QuizDao;
import com.expluto.quizapp.model.Question;
import com.expluto.quizapp.model.QuestionWrapper;
import com.expluto.quizapp.model.Quiz;
import com.expluto.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = quizDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);




    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions(); //since we are using optional we first have to get "get" objet then "getQuestions"
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFromDB )
        {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        Optional<Quiz> quiz =quizDao.findById(id);//when we put .get we dont have to put optional
        List<Question> questions = quiz.get().getQuestions();

        int right = 0; //To count number of right answers.
        int i=0; //to iterate through questions in quiz

        for (Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
