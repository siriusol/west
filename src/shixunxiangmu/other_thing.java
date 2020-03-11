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
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
//import java.lang.Math;

public class other_thing extends main_thing
{
	public Image image;
	public ImageView imagev;
	public int blood;
	
	public int index=-1;//发射子弹编号
	//public buttlet[] but = new buttlet[20];//子弹
	//public int begin,end;//子弹开始下标和结束下标
	public int cnt;//攻击冷却
	public int flagr=1;//怪物朝向
	public int flagrchange=1;//怪物是否已经是正确朝向
	public int attack = 0;//怪物被攻击时间控制
	public int gong_cnt = 0;//怪物攻击图像控制
	public boolean gong = false;//攻击状态
	
	//boolean ifleft = true;
	public other_thing()
	{
		
	}
	public other_thing(String s,level lev,int blood,int shang)
	{
		this.shanghai = new SimpleIntegerProperty(shang);
		image = new Image(s);
		imagev = new ImageView(image);
		this.getChildren().add(imagev);
		this.blood = blood;//怪物血量
		cnt = 0;
		EventHandler<ActionEvent> eventHandler = e->
		{
			if(this.attack == 0)
			{
				//怪物对人物进行跟踪
				if (lev.p1.getTranslateX() + lev.p1.widthProperty().doubleValue() + 400 < this.getTranslateX() + this.widthProperty().doubleValue())
				{
					this.setTranslateX(this.getTranslateX() - 1);
					flagr = 2;
				}
				if (lev.p1.getTranslateX() + lev.p1.widthProperty().doubleValue() > this.getTranslateX() + this.widthProperty().doubleValue() + 400)
				{
					if (lev.p1.getTranslateX() <= 640 || lev.imagevbj.getTranslateX() <= -6900)
						this.setTranslateX(this.getTranslateX() + 1);
					flagr = 1;
				}
				if (lev.p1.getTranslateY() +lev.p1.heightProperty().doubleValue()< this.getTranslateY() + this.heightProperty().doubleValue())
				{
					this.setTranslateY(this.getTranslateY() - 1);				
				}
				if (lev.p1.getTranslateY() +lev.p1.heightProperty().doubleValue()> this.getTranslateY()+ this.heightProperty().doubleValue())
				{
					this.setTranslateY(this.getTranslateY() + 1);
				}
			}
			
			//怪物自动发射子弹
			/*for(int i = 0;i < lev.others.length;++i)
			{
				if(lev.others[i] != null)
				{
					
				}
			}*/
		};
		
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(10),eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	public void set_zuobiao(int x,int y)//改变图片坐标
	{
		this.setTranslateX(x);
		this.setTranslateY(y);
	}
	public void set_image(String s)//图像更改
	{
		image = new Image(s);
		imagev.setImage(image);
	}
}
