package com.thaidev.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thaidev.model.NewsModel;
import com.thaidev.service.INewsService;
import com.thaidev.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet{
	
	@Inject
	private INewsService newsService;
	
	private static final long serialVersionUID = 1898933662224679336L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class); // JSON to model
		newsModel = newsService.save(newsModel);
		mapper.writeValue(resp.getOutputStream(), newsModel);
	}
	
	
	
	  @Override protected void doPut(HttpServletRequest req, HttpServletResponse
	  resp) throws ServletException, IOException {
		  ObjectMapper mapper = new ObjectMapper();
		  req.setCharacterEncoding("UTF-8");
		  resp.setContentType("application/json");
		  NewsModel updateNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class); // JSON to model
		  updateNews = newsService.update(updateNews);
		  mapper.writeValue(resp.getOutputStream(), updateNews);
	  }
	  
		
	  @Override protected void doDelete(HttpServletRequest req, HttpServletResponse
	  resp) throws ServletException, IOException {
		  ObjectMapper mapper = new ObjectMapper();
		  req.setCharacterEncoding("UTF-8");
		  resp.setContentType("application/json");
		  NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class); // JSON to model
		  newsService.delete(newsModel.getIds());
		  mapper.writeValue(resp.getOutputStream(), "{}");
	  }
		 
	 
	 
}
