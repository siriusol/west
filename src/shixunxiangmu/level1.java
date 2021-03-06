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
public class level1 extends level
{

	public level1(main_work main)
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
		imagebj = new Image("image/bj-1.png");
		imagevbj = new ImageView(imagebj);
		imagevbj.setTranslateX(0);
		imagevbj.setTranslateY(0);
		
		//设置远程攻击人物
		p1 = new yuancheng(this,500,2000);
		p1.set_zuobiao(0, 400);
		
		begin = end = 0;
		for(int i = 0;i < 8;++i)
			chuguai[i] = 0;
		
		//设置boss
		
				boss1 = new boss();
				boss1.setTranslateX(-200);
				boss1.setTranslateY(-200);

		//设置障碍物
		zhang[0] = new zhangai("image/earth-1.png");
		zhang[1] = new zhangai("image/tai-1.png");
		zhang[2] = new zhangai("image/tai-2.png");
		zhang[3] = new zhangai("image/tai-4.png");
		zhang[4] = new zhangai("image/tai-3.png");
		zhang[5] = new zhangai("image/tai-1.png");
		zhang[6] = new zhangai("image/tai-1.png");
		zhang[7] = new zhangai("image/tai-1.png");
		zhang[8] = new zhangai("image/tai-4.png");
		zhang[9] = new zhangai("image/tai-2.png");
		zhang[10] = new zhangai("image/tai-2.png");
		zhang[11] = new zhangai("image/tai-1.png");
		zhang[12] = new zhangai("image/tai-1.png");
		zhang[13] = new zhangai("image/tai-1.png");
		zhang[14] = new zhangai("image/tai-2.png");
		zhang[15] = new zhangai("image/tai-3.png");
		zhang[16] = new zhangai("image/tai-2.png");
		zhang[17] = new zhangai("image/tai-1.png");

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
		
		mainpane = new Pane();
		mainpane.getChildren().add(imagevbj);
		mainpane.getChildren().add(p1);
		for(int i = 0;i < zhang.length;++i)
			mainpane.getChildren().add(zhang[i]);
		for(int i = 0;i < 8;++i)
			gong[i] = false;
		
		
		
		
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
				//添加技能栏
				Image imageskill = new Image("image/skill.png");
				ImageView imagevskill = new ImageView(imageskill);
				imagevskill.setTranslateX(20);
				imagevskill.setTranslateY(635);
				mainpane.getChildren().add(imagevskill);
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
						
