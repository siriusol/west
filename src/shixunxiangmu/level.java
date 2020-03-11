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
import java.util.ArrayList;
public class level extends Stage//关卡类
{
	Timeline animation = null;
	public zhangai[] zhang = new zhangai[18];//障碍物
	public other_thing[] others = new other_thing[10];//小兵
	public bing[] zbing = new bing[10];//冰
	public huo[] zhuo = new huo[10];//火
	public du[] zdu = new du[10];//毒
	public buttlet[] but = new buttlet[40];//怪物子弹
	public int begin,end;//怪物子弹坐标
	public yuancheng p1;//远程人物
	
	public jincheng p2;//近程人物
	
	//道具
	public xued[] xue = new xued[20];
	public land[] lan = new land[20];
	public gongd[] gongplus= new gongd[20];

	public double xnow,ynow;
	
	public boss boss1;
	public boss_2 boss2;
	xin xinzang;
	public int butbeginshijian = 0;
	public int butbeginlast=-1;
	public int butcntshijian = 0;
	//怪物出现效果
	public int[] chuguai = new int[10];
	public ImageView[] chu = new ImageView[10];
	public boolean canchu = true;
	
	public boolean[] gong = new boolean[10];//怪物是否是攻击状态
	//怪物子弹缓存
	int[] list = new int[10];
	int[] butlist = new int[10];
	int[] whoattack = new int[10];
	int index = 0;
	int butcnt = 0;//子弹数量
	
	public Image imagebj;
	public ImageView imagevbj;//关卡背景图像
	public Pane mainpane;//关卡的主界面布局
	public level()
	{
		this.setWidth(1280);
		this.setHeight(760);
		this.setResizable(false);
	}
}
