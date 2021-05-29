package com.drivease.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drivease.dao.FeedbackDao;
import com.drivease.model.Feedback;
import com.drivease.service.FeedbackService;

@Service("feedbackservice")
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDao feedbackdao;

	public List<Feedback> getAll() {
		// TODO Auto-generated method stub
		return feedbackdao.getAll();
	}

	public boolean deleteFeedback(long id) {
		// TODO Auto-generated method stub
		return feedbackdao.deleteFeedback(id);
	}

	public Feedback getFeedback(long id) {
		// TODO Auto-generated method stub
		return feedbackdao.getById(id);
	}

	public int sendReply(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackdao.sendReply(feedback);
	}
	
	
}