				mainpane.getChildren().add(boss1);
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
			//人物子弹
			//防止连发子弹,后面数字越大，子弹间隔时间越长
			
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
			if(boss1.cnt != 0)
				boss1.cnt = (boss1.cnt+1)%600;
			//if(p1.nu<=3000)
				//++p1.nu;
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
							p1.shanghai.set(p2.shanghai.get() + 1);
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
							others[i] = new other_thing("guaiwu/zhanzuo_1.png",this,3,2);
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
									others[i].set_image("guaiwu/be_attackzuo_1.png");
								}
								else
								{
									others[i].set_image("guaiwu/be_attackyou_1.png");
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
										others[i].set_image("guaiwu/be_attackzuo_1.png");
									}
									else
									{
										others[i].set_image("guaiwu/be_attackyou_1.png");
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
			//怪物动画效果
			for(int i = 0;i < index;++i)
			{
				if(others[whoattack[i]] != null)
				{
					list[i] = list[i]+1;
					if(list[i] == 49)
					{
						if(others[whoattack[i]].flagr == 1)
							others[whoattack[i]].set_image("guaiwu/attackyou2_1.png");
						else
							others[whoattack[i]].set_image("guaiwu/attackzuo2_1.png");
					}
					else if(list[i] == 99)
					{
						if(others[whoattack[i]].flagr == 1)
							others[whoattack[i]].set_image("guaiwu/zhanyou_1.png");
						else
							others[whoattack[i]].set_image("guaiwu/zhanzuo_1.png");
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
								others[i].set_image("guaiwu/zhanzuo_1.png");
								others[i].flagrchange = 2;
								others[i].flagr = 2;
							}
							else if(p1.getTranslateX()+p1.widthProperty().doubleValue()/2 > others[i].getTranslateX()+others[i].widthProperty().doubleValue()/2 && others[i].flagrchange == 2)
							{
								others[i].set_image("guaiwu/zhanyou_1.png");
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
									but[end] = new buttlet(others[i].shanghai,"guaiwu/bullet_1.png",others[i]);
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
										others[i].set_image("guaiwu/attackyou1_1.png");
									else
										others[i].set_image("guaiwu/attackzuo1_1.png");
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
									others[i].set_image("guaiwu/zhanyou_1.png");
								else
									others[i].set_image("guaiwu/zhanzuo_1.png");
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

			
			
			//boss的血条
			if (boss1 != null && imagevbj.getTranslateX() <= -6900)
			{
			//	System.out.println("666666666666");
				if (boss1.blood <= 0)
				{
					imagevbossblood.setImage(imagebossblood0);
				}
				else if (boss1.blood < 30)
				{
					imagevbossblood.setImage(imagebossblood1);
				}
				else if (boss1.blood < 60)
				{
					imagevbossblood.setImage(imagebossblood2);
				}
				else if (boss1.blood < 90)
				{
					imagevbossblood.setImage(imagebossblood3);
				}
				else if (boss1.blood <= 120)
				{
					imagevbossblood.setImage(imagebossblood4);
				}
				else 
				{
					imagevbossblood.setImage(imagebossblood5);
				}
			}

			//人物还没到关底时boss的位置			
			if (boss1 != null && imagevbj.getTranslateX() > -6900)
			{
				boss1.setTranslateX(-200);
				boss1.setTranslateY(-200);
			}
			else if(boss1 != null)  //人物已经到关底时boss的位置变化
			{
				if (boss1.status < 10)//boss正常飞
				{
					if (boss1.getTranslateX() > p1.getTranslateX())
					{								
						if (boss1.number < 24)
						{
							boss1.imagev.setImage(imagenormalleft1);
							boss1.number++;
						}
						else if (boss1.number < 48)
						{
							boss1.imagev.setImage(imagenormalleft2);
							boss1.number++;
						}
						else if (boss1.number < 72)
						{
							boss1.imagev.setImage(imagenormalleft3);
							boss1.number++;
						}
						else
						{
							boss1.number = 0;
							boss1.status++;
						}
						boss1.setTranslateX(boss1.getTranslateX() - 1);
					}
					else if (boss1.getTranslateX() < p1.getTranslateX())
					{
						if (boss1.number < 24)
						{
							boss1.imagev.setImage(imagenormalright1);
							boss1.number++;
						}
						else if (boss1.number < 48)
						{
							boss1.imagev.setImage(imagenormalright2);
							boss1.number++;
						}
						else if (boss1.number < 72)
						{
							boss1.imagev.setImage(imagenormalright3);
							boss1.number++;
						}
						else
						{
							boss1.number = 0;
							boss1.status++;
						}
						boss1.setTranslateX(boss1.getTranslateX() + 1);
					}
					else
					{
						boss1.number++;
						boss1.status++;
					}
					
					if (p1.getTranslateY() < boss1.getTranslateY())
					{
						boss1.setTranslateY(boss1.getTranslateY() - 1);
					}
					if (p1.getTranslateY() > boss1.getTranslateY())
					{
						boss1.setTranslateY(boss1.getTranslateY() + 1);
					}
					
				}
				else if (boss1.status == 10)//boss闪现后冲刺
				{
					//进入此处时number == 0;
					//System.out.println(boss1.number);			
					if (boss1.number < 20)
					{
						if (!boss1.ifright)
							boss1.imagev.setImage(imagemoveleft1);
						else
							boss1.imagev.setImage(imagemoveright1);
						boss1.number++;
					}
					else if (boss1.number < 40)
					{
						boss1.imagev.setImage(imagemoveright15);
						boss1.number++;
					}
					else if (boss1.number < 60)
					{
						if (boss1.ifright)
						{
							boss1.setTranslateX(0);
							boss1.setTranslateY(0);
						}
						else
						{
							boss1.setTranslateX(1000);
							boss1.setTranslateY(0);
						}
						boss1.number++;
					}
					else if (boss1.number < 80)
					{
						if (boss1.ifright)
							boss1.imagev.setImage(imagemoveright1);
						else
							boss1.imagev.setImage(imagemoveleft1);
						boss1.number++;
					}
					else if (boss1.number < 100)
					{
						if (boss1.ifright)
							boss1.imagev.setImage(imagemoveright2);
						else
							boss1.imagev.setImage(imagemoveleft2);						
						boss1.number++;
					}
					else if (boss1.number < 120)
					{
						if (boss1.ifright)
							boss1.imagev.setImage(imagemoveright3);
						else
							boss1.imagev.setImage(imagemoveleft3);
						boss1.number++;
					}
					else if (boss1.number == 120 && Math.abs((int)(boss1.getTranslateY() - p1.getTranslateY())) > 5)
					{
						if (boss1.ifright)
						{
							boss1.imagev.setImage(imagemoveright4);
							boss1.setTranslateX(boss1.getTranslateX() + 1);
							if (boss1.getTranslateY() - p1.getTranslateY() < 0)
								boss1.setTranslateY(boss1.getTranslateY() + 4);
							else
								boss1.setTranslateY(boss1.getTranslateY() - 4);
						}
						
						else
						{
							boss1.imagev.setImage(imagemoveleft4);
							boss1.setTranslateX(boss1.getTranslateX() - 1);
							if (boss1.getTranslateY() - p1.getTranslateY() < 0)
								boss1.setTranslateY(boss1.getTranslateY() + 4);
							else
								boss1.setTranslateY(boss1.getTranslateY() - 4);
						}
						
						//System.out.println(boss1.getTranslateX() + "   " + boss1.getTranslateY());
						//System.out.println(boss1.number);
						//System.out.println( Math.abs((int)(boss1.getTranslateY() - p1.getTranslateY())));					
					}
					else if (boss1.number == 120 && Math.abs((int)(boss1.getTranslateY() - p1.getTranslateY())) <= 5)
					{
						boss1.number++;
					}
					else if (boss1.number < 200)
					{
						if (boss1.ifright)
						{
							boss1.imagev.setImage(imagerushright);
							boss1.setTranslateX(boss1.getTranslateX() + 8);
						}
						else
						{
							boss1.imagev.setImage(imagerushleft);
							boss1.setTranslateX(boss1.getTranslateX() - 8);
						}
						boss1.number++;
						//System.out.println(boss1.number);
					}
					else if (boss1.number < 310)
					{
						if (boss1.ifright)
						{
							boss1.imagev.setImage(imagerushrighttop);
							boss1.setTranslateX(boss1.getTranslateX() + 1);
							
						}
						else
						{
							boss1.imagev.setImage(imagerushlefttop);
							boss1.setTranslateX(boss1.getTranslateX() - 1);
						}
						boss1.setTranslateY(boss1.getTranslateY() - 4);
						boss1.number++;
						//System.out.println(boss1.getTranslateY());
						//System.out.println(boss1.number);
					}
					else if (boss1.getTranslateY() < 100)
					{
						//System.out.println(boss1.number);
						boss1.status = 20;
						//此时boss1.number == 310;
						boss1.number = 0;
						if (boss1.ifright)
						{
							boss1.ifright = false;
						}
						else
						{
							boss1.ifright = true;
						}
					}
					
					/*
					else if (boss1.number < 180 && boss1.getTranslateX() >= 1100)
					{
						boss1.imagev.setImage(imagerushright);
						boss1.setTranslateX(boss1.getTranslateX() - 10);
					}
					*/
				}
				//此时boss闪现冲刺执行完毕
				else if (boss1.status < 30)
				{
					//System.out.println("6666");
					if (boss1.getTranslateX() > p1.getTranslateX())
					{								
						if (boss1.number < 24)
						{
							boss1.imagev.setImage(imagenormalleft1);
							boss1.number++;
						}
						else if (boss1.number < 48)
						{
							boss1.imagev.setImage(imagenormalleft2);
							boss1.number++;
						}
						else if (boss1.number < 72)
						{
							boss1.imagev.setImage(imagenormalleft3);
							boss1.number++;
						}
						else
						{
							boss1.number = 0;
							boss1.status++;
						}
						boss1.setTranslateX(boss1.getTranslateX() - 1);
					}
					else if (boss1.getTranslateX() < p1.getTranslateX())
					{
						if (boss1.number < 24)
						{
							boss1.imagev.setImage(imagenormalright1);
							boss1.number++;
						}
						else if (boss1.number < 48)
						{
							boss1.imagev.setImage(imagenormalright2);
							boss1.number++;
						}
						else if (boss1.number < 72)
						{
							boss1.imagev.setImage(imagenormalright3);
							boss1.number++;
						}
						else
						{
							boss1.number = 0;
							boss1.status++;
						}
						boss1.setTranslateX(boss1.getTranslateX() + 1);
					}
					else
						boss1.status++;
					if (p1.getTranslateY() < boss1.getTranslateY())
					{
						boss1.setTranslateY(boss1.getTranslateY() - 1);
					}
					if (p1.getTranslateY() > boss1.getTranslateY())
					{
						boss1.setTranslateY(boss1.getTranslateY() + 1);
					}
				}
				//此时boos1.status == 30
				else
				{
					if (p1.getTranslateY() > 500)//人在最下面一层
					{
						if (boss1.getTranslateX() < p1.getTranslateX())
						{
							if (boss1.number < 20)
							{						
								boss1.imagev.setImage(imagemoveright1);
								boss1.number++;
							}
							else if (boss1.number < 40)
							{
								boss1.imagev.setImage(imagemoveright15);
								boss1.number++;
							}
							else if (boss1.number < 60)
							{
								boss1.imagev.setImage(imageciright);
								if (boss1.getTranslateX() < p1.getTranslateX())
								{
									boss1.setTranslateX(p1.getTranslateX() - 300);
									boss1.setTranslateY(302);
								}
								else
								{
									//boss1.setTranslateX(0);
									boss1.setTranslateX(p1.getTranslateX() + 300);
									boss1.setTranslateY(302);
								}
								boss1.number++;
							}
							else if (boss1.number < 80)
							{
								boss1.imagev.setImage(imageciright1);
								boss1.setTranslateX(boss1.getTranslateX() + 5);
								boss1.setTranslateY(boss1.getTranslateY() + 5);
								boss1.number++;
							}
							else if (boss1.number < 100)
							{
								boss1.imagev.setImage(imageciright);
								boss1.setTranslateX(boss1.getTranslateX() + 1);
								boss1.setTranslateY(boss1.getTranslateY() + 1);
								boss1.number++;
							}
							else if (boss1.number < 120)
							{
								boss1.imagev.setImage(imageciright2);
								boss1.setTranslateX(boss1.getTranslateX() + 5);
								boss1.setTranslateY(boss1.getTranslateY() + 5);
								boss1.number++;
							}
							else if (boss1.number < 160)
							{
								boss1.imagev.setImage(imageciright1);
								boss1.setTranslateX(boss1.getTranslateX() + 1);
								boss1.setTranslateY(boss1.getTranslateY() + 1);
								boss1.number = 0;
								boss1.status = 0;
								//System.out.println("66666");
							}
						}
						else
						{
							if (boss1.number < 20)
							{						
								boss1.imagev.setImage(imagemoveleft1);
								boss1.number++;
							}
							else if (boss1.number < 40)
							{
								boss1.imagev.setImage(imagemoveleft15);
								boss1.number++;
							}
							else if (boss1.number < 60)
							{
								boss1.imagev.setImage(imagecileft);
								if (boss1.getTranslateX() < p1.getTranslateX())
								{
									boss1.setTranslateX(p1.getTranslateX() - 300);
									boss1.setTranslateY(302);
								}
								else
								{
									//boss1.setTranslateX(0);
									boss1.setTranslateX(p1.getTranslateX() + 300);
									boss1.setTranslateY(302);
								}
								boss1.number++;
							}
							else if (boss1.number < 80)
							{
								boss1.imagev.setImage(imagecileft1);
								boss1.setTranslateX(boss1.getTranslateX() - 5);
								boss1.setTranslateY(boss1.getTranslateY() + 5);
								boss1.number++;
							}
							else if (boss1.number < 100)
							{
								boss1.imagev.setImage(imagecileft);
								boss1.setTranslateX(boss1.getTranslateX() - 1);
								boss1.setTranslateY(boss1.getTranslateY() + 1);
								boss1.number++;
							}
							else if (boss1.number < 120)
							{
								boss1.imagev.setImage(imagecileft2);
								boss1.setTranslateX(boss1.getTranslateX() - 5);
								boss1.setTranslateY(boss1.getTranslateY() + 5);
								boss1.number++;
							}
							else if (boss1.number < 160)
							{
								boss1.imagev.setImage(imagecileft1);
								boss1.setTranslateX(boss1.getTranslateX() - 1);
								boss1.setTranslateY(boss1.getTranslateY() + 1);
								boss1.number = 0;
								boss1.status = 0;
							}
						}
					}
					else if (p1.getTranslateY() > 300)//人在中间一层
					{
						if (boss1.getTranslateX() < p1.getTranslateX())
						{
							if (boss1.number < 20)
							{						
								boss1.imagev.setImage(imagemoveright1);
								boss1.number++;
							}
							else if (boss1.number < 40)
							{
								boss1.imagev.setImage(imagemoveright15);
								boss1.number++;
							}
							else if (boss1.number < 60)
							{
								boss1.imagev.setImage(imageciright);
								if (boss1.getTranslateX() < p1.getTranslateX())
								{
									boss1.setTranslateX(p1.getTranslateX() - 300);
									boss1.setTranslateY(72);
								}
								else
								{
									//boss1.setTranslateX(0);
									boss1.setTranslateX(p1.getTranslateX() + 300);
									boss1.setTranslateY(72);
								}
								boss1.number++;
							}
							else if (boss1.number < 80)
							{
								boss1.imagev.setImage(imageciright1);
								boss1.setTranslateX(boss1.getTranslateX() + 5);
								boss1.setTranslateY(boss1.getTranslateY() + 5);
								boss1.number++;
							}
							else if (boss1.number < 100)
							{
								boss1.imagev.setImage(imageciright);
								boss1.setTranslateX(boss1.getTranslateX() + 1);
								boss1.setTranslateY(boss1.getTranslateY() + 1);
								boss1.number++;
							}
							else if (boss1.number < 120)
							{
								boss1.imagev.setImage(imageciright2);
								boss1.setTranslateX(boss1.getTranslateX() + 5);
								boss1.setTranslateY(boss1.getTranslateY() + 5);
								boss1.number++;
							}
							else if (boss1.number < 160)
							{
								boss1.imagev.setImage(imageciright1);
								boss1.setTranslateX(boss1.getTranslateX() + 1);
								boss1.setTranslateY(boss1.getTranslateY() + 1);
								boss1.number = 0;
								boss1.status = 0;
								//System.out.println("66666");
							}
						}
						else
						{
							if (boss1.number < 20)
							{						
								boss1.imagev.setImage(imagemoveleft1);
								boss1.number++;
							}
							else if (boss1.number < 40)
							{
								boss1.imagev.setImage(imagemoveleft15);
								boss1.number++;
							}
							else if (boss1.number < 60)
							{
								boss1.imagev.setImage(imagecileft);
								if (boss1.getTranslateX() < p1.getTranslateX())
								{
									boss1.setTranslateX(p1.getTranslateX() - 300);
									boss1.setTranslateY(72);
								}
								else
								{
									//boss1.setTranslateX(0);
									boss1.setTranslateX(p1.getTranslateX() + 300);
									boss1.setTranslateY(72);
								}
								boss1.number++;
							}
							else if (boss1.number < 80)
							{
								boss1.imagev.setImage(imagecileft1);
								boss1.setTranslateX(boss1.getTranslateX() - 5);
								boss1.setTranslateY(boss1.getTranslateY() + 5);
								boss1.number++;
							}
							else if (boss1.number < 100)
							{
								boss1.imagev.setImage(imagecileft);
								boss1.setTranslateX(boss1.getTranslateX() - 1);
								boss1.setTranslateY(boss1.getTranslateY() + 1);
								boss1.number++;
							}
							else if (boss1.number < 120)
							{
								boss1.imagev.setImage(imagecileft2);
								boss1.setTranslateX(boss1.getTranslateX() - 5);
								boss1.setTranslateY(boss1.getTranslateY() + 5);
								boss1.number++;
							}
							else if (boss1.number < 160)
							{
								boss1.imagev.setImage(imagecileft1);
								boss1.setTranslateX(boss1.getTranslateX() - 1);
								boss1.setTranslateY(boss1.getTranslateY() + 1);
								boss1.number = 0;
								boss1.status = 0;
								//System.out.println("77777");
							}
						}
					}
					else
						boss1.status = 0;
					
				}
			}
			
			//boss发射子弹
			if(boss1 != null)
			if(boss1.status > 5 && boss1.status < 10 && boss1.cnt == 0)
			{
					boss1.cnt = 1;
					if(boss1.ifright)
					{
						boss1.but[boss1.end] = new buttlet(boss1.shanghai,"image/bossdan_you.png",boss1);
						boss1.but[boss1.end].set_zuobiao((int)(boss1.getTranslateX()+boss1.widthProperty().doubleValue()/2),(int)(boss1.getTranslateY()+boss1.heightProperty().doubleValue()/2));
						boss1.but[boss1.end].dir = 1;
						mainpane.getChildren().add(boss1.but[boss1.end]);
						//当前子弹下标后移
						++boss1.end;
						if(boss1.end == boss1.but.length)
							boss1.end = 0;
						
						boss1.but[boss1.end] = new buttlet(boss1.shanghai,"image/bossdan_you.png",boss1);
						boss1.but[boss1.end].set_zuobiao((int)(boss1.getTranslateX()+boss1.widthProperty().doubleValue()/2-60),(int)(boss1.getTranslateY()+boss1.heightProperty().doubleValue()/2));
						boss1.but[boss1.end].dir = 1;
						mainpane.getChildren().add(boss1.but[boss1.end]);
						//当前子弹下标后移
						++boss1.end;
						if(boss1.end == boss1.but.length)
							boss1.end = 0;
						
						boss1.but[boss1.end] = new buttlet(boss1.shanghai,"image/bossdan_you.png",boss1);
						boss1.but[boss1.end].set_zuobiao((int)(boss1.getTranslateX()+boss1.widthProperty().doubleValue()/2),(int)(boss1.getTranslateY()+boss1.heightProperty().doubleValue()/2-60));
						boss1.but[boss1.end].dir = 1;
						mainpane.getChildren().add(boss1.but[boss1.end]);
						//当前子弹下标后移
						++boss1.end;
						if(boss1.end == boss1.but.length)
							boss1.end = 0;
					}
					else
					{
						boss1.but[boss1.end] = new buttlet(boss1.shanghai,"image/bossdan_zuo.png",boss1);
						boss1.but[boss1.end].set_zuobiao((int)(boss1.getTranslateX()+boss1.widthProperty().doubleValue()/2),(int)(boss1.getTranslateY()+boss1.heightProperty().doubleValue()/2));
						boss1.but[boss1.end].dir = 2;
						mainpane.getChildren().add(boss1.but[boss1.end]);
						//当前子弹下标后移
						++boss1.end;
						if(boss1.end == boss1.but.length)
							boss1.end = 0;
						
						boss1.but[boss1.end] = new buttlet(boss1.shanghai,"image/bossdan_zuo.png",boss1);
						boss1.but[boss1.end].set_zuobiao((int)(boss1.getTranslateX()+boss1.widthProperty().doubleValue()/2+60),(int)(boss1.getTranslateY()+boss1.heightProperty().doubleValue()/2));
						boss1.but[boss1.end].dir = 2;
						mainpane.getChildren().add(boss1.but[boss1.end]);
						//当前子弹下标后移
						++boss1.end;
						if(boss1.end == boss1.but.length)
							boss1.end = 0;
						
						boss1.but[boss1.end] = new buttlet(boss1.shanghai,"image/bossdan_zuo.png",boss1);
						boss1.but[boss1.end].set_zuobiao((int)(boss1.getTranslateX()+boss1.widthProperty().doubleValue()/2),(int)(boss1.getTranslateY()+boss1.heightProperty().doubleValue()/2-60));
						boss1.but[boss1.end].dir = 2;
						mainpane.getChildren().add(boss1.but[boss1.end]);
						//当前子弹下标后移
						++boss1.end;
						if(boss1.end == boss1.but.length)
							boss1.end = 0;
					}
				}
				

			
			//boss攻击
					if(boss1 != null)
						if((boss1.status== 10||boss1.status==30)&&zhangai.crash(boss1, p1, 0, 0, 3)&&p1.be_attack==0&&p1.buti ==0)
						{
							if(p1.attack == 0 && p1.attack_U == 0 && p1.attack_L == 0)
							{
								if(!boss1.ifright)
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
							p1.blood -= boss1.shanghai.intValue();
							if(p1.nu<=2000)
								p1.nu += boss1.shanghai.intValue()*30;
							System.out.println(p1.nu);
							if(p1.blood <= 0)//血量过低后怪物销毁
							{
								this.hide();
								main.mainStage.show();
							}
							p1.be_attack = 1;
							p1.buti = 1;
						}
						//boss子弹攻击
						if(boss1 != null)
						for(int j = 0;j<boss1.but.length;++j)
						{
							if(boss1.but[j] != null && zhangai.crash(boss1.but[j], p1, 0, 0, 3) && p1.buti == 0)
							{
								if(p1.attack == 0 && p1.attack_U == 0 && p1.attack_L == 0)
								{
									if(boss1.but[j].dir == 2)
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
								p1.blood -= boss1.but[j].shanghai.intValue();
								if(p1.nu<=2000)
									p1.nu += boss1.but[j].shanghai.intValue()*30;
								if(p1.blood <= 0)//血量过低后怪物销毁
								{
									this.hide();
									main.mainStage.show();
								}
								p1.be_attack = 1;
								p1.buti = 1;
								break;
							}
						}
						
						//boss子弹移动
						if(boss1 != null)
						for(int i = 0;i < boss1.but.length;++i)
						{
							if(boss1.but[i] != null)
							{
								if(boss1.but[i].dir == 1)
								{
									boss1.but[i].setTranslateX(boss1.but[i].getTranslateX()+2);
									boss1.but[i].setTranslateY(boss1.but[i].getTranslateY()+2);
								}
								else
								{
									boss1.but[i].setTranslateX(boss1.but[i].getTranslateX()-2);
									boss1.but[i].setTranslateY(boss1.but[i].getTranslateY()+2);
								}
							}
						}
						
						//boss子弹出边界后销毁
						if(boss1 != null)
						if(boss1.but[boss1.begin] != null)
						{
							if(boss1.but[boss1.begin].getTranslateX() >= 1280 || boss1.but[boss1.begin].getTranslateX()+boss1.but[boss1.begin].widthProperty().doubleValue()/2 <= 0|| boss1.but[boss1.begin].getTranslateY()>= 760)
							{
								boss1.but[boss1.begin].imagev.setImage(new Image("image/toumin.png"));
								boss1.but[boss1.begin] = null;
								//System.out.println(1);
								++boss1.begin;
								if(boss1.begin >= boss1.but.length-1)
									boss1.begin = 0;
							}
						}
						
						
						
						//boss被攻击
						if(boss1!=null)
						{
								for(int j = p1.begin;j != p1.end;j = (j+1)%p1.but.length)//遍历所有子弹
								{
									if(p1.but[j] != null && zhangai.crash(p1.but[j], boss1, 0, 0, 3))//怪物与子弹发生碰撞
									{
										boss1.blood -= p1.but[j].shanghai.intValue();//怪物扣血
										
										if(boss1.blood <= 0)//血量过低后boss销毁
										{
											boss1.imagev.setImage(new Image("image/toumin.png"));
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
								if(boss1 != null)
								{
									for(int j = p1.begin1;j != p1.end1;j = (j+1)%p1.but1.length)//遍历所有子弹
									{
										if(p1.but1[j] != null && zhangai.crash(p1.but1[j], boss1, 0, 0, 3))//怪物与子弹发生碰撞
										{
											boss1.blood -= p1.but1[j].shanghai.intValue();//怪物扣血
											if(boss1.blood <= 0)//血量过低后怪物销毁
											{
												boss1.imagev.setImage(new Image("image/toumin.png"));
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
