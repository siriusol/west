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
	
	public int index=-1;//�����ӵ����
	//public buttlet[] but = new buttlet[20];//�ӵ�
	//public int begin,end;//�ӵ���ʼ�±�ͽ����±�
	public int cnt;//������ȴ
	public int flagr=1;//���ﳯ��
	public int flagrchange=1;//�����Ƿ��Ѿ�����ȷ����
	public int attack = 0;//���ﱻ����ʱ�����
	public int gong_cnt = 0;//���﹥��ͼ�����
	public boolean gong = false;//����״̬
	
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
		this.blood = blood;//����Ѫ��
		cnt = 0;
		EventHandler<ActionEvent> eventHandler = e->
		{
			if(this.attack == 0)
			{
				//�����������и���
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
			
			//�����Զ������ӵ�
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
	public void set_zuobiao(int x,int y)//�ı�ͼƬ����
	{
		this.setTranslateX(x);
		this.setTranslateY(y);
	}
	public void set_image(String s)//ͼ�����
	{
		image = new Image(s);
		imagev.setImage(image);
	}
}
