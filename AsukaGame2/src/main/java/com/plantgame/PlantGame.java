package com.plantgame;

import com.frame.GameFrame;
import com.frame.ImageUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class PlantGame extends GameFrame {
	private Plant plant;
	private Obstacles obs;
	final private BufferedImage bg;
	private boolean enter;
	private Date begTime;
	private int playTime;
	private boolean again;
	
	public PlantGame() throws IOException {
		this.plant = new Plant();
		this.obs = new Obstacles("images\\障碍物.png");
		this.bg = ImageUtil.creatImage("images\\background.jpg");
		this.width = PGConstants.WIDTH;
		this.height = PGConstants.HEIGHT;
		this.title = PGConstants.TITLE;
	}

	@Override
	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		addMouseMotionListener(new MouseMonitor());
	}
	
	private static void printInfo(Graphics g, String mes, String font, int x, int y, int pixelSize) {
		Color c = g.getColor();
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font(font, Font.BOLD, pixelSize));
		g.drawString(mes, x, y);
		g.setColor(c);
	}

	@Override
	public void paint(Graphics g) {
		try {
			g.drawImage(bg, 0, 0, null);
			if(!enter) {
				printInfo( g, " 明日香的躲避球大冒险", "宋体",
							PGConstants.WIDTH_MID * 3 / 7, PGConstants.HEIGHT_DOWN * 9 / 20, 60);
				printInfo( g, "  按Enter开始", "宋体",
							(int)(PGConstants.WIDTH_MID * 6.8 / 10), PGConstants.HEIGHT * 3 / 5, 40);
				printInfo( g, "请先移动鼠标到合适位置", "宋体",
							PGConstants.LEFT_RIGHT_BOTTOM * 2, PGConstants.HEIGHT_DOWN - PGConstants.LEFT_RIGHT_BOTTOM, 20);
			}
			else if(plant.getAlive())
			{
				plant.paint(g);
				obs.draw(g);
				for(int i = 0; i < PGConstants.OBS_NUM; ++i) {
					boolean col = plant.getRect().intersects(obs.getRect(i));
					if(col) {
						plant.setAlive(false);
						playTime = (int)(new Date().getTime() - begTime.getTime()) / 1000;
						break;
					}
				}
				playTime = (int)(new Date().getTime() - begTime.getTime()) / 1000;
				printInfo( g, "Time:" + playTime + "s", "Candara",
							PGConstants.WIDTH - 130, PGConstants.LEFT_RIGHT_BOTTOM * 8, 30);
			}
			else {
				printInfo( g, "GAME OVER", "Berlin Sans FB Demi",
							(int)(PGConstants.WIDTH_MID * 0.525), PGConstants.HEIGHT / 2, 100);
				printInfo( g, "你坚持了" + playTime + "秒，真是太久了！", "宋体",
						(int)(PGConstants.WIDTH_MID * 0.6), PGConstants.HEIGHT / 2 + 100, 40);
				printInfo( g, "按B重新开始,移动鼠标找好出生点位哦", "宋体",
							PGConstants.LEFT_RIGHT_BOTTOM * 2, PGConstants.HEIGHT_DOWN - PGConstants.LEFT_RIGHT_BOTTOM, 20);
				if(again) {
					again = false;
					this.plant = new Plant();
					this.obs = new Obstacles("images\\障碍物.png");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				enter = true;
				begTime = new Date();
			}
			if(e.getKeyCode() == KeyEvent.VK_B) {
				again = true;
				begTime = new Date();
			}
		}
	}

	 class MouseMonitor extends MouseAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			plant.mouseMoved(e);
		}
	}
}
