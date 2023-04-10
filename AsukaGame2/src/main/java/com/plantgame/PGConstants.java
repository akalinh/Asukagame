package com.plantgame;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PGConstants {
	static int[] obs_setting = new int[2];

	static{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document d = builder.parse("Ball.xml");
			// 每一个标签都作为一个节点
			NodeList nodeList = d.getElementsByTagName("test");
			Node rootNode = nodeList.item(0);
			NodeList childNodes = rootNode.getChildNodes();

			for (int i = 0; i < childNodes.getLength(); i++) {
				Node child = childNodes.item(i);
				if (child.getNodeType() == Node.ELEMENT_NODE) {  //过滤换行符之类的内容，因为它们都被认为是一个文本节点
					if(child.getNodeName().equals("ballnumber")) {
						obs_setting[0] = Integer.parseInt(child.getFirstChild().getNodeValue());
					}
					else if(child.getNodeName().equals("ballspeed")){
						obs_setting[1] = Integer.parseInt(child.getFirstChild().getNodeValue());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static int OBS_NUM = obs_setting[0];
	public static final int OBS_SPEED = obs_setting[1];
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	public static final String TITLE = "Asuka";
	public static final int TOP = 38;
	public static final int LEFT_RIGHT_BOTTOM = 9;
	public static final int WIDTH_MID = PGConstants.WIDTH / 2;
	public static final int HEIGHT_DOWN = PGConstants.HEIGHT - PGConstants.LEFT_RIGHT_BOTTOM;
	public static final int X_RANGE = PGConstants.WIDTH - 2 * PGConstants.LEFT_RIGHT_BOTTOM - 1;
	public static final int Y_RANGE = PGConstants.HEIGHT - PGConstants.LEFT_RIGHT_BOTTOM - PGConstants.TOP - 1;

}
