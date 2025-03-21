package com.expluto.quizapp.dao;

import com.expluto.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository <Question,Integer> {

    List<Question> findByCategory(String category);

}
