package shixunxiangmu;
import java.util.Calendar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import java.util.GregorianCalendar;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
public class level2_shuang extends level
{

	public level2_shuang(main_work main)
	{
		//关卡末尾暂停
				Image shengli = new Image("image/tongguan.png");
				ImageView shengliv = new ImageView(shengli);
				shengliv.setTranslateX(315);
				shengliv.setTranslateY(315);
				Image fanhuibt = new Image("image/return.png");
				ImageView fanhuibtv = new ImageView(fanhuibt);
				fanhuibtv.setTranslateX(582);
				fanhuibtv.setTranslateY(465);
				
				fanhuibtv.setOnMouseClicked(e ->{//取消点击
					main.mainStage.show();
					this.close();
				});
				
		//设置关卡背景
		imagebj = new Image("image/guan2_bj.png");
		imagevbj = new ImageView(imagebj);
		imagevbj.setTranslateX(0);
		imagevbj.setTranslateY(0);
		
		//设置远程攻击人物
		p1 = new yuancheng(this,500,2000);
		p1.set_zuobiao(0, 400);
		
		//设置近程人物
		p2 = new jincheng(this,500,2000);
		p2.set_zuobiao(0,400);
		
		begin = end = 0;
		for(int i = 0;i < 8;++i)
			chuguai[i] = 0;
		
		//设置boss
		mainpane = new Pane();
				boss2 = new boss_2();
				boss2.setTranslateX(-1000);
				boss2.setTranslateY(-1000);
				xinzang = new xin();
				xinzang.set_zuobiao(-200, -200);
				

		//设置障碍物
		zhang[0] = new zhangai("image/guan2_earth.png");
		zhang[1] = new zhangai("image/tai-1-new.png");
		zhang[2] = new zhangai("image/tai-2-new.png");
		zhang[3] = new zhangai("image/tai-4-new.png");
		zhang[4] = new zhangai("image/tai-3-new.png");
		zhang[5] = new zhangai("image/tai-1-new.png");
		zhang[6] = new zhangai("image/tai-1-new.png");
		zhang[7] = new zhangai("image/tai-1-new.png");
		zhang[8] = new zhangai("image/tai-4-new.png");
		zhang[9] = new zhangai("image/tai-2-new.png");
		zhang[10] = new zhangai("image/tai-2-new.png");
		zhang[11] = new zhangai("image/tai-1-new.png");
		zhang[12] = new zhangai("image/tai-1-new.png");
		zhang[13] = new zhangai("image/tai-1-new.png");
		zhang[14] = new zhangai("image/tai-2-new.png");
		zhang[15] = new zhangai("image/tai-3-new.png");
		zhang[16] = new zhangai("image/tai-2-new.png");
		zhang[17] = new zhangai("image/tai-1-new.png");

		zhang[0].set_zuobiao(0, 630);
		zhang[1].set_zuobiao(150, 400);
		zhang[2].set_zuobiao(340, 170);
		zhang[3].set_zuobiao(600, 400);
		zhang[4].set_zuobiao(1100, 170);
		zhang[5].set_zuobiao(2100, 170);
		zhang[6].set_zuobiao(2800, 170);
		zhang[7].set_zuobiao(1900, 400);		
		zhang[8].set_zuobiao(2400, 400);
		zhang[9].set_zuobiao(3600,170);
		zhang[10].set_zuobiao(3900, 400);
		zhang[11].set_zuobiao(5000, 400);
		zhang[12].set_zuobiao(6000, 400);
		zhang[13].set_zuobiao(4800, 170);
		zhang[14].set_zuobiao(7000, 400);
		zhang[15].set_zuobiao(5500, 170);
		zhang[16].set_zuobiao(6200, 170);
		zhang[17].set_zuobiao(7200, 170);
		
	
		mainpane.getChildren().add(imagevbj);
		mainpane.getChildren().add(boss2);
		mainpane.getChildren().add(xinzang);
		mainpane.getChildren().add(p1);
		mainpane.getChildren().add(p2);
		for(int i = 0;i < zhang.length;++i)
			mainpane.getChildren().add(zhang[i]);
		for(int i = 0;i < 8;++i)
			gong[i] = false;

		Image iyou = new Image("image/boss2_you.png");
		Image izuo = new Image("image/boss2_zuo.png");
		Image ib = new Image("image/boss2.png");
		Image xin1 = new Image("image/heart.png");
		Image xin2 = new Image("image/heart_2.png");
		Image gongbb = new Image("image/qiu.png");
		//添加状态栏
				Image imagecondition = new Image("image/condition.png");
				ImageView imagevcondition = new ImageView(imagecondition);
				imagevcondition.setTranslateX(0);
				imagevcondition.setTranslateY(0);
				mainpane.getChildren().add(imagevcondition);
				//添加血条
				Image imageblood = new Image("image/condition5.png");
				ImageView imagevblood = new ImageView(imageblood);
				imagevblood.setTranslateX(105);
				imagevblood.setTranslateY(35);
				mainpane.getChildren().add(imagevblood);
				//添加蓝条
				Image imagemagic = new Image("image/condition5-magic.png");
				ImageView imagevmagic = new ImageView(imagemagic);
				imagevmagic.setTranslateX(105);
				imagevmagic.setTranslateY(53);
				mainpane.getChildren().add(imagevmagic);
				//添加怒气条
				Image imagesp = new Image("image/condition0-sp.png");
				ImageView imagevsp = new ImageView(imagesp);
				imagevsp.setTranslateX(105);
				imagevsp.setTranslateY(70);
				mainpane.getChildren().add(imagevsp);
				
				
				//添加状态栏
				Image imagecondition1 = new Image("image/condition_2.png");
				ImageView imagevcondition1 = new ImageView(imagecondition1);
				imagevcondition1.setTranslateX(940);
				imagevcondition1.setTranslateY(0);
				mainpane.getChildren().add(imagevcondition1);
				//添加血条
				Image imageblood1 = new Image("image/condition5_2.png");
				ImageView imagevblood1 = new ImageView(imageblood1);
				imagevblood1.setTranslateX(980);
				imagevblood1.setTranslateY(35);
				mainpane.getChildren().add(imagevblood1);
				//添加蓝条
				Image imagemagic1 = new Image("image/condition5-magic_2.png");
				ImageView imagevmagic1 = new ImageView(imagemagic1);
				imagevmagic1.setTranslateX(980);
				imagevmagic1.setTranslateY(53);
				mainpane.getChildren().add(imagevmagic1);
				//添加怒气条
				Image imagesp1 = new Image("image/condition0-sp_2.png");
				ImageView imagevsp1 = new ImageView(imagesp1);
				imagevsp1.setTranslateX(980);
				imagevsp1.setTranslateY(70);
				mainpane.getChildren().add(imagevsp1);
				
				
				//添加技能栏
				Image imageskill = new Image("image/skill.png");
				ImageView imagevskill = new ImageView(imageskill);
				imagevskill.setTranslateX(20);
				imagevskill.setTranslateY(635);
				mainpane.getChildren().add(imagevskill);
				
				Image imageskill1 = new Image("image/condition-2.png");
				ImageView imagevskill1 = new ImageView(imageskill1);
				imagevskill1.setTranslateX(1010);
				imagevskill1.setTranslateY(630);
				mainpane.getChildren().add(imagevskill1);
				//添加技能块
				Image imageskilly = new Image("image/skill-y.png");
				Image imageskillu = new Image("image/skill-touming.png");
				Image imageskilli = new Image("image/skill-I.png");
				Image imageskillo = new Image("image/skill-O.png");
				Image imageskilll = new Image("image/skill-touming.png");
				ImageView imagevskilly = new ImageView(imageskilly);
				ImageView imagevskillu = new ImageView(imageskillu);
				ImageView imagevskilli = new ImageView(imageskilli);
				ImageView imagevskillo = new ImageView(imageskillo);
				ImageView imagevskilll = new ImageView(imageskilll);
				imagevskilly.setTranslateX(88);
				imagevskilly.setTranslateY(662);
				imagevskillu.setTranslateX(118);
				imagevskillu.setTranslateY(662);
				imagevskilli.setTranslateX(146);
				imagevskilli.setTranslateY(662);
				imagevskillo.setTranslateX(176);
				imagevskillo.setTranslateY(662);
				imagevskilll.setTranslateX(206);
				imagevskilll.setTranslateY(662);
				mainpane.getChildren().add(imagevskilly);
				mainpane.getChildren().add(imagevskillu);
				mainpane.getChildren().add(imagevskilli);
				mainpane.getChildren().add(imagevskillo);
				mainpane.getChildren().add(imagevskilll);
				
				
				
				
				
				Image imageskilly1 = new Image("image/skill-2-7-2.png");
				Image imageskillu1 = new Image("image/skill-2-4.png");
				Image imageskilli1 = new Image("image/skill-2-8-2.png");
				Image imageskillo1 = new Image("image/skill-2-9-2.png");
				Image imageskilll1 = new Image("image/skill-2-3.png");
				ImageView imagevskilly1 = new ImageView(imageskilly1);
				ImageView imagevskillu1 = new ImageView(imageskillu1);
				ImageView imagevskilli1 = new ImageView(imageskilli1);
				ImageView imagevskillo1 = new ImageView(imageskillo1);
				ImageView imagevskilll1 = new ImageView(imageskilll1);
				imagevskilly1.setTranslateX(1015);
				imagevskilly1.setTranslateY(657);
				imagevskillu1.setTranslateX(1045);
				imagevskillu1.setTranslateY(657);
				imagevskilli1.setTranslateX(1075);
				imagevskilli1.setTranslateY(657);
				imagevskillo1.setTranslateX(1105);
				imagevskillo1.setTranslateY(657);
				imagevskilll1.setTranslateX(1135);
				imagevskilll1.setTranslateY(657);
				mainpane.getChildren().add(imagevskilly1);
				mainpane.getChildren().add(imagevskillu1);
				mainpane.getChildren().add(imagevskilli1);
				mainpane.getChildren().add(imagevskillo1);
				mainpane.getChildren().add(imagevskilll1);
						
				
				//添加boss血条
				Image imagebossblood5 = new Image("image/boss-blood-5.png");
				Image imagebossblood4 = new Image("image/boss-blood-4.png");
				Image imagebossblood3 = new Image("image/boss-blood-3.png");
				Image imagebossblood2 = new Image("image/boss-blood-2.png");
				Image imagebossblood1 = new Image("image/boss-blood-1.png");
				Image imagebossblood0 = new Image("image/boss-blood-0.png");
				Image imagebossbloodtouming = new Image("image/toumingbt.png");
				ImageView imagevbossblood = new ImageView(imagebossbloodtouming);
				imagevbossblood.setTranslateX(450);
				imagevbossblood.setTranslateY(30);
				mainpane.getChildren().add(imagevbossblood);

				
				Image imagenormalleft1 = new Image("image/normal-left-1.png");
				Image imagenormalleft2 = new Image("image/normal-left-2.png");
				Image imagenormalleft3 = new Image("image/normal-left-3.png");
				
				Image imagenormalright1 = new Image("image/normal-right-1.png");
				Image imagenormalright2 = new Image("image/normal-right-2.png");
				Image imagenormalright3 = new Image("image/normal-right-3.png");
				
				Image imagemoveright1 = new Image("image/move-right-1.png");
				Image imagemoveright15 = new Image("image/move-right-1.5.png");
				Image imagemoveright2 = new Image("image/move-right-2.png");
				Image imagemoveright3 = new Image("image/move-right-3.png");
				Image imagemoveright4 = new Image("image/move-right-4.png");
				
				Image imagemoveleft1 = new Image("image/move-left-1.png");
				Image imagemoveleft15 = new Image("image/move-left-1.5.png");
				Image imagemoveleft2 = new Image("image/move-left-2.png");
				Image imagemoveleft3 = new Image("image/move-left-3.png");
				Image imagemoveleft4 = new Image("image/move-left-4.png");
				
				Image imagerushright = new Image("image/rush-right.png");
				Image imagerushrighttop = new Image("image/rush-right-top.png");
				
				Image imagerushleft = new Image("image/rush-left.png");	
				Image imagerushlefttop = new Image("image/rush-left-top.png");
				
				Image imagecileft = new Image("image/ci-left.png");
				Image imagecileft1 = new Image("image/ci-left-1.png");
				Image imagecileft2 = new Image("image/ci-left-2.png");
				
				Image imageciright = new Image("image/ci-right.png");
				Image imageciright1 = new Image("image/ci-right-1.png");
				Image imageciright2 = new Image("image/ci-right-2.png");


		
		EventHandler<ActionEvent> eventHandler = e->
		{
			//System.out.println(boss2.number + " " +boss2.number1 + " " + boss2.number2);
			//人物子弹
			//防止连发子弹,后面数字越大，子弹间隔时间越长
			//System.out.println(p2.getTranslateX());
			//System.out.println(p1.blood+" "+p1.lan);
			if(p1.cnt != 0)
				p1.cnt = (p1.cnt + 1) % 30;
			if(p1.cnt_L != 0)
				p1.cnt_L = (p1.cnt_L+1)%300;
			if(p1.cnt_U != 0)
				p1.cnt_U = (p1.cnt_U+1)%300;
			if(p1.cnt_W != 0)
				p1.cnt_W = (p1.cnt_W+1)%100;
			if(p1.cnt_S != 0)
				p1.cnt_S = (p1.cnt_S+1)%100;
			if(p1.be_attack != 0)
				p1.be_attack = (p1.be_attack+1)%30;
			if(p1.buti != 0)
				p1.buti = (p1.buti+1)%300;
			
			if(p2.cnt != 0)
				p2.cnt = (p2.cnt + 1) % 30;
			if(p2.cnt_L != 0)
				p2.cnt_L = (p2.cnt_L+1)%300;
			if(p2.cnt_U != 0)
				p2.cnt_U = (p2.cnt_U+1)%300;
			if(p2.cnt_W != 0)
				p2.cnt_W = (p2.cnt_W+1)%100;
			if(p2.cnt_S != 0)
				p2.cnt_S = (p2.cnt_S+1)%100;
			if(p2.be_attack != 0)
				p2.be_attack = (p2.be_attack+1)%30;
			if(p2.buti != 0)
				p2.buti = (p2.buti+1)%300;
			
			if(boss2 != null)
			{
				if(boss2.cnt != 0)
					boss2.cnt = (boss2.cnt+1)%300;
				if(boss2.buti != 0)
					boss2.buti = (boss2.buti+1)%300;
				if(boss2.number != 0)
					++boss2.number;
				if(boss2.number1 != 0)
					++boss2.number1;
				if(boss2.number2 != 0)
					++boss2.number2;
			}
			
			if(butbeginlast != begin)
			{
				butbeginlast = begin;
				butbeginshijian = 0;
			}
			else
				++butbeginshijian;
		//	System.out.println(butcnt + " " + butcntshijian);
			if(butbeginshijian >= 500)
			{
				++begin;
				if(begin >= but.length-1)
					begin = 0;
			}
			if(butcnt >= 4)
				++butcntshijian;
			else
				butcntshijian=0;
			if(butcntshijian >= 500)
			{
				butcnt = 0;
				butcntshijian = 0;
			}
			
			//人物道具拾取
			if(p1!=null)
			{
				for(int i = 0;i < xue.length;++i)
				{
					if(xue[i] != null)
					{
						if(zhangai.crash(p1,xue[i],0,0,3))
						{
							xue[i].set_image("image/toumin.png");
							xue[i] = null;
							p1.blood += 20;
							if (p1.blood > 500)
								p1.blood = 500;
						}
					}
				}
				for(int i = 0;i < lan.length;++i)
				{
					if(lan[i] != null)
					{
						if(zhangai.crash(p1,lan[i],0,0,3))
						{
							lan[i].set_image("image/toumin.png");
							lan[i] = null;
							p1.lan += 100;
							if (p1.lan > 2000)
								p1.lan = 2000;
						}
					}
				}
				for(int i = 0;i < gongplus.length;++i)
				{
					if(gongplus[i] != null)
					{
						if(zhangai.crash(p1,gongplus[i],0,0,3))
						{
							gongplus[i].set_image("image/toumin.png");
							gongplus[i] = null;
							p1.shanghai.set(p1.shanghai.get() + 1);
						}
					}
				}
			}
			//人物2道具拾取
			if(p2!=null)
			{
				for(int i = 0;i < xue.length;++i)
				{
					if(xue[i] != null)
					{
						if(zhangai.crash(p2,xue[i],0,0,3))
						{
							xue[i].set_image("image/toumin.png");
							xue[i] = null;
							p2.blood += 20;
							if (p2.blood > 500)
								p2.blood = 500;
						}
					}
				}
				for(int i = 0;i < lan.length;++i)
				{
					if(lan[i] != null)
					{
						if(zhangai.crash(p2,lan[i],0,0,3))
						{
							lan[i].set_image("image/toumin.png");
							lan[i] = null;
							p2.lan += 100;
							if (p2.lan > 2000)
								p2.lan = 2000;
						}
					}
				}
				for(int i = 0;i < gongplus.length;++i)
				{
					if(gongplus[i] != null)
					{
						if(zhangai.crash(p2,gongplus[i],0,0,3))
						{
							gongplus[i].set_image("image/toumin.png");
							gongplus[i] = null;
							p2.shanghai.set(p2.shanghai.get() + 1);
						}
					}
				}
			}
			//子弹移动
			for(int i = 0;i < p1.but.length;++i)
			{
				if(p1.but[i] != null)
				{
					if(p1.but[i].dir == 1)
						p1.but[i].setTranslateX(p1.but[i].getTranslateX()+5);
					else if(p1.but[i].dir == 2)
						p1.but[i].setTranslateX(p1.but[i].getTranslateX()-5);
				}
			}
			for(int i = 0;i < p1.but1.length;++i)
			{
				if(p1.but1[i] != null)
				{
					if(p1.but1[i].dir == 1)
						p1.but1[i].setTranslateX(p1.but1[i].getTranslateX()+10);
					else if(p1.but1[i].dir == 2)
						p1.but1[i].setTranslateX(p1.but1[i].getTranslateX()-10);
					else if(p1.but1[i].dir == 3)
						p1.but1[i].setTranslateY(p1.but1[i].getTranslateY()-5);
					else if(p1.but1[i].dir == 4)
						p1.but1[i].setTranslateY(p1.but1[i].getTranslateY()+5);
					else if(p1.but1[i].dir == 5)//右下
					{
						p1.but1[i].setTranslateX(p1.but1[i].getTranslateX()+8);
						p1.but1[i].setTranslateY(p1.but1[i].getTranslateY()+8);
					}
					else if(p1.but1[i].dir == 6)//左下
					{
						p1.but1[i].setTranslateX(p1.but1[i].getTranslateX()-8);
						p1.but1[i].setTranslateY(p1.but1[i].getTranslateY()+8);
					}
						
				}
			}
			
			//子弹出边界后销毁
			if(p1.but[p1.begin] != null)
				if(p1.but[p1.begin].getTranslateX() >= 1280 || p1.but[p1.begin].getTranslateX()+p1.but[p1.begin].widthProperty().doubleValue() <= 0)
				{
					p1.but[p1.begin].imagev.setImage(new Image("image/toumin.png"));
					p1.but[p1.begin] = null;
					++p1.begin;
					if(p1.begin >= p1.but.length-1)
						p1.begin = 0;
				}
			if(p1.but1[p1.begin1] != null)
				if(p1.but1[p1.begin1].getTranslateX() >= 1280 || p1.but1[p1.begin1].getTranslateX()+p1.but1[p1.begin1].widthProperty().doubleValue() <= 0 || p1.but1[p1.begin1].getTranslateY()  >= 760 || p1.but1[p1.begin1].getTranslateY()+p1.but1[p1.begin1].heightProperty().doubleValue() <= 0)
				{
					p1.but1[p1.begin1].imagev.setImage(new Image("image/toumin.png"));
					p1.but1[p1.begin1] = null;
					++p1.begin1;
					if(p1.begin1 >= p1.but1.length-1)
						p1.begin1 = 0;
				}
			//怪物子弹移动和销毁
			for(int i = 0;i < but.length;++i)
			{
				if(but[i] != null)
				{
					if(but[i].dir == 1)
						but[i].setTranslateX(but[i].getTranslateX()+2);
					else
						but[i].setTranslateX(but[i].getTranslateX()-2);
				}
			}
			
			//子弹出边界后销毁
			if(but[begin] != null)
			{
				if(but[begin].getTranslateX() >= 1280 || but[begin].getTranslateX()+but[begin].widthProperty().doubleValue()/2 <= 0)
				{
					but[begin].imagev.setImage(new Image("image/toumin.png"));
					but[begin] = null;
					//System.out.println(1);
					++begin;
					if(begin >= but.length-1)
						begin = 0;
					--butcnt;
				}
			}
			
			
					
			//新增怪物
			if(this.imagevbj.getTranslateX() > -6900)
			{
				for (int i = 0; i < 8;i++)
				{
					if (others[i] == null)
					{
						if(gong[i])
						{
							--butcnt;
							gong[i] = false;
						}
		//				System.out.println(1);
						++chuguai[i];
						if(chuguai[i] == 20)
						{
							chu[i] = new ImageView(new Image("guaiwu/chu1.png"));
							chu[i].setTranslateX(500+i*100);
							chu[i].setTranslateY(0);
							mainpane.getChildren().add(chu[i]);
						}
						else if(chuguai[i] == 40)
						{
							chu[i].setImage(new Image("guaiwu/chu2.png"));
						}
						else if(chuguai[i] == 60)
						{
							chu[i].setImage(new Image("guaiwu/chu3.png"));
						}
						else if(chuguai[i] == 80)
						{
							chu[i].setImage(new Image("guaiwu/chu4.png"));
						}
						else if(chuguai[i] == 100)
						{
							chu[i].setImage(new Image("guaiwu/chu5.png"));
						}
						else if(chuguai[i] == 120)
						{
							chu[i].setImage(new Image("guaiwu/chu4.png"));
						}
						else if(chuguai[i] == 140)
						{
							chu[i].setImage(new Image("guaiwu/chu2.png"));
						}
						else if(chuguai[i] == 160)
						{
							chu[i].setImage(new Image("image/toumin.png"));
							chu[i] = null;
							others[i] = new other_thing("guaiwu/zhanzuo_2.png",this,3,2);
							others[i].set_zuobiao(500 + i*100, 0);
							mainpane.getChildren().add(others[i]);
							chuguai[i] = 0;
						}
					}
				}		
			}
			else if(canchu)
			{
				canchu = false;
				for(int i = 0;i < 8;++i)
					if(chu[i] != null)
					{
						chu[i].setImage(new Image("image/toumin.png"));
						chu[i] = null;
					}
			}
			
			//怪物与子弹发生碰撞
			for(int i = 0;i < others.length;++i)//遍历所有怪物
			{
				if(others[i] != null)
				{
					for(int j = p1.begin;j != p1.end;j = (j+1)%p1.but.length)//遍历所有子弹
					{
						if(p1.but[j] != null && zhangai.crash(p1.but[j], others[i], 0, 0, 3))//怪物与子弹发生碰撞
						{
							others[i].blood -= p1.but[j].shanghai.intValue();//怪物扣血
							if(!others[i].gong)
							{
								if(p1.but[j].dir == 1)
								{
									others[i].set_image("guaiwu/be_attackzuo_2.png");
								}
								else
								{
									others[i].set_image("guaiwu/be_attackyou_2.png");
								}
							
								others[i].attack = 1;
							}
							
							if(others[i].blood <= 0)//血量过低后怪物销毁
							{
								int temp = (int)(Math.random() * 30);
								//System.out.println(temp);
								
								if (temp == 0 || temp == 1)
								{
									for (int m = 0; m < xue.length;m++)
									{
										if (xue[m] == null)
										{
											xue[m] = new xued("image/blood-plus.png");
											xue[m].setTranslateX(others[i].getTranslateX());
											xue[m].setTranslateY(others[i].getTranslateY());
											mainpane.getChildren().add(xue[m]);
							
											break;
										}
									}
								}
								else if (temp == 2)
								{
									//System.out.println("123456789");
									for (int m = 0; m < lan.length;m++)
									{
										if (lan[m] == null)
										{
											lan[m] = new land("image/magic-plus.png");
											lan[m].setTranslateX(others[i].getTranslateX());
											lan[m].setTranslateY(others[i].getTranslateY());
											mainpane.getChildren().add(lan[m]);
								
											break;
										}
									}
								}
								else if (temp == 3)
								{
									for (int m = 0; m < gongplus.length;m++)
									{
										if (gongplus[m] == null)
										{
											gongplus[m] = new gongd("image/gong-plus.png");
											gongplus[m].setTranslateX(others[i].getTranslateX());
											gongplus[m].setTranslateY(others[i].getTranslateY());
											mainpane.getChildren().add(gongplus[m]);
										
											break;
										}
									}
								}

								others[i].imagev.setImage(new Image("image/toumin.png"));
								if(others[i].index != -1)
								{
									but[others[i].index].imagev.setImage(new Image("image/toumin.png"));
									but[others[i].index] = null;
								}
								/*if(others[i].gong)
								{
									--butcnt;
								}*/
								others[i] = null;
							}
							++p1.but[j].cnt;//该子弹碰撞数加一
							if(p1.but[j].cnt >= 4)//一颗子弹打的人数过多后子弹销毁,2为子弹可以打的人数
							{
								p1.but[j].imagev.setImage(new Image("image/toumin.png"));
								p1.but[j] = null;
							}
						}
					}
					//怪物与技能子弹发生碰撞
					if(others[i] != null)
					{
						for(int j = p1.begin1;j != p1.end1;j = (j+1)%p1.but1.length)//遍历所有子弹
						{
							if(p1.but1[j] != null && zhangai.crash(p1.but1[j], others[i], 0, 0, 3))//怪物与子弹发生碰撞
							{
								others[i].blood -= p1.but1[j].shanghai.intValue();//怪物扣血
								if(!others[i].gong)
								{
									if(p1.but1[j].dir == 1)
									{
										others[i].set_image("guaiwu/be_attackzuo_2.png");
									}
									else
									{
										others[i].set_image("guaiwu/be_attackyou_2.png");
									}
								
									others[i].attack = 1;
								}
								
								if(others[i].blood <= 0)//血量过低后怪物销毁
								{
									int temp = (int)(Math.random() * 30);
									//System.out.println(temp);
									
									if (temp == 0 || temp == 1)
									{
										for (int m = 0; m < xue.length;m++)
										{
											if (xue[m] == null)
											{
												xue[m] = new xued("image/blood-plus.png");
												xue[m].setTranslateX(others[i].getTranslateX());
												xue[m].setTranslateY(others[i].getTranslateY());
												mainpane.getChildren().add(xue[m]);
								
												break;
											}
										}
									}
									else if (temp == 2)
									{
										//System.out.println("123456789");
										for (int m = 0; m < lan.length;m++)
										{
											if (lan[m] == null)
											{
												lan[m] = new land("image/magic-plus.png");
												lan[m].setTranslateX(others[i].getTranslateX());
												lan[m].setTranslateY(others[i].getTranslateY());
												mainpane.getChildren().add(lan[m]);
										
												break;
											}
										}
									}
									else if (temp == 3)
									{
										for (int m = 0; m < gongplus.length;m++)
										{
											if (gongplus[m] == null)
											{
												gongplus[m] = new gongd("image/gong-plus.png");
												gongplus[m].setTranslateX(others[i].getTranslateX());
												gongplus[m].setTranslateY(others[i].getTranslateY());
												mainpane.getChildren().add(gongplus[m]);
									
												break;
											}
										}
									}

									others[i].imagev.setImage(new Image("image/toumin.png"));
									if(others[i].index != -1)
									{
										but[others[i].index].imagev.setImage(new Image("image/toumin.png"));
										but[others[i].index] = null;
									}
									/*if(others[i].gong)
									{
										--butcnt;
									}*/
									others[i] = null;
								}
								++p1.but1[j].cnt;//该子弹碰撞数加一
								if(p1.but1[j].cnt >= 4)//一颗子弹打的人数过多后子弹销毁,2为子弹可以打的人数
								{
									p1.but1[j].imagev.setImage(new Image("image/toumin.png"));
									p1.but1[j] = null;
								}
							}
						}
					}
				}
			}
			
			
			
			//怪物与玩家二发生碰撞
		if(p2 != null && (p2.attack != 0 || p2.attack_L != 0 || p2.attack_U != 0))
		{
			for(int i = 0;i < others.length;++i)//遍历所有怪物
			{
				if(others[i] != null)
				{
						if(zhangai.crash(p2, others[i], 0, 0, 3) && others[i].attack == 0)//怪物与子弹发生碰撞
						{
							if(p2.attack != 0)
								others[i].blood -= p2.shanghai.intValue();//怪物扣血
							else if(p2.attack_L != 0)
								others[i].blood -= p2.shanghai.intValue()*2;//怪物扣血
							else if(p2.attack_U != 0)
								others[i].blood -= p2.shanghai.intValue()*3;//怪物扣血
							if(!others[i].gong)
							{
								if(p2.flagr == 1)
								{
									others[i].set_image("guaiwu/be_attackzuo_2.png");
								}
								else
								{
									others[i].set_image("guaiwu/be_attackyou_2.png");
								}
							
								others[i].attack = 1;
							}
							
							if(others[i].blood <= 0)//血量过低后怪物销毁
							{
								int temp = (int)(Math.random() * 30);
								//System.out.println(temp);
								
								if (temp == 0 || temp == 1)
								{
									for (int m = 0; m < xue.length;m++)
									{
										if (xue[m] == null)
										{
											xue[m] = new xued("image/blood-plus.png");
											xue[m].setTranslateX(others[i].getTranslateX());
											xue[m].setTranslateY(others[i].getTranslateY());
											mainpane.getChildren().add(xue[m]);
									
											break;
										}
									}
								}
								else if (temp == 2)
								{
									//System.out.println("123456789");
									for (int m = 0; m < lan.length;m++)
									{
										if (lan[m] == null)
										{
											lan[m] = new land("image/magic-plus.png");
											lan[m].setTranslateX(others[i].getTranslateX());
											lan[m].setTranslateY(others[i].getTranslateY());
											mainpane.getChildren().add(lan[m]);
							
											break;
										}
									}
								}
								else if (temp == 3)
								{
									for (int m = 0; m < gongplus.length;m++)
									{
										if (gongplus[m] == null)
										{
											gongplus[m] = new gongd("image/gong-plus.png");
											gongplus[m].setTranslateX(others[i].getTranslateX());
											gongplus[m].setTranslateY(others[i].getTranslateY());
											mainpane.getChildren().add(gongplus[m]);
									
											break;
										}
									}
								}

								others[i].imagev.setImage(new Image("image/toumin.png"));
								if(others[i].index != -1)
								{
									but[others[i].index].imagev.setImage(new Image("image/toumin.png"));
									but[others[i].index] = null;
								}
								/*if(others[i].gong)
								{
									--butcnt;
								}*/
								others[i] = null;
							}
						}
					}
				}
			}
			//怪物动画效果
			for(int i = 0;i < index;++i)
			{
				if(others[whoattack[i]] != null)
				{
					list[i] = list[i]+1;
					if(list[i] == 49)
					{
						if(others[whoattack[i]].flagr == 1)
							others[whoattack[i]].set_image("guaiwu/attackyou2_2.png");
						else
						{
							others[whoattack[i]].set_image("guaiwu/attackzuo2_2.png");
							others[whoattack[i]].setTranslateX(others[whoattack[i]].getTranslateX()-166);
						}
					}
					else if(list[i] == 99)
					{
						if(others[whoattack[i]].flagr == 1)
							others[whoattack[i]].set_image("guaiwu/zhanyou_2.png");
						else
						{
							others[whoattack[i]].set_image("guaiwu/zhanzuo_2.png");
							others[whoattack[i]].setTranslateX(others[whoattack[i]].getTranslateX()+166);
						}
						if(others[whoattack[i]].flagr == 1)//怪物向右
						{
							but[butlist[i]].set_zuobiao((int)(others[whoattack[i]].getTranslateX()+others[whoattack[i]].widthProperty().doubleValue()),(int)(others[whoattack[i]].getTranslateY()));
							but[butlist[i]].dir = 1;//子弹向右
						}
						else
						{
							but[butlist[i]].set_zuobiao((int)(others[whoattack[i]].getTranslateX()),(int)(others[whoattack[i]].getTranslateY()));
							but[butlist[i]].dir = 2;
						}
						mainpane.getChildren().add(but[butlist[i]]);
						others[whoattack[i]].cnt = 1;//子弹进入冷却状态
						others[whoattack[i]].index = -1;
						//System.out.println(gong[whoattack[i]]);
						others[whoattack[i]].gong = false;
						gong[whoattack[i]] = false;
						for(int j = i;j < index-1;++j)
						{
							butlist[j] = butlist[j+1];
							list[j] = list[j+1];
							whoattack[j] = whoattack[j+1];
						}
						--index;
						--i;
					}
				}
				else
				{
					but[butlist[i]] = null;
					for(int j = i;j < index-1;++j)
					{
						butlist[j] = butlist[j+1];
						list[j] = list[j+1];
						whoattack[j] = whoattack[j+1];
					}
					--index;
					--i;
				}
			}
			
			//p1与子弹发生碰撞
			if(p1.be_attack == 0)
			{
					for(int j = begin;j != end;j = (j+1)%but.length)//遍历所有子弹
					{
						if(but[j] != null && zhangai.crash(but[j], p1, 0, 0, 3))
						{
							if(p1.attack == 0 && p1.attack_U == 0 && p1.attack_L == 0)
							{
								if(but[j].dir == 2)
								{
									p1.set_image("image/be_attack_you.png", p1 instanceof yuancheng);
									p1.flagr = 1;
								}
								else
								{
									p1.set_image("image/be_attack_zuo.png", p1 instanceof yuancheng);
									p1.flagr = 2;
								}
							}
							p1.blood -= but[j].shanghai.intValue();
							if(p1.nu<=2000)
								p1.nu += but[j].shanghai.intValue()*30;
							if(p1.blood <= 0)//血量过低后怪物销毁
							{
								this.hide();
								main.mainStage.show();
							}
							p1.be_attack = 1;
							break;
						}
					}
			}
			
			//p2与子弹发生碰撞
			if(p2.be_attack == 0)
			{
					for(int j = begin;j != end;j = (j+1)%but.length)//遍历所有子弹
					{
						if(but[j] != null && zhangai.crash(but[j], p2, 0, 0, 3))
						{
							if(p2.attack == 0 && p2.attack_U == 0 && p2.attack_L == 0)
							{
								if(but[j].dir == 2)
								{
									p2.set_image("2image/be_attack_you.png");
									p2.flagr = 1;
								}
								else
								{
									p2.set_image("2image/be_attack_zuo.png");
									p2.flagr = 2;
								}
							}
							p2.blood -= but[j].shanghai.intValue();
							if(p2.nu<=2000)
								p2.nu += but[j].shanghai.intValue()*30;
							if(p2.blood <= 0)//血量过低后怪物销毁
							{
								this.hide();
								main.mainStage.show();
							}
							p2.be_attack = 1;
							break;
						}
					}
			}
			//怪物子弹及方向变化
			for(int i = 0;i < others.length;++i)
			{
				if(others[i] != null)
				{
					if(!others[i].gong)
					{
						if(others[i].attack == 0 )
						{
							if(p1.getTranslateX()+p1.widthProperty().doubleValue()/2 < others[i].getTranslateX()+others[i].widthProperty().doubleValue()/2 && others[i].flagrchange == 1)
							{
								others[i].set_image("guaiwu/zhanzuo_2.png");
								others[i].flagrchange = 2;
								others[i].flagr = 2;
							}
							else if(p1.getTranslateX()+p1.widthProperty().doubleValue()/2 > others[i].getTranslateX()+others[i].widthProperty().doubleValue()/2 && others[i].flagrchange == 2)
							{
								others[i].set_image("guaiwu/zhanyou_2.png");
								others[i].flagrchange = 1;
								others[i].flagr = 1;
							}
					
							if(Math.abs(others[i].getTranslateX() + others[i].widthProperty().doubleValue() - (p1.getTranslateX() + p1.widthProperty().doubleValue())) < 400)
							{
						//		System.out.println(butcnt);
								if(others[i].cnt == 0 && (butcnt <= 3 || (end+but.length-begin)%but.length <= 3))//如果现在可以发射子弹,即子弹冷却时间已经过去
								{
									if(end>=but.length-1)
										end = 0;
									if(others[i].flagr == 1)
										but[end] = new buttlet(others[i].shanghai,"guaiwu/bullet_2_you.png",others[i]);
									else
										but[end] = new buttlet(others[i].shanghai,"guaiwu/bullet_2_zuo.png",others[i]);
									butlist[index] = end;
									list[index] = 0;
									whoattack[index] = i;
									++index;
									++butcnt;
									others[i].index = end;
									but[end].set_zuobiao((int)(others[i].getTranslateX()),(int)(others[i].getTranslateY()));
									but[end].dir = 0;
									
									++end;
									if(end >= but.length-1)
										end = 0;
									
									others[i].gong = true;
									gong[i] = true;
									if(others[i].flagr == 1)
										others[i].set_image("guaiwu/attackyou1_2.png");
									else
									{
										others[i].set_image("guaiwu/attackzuo1_2.png");
									}
									/*if(end != 0)
										change_guai(i,end-1);
									else 
										change_guai(i,end-1);*/
								}
							}
						}
						else
						{
							others[i].attack = (others[i].attack+1)%60;
							if(others[i].attack == 0)
							{
								if(others[i].flagr == 1)
									others[i].set_image("guaiwu/zhanyou_2.png");
								else
									others[i].set_image("guaiwu/zhanzuo_2.png");
							}
						}
					}
					if(others[i].cnt != 0)
						others[i].cnt = (others[i].cnt + 1) % 500;
				}
			}
			
			//血条变化
			if (this.p1.blood <= 0)
			{
				Image temp = new Image("image/condition0.png");
				imagevblood.setImage(temp);
			}
			else if (this.p1.blood <= 100)
			{
				Image temp = new Image("image/condition1.png");
				imagevblood.setImage(temp);
			}
			else if (this.p1.blood <= 200)
			{
				Image temp = new Image("image/condition2.png");
				imagevblood.setImage(temp);
			}
			else if (this.p1.blood <= 300)
			{
				Image temp = new Image("image/condition3.png");
				imagevblood.setImage(temp);
			}
			else if (this.p1.blood <= 400)
			{
				Image temp = new Image("image/condition4.png");
				imagevblood.setImage(temp);
			}
			else
			{
				Image temp = new Image("image/condition5.png");
				imagevblood.setImage(temp);
			}
			
			//蓝条变化
			if (this.p1.lan <= 0)
			{
				Image temp = new Image("image/condition0-magic.png");
				imagevmagic.setImage(temp);
			}
			else if (this.p1.lan <= 400)
			{
				Image temp = new Image("image/condition1-magic.png");
				imagevmagic.setImage(temp);
			}
			else if (this.p1.lan <= 800)
			{
				Image temp = new Image("image/condition2-magic.png");
				imagevmagic.setImage(temp);
			}
			else if (this.p1.lan <= 1200)
			{
				Image temp = new Image("image/condition3-magic.png");
				imagevmagic.setImage(temp);
			}
			else if (this.p1.lan <= 1600)
			{
				Image temp = new Image("image/condition4-magic.png");
				imagevmagic.setImage(temp);
			}
			else
			{
				Image temp = new Image("image/condition5-magic.png");
				imagevmagic.setImage(temp);
			}
			//怒气条变化
			if (this.p1.nu <= 0)
			{
				Image temp = new Image("image/condition0-sp.png");
				imagevsp.setImage(temp);
			}
			else if (this.p1.nu <= 400)
			{
				Image temp = new Image("image/condition1-sp.png");
				imagevsp.setImage(temp);
			}
			else if (this.p1.nu <= 800)
			{
				Image temp = new Image("image/condition2-sp.png");
				imagevsp.setImage(temp);
			}
			else if (this.p1.nu <= 1200)
			{
				Image temp = new Image("image/condition3-sp.png");
				imagevsp.setImage(temp);
			}
			else if (this.p1.nu < 2000)
			{
				Image temp = new Image("image/condition4-sp.png");
				imagevsp.setImage(temp);
			}
			else if (this.p1.nu >= 2000)
			{
				Image temp = new Image("image/condition5-sp.png");
				imagevsp.setImage(temp);
			}
			
			
			
			
			
			
			//血条变化
			if (this.p2.blood <= 0)
			{
				Image temp = new Image("image/condition0_2.png");
				imagevblood1.setImage(temp);
			}
			else if (this.p2.blood <= 100)
			{
				Image temp = new Image("image/condition1_2.png");
				imagevblood1.setImage(temp);
			}
			else if (this.p2.blood <= 200)
			{
				Image temp = new Image("image/condition2_2.png");
				imagevblood1.setImage(temp);
			}
			else if (this.p2.blood <= 300)
			{
				Image temp = new Image("image/condition3_2.png");
				imagevblood1.setImage(temp);
			}
			else if (this.p2.blood <= 400)
			{
				Image temp = new Image("image/condition4_2.png");
				imagevblood1.setImage(temp);
			}
			else
			{
				Image temp = new Image("image/condition5_2.png");
				imagevblood1.setImage(temp);
			}
			
			//蓝条变化
			if (this.p2.lan <= 0)
			{
				Image temp = new Image("image/condition0-magic_2.png");
				imagevmagic1.setImage(temp);
			}
			else if (this.p2.lan <= 400)
			{
				Image temp = new Image("image/condition1-magic_2.png");
				imagevmagic1.setImage(temp);
			}
			else if (this.p2.lan <= 800)
			{
				Image temp = new Image("image/condition2-magic_2.png");
				imagevmagic1.setImage(temp);
			}
			else if (this.p2.lan <= 1200)
			{
				Image temp = new Image("image/condition3-magic_2.png");
				imagevmagic1.setImage(temp);
			}
			else if (this.p2.lan <= 1600)
			{
				Image temp = new Image("image/condition4-magic_2.png");
				imagevmagic1.setImage(temp);
			}
			else
			{
				Image temp = new Image("image/condition5-magic_2.png");
				imagevmagic1.setImage(temp);
			}
			//怒气条变化
			if (this.p2.nu <= 0)
			{
				Image temp = new Image("image/condition0-sp_2.png");
				imagevsp1.setImage(temp);
			}
			else if (this.p2.nu <= 400)
			{
				Image temp = new Image("image/condition1-sp_2.png");
				imagevsp1.setImage(temp);
			}
			else if (this.p2.nu <= 800)
			{
				Image temp = new Image("image/condition2-sp_2.png");
				imagevsp1.setImage(temp);
			}
			else if (this.p2.nu <= 1200)
			{
				Image temp = new Image("image/condition3-sp_2.png");
				imagevsp1.setImage(temp);
			}
			else if (this.p2.nu < 2000)
			{
				Image temp = new Image("image/condition4-sp_2.png");
				imagevsp1.setImage(temp);
			}
			else if (this.p2.nu >= 2000)
			{
				Image temp = new Image("image/condition5-sp_2.png");
				imagevsp1.setImage(temp);
			}
			
			
			
			
			
			//技能块变化
			if (p1.cnt_L != 0)
			{
				imagevskilll.setImage(new Image("image/skill-L.png"));
			}
			else
			{
				imagevskilll.setImage(new Image("image/skill-touming.png"));
			}
			if (p1.cnt_U != 0)
			{
				imagevskillu.setImage(new Image("image/skill-U.png"));
			}
			else
			{
				imagevskillu.setImage(new Image("image/skill-touming.png"));
			}
			
			
			if (p2.cnt_L != 0)
			{
				imagevskilll1.setImage(new Image("image/skill-2-3-2.png"));
			}
			else
			{
				imagevskilll1.setImage(new Image("image/skill-2-3.png"));
			}
			if (p2.cnt_U != 0)
			{
				imagevskillu1.setImage(new Image("image/skill-2-4-2.png"));
			}
			else
			{
				imagevskillu1.setImage(new Image("image/skill-2-4.png"));
			}

			
			
			//boss的血条
			if (boss2 != null && imagevbj.getTranslateX() <= -6900)
			{
				//System.out.println("666666666666");
				if (boss2.blood <= 0)
				{
					imagevbossblood.setImage(imagebossblood0);
				}
				else if (boss2.blood < 30)
				{
					imagevbossblood.setImage(imagebossblood1);
				}
				else if (boss2.blood < 60)
				{
					imagevbossblood.setImage(imagebossblood2);
				}
				else if (boss2.blood < 90)
				{
					imagevbossblood.setImage(imagebossblood3);
				}
				else if (boss2.blood <= 120)
				{
					imagevbossblood.setImage(imagebossblood4);
				}
				else 
				{
					imagevbossblood.setImage(imagebossblood5);
				}
			}

			//boss攻击效果
			
			if(boss2 != null && boss2.number == 70)
			{
				boss2.number = 0;
				boss2.but[boss2.end] = new buttlet(boss2.shanghai,"image/qiu.png",boss2);
				boss2.but[boss2.end].set_zuobiao(490, 250);
				if(p1!=null && ynow>250)
				{
					boss2.but[boss2.end].y = 2;
					boss2.but[boss2.end].x = 2 * (xnow-490) / (ynow-250);
				}
				else if(p1!=null && ynow<250)
				{
					boss2.but[boss2.end].y = -2;
					boss2.but[boss2.end].x = (-2) * (xnow-490) / (ynow-250);
				}
				else if(p1 !=null && ynow == 250)
				{
					if(xnow >= 490)
					{
						boss2.but[boss2.end].y = 0;
						boss2.but[boss2.end].x = 2;
					}
					else
					{
						boss2.but[boss2.end].y = 0;
						boss2.but[boss2.end].x = -2;
					}
				}
				boss2.but[boss2.end].dir = 1;
				mainpane.getChildren().add(boss2.but[boss2.end]);
				++boss2.end;
				if(boss2.end == boss2.but.length)
					boss2.end = 0;
			}
			
			
			if(boss2 != null && boss2.number1 == 70)
			{
				boss2.number1 = 0;
				boss2.but[boss2.end] = new buttlet(boss2.shanghai,"image/qiu.png",boss2);
				boss2.but[boss2.end].set_zuobiao(690, 250);
				if(p1!=null && ynow>250)
				{
					boss2.but[boss2.end].y = 2;
					boss2.but[boss2.end].x = 2 * (xnow-690) / (ynow-250);
				}
				else if(p1!=null && ynow<250)
				{
					boss2.but[boss2.end].y = -2;
					boss2.but[boss2.end].x = (-2) * (xnow-690) / (ynow-250);
				}
				else if(p1 !=null && ynow == 250)
				{
					if(xnow >= 690)
					{
						boss2.but[boss2.end].y = 0;
						boss2.but[boss2.end].x = 2;
					}
					else
					{
						boss2.but[boss2.end].y = 0;
						boss2.but[boss2.end].x = -2;
					}
				}
				boss2.but[boss2.end].dir = 2;
				mainpane.getChildren().add(boss2.but[boss2.end]);
				++boss2.end;
				if(boss2.end == boss2.but.length)
					boss2.end = 0;
			}
			
			if(boss2!= null && boss2.number2 == 70)
			{
				boss2.number2 = 0;
				for(int i = 0;i < 4;++i)
				{
					boss2.but[boss2.end] = new buttlet(boss2.shanghai,"image/qiu.png",boss2);
					boss2.but[boss2.end].set_zuobiao(100+i*300, 40);
					boss2.but[boss2.end].dir = 0;
					mainpane.getChildren().add(boss2.but[boss2.end]);
					++boss2.end;
					if(boss2.end == boss2.but.length)
						boss2.end = 0;
				}
			}
			
			
			//人物还没到关底时boss的位置			
			if (boss2 != null && imagevbj.getTranslateX() > -6900)
			{
				boss2.setTranslateX(-1000);
				boss2.setTranslateY(-1000);
				xinzang.set_zuobiao(-200, -200);
			}
			else if(boss2 != null)  //人物已经到关底时boss的位置变化
			{
				if(xinzang.k != 0)
					xinzang.k = (xinzang.k + 1) % 50;
				if(xinzang.k != 0)
				{
					xinzang.set_zuobiao(560, 260);
					xinzang.imagev.setImage(xin2);
				}
				else
				{
					xinzang.imagev.setImage(xin1);
					xinzang.set_zuobiao(570, 270);
				}
				boss2.setTranslateX(159);
				boss2.setTranslateY(100);
				
				++boss2.status;
				
				if(boss2.status == 600)
				{
					boss2.status = 0;
					boss2.number2 = 1;
				}
				else if(boss2.status == 200)
				{
					boss2.number = 1;
					boss2.imagev.setImage(iyou);
					xnow = p1.getTranslateX();
					ynow = p1.getTranslateY();
				}
				else if(boss2.status == 400)
				{
					boss2.number1 = 1;
					boss2.imagev.setImage(izuo);
					xnow = p2.getTranslateX();
					ynow = p2.getTranslateY();
				}
				else if(boss2.status >= 200 && boss2.status <= 250)
				{
					boss2.imagev.setImage(iyou);
				}
				else if(boss2.status >= 400 && boss2.status <= 450)
				{
					boss2.imagev.setImage(izuo);
				}
				else
				{
					boss2.imagev.setImage(ib);
				}
			}
	
			
	//boss子弹攻击
				if(boss2 != null)
				{
						for(int j = 0;j<boss2.but.length;++j)
						{
							if(boss2.but[j] != null && zhangai.crash(boss2.but[j], p1, 0, 0, 3) && p1.buti == 0)
							{
								if(p1.attack == 0 && p1.attack_U == 0 && p1.attack_L == 0)
								{
									if(boss2.but[j].dir == 2)
									{
										p1.set_image("image/be_attack_you.png", p1 instanceof yuancheng);
										p1.flagr = 1;
									}
									else
									{
										p1.set_image("image/be_attack_zuo.png", p1 instanceof yuancheng);
										p1.flagr = 2;
									}
								}
								p1.blood -= boss2.but[j].shanghai.intValue();
								if(p1.nu<=2000)
									p1.nu += boss2.but[j].shanghai.intValue()*30;
								if(p1.blood <= 0)//血量过低后怪物销毁
								{
									this.hide();
									main.mainStage.show();
								}
								p1.be_attack = 1;
								p1.buti = 1;
								break;
							}
							if(boss2.but[j] != null && zhangai.crash(boss2.but[j], p2, 0, 0, 3) && p2.buti == 0)
							{
								if(p2.attack == 0 && p2.attack_U == 0 && p2.attack_L == 0)
								{
									if(boss2.but[j].dir == 2)
									{
										p2.set_image("2image/be_attack_you.png");
										p2.flagr = 1;
									}
									else
									{
										p2.set_image("2image/be_attack_zuo.png");
										p2.flagr = 2;
									}
								}
								p2.blood -= boss2.but[j].shanghai.intValue();
								if(p2.nu<=2000)
									p2.nu += boss2.but[j].shanghai.intValue()*30;
								if(p2.blood <= 0)//血量过低后怪物销毁
								{
									this.hide();
									main.mainStage.show();
								}
								p2.be_attack = 1;
								p2.buti = 1;
								break;
							}
						}
				}
						
		//boss子弹移动
						if(boss2 != null)
						for(int i = 0;i < boss2.but.length;++i)
						{
							if(boss2.but[i] != null)
							{
								if(boss2.but[i].dir == 1 || boss2.but[i].dir == 2)
								{
									boss2.but[i].setTranslateX(boss2.but[i].getTranslateX()+boss2.but[i].x);
									boss2.but[i].setTranslateY(boss2.but[i].getTranslateY()+boss2.but[i].y);
								}
								else
								{
									boss2.but[i].setTranslateY(boss2.but[i].getTranslateY()+4);
								}
							}
						}
						
						//boss子弹出边界后销毁
						if(boss2 != null)
						if(boss2.but[boss2.begin] != null)
						{
							if(boss2.but[boss2.begin].getTranslateX() >= 1280 || boss2.but[boss2.begin].getTranslateX()+boss2.but[boss2.begin].widthProperty().doubleValue()/2 <= 0|| boss2.but[boss2.begin].getTranslateY()>= 760)
							{
								boss2.but[boss2.begin].imagev.setImage(new Image("image/toumin.png"));
								boss2.but[boss2.begin] = null;
								//System.out.println(1);
								++boss2.begin;
								if(boss2.begin >= boss2.but.length)
									boss2.begin = 0;
							}
						}
						
						
						
						//boss被攻击
						if(boss2!=null)
						{
								for(int j = p1.begin;j != p1.end;j = (j+1)%p1.but.length)//遍历所有子弹
								{
									if(p1.but[j] != null && zhangai.crash(p1.but[j], xinzang, 0, 0, 3))//怪物与子弹发生碰撞
									{
										boss2.blood -= p1.but[j].shanghai.intValue();//怪物扣血
										xinzang.k = 1;
										if(boss2.blood <= 0)//血量过低后boss销毁
										{
											boss2.imagev.setImage(new Image("image/toumin.png"));
											mainpane.getChildren().add(fanhuibtv);
											mainpane.getChildren().add(shengliv);
											animation.pause();
										}
										++p1.but[j].cnt;//该子弹碰撞数加一
										if(p1.but[j].cnt >= 4)//一颗子弹打的人数过多后子弹销毁,2为子弹可以打的人数
										{
											p1.but[j].imagev.setImage(new Image("image/toumin.png"));
											p1.but[j] = null;
										}
									}
								}
								//怪物与技能子弹发生碰撞
								if(boss2 != null)
								{
									for(int j = p1.begin1;j != p1.end1;j = (j+1)%p1.but1.length)//遍历所有子弹
									{
										if(p1.but1[j] != null && zhangai.crash(p1.but1[j], xinzang, 0, 0, 3))//怪物与子弹发生碰撞
										{
											boss2.blood -= p1.but1[j].shanghai.intValue();//怪物扣血
											xinzang.k = 1;
											if(boss2.blood <= 0)//血量过低后怪物销毁
											{
												boss2.imagev.setImage(new Image("image/toumin.png"));
												mainpane.getChildren().add(fanhuibtv);
												mainpane.getChildren().add(shengliv);
												animation.pause();
											}
								    			++p1.but1[j].cnt;//该子弹碰撞数加一
											if(p1.but1[j].cnt >= 4)//一颗子弹打的人数过多后子弹销毁,2为子弹可以打的人数
											{
												p1.but1[j].imagev.setImage(new Image("image/toumin.png"));
												p1.but1[j] = null;
											}
										}
									}
								}
							}
						
						
						if(boss2!=null)
						{
							//System.out.println(boss2.blood);
							if(p2 != null && (p2.attack != 0 || p2.attack_L != 0 || p2.attack_U != 0)&&boss2.buti == 0)
							{
			
											if(zhangai.crash(p2, xinzang, 0, 0, 3))//怪物与子弹发生碰撞
											{
												boss2.buti = 1;
												xinzang.k = 1;
												if(p2.attack != 0)
													boss2.blood -= p2.shanghai.intValue();//怪物扣血
												else if(p2.attack_L != 0)
													boss2.blood -= p2.shanghai.intValue()*2;//怪物扣血
												else if(p2.attack_U != 0)
													boss2.blood -= p2.shanghai.intValue()*3;//怪物扣血
												if(boss2.blood <= 0)//血量过低后怪物销毁
												{
													boss2.imagev.setImage(new Image("image/toumin.png"));
													mainpane.getChildren().add(fanhuibtv);
													mainpane.getChildren().add(shengliv);
													animation.pause();

												}
											}
								}
							}
						
		};
		animation = new Timeline(new KeyFrame(Duration.millis(10),eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		

		Scene scene = new Scene(mainpane);
		this.setTitle("第一关");
		this.setScene(scene);
		p1.requestFocus();
	}
	
}
