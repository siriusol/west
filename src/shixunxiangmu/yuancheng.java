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

public class yuancheng extends our_thing 
{
	public buttlet[] but = new buttlet[20];//�ӵ�
	public buttlet[] but1 = new buttlet[30];//�����ӵ�
	public int begin,end;//�ӵ���ʼ�±�ͽ����±�
	public int begin1,end1;
	public int cntbut_L = 0;
	public int cntbut_U = 0;
	public int cnt;//������ȴ
	public yuancheng()
	{
		//System.out.println("yuancheng");
	}
	public yuancheng(level s,int blood,int lan)
	{
		super("1image/zhanli_you.png",s);
		//System.out.println("yuancheng");
		this.blood = blood;
		this.lan = lan;
		begin = end = cnt = 0;
		shanghai = new SimpleIntegerProperty(1);


	}
	public void set_zuobiao(int x,int y)//�ı�ͼƬ����
	{
		this.setTranslateX(x);
		this.setTranslateY(y);
	}
}
