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
public class level extends Stage//�ؿ���
{
	Timeline animation = null;
	public zhangai[] zhang = new zhangai[18];//�ϰ���
	public other_thing[] others = new other_thing[10];//С��
	public bing[] zbing = new bing[10];//��
	public huo[] zhuo = new huo[10];//��
	public du[] zdu = new du[10];//��
	public buttlet[] but = new buttlet[40];//�����ӵ�
	public int begin,end;//�����ӵ�����
	public yuancheng p1;//Զ������
	
	public jincheng p2;//��������
	
	//����
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
	//�������Ч��
	public int[] chuguai = new int[10];
	public ImageView[] chu = new ImageView[10];
	public boolean canchu = true;
	
	public boolean[] gong = new boolean[10];//�����Ƿ��ǹ���״̬
	//�����ӵ�����
	int[] list = new int[10];
	int[] butlist = new int[10];
	int[] whoattack = new int[10];
	int index = 0;
	int butcnt = 0;//�ӵ�����
	
	public Image imagebj;
	public ImageView imagevbj;//�ؿ�����ͼ��
	public Pane mainpane;//�ؿ��������沼��
	public level()
	{
		this.setWidth(1280);
		this.setHeight(760);
		this.setResizable(false);
	}
}
