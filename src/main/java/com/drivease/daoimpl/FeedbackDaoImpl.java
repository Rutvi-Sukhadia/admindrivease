package com.drivease.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drivease.dao.FeedbackDao;
import com.drivease.model.Feedback;
import com.drivease.util.Mailer;

@Repository("feedbackDao")
public class FeedbackDaoImpl extends GenericDaoImpl<Feedback> implements FeedbackDao{

	public List<Feedback> getAll() {
		// TODO Auto-generated method stub
		return super.getByQuery("FROM Feedback f WHERE f.isDeleted=0");
	}

	public boolean deleteFeedback(long id) {
		Feedback obj = super.getById(Feedback.class,id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getFeedbackId()>0;
	}

	public Feedback getById(long id) {
		// TODO Auto-generated method stub
		return super.getById(Feedback.class, id);
	}

	public int sendReply(Feedback feedback) {
		
		String reply = feedback.getReplymsg();
		Mailer.send("drivease2419@gmail.com", "drivEase@1924", feedback.getEmailId(), "Reply to your feedback "," Dear " +feedback.getName() + "\n"+ reply);
		
		return 0;
	}

}
