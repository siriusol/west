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

public class our_thing extends main_thing
{
	public int buti = 0;//��boss��������
	public int jump = 0,jump_2 = 0;//��Ծ״̬,0û��,1һ����,2������
	public int high = 150,high1,high2;//��Ծ�߶ȣ�һ����ʣ��߶�,������ʣ��߶�
	public int flagjump = 0;//�������Ķ�̬Ч��ͼ���л�
	boolean flag1 = false,flag2 = false,flag1_2 = false,flag2_2 = false;//�Ƿ���û����һ������˲�䣬һ��������������˲��
	boolean flagbut = false,flagbut_2 = false;//�Ƿ������ӵ�
	public boolean press_right = false,press_left = false,press_right_2 = false,press_left_2 = false;//���Ұ���
	public boolean press_U = false,press_L = false,press_U_2 = false,press_L_2 = false;
	public boolean press_W = false,press_S = false,press_space = false,press_W_2 = false,press_S_2 = false,press_space_2 = false;
	public int attack_U = 0,attack_L = 0;//���ܶ�̬Ч��
	public int cnt_U = 0,cnt_L = 0,cnt_W=0,cnt_S=0;//������ȴʱ��
	public int flagr = 1,flagr_2 = 1;//��һ�ΰ�ʲô����2����1,���������ڵĳ���
	public boolean flagb = false;//��Ҷ��Ƿ��±����ƶ�
	int attack = 0;
	int be_attack = 0;
	public int blood,lan,nu=0;//����Ѫ��,��
	public Image image;
	public ImageView imagev;
	public our_thing()
	{
		super();
	}
	public our_thing(String s,level lev)
	{
		
		image = new Image(s);
		imagev = new ImageView(image);
		this.getChildren().add(imagev);
		
		//�����¼�
		this.setOnKeyPressed(e->
		{
			if(e.getCode() == KeyCode.J&&attack == 0 && attack_U == 0 && attack_L == 0)
			{
					flagbut = true;
			}
			else if(e.getCode() == KeyCode.A&&attack == 0 && attack_U == 0 && attack_L == 0)
			{
				press_left = true;
				flagr = 2;
			}
			else if(e.getCode() == KeyCode.D && attack == 0 && attack_U == 0 && attack_L == 0)
			{
				press_right = true;
				flagr = 1;
			}
			else if(e.getCode() == KeyCode.K && attack == 0 && attack_U == 0 && attack_L == 0)
			{
				if(jump == 0)
				{
					jump = 1;
					flag1 = false;
				}
				else if(jump == 1)
				{
					jump = 2;
					flag2 = false;
				}
			}
			else if(e.getCode() == KeyCode.SPACE && attack == 0 && attack_U == 0 && attack_L == 0)
			{
				press_space = true;
			}
			else if(e.getCode() == KeyCode.W && attack == 0 && attack_U == 0 && attack_L == 0)
			{
				press_W = true;
			}
			else if(e.getCode() == KeyCode.S && attack == 0 && attack_U == 0 && attack_L == 0)
			{
				press_S = true;
			}
			else if(e.getCode() == KeyCode.L&&attack == 0 && attack_U == 0 && attack_L == 0&&cnt_L==0&& lan >=50)
			{
					press_L = true;
			}
			else if(e.getCode() == KeyCode.U&&attack == 0 && attack_U == 0 && attack_L == 0&& lan >=50&&cnt_U ==0)
			{
					press_U = true;
			}
			
			
			//�����
			if(e.getCode() == KeyCode.NUMPAD1&&lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0)
			{
					lev.p2.flagbut_2 = true;
			}
			else if(e.getCode() == KeyCode.LEFT&&lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0)
			{
				lev.p2.press_left_2 = true;
				lev.p2.flagr_2 = 2;
			}
			else if(e.getCode() == KeyCode.RIGHT && lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0)
			{
				lev.p2.press_right_2 = true;
				lev.p2.flagr_2 = 1;
			}
			else if(e.getCode() == KeyCode.NUMPAD2 && lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0)
			{
				if(lev.p2.jump_2 == 0)
				{
					lev.p2.jump_2 = 1;
					lev.p2.flag1_2 = false;
				}
				else if(lev.p2.jump_2 == 1)
				{
					lev.p2.jump_2 = 2;
					lev.p2.flag2_2 = false;
				}
			}
			else if(e.getCode() == KeyCode.NUMPAD0 && lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0)
			{
				lev.p2.press_space_2 = true;
			}
			else if(e.getCode() == KeyCode.UP && lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0)
			{
				lev.p2.press_W_2 = true;
			}
			else if(e.getCode() == KeyCode.DOWN && lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0)
			{
				lev.p2.press_S_2 = true;
			}
			else if(e.getCode() == KeyCode.NUMPAD3&&lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0&&lev.p2.cnt_L==0&& lev.p2.lan >=50)
			{
				lev.p2.press_L_2 = true;
			}
			else if(e.getCode() == KeyCode.NUMPAD4&&lev.p2.attack == 0 && lev.p2.attack_U == 0 && lev.p2.attack_L == 0&& lev.p2.lan >=50&&lev.p2.cnt_U ==0)
			{
				lev.p2.press_U_2 = true;
			}
		});
		this.setOnKeyReleased(e->
		{
			switch (e.getCode())
			{
			case A: press_left = false;break;
			case D: press_right = false;break;
			case J: flagbut = false;break;
			case U: press_U = false;break;
			case L: press_L = false;break;
			case W: press_W = false;break;
			case S: press_S = false;break;
			case SPACE:press_space = false;break;
			
			case LEFT: lev.p2.press_left_2 = false;break;
			case RIGHT: lev.p2.press_right_2 = false;break;
			case NUMPAD1: lev.p2.flagbut_2 = false;break;
			case NUMPAD4: lev.p2.press_U_2 = false;break;
			case NUMPAD3: lev.p2.press_L_2 = false;break;
			case UP: lev.p2.press_W_2 = false;break;
			case DOWN: lev.p2.press_S_2 = false;break;
			case NUMPAD0:lev.p2.press_space_2 = false;break;
			default:
			}
		}
		);
		
		//��������̬Ч��
		EventHandler<ActionEvent> eventHandler1 = e->{
		if(this instanceof yuancheng)
		{
			if(flagjump == 1)
			{
				if(flagr == 1)
    				set_image("image/ertiao2_you.png",this instanceof yuancheng);
    			else
    				set_image("image/ertiao2_zuo.png",this instanceof yuancheng);
    			++flagjump;
			}
			else if(flagjump == 2)
			{
				if(flagr == 1)
    				set_image("image/ertiao3_you.png",this 
    						instanceof yuancheng);
    			else
    				set_image("image/ertiao3_zuo.png",this instanceof yuancheng);
    			++flagjump;
			}
			else if(flagjump == 3)
			{
				if(flagr == 1)
    				set_image("image/yitiao_you.png",this instanceof yuancheng);
    			else
    				set_image("image/yitiao_zuo.png",this instanceof yuancheng);
    			flagjump=0;
			}
		}
		else
		{
			////
			if(flagjump == 1)
			{
				if(lev.p2.flagr_2 == 1)
    				set_image("image/ertiao2_you.png",this instanceof yuancheng);
    			else
    				set_image("image/ertiao2_zuo.png",this instanceof yuancheng);
    			++flagjump;
			}
			else if(flagjump == 2)
			{
				if(lev.p2.flagr_2 == 1)
    				set_image("image/ertiao3_you.png",this instanceof yuancheng);
    			else
    				set_image("image/ertiao3_zuo.png",this instanceof yuancheng);
    			++flagjump;
			}
			else if(flagjump == 3)
			{
				if(lev.p2.flagr_2 == 1)
    				set_image("image/yitiao_you.png",this instanceof yuancheng);
    			else
    				set_image("image/yitiao_zuo.png",this instanceof yuancheng);
    			flagjump=0;
			}
		}
		};
		
		
		EventHandler<ActionEvent> eventHandler = e->{
			//System.out.println(lev.p2.press_L_2);
	if(this != null && this instanceof yuancheng)//Զ������
	{
			//System.out.println(nu);
			if(attack != 0)
				attack = (attack+1)%20;
			if(attack_U != 0)
				++attack_U;
			if(attack_L != 0)
				++attack_L;
			if(lev.p1.cntbut_L != 0)
				++lev.p1.cntbut_L;
			if(lev.p1.cntbut_U != 0)
				++lev.p1.cntbut_U;
			//ŭ���ͷ�
			if(this.nu>=2000&&press_space)
			{
				lev.p1.nu = 0;
				press_space = false;
				for(int i = 1;i <= 7;++i)
				{
					lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"image/bullet_you.png",lev.p1);
					lev.p1.but1[lev.p1.end1].set_zuobiao(0,i*100);
					lev.p1.but1[lev.p1.end1].dir = 1;
					lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
					//��ǰ�ӵ��±����
					++lev.p1.end1;
					if(lev.p1.end1 == lev.p1.but1.length)
						lev.p1.end1 = 0;
				}
				for(int i = 1;i <= 7;++i)
				{
					lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"image/bullet_zuo.png",lev.p1);
					lev.p1.but1[lev.p1.end1].set_zuobiao(1170,i*100);
					//System.out.println(1);
					lev.p1.but1[lev.p1.end1].dir = 2;
					lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
					//��ǰ�ӵ��±����
					++lev.p1.end1;
					if(lev.p1.end1 == lev.p1.but1.length)
						lev.p1.end1 = 0;
				}
			}
			//����L���ͷ�
			if(attack_L < 100 && attack_L != 0)
			{
				if(lev.p1.cntbut_L % 10 == 0)
				{
					if(lev.p1.flagr == 1 || press_right)//��������
					{
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"image/bullet_you.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()+lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY() + lev.p1.widthProperty().doubleValue()/2));
						lev.p1.but1[lev.p1.end1].dir = 1;//�ӵ�����
					}
					else//��������
					{
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"image/bullet_zuo.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX() + lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY() + lev.p1.widthProperty().doubleValue()/2));
						lev.p1.but1[lev.p1.end1].dir = 2;
					}
					lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
					//��ǰ�ӵ��±����
					++lev.p1.end1;
					if(lev.p1.end1 == lev.p1.but1.length)
						lev.p1.end1 = 0;
				}
			}
			else if(attack_L == 50)
			{
				//System.out.println(2);
				if(flagr == 1 || press_right)
					lev.p1.set_image("image/ji12_you.png",this instanceof yuancheng);
				else
					lev.p1.set_image("image/ji12_zuo.png",this instanceof yuancheng);
			}
			else if(attack_L == 100)
			{
				//System.out.println(3);
				attack_L = 0;
				lev.p1.cntbut_L = 0;
				if(jump != 0)
				{
					if(flagr == 1 || press_right)
						set_image("image/yitiao_you.png",this instanceof yuancheng);
					else
						set_image("image/yitiao_zuo.png",this instanceof yuancheng);
				}
			}
			//����U���ͷ�
			
			if(attack_U == 10)
			{
				//System.out.println(2);
				if(flagr == 1 || press_right)
					lev.p1.set_image("image/ji27.png",this instanceof yuancheng);
				else
					lev.p1.set_image("image/ji22.png",this instanceof yuancheng);
			}
			else if(attack_U == 20)
			{
				//System.out.println(3);
				if(flagr == 1 || press_right)
					lev.p1.set_image("image/ji28.png",this instanceof yuancheng);
				else
					lev.p1.set_image("image/ji23.png",this instanceof yuancheng);
			}
			else if(attack_U == 30)
			{
				//System.out.println(3);
				if(flagr == 1 || press_right)
					lev.p1.set_image("image/ji24.png",this instanceof yuancheng);
				else
					lev.p1.set_image("image/ji24.png",this instanceof yuancheng);
			}
			else if(attack_U == 40)
			{
				//System.out.println(3);
				if(flagr == 1 || press_right)
					lev.p1.set_image("image/ji25.png",this instanceof yuancheng);
				else
					lev.p1.set_image("image/ji25.png",this instanceof yuancheng);
			}
			else if(attack_U == 50)
			{
				//System.out.println(3);
				if(flagr == 1 || press_right)
					lev.p1.set_image("image/ji22.png",this instanceof yuancheng);
				else
					lev.p1.set_image("image/ji27.png",this instanceof yuancheng);
			}
			else if(attack_U == 60)
			{
				//System.out.println(3);
				if(flagr == 1 || press_right)
					lev.p1.set_image("image/ji23.png",this instanceof yuancheng);
				else
					lev.p1.set_image("image/ji28.png",this instanceof yuancheng);
			}
			else if(attack_U == 70)
			{
				//System.out.println(3);
				attack_U = 0;
				lev.p1.cntbut_U = 0;
				if(jump != 0)
				{
					if(flagr == 1 || press_right)
						set_image("image/yitiao_you.png",this instanceof yuancheng);
					else
						set_image("image/yitiao_zuo.png",this instanceof yuancheng);
				}
				if(flagr == 1 || press_right)
				{
					flagr = 2;
					press_right = false;
				}
				else
					flagr = 1;
			}
			else if(attack_U < 40 && attack_U != 0)
			{
				if(lev.p1.cntbut_U % 5 == 0)
				{
					if(lev.p1.flagr == 1 || press_right)//��������
					{
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/you2.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()+lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY() + lev.p1.widthProperty().doubleValue()/2));
						lev.p1.but1[lev.p1.end1].dir = 5;//�ӵ�������
					}
					else//��������
					{
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/you1.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX() + lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY() + lev.p1.widthProperty().doubleValue()/2));
						lev.p1.but1[lev.p1.end1].dir = 6;
					}
					lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
					//��ǰ�ӵ��±����
					++lev.p1.end1;
					if(lev.p1.end1 == lev.p1.but1.length)
						lev.p1.end1 = 0;
				}
			}
			else if(attack_U > 40)
			{
				if(lev.p1.cntbut_U % 5 == 0)
				{
					if(lev.p1.flagr == 1 || press_right)
					{
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/you1.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX() + lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY() + lev.p1.widthProperty().doubleValue()/2));
						lev.p1.but1[lev.p1.end1].dir = 6;
					}
					else
					{
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/you2.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()+lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY() + lev.p1.widthProperty().doubleValue()/2));
						lev.p1.but1[lev.p1.end1].dir = 5;//�ӵ�������
					}
					lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
					//��ǰ�ӵ��±����
					++lev.p1.end1;
					if(lev.p1.end1 == lev.p1.but1.length)
						lev.p1.end1 = 0;
				}
			}
			
			if(be_attack == 0)
			{
				//���＼��
				if(press_L && attack == 0 && attack_U == 0 && attack_L == 0)
				{
					press_L = false;
					attack_L = 1;
					lev.p1.cntbut_L = 1;
					lev.p1.cnt_L = 1;
					lan -= 50;
					if(flagr == 1||press_right)
						lev.p1.set_image("image/ji11_you.png",this instanceof yuancheng);
					else
						lev.p1.set_image("image/ji11_zuo.png",this instanceof yuancheng);
				}
				else if(press_U && attack == 0 && attack_U == 0 && attack_L == 0)
				{
					press_U = false;
					//System.out.println(1);
					attack_U = 1;
					lev.p1.cntbut_U = 1;
					lev.p1.cnt_U = 1;
					lan -= 50;
					if(flagr == 1||press_right)
						lev.p1.set_image("image/ji26.png",this instanceof yuancheng);
					else
						lev.p1.set_image("image/ji21.png",this instanceof yuancheng);
					if(lev.p1.getTranslateY()-200>0)
						lev.p1.set_zuobiao((int)lev.p1.getTranslateX(), (int)lev.p1.getTranslateY()-200);
					else
						lev.p1.set_zuobiao((int)lev.p1.getTranslateX(), 0);
				}
				
				//�����ӵ�����
				if(flagbut)
				{
					if(press_W&&lev.p1.cnt_W==0)
					{
						lev.p1.cnt_W = 1;//�ӵ�������ȴ״̬
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/shang.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()),(int)(lev.p1.getTranslateY()));
						lev.p1.but1[lev.p1.end1].dir = 3;
						lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
						//��ǰ�ӵ��±����
						++lev.p1.end1;
						if(lev.p1.end1 == lev.p1.but1.length)
							lev.p1.end1 = 0;
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/shang.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()+lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY()));
						lev.p1.but1[lev.p1.end1].dir = 3;
						lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
						//��ǰ�ӵ��±����
						++lev.p1.end1;
						if(lev.p1.end1 == lev.p1.but1.length)
							lev.p1.end1 = 0;
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/shang.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()+lev.p1.widthProperty().doubleValue()),(int)(lev.p1.getTranslateY()));
						lev.p1.but1[lev.p1.end1].dir = 3;
						lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
						//��ǰ�ӵ��±����
						++lev.p1.end1;
						if(lev.p1.end1 == lev.p1.but1.length)
							lev.p1.end1 = 0;
					}
					if(press_S&&lev.p1.cnt_S==0)
					{
						lev.p1.cnt_S = 1;//�ӵ�������ȴ״̬
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/xia.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()),(int)(lev.p1.getTranslateY()));
						lev.p1.but1[lev.p1.end1].dir = 4;
						lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
						//��ǰ�ӵ��±����
						++lev.p1.end1;
						if(lev.p1.end1 == lev.p1.but1.length)
							lev.p1.end1 = 0;
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/xia.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()+lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY()));
						lev.p1.but1[lev.p1.end1].dir = 4;
						lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
						//��ǰ�ӵ��±����
						++lev.p1.end1;
						if(lev.p1.end1 == lev.p1.but1.length)
							lev.p1.end1 = 0;
						lev.p1.but1[lev.p1.end1] = new buttlet(lev.p1.shanghai,"1image/xia.png",lev.p1);
						lev.p1.but1[lev.p1.end1].set_zuobiao((int)(lev.p1.getTranslateX()+lev.p1.widthProperty().doubleValue()),(int)(lev.p1.getTranslateY()));
						lev.p1.but1[lev.p1.end1].dir = 4;
						lev.mainpane.getChildren().add(lev.p1.but1[lev.p1.end1]);
						//��ǰ�ӵ��±����
						++lev.p1.end1;
						if(lev.p1.end1 == lev.p1.but1.length)
							lev.p1.end1 = 0;
					}
					else if(lev.p1.cnt == 0)//������ڿ��Է����ӵ�,���ӵ���ȴʱ���Ѿ���ȥ
					{
						attack = 1;
						if(lev.p1.flagr == 1 || press_right)//��������
						{
							lev.p1.but[lev.p1.end] = new buttlet(lev.p1.shanghai,"image/bullet_you.png",lev.p1);
							lev.p1.but[lev.p1.end].set_zuobiao((int)(lev.p1.getTranslateX()+lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY() + lev.p1.widthProperty().doubleValue()/2));
							lev.p1.but[lev.p1.end].dir = 1;//�ӵ�����
							lev.p1.set_image("image/attack_you.png", this instanceof yuancheng);
						}
						else//��������
						{
							lev.p1.but[lev.p1.end] = new buttlet(lev.p1.shanghai,"image/bullet_zuo.png",lev.p1);
							lev.p1.but[lev.p1.end].set_zuobiao((int)(lev.p1.getTranslateX() + lev.p1.widthProperty().doubleValue()/2),(int)(lev.p1.getTranslateY() + lev.p1.widthProperty().doubleValue()/2));
							lev.p1.but[lev.p1.end].dir = 2;
							lev.p1.set_image("image/attack_zuo.png", this instanceof yuancheng);
						}
						lev.mainpane.getChildren().add(lev.p1.but[lev.p1.end]);
						//��ǰ�ӵ��±����
						++lev.p1.end;
						if(lev.p1.end == lev.p1.but.length)
							lev.p1.end = 0;
						lev.p1.cnt = 1;//�ӵ�������ȴ״̬
					}
				}
			if(attack == 0 && attack_U == 0 && attack_L == 0)
			{
				
				if(press_right)
				{
					if(jump == 0)
						set_image("image/pao_you.png",this instanceof yuancheng);
					if(this.getTranslateX() > 640 && lev.imagevbj.getTranslateX() > -6900)//�����ƶ�
					{
						//System.out.println(flagb);
						if(!flagb)
						{
							
							lev.imagevbj.setTranslateX(lev.imagevbj.getTranslateX() - 3);
							for(int i = 0;i < lev.zhang.length;++i)
								if(lev.zhang[i] != null)
									lev.zhang[i].setTranslateX(lev.zhang[i].getTranslateX() - 3);
							for(int i = 0;i < lev.xue.length;++i)
							{
								if(lev.xue[i] != null)
								{
									lev.xue[i].setTranslateX(lev.xue[i].getTranslateX() - 3);
								}
							}
							for(int i = 0;i < lev.lan.length;++i)
							{
								if(lev.lan[i] != null)
								{
									lev.lan[i].setTranslateX(lev.lan[i].getTranslateX() - 3);
								}
							}
							for(int i = 0;i < lev.gongplus.length;++i)
							{
								if(lev.gongplus[i] != null)
								{
									lev.gongplus[i].setTranslateX(lev.gongplus[i].getTranslateX() - 3);
								}
							}
						}
							/*
						boolean flag3 = false;
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								if(zhangai.crash(this,lev.zhang[i],(int)this.widthProperty().doubleValue(),0,1))
									flag3 = true;
						if(flag3)
						{
							lev.imagevbj.setTranslateX(lev.imagevbj.getTranslateX() + 3);
							for(int i = 0;i < lev.zhang.length;++i)
								if(lev.zhang[i] != null)
									lev.zhang[i].setTranslateX(lev.zhang[i].getTranslateX() + 3);
						}
						*/
					}
					else//�����ƶ�
					{
						this.setTranslateX(this.getTranslateX() + 3);
						boolean flag3 = false;
						/*
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								if(zhangai.crash(this,lev.zhang[i],(int)this.widthProperty().doubleValue(),0,1))
									flag3 = true;*/
						if(this.getTranslateX() + this.widthProperty().doubleValue()>= 1280)
						{
							flag3 = true;
						}
						if(flag3)
							this.setTranslateX(this.getTranslateX() - 3);
					}
				}
			
				//����Ч��
				else if(press_left)
				{
					if(jump == 0)
						set_image("image/pao_zuo.png",this instanceof yuancheng);
					this.setTranslateX(this.getTranslateX() - 3);
					
					boolean flag3 = false;
					/*
					//���Ʒ�����ײ
					for(int i = 0;i < lev.zhang.length;++i)
						if(lev.zhang[i] != null)
							if(zhangai.crash(this, lev.zhang[i], 0, (int) lev.zhang[i].widthProperty().doubleValue(), 1))
								flag3 = true;*/
					if(this.getTranslateX()<0)
						flag3 = true;
					if(flag3)
						this.setTranslateX(this.getTranslateX() + 3);
						
				}
			
		    
		    
				//�������ƶ�������Ծͼ��仯
				else if(!press_right && !press_left && jump == 0)
				{
					if(flagr == 1)
						set_image("image/zhanli_you.png",this instanceof yuancheng);
					else
						set_image("image/zhanli_zuo.png",this instanceof yuancheng);
				}
		    
				//һ����ͼ��仯��������������̬Ч������Ժ�
				if(jump != 0 && flagjump == 0)
				{
					if(flagr == 1||press_right)
						set_image("image/yitiao_you.png",this instanceof yuancheng);
					else
						set_image("image/yitiao_zuo.png",this instanceof yuancheng);
				}
			}
		}
				//һ����
				if(jump == 1)
				{
					if(attack == 0 && be_attack == 0 && attack_U == 0 && attack_L == 0)
					{
						if(flagr == 1 || press_right)
							set_image("image/yitiao_you.png",this instanceof yuancheng);
						else
							set_image("image/yitiao_zuo.png",this instanceof yuancheng);
					}
		    	
					if(!flag1)//�仯˲��
					{
						high1 = high;
						flag1 = true;
						high1 -= 4;
						this.setTranslateY(this.getTranslateY() - 4);
						boolean flag3 = false;
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								if(zhangai.crash(this,lev.zhang[i],0,(int)lev.zhang[i].heightProperty().doubleValue(),2))
									flag3 = true;
						if(flag3)
						{
							//high1 = 0;
							//this.setTranslateY(this.getTranslateY() + 4);
						}
					}
					else
					{
						if(high1 > 0)
						{
							high1 -= 4;
							this.setTranslateY(this.getTranslateY() - 4);
							boolean flag3 = false;
							for(int i = 0;i < lev.zhang.length;++i)
								if(lev.zhang[i] != null)
									if(zhangai.crash(this,lev.zhang[i],0,(int)lev.zhang[i].heightProperty().doubleValue(),2))
										flag3 = true;
							if(flag3)
							{
								//high1 = 0;
								//this.setTranslateY(this.getTranslateY() + 4);
							}
						}
					}
				}
				else if(jump == 2)//������
				{
					if(!flag2)//�仯˲��
					{
						if(flagjump == 0 && attack == 0 && be_attack == 0 && attack_U == 0 && attack_L == 0)
						{
							if(flagr == 1||press_right)
								set_image("image/ertiao1_you.png",this instanceof yuancheng);
							else
								set_image("image/ertiao1_zuo.png",this instanceof yuancheng);
							//����ͼ��仯
							++flagjump;
							Timeline animation1 = new Timeline(new KeyFrame(Duration.millis(100),eventHandler1));
							animation1.setCycleCount(3);
							animation1.play();
						}
		    		
						if(high1 >= 0)
						{
							high2 = high + high1;
						}
						else
						{
							high2 = high;
						}
						flag2 = true;
						high2 -= 4;
						this.setTranslateY(this.getTranslateY() - 4);
						boolean flag3 = false;
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								if(zhangai.crash(this,lev.zhang[i],0,(int)lev.zhang[i].heightProperty().doubleValue(),2))
									flag3 = true;
						if(flag3)
						{
							//high2 = 0;
							//this.setTranslateY(this.getTranslateY() + 4);
						}
					}
					else
					{
						if(high2 > 0)
						{
							high2 -= 4;
							this.setTranslateY(this.getTranslateY() - 4);
							boolean flag3 = false;
							for(int i = 0;i < lev.zhang.length;++i)
								if(lev.zhang[i] != null)
									if(zhangai.crash(this,lev.zhang[i],0,(int)lev.zhang[i].heightProperty().doubleValue(),2))
										flag3 = true;
							if(flag3)
							{
								//high2 = 0;
								//this.setTranslateY(this.getTranslateY() + 4);
							}
						}
					}
		    }
		    //��������
			if(attack_L == 0 && attack_U == 0)
			{
		    boolean flag3 = false;
		    for(int i = 0;i < lev.zhang.length;++i)
	    		if(lev.zhang[i] != null)
	    			if(zhangai.crash(this,lev.zhang[i],(int)this.heightProperty().doubleValue(),0,2))
	    				flag3 = true;
		    if(!flag3 && (jump == 1 && high1 <= 0 || jump == 2 && high2 <= 0 || jump == 0))
		    {
		    	this.setTranslateY(this.getTranslateY() + 4);
		    	if(flag3)
	    		{
	    			jump = 0;
	    			this.setTranslateY(this.getTranslateY() - 4);
	    		}
		    }
		    else if(flag3)
    		{
    			jump = 0;
    		}
		    for(int i = 0;i < lev.zhang.length;++i)
		    	if(this != null && lev.zhang[i]!=null)
		    		zhangai.go_back(this, lev.zhang[i]);
			}
	}
	
	
	
	//��������
	else if(this != null)
	{
		if(attack != 0)
			attack = (attack+1)%20;
		if(attack_U != 0)
			++attack_U;
		if(attack_L != 0)
			++attack_L;
		if(lev.p2.cntbut_L != 0)
			++lev.p2.cntbut_L;
		if(lev.p2.cntbut_U != 0)
			++lev.p2.cntbut_U;
		//ŭ���ͷ�
		/*
		if(this.nu>=2000&&press_space_2)
		{
			lev.p2.nu = 0;
			for(int i = 1;i <= 7;++i)
			{
				lev.p2.but1[lev.p2.end1] = new buttlet(lev.p2.shanghai,"image/bullet_you.png",lev.p2);
				lev.p2.but1[lev.p2.end1].set_zuobiao(0,i*100);
				lev.p2.but1[lev.p2.end1].dir = 1;
				lev.mainpane.getChildren().add(lev.p2.but1[lev.p2.end1]);
				//��ǰ�ӵ��±����
				++lev.p2.end1;
				if(lev.p2.end1 == lev.p2.but1.length)
					lev.p2.end1 = 0;
			}
			for(int i = 1;i <= 7;++i)
			{
				lev.p2.but1[lev.p2.end1] = new buttlet(lev.p2.shanghai,"image/bullet_zuo.png",lev.p2);
				lev.p2.but1[lev.p2.end1].set_zuobiao(1170,i*100);
				//System.out.println(1);
				lev.p2.but1[lev.p2.end1].dir = 2;
				lev.mainpane.getChildren().add(lev.p2.but1[lev.p2.end1]);
				//��ǰ�ӵ��±����
				++lev.p2.end1;
				if(lev.p2.end1 == lev.p2.but1.length)
					lev.p2.end1 = 0;
			}
		}*/
		
		//����L���ͷ�
		if(attack_L == 30)
		{
				if(lev.p2.flagr_2 == 1 || press_right_2)//��������
				{
					lev.p2.set_image("image/ji12_you.png", this instanceof yuancheng);
				}
				else//��������
				{
					lev.p2.set_image("image/ji12_zuo.png", this instanceof yuancheng);
				}
		}
		else if(attack_L > 30 && attack_L < 70)
		{
			if(lev.p2.flagr_2 == 1 || press_right_2)//��������
			{
				
				double x = this.getTranslateX() + 12;
				if(this.getTranslateX() <= 640 && x<=640)
					lev.p2.setTranslateX(x);
				else if(this.getTranslateX() <= 640 && x>640)
				{
					if(lev.imagevbj.getTranslateX() > -6900)
					{
						double dx = 640 - this.getTranslateX();
						lev.p2.setTranslateX(this.getTranslateX() + dx);
						lev.imagevbj.setTranslateX(lev.imagevbj.getTranslateX() - (12-dx));
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								lev.zhang[i].setTranslateX(lev.zhang[i].getTranslateX() - (12-dx));
						for(int i = 0;i < lev.xue.length;++i)
						{
							if(lev.xue[i] != null)
							{
								lev.xue[i].setTranslateX(lev.xue[i].getTranslateX() - (12-dx));
							}
						}
						for(int i = 0;i < lev.lan.length;++i)
						{
							if(lev.lan[i] != null)
							{
								lev.lan[i].setTranslateX(lev.lan[i].getTranslateX() - (12-dx));
							}
						}
						for(int i = 0;i < lev.gongplus.length;++i)
						{
							if(lev.gongplus[i] != null)
							{
								lev.gongplus[i].setTranslateX(lev.gongplus[i].getTranslateX() - (12-dx));
							}
						}
					}
					else
					{
						if(x + this.widthProperty().doubleValue() < 1280)
							lev.p2.setTranslateX(x);
						else
						{
							lev.p2.setTranslateX(1280-this.widthProperty().doubleValue());
						}
					}
				}
				else
				{
					if(lev.imagevbj.getTranslateX() > -6900)
					{
						lev.imagevbj.setTranslateX(lev.imagevbj.getTranslateX() - 12);
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								lev.zhang[i].setTranslateX(lev.zhang[i].getTranslateX() - 12);
						for(int i = 0;i < lev.xue.length;++i)
						{
							if(lev.xue[i] != null)
							{
								lev.xue[i].setTranslateX(lev.xue[i].getTranslateX() - 12);
							}
						}
						for(int i = 0;i < lev.lan.length;++i)
						{
							if(lev.lan[i] != null)
							{
								lev.lan[i].setTranslateX(lev.lan[i].getTranslateX() - 12);
							}
						}
						for(int i = 0;i < lev.gongplus.length;++i)
						{
							if(lev.gongplus[i] != null)
							{
								lev.gongplus[i].setTranslateX(lev.gongplus[i].getTranslateX() - 12);
							}
						}
					}
					else
					{
						if(x + this.widthProperty().doubleValue() < 1280)
							lev.p2.setTranslateX(x);
						else
						{
							lev.p2.setTranslateX(1280-this.widthProperty().doubleValue());
						}
					}
				}
			}
			else//��������
			{
				double x = this.getTranslateX() - 12;
				if(x > 0)
					lev.p2.setTranslateX(x);
				else
					lev.p2.setTranslateX(0);
			}
		}
		else if(attack_L == 70)
		{
			attack_L = 0;
			lev.p2.setTranslateY(lev.p2.getTranslateY()-17);
		}
		
		//����U���ͷ�
		
		if(attack_U == 10)
		{
			//System.out.println(2);
			lev.p2.setTranslateY(lev.p2.getTranslateY()-58);
			if(flagr_2 == 1 || press_right_2)
				lev.p2.set_image("image/ji22_you.png",this instanceof yuancheng);
			else
				lev.p2.set_image("image/ji22_zuo.png",this instanceof yuancheng);
		}
		else if(attack_U == 20)
		{
			//System.out.println(3);
			lev.p2.setTranslateY(lev.p2.getTranslateY()-14);
			if(flagr_2 == 1 || press_right_2)
				lev.p2.set_image("image/ji23_you.png",this instanceof yuancheng);
			else
				lev.p2.set_image("image/ji23_zuo.png",this instanceof yuancheng);
		}
		else if(attack_U == 30)
		{
			lev.p2.setTranslateY(lev.p2.getTranslateY()+89);
			attack_U = 0;
		}
		
		if(be_attack == 0)
		{
			//���＼��
			
			if(press_L_2 && attack == 0 && attack_U == 0 && attack_L == 0)
			{
				lev.p2.attack_L = 1;
				lev.p2.press_L_2 = false;
				lev.p2.cntbut_L = 1;
				lev.p2.cnt_L = 1;
				lan -= 50;
				if(flagr_2 == 1||press_right_2)
					lev.p2.set_image("image/ji11_you.png",this instanceof yuancheng);
				else
					lev.p2.set_image("image/ji11_zuo.png",this instanceof yuancheng);
			}
			
			else if(press_U_2 && attack == 0 && attack_U == 0 && attack_L == 0)
			{
				lev.p2.attack_U = 1;
				lev.p2.press_U_2 = false;
				lev.p2.cntbut_U = 1;
				lev.p2.cnt_U = 1;
				lan -= 50;
				lev.p2.setTranslateY(lev.p2.getTranslateY()-17);
				if(flagr_2 == 1||press_right_2)
					lev.p2.set_image("image/ji21_you.png",this instanceof yuancheng);
				else
					lev.p2.set_image("image/ji21_zuo.png",this instanceof yuancheng);
			}
			
			//������ͨ����
			if(flagbut_2)
			{
				/*
				if(press_W_2&&lev.p2.cnt_W==0)
				{
					lev.p2.cnt_W = 1;//�ӵ�������ȴ״̬
					lev.p2.but1[lev.p2.end1] = new buttlet(lev.p2.shanghai,"1image/shang.png",lev.p2);
					lev.p2.but1[lev.p2.end1].set_zuobiao((int)(lev.p2.getTranslateX()),(int)(lev.p2.getTranslateY()));
					lev.p2.but1[lev.p2.end1].dir = 3;
					lev.mainpane.getChildren().add(lev.p2.but1[lev.p2.end1]);
					//��ǰ�ӵ��±����
					++lev.p2.end1;
					if(lev.p2.end1 == lev.p2.but1.length)
						lev.p2.end1 = 0;
					lev.p2.but1[lev.p2.end1] = new buttlet(lev.p2.shanghai,"1image/shang.png",lev.p2);
					lev.p2.but1[lev.p2.end1].set_zuobiao((int)(lev.p2.getTranslateX()+lev.p2.widthProperty().doubleValue()/2),(int)(lev.p2.getTranslateY()));
					lev.p2.but1[lev.p2.end1].dir = 3;
					lev.mainpane.getChildren().add(lev.p2.but1[lev.p2.end1]);
					//��ǰ�ӵ��±����
					++lev.p2.end1;
					if(lev.p2.end1 == lev.p2.but1.length)
						lev.p2.end1 = 0;
					lev.p2.but1[lev.p2.end1] = new buttlet(lev.p2.shanghai,"1image/shang.png",lev.p2);
					lev.p2.but1[lev.p2.end1].set_zuobiao((int)(lev.p2.getTranslateX()+lev.p2.widthProperty().doubleValue()),(int)(lev.p2.getTranslateY()));
					lev.p2.but1[lev.p2.end1].dir = 3;
					lev.mainpane.getChildren().add(lev.p2.but1[lev.p2.end1]);
					//��ǰ�ӵ��±����
					++lev.p2.end1;
					if(lev.p2.end1 == lev.p2.but1.length)
						lev.p2.end1 = 0;
				}
				if(press_S_2&&lev.p2.cnt_S==0)
				{
					lev.p2.cnt_S = 1;//�ӵ�������ȴ״̬
					lev.p2.but1[lev.p2.end1] = new buttlet(lev.p2.shanghai,"1image/xia.png",lev.p2);
					lev.p2.but1[lev.p2.end1].set_zuobiao((int)(lev.p2.getTranslateX()),(int)(lev.p2.getTranslateY()));
					lev.p2.but1[lev.p2.end1].dir = 4;
					lev.mainpane.getChildren().add(lev.p2.but1[lev.p2.end1]);
					//��ǰ�ӵ��±����
					++lev.p2.end1;
					if(lev.p2.end1 == lev.p2.but1.length)
						lev.p2.end1 = 0;
					lev.p2.but1[lev.p2.end1] = new buttlet(lev.p2.shanghai,"1image/xia.png",lev.p2);
					lev.p2.but1[lev.p2.end1].set_zuobiao((int)(lev.p2.getTranslateX()+lev.p2.widthProperty().doubleValue()/2),(int)(lev.p2.getTranslateY()));
					lev.p2.but1[lev.p2.end1].dir = 4;
					lev.mainpane.getChildren().add(lev.p2.but1[lev.p2.end1]);
					//��ǰ�ӵ��±����
					++lev.p2.end1;
					if(lev.p2.end1 == lev.p2.but1.length)
						lev.p2.end1 = 0;
					lev.p2.but1[lev.p2.end1] = new buttlet(lev.p2.shanghai,"1image/xia.png",lev.p2);
					lev.p2.but1[lev.p2.end1].set_zuobiao((int)(lev.p2.getTranslateX()+lev.p2.widthProperty().doubleValue()),(int)(lev.p2.getTranslateY()));
					lev.p2.but1[lev.p2.end1].dir = 4;
					lev.mainpane.getChildren().add(lev.p2.but1[lev.p2.end1]);
					//��ǰ�ӵ��±����
					++lev.p2.end1;
					if(lev.p2.end1 == lev.p2.but1.length)
						lev.p2.end1 = 0;
				}
				*/
				if(lev.p2.cnt == 0)//������ڿ��Է����ӵ�,���ӵ���ȴʱ���Ѿ���ȥ
				{
					attack = 1;
					if(lev.p2.flagr_2 == 1 || press_right_2)//��������
					{
						lev.p2.set_image("image/attack_you.png", this instanceof yuancheng);
					}
					else//��������
					{
						lev.p2.set_image("image/attack_zuo.png", this instanceof yuancheng);
					}
					lev.p2.cnt = 1;//�ӵ�������ȴ״̬
				}
			}
		if(attack == 0 && attack_U == 0 && attack_L == 0)
		{
			//����Ч��
			if(lev.p2.getTranslateX() > 640 && !lev.p2.press_right_2)
				lev.p1.flagb = false;
			//����Ч��
			if(press_right_2)
			{
				if(jump_2 == 0)
					set_image("image/pao_you.png",this instanceof yuancheng);
				if(this.getTranslateX() > 640 && lev.imagevbj.getTranslateX() > -6900)//�����ƶ�
				{
					lev.imagevbj.setTranslateX(lev.imagevbj.getTranslateX() - 3);
					lev.p1.flagb = true;
					for(int i = 0;i < lev.zhang.length;++i)
						if(lev.zhang[i] != null)
							lev.zhang[i].setTranslateX(lev.zhang[i].getTranslateX() - 3);
					for(int i = 0;i < lev.xue.length;++i)
					{
						if(lev.xue[i] != null)
						{
							lev.xue[i].setTranslateX(lev.xue[i].getTranslateX() - 3);
						}
					}
					for(int i = 0;i < lev.lan.length;++i)
					{
						if(lev.lan[i] != null)
						{
							lev.lan[i].setTranslateX(lev.lan[i].getTranslateX() - 3);
						}
					}
					for(int i = 0;i < lev.gongplus.length;++i)
					{
						if(lev.gongplus[i] != null)
						{
							lev.gongplus[i].setTranslateX(lev.gongplus[i].getTranslateX() - 3);
						}
					}
					/*
					boolean flag3 = false;
					for(int i = 0;i < lev.zhang.length;++i)
						if(lev.zhang[i] != null)
							if(zhangai.crash(this,lev.zhang[i],(int)this.widthProperty().doubleValue(),0,1))
								flag3 = true;
					if(flag3)
					{
						lev.imagevbj.setTranslateX(lev.imagevbj.getTranslateX() + 3);
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								lev.zhang[i].setTranslateX(lev.zhang[i].getTranslateX() + 3);
					}
					*/
				}
				else//�����ƶ�
				{
					lev.p1.flagb = false;
					this.setTranslateX(this.getTranslateX() + 3);
					boolean flag3 = false;
					/*
					for(int i = 0;i < lev.zhang.length;++i)
						if(lev.zhang[i] != null)
							if(zhangai.crash(this,lev.zhang[i],(int)this.widthProperty().doubleValue(),0,1))
								flag3 = true;*/
					if(this.getTranslateX() + this.widthProperty().doubleValue()>= 1280)
					{
						flag3 = true;
					}
					if(flag3)
						this.setTranslateX(this.getTranslateX() - 3);
				}
			}
		
			//����Ч��
			else if(press_left_2)
			{
				if(jump_2 == 0)
					set_image("image/pao_zuo.png",this instanceof yuancheng);
				this.setTranslateX(this.getTranslateX() - 3);
				
				boolean flag3 = false;
				/*
				//���Ʒ�����ײ
				for(int i = 0;i < lev.zhang.length;++i)
					if(lev.zhang[i] != null)
						if(zhangai.crash(this, lev.zhang[i], 0, (int) lev.zhang[i].widthProperty().doubleValue(), 1))
							flag3 = true;*/
				if(this.getTranslateX()<0)
					flag3 = true;
				if(flag3)
					this.setTranslateX(this.getTranslateX() + 3);
					
			}
		
	    
	    
			//�������ƶ�������Ծͼ��仯
			else if(!press_right_2 && !press_left_2 && jump_2 == 0)
			{
				if(flagr_2 == 1)
					set_image("image/zhanli_you.png",this instanceof yuancheng);
				else
					set_image("image/zhanli_zuo.png",this instanceof yuancheng);
			}
	    
			//һ����ͼ��仯��������������̬Ч������Ժ�
			if(jump_2 != 0 && flagjump == 0)
			{
				if(flagr_2 == 1||press_right_2)
					set_image("image/yitiao_you.png",this instanceof yuancheng);
				else
					set_image("image/yitiao_zuo.png",this instanceof yuancheng);
			}
		}
	}
			//һ����
			if(jump_2 == 1)
			{
				if(attack == 0 && be_attack == 0 && attack_U == 0 && attack_L == 0)
				{
					if(flagr_2 == 1 || press_right_2)
						set_image("image/yitiao_you.png",this instanceof yuancheng);
					else
						set_image("image/yitiao_zuo.png",this instanceof yuancheng);
				}
	    	
				if(!flag1_2)//�仯˲��
				{
					high1 = high;
					flag1_2 = true;
					high1 -= 4;
					this.setTranslateY(this.getTranslateY() - 4);
					boolean flag3 = false;
					for(int i = 0;i < lev.zhang.length;++i)
						if(lev.zhang[i] != null)
							if(zhangai.crash(this,lev.zhang[i],0,(int)lev.zhang[i].heightProperty().doubleValue(),2))
								flag3 = true;
					if(flag3)
					{
						//high1 = 0;
						//this.setTranslateY(this.getTranslateY() + 4);
					}
				}
				else
				{
					if(high1 > 0)
					{
						high1 -= 4;
						this.setTranslateY(this.getTranslateY() - 4);
						boolean flag3 = false;
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								if(zhangai.crash(this,lev.zhang[i],0,(int)lev.zhang[i].heightProperty().doubleValue(),2))
									flag3 = true;
						if(flag3)
						{
							//high1 = 0;
							//this.setTranslateY(this.getTranslateY() + 4);
						}
					}
				}
			}
			else if(jump_2 == 2)//������
			{
			//	System.out.println(flag2_2);
				if(!flag2_2)//�仯˲��
				{
					if(flagjump == 0 && attack == 0 && be_attack == 0 && attack_U == 0 && attack_L == 0)
					{
						if(flagr_2 == 1||press_right_2)
							set_image("image/ertiao1_you.png",this instanceof yuancheng);
						else
							set_image("image/ertiao1_zuo.png",this instanceof yuancheng);
						//����ͼ��仯
						++flagjump;
						Timeline animation1 = new Timeline(new KeyFrame(Duration.millis(100),eventHandler1));
						animation1.setCycleCount(3);
						animation1.play();
					}
	    		
					if(high1 >= 0)
					{
						high2 = high + high1;
					}
					else
					{
						high2 = high;
					}
					flag2_2 = true;
					high2 -= 4;
					this.setTranslateY(this.getTranslateY() - 4);
					boolean flag3 = false;
					for(int i = 0;i < lev.zhang.length;++i)
						if(lev.zhang[i] != null)
							if(zhangai.crash(this,lev.zhang[i],0,(int)lev.zhang[i].heightProperty().doubleValue(),2))
								flag3 = true;
					if(flag3)
					{
						//high2 = 0;
						//this.setTranslateY(this.getTranslateY() + 4);
					}
				}
				else
				{
					if(high2 > 0)
					{
						high2 -= 4;
						this.setTranslateY(this.getTranslateY() - 4);
						boolean flag3 = false;
						for(int i = 0;i < lev.zhang.length;++i)
							if(lev.zhang[i] != null)
								if(zhangai.crash(this,lev.zhang[i],0,(int)lev.zhang[i].heightProperty().doubleValue(),2))
									flag3 = true;
						if(flag3)
						{
							//high2 = 0;
							//this.setTranslateY(this.getTranslateY() + 4);
						}
					}
				}
	    }
	    //��������
		if(attack_L == 0 && attack_U == 0)
		{
	    boolean flag3 = false;
	    for(int i = 0;i < lev.zhang.length;++i)
    		if(lev.zhang[i] != null)
    			if(zhangai.crash(this,lev.zhang[i],(int)this.heightProperty().doubleValue(),0,2))
    				flag3 = true;
	    if(!flag3 && (jump_2 == 1 && high1 <= 0 || jump_2 == 2 && high2 <= 0 || jump_2 == 0))
	    {
	    	this.setTranslateY(this.getTranslateY() + 4);
	    	if(flag3)
    		{
    			jump_2 = 0;
    			this.setTranslateY(this.getTranslateY() - 4);
    		}
	    }
	    else if(flag3)
		{
			jump_2 = 0;
		}
	    for(int i = 0;i < lev.zhang.length;++i)
	    {
	    	if(this != null && lev.zhang[i]!=null)
	    		zhangai.go_back(this, lev.zhang[i]);
	    }
		}
	}
	};
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(10),eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		
	}
	
	public void set_image(String s,boolean bb)//ͼ�����
	{
		if(bb)
			s = "1" + s;
		else
			s = "2" + s;//////
//		this.getChildren().remove(imagev);
		image = new Image(s);
		imagev.setImage(image);
	//	this.getChildren().add(imagev1);
	//	this.getChildren().remove(imagev);
	//	imagev = imagev1;
	}
}
