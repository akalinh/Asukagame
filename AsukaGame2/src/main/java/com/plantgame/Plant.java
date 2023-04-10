package com.plantgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class Plant extends JPanel implements MouseMotionListener {
	private boolean alive = true;
	ImageIcon role = new ImageIcon("images\\text.png");
	int roleX=0;//定义图片一开始出现在视图中的X坐标
	int roleY=0;//定义图片一开始出现在视图中的Y坐标
	int newroleX = roleX;//移动后新鼠标在视图中的X坐标位置（在下方的paint方法里将鼠标置于图片中央）
	int newroleY = roleY;
	int roleWidth =50;//定义图片的宽
	int roleHeight = 50;//定义图片的高

	public Plant() throws IOException {
	}

	public boolean getAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public Rectangle getRect() {
		return new Rectangle(roleX, roleY, roleWidth, roleHeight);
	}

//
	public void paint(Graphics g) {             //画图
		super.paint(g);
		g.drawImage(role.getImage(),roleX,roleY,roleWidth,roleHeight,null);
	}


	public void mouseDragged(MouseEvent e) {        //鼠标点击监听器

//		newroleX = e.getX()-roleWidth/2;               //判断图片移动范围，将鼠标置于图片中央
//		newroleY = e.getY()-roleHeight/2;
//
//		//System.out.println("移动触发"+e.getX()+","+e.getY()+","+newroleX+","+newroleY);
//		//1500和900为视图的高和宽
//		if((newroleX+roleWidth>1500)&&(newroleY+roleHeight>900))     //判断右下角
//		{/*X,Y值不做改变*/}
//
//		else if((newroleX<0)&&(newroleY<0))                            //判断左上角
//		{/*X,Y值不做改变*/}
//
//		else if((newroleX+roleWidth>1500)&&(newroleY<0))             //判断右上角
//		{/*X,Y值不做改变*/}
//
//		else if((newroleY+roleHeight>900)&&(newroleX<0))             //判断左下角
//		{/*X,Y值不做改变*/}
//
//		else if((newroleX+roleWidth>1500)           //判断左边缘和右边缘
//				||
//				(newroleX<0)) {
//			roleY = newroleY;
//			repaint(roleX,roleY,roleWidth,roleHeight);
//		}
//
//		else if((newroleY+roleHeight>900)       //判断上边缘和下边缘
//				||
//				(newroleY<0)){
//			roleX = newroleX;
//			repaint(roleX,roleY,roleWidth,roleHeight);
//		}
//		else {                                     //未超范围值不变
//			roleX = newroleX;
//			roleY = newroleY;
//			repaint(roleX,roleY,roleWidth,roleHeight);
//		}
	}
	public void mouseMoved(MouseEvent e) {        //鼠标移动监听器
		//以下判断同上
		newroleX = e.getX()-roleWidth/2;
		newroleY = e.getY()-roleHeight/2;

		//System.out.println("移动触发"+e.getX()+","+e.getY()+","+newroleX+","+newroleY);

		if((newroleX+roleWidth>1500)&&(newroleY+roleHeight>900))
		{/*X,Y值不做改变*/}

		else if((newroleX<0)&&(newroleY<0))
		{/*X,Y值不做改变*/}

		else if((newroleX+roleWidth>1500)&&(newroleY<0))
		{/*X,Y值不做改变*/}

		else if((newroleY+roleHeight>900)&&(newroleX<0))
		{/*X,Y值不做改变*/}

		else if((newroleX+roleWidth>1500)
				||
				(newroleX<0)) {
			roleY = newroleY;
			repaint(roleX,roleY,roleWidth,roleHeight);
		}

		else if((newroleY+roleHeight>900)
				||
				(newroleY<0)){
			roleX = newroleX;
			repaint(roleX,roleY,roleWidth,roleHeight);
		}
		else {
			roleX = newroleX;
			roleY = newroleY;
			repaint(roleX,roleY,roleWidth,roleHeight);
		}
	}
}


