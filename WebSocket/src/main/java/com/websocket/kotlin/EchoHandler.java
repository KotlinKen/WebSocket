package com.websocket.kotlin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		sessionList.add(session);
		logger.info("{} 연결됨", session.getId());
		super.afterConnectionEstablished(session);
	}
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		super.handleMessage(session, message);
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(session.getId()+ " : " + message.getPayload()));
		}
		
		super.handleTextMessage(session, message);
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		sessionList.remove(session);
		logger.info("{} 연결 끊김", session.getId());
		
		super.afterConnectionClosed(session, status);
	}

}
