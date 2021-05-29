package com.drivease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.drivease.model.Feedback;

import com.drivease.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackService feedbackservice;
	
	@RequestMapping("/feedbackList")
	public ModelAndView getAllFeedbacks()
	{
		List<Feedback> list = feedbackservice.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("feedbacklist");
		model.addObject("list",list);
		return model;
	}
	@RequestMapping("/deleteFeedback/{id}")
	public String deleteFeedback(@PathVariable long id) {
		boolean result=feedbackservice.deleteFeedback(id);
		return "redirect:/feedback/feedbackList";
	}
	@RequestMapping("/replyFeedback/{id}")
	public String replyFeedback(@PathVariable long id,ModelMap model ) {
		Feedback feedback=feedbackservice.getFeedback(id);
		model.addAttribute("feedback", feedback);
		return "feedbackreply";
	}
	@RequestMapping("/sendReply")
	public String sendReply(@ModelAttribute("feedback") Feedback feedback)
	{
		
		int result1=feedbackservice.sendReply(feedback);
		return "redirect:/feedback/feedbackList";
	}
	

}
