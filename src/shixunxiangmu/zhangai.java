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
public class zhangai extends main_thing
{
	public Image image;
	public ImageView imagev;
	public zhangai()
	{
		image = null;
		imagev = null;
	}
	public zhangai(String s)
	{
		image = new Image(s);
		imagev = new ImageView(image);
		this.getChildren().add(imagev);
	}
	public void set_image(String s)//更改图片,传入图片目录
	{
		this.getChildren().remove(imagev);
		image = new Image(s);
		imagev = new ImageView(image);
		this.getChildren().add(imagev);
	}
	public void set_zuobiao(int x,int y)//更改坐标
	{
		this.setTranslateX(x);
		this.setTranslateY(y);
	}
	
	public static boolean crash(Pane v1,Pane v2,int a,int b,int flag)//碰撞函数,flag为1时水平碰撞
	//2时垂直碰撞，3时任意方向碰撞，a,b分别为v1,v2碰撞点与左上角的差值
	{
		if(v1 != null && v2 != null)
		{
			if(flag == 1)
			{
				//System.out.println(v1.getTranslateX() + " " + a + " " + v2.getTranslateX() + " " + b);
				//System.out.println(v1.getTranslateY() + " " + v2.getTranslateY());
				if(Math.abs(v1.getTranslateX() + a - v2.getTranslateX() - b) < 2 && (v1.getTranslateY() - v2.getTranslateY() < v1.heightProperty().doubleValue() && v1.getTranslateY() - v2.getTranslateY() >= 0 || v2.getTranslateY() - v1.getTranslateY() < v2.heightProperty().doubleValue() && v2.getTranslateY() - v1.getTranslateY() >= 0))
					return true;
				else
					return false;
			}
			else if(flag == 2)
			{
				if(Math.abs(v1.getTranslateY() + a - v2.getTranslateY() - b) < 2 &&(v1.getTranslateX() - v2.getTranslateX() < v2.widthProperty().doubleValue() && v1.getTranslateX() - v2.getTranslateX() >= 0 || v2.getTranslateX() - v1.getTranslateX() < v1.widthProperty().doubleValue() && v2.getTranslateX() - v1.getTranslateX() >= 0))
				{
					//System.out.println(v1.getTranslateY() + " " + a + " " + v2.getTranslateY() + " " + b);
					//System.out.println(v1.getTranslateX() + " " + v2.getTranslateX() + " " + v1.widthProperty().doubleValue() + " " + v2.widthProperty().doubleValue());
					//System.out.println();
					return true;
				}
				else
					return false;
			}
			else
			{
				double x1 = v1.getTranslateX() + v1.widthProperty().doubleValue()/2;
				double y1 = v1.getTranslateY() + v1.heightProperty().doubleValue()/2;
				double x2 = v2.getTranslateX() + v2.widthProperty().doubleValue()/2;
				double y2 = v2.getTranslateY() + v2.heightProperty().doubleValue()/2;
				double x3 = Math.abs(x2-x1);
				double y3 = Math.abs(y2-y1);
				double v1_xr = v1.getTranslateX()+v1.widthProperty().doubleValue();
				double v1_xl = v1.getTranslateX();
				double v1_yt = v1.getTranslateY();
				double v1_yb = v1.getTranslateY()+v1.heightProperty().doubleValue();
				
				double v2_xr = v2.getTranslateX()+v2.widthProperty().doubleValue();
				double v2_xl = v2.getTranslateX();
				double v2_yt = v2.getTranslateY();
				double v2_yb = v2.getTranslateY()+v2.heightProperty().doubleValue();
				
				if(Math.sqrt(x3 * x3 + y3 * y3) < 30)
					return true;
				if(v1_yb > v2_yt+2 && v1_xr > v2_xl+2 && v1_yt < v2_yt && v1_xl < v2_xl)
				{
					return true;
					//System.out.println(1);
				}
				if(v1_yb > v2_yt+2 && v1_xl < v2_xr-2 && v1_yt < v2_yt && v1_xr > v2_xr)
				{
					return true;
					//System.out.println(2);
				}
				if(v1_yt < v2_yb-2 && v1_xr > v2_xl+2 && v1_yb > v2_yb && v1_xl < v2_xl)
				{
					return true;
					//System.out.println(3);
				}
				if(v1_yt < v2_yb-2 && v1_xl < v2_xr-2 && v1_yb > v2_yb && v1_xr > v2_xr)
				{
					return true;
					//System.out.println(4);
				}
				if(v1_yb > v2_yt+2 && v1_xl >= v2_xl && v1_yt < v2_yt && v1_xr <= v2_xr)
				{
					return true;
					//System.out.println(5);
				}
				if(v1_yt < v2_yt-2 && v1_xl >= v2_xl && v1_yb > v2_yb && v1_xr <= v2_xr)
				{
					return true;
					//System.out.println(6);
				}
				return false;
			}
		}
		else
			return false;
	}
	
	public static void go_back(Pane v1,Pane v2)//云层浮力效果
	{
		double v1_xr = v1.getTranslateX()+v1.widthProperty().doubleValue();
		double v1_xl = v1.getTranslateX();
		double v1_yt = v1.getTranslateY();
		double v1_yb = v1.getTranslateY()+v1.heightProperty().doubleValue();
		
		double v2_xr = v2.getTranslateX()+v2.widthProperty().doubleValue();
		double v2_xl = v2.getTranslateX();
		double v2_yt = v2.getTranslateY();
		double v2_yb = v2.getTranslateY()+v2.heightProperty().doubleValue();
		
		if(v1_yb > v2_yt+2 && v1_xr > v2_xl+2 && v1_yt < v2_yt && v1_xl < v2_xl)
		{
			v1.setTranslateY(v1.getTranslateY()-3);
			//System.out.println(1);
		}
		else if(v1_yb > v2_yt+2 && v1_xl < v2_xr-2 && v1_yt < v2_yt && v1_xr > v2_xr)
		{
			v1.setTranslateY(v1.getTranslateY()-3);
			//System.out.println(2);
		}
		else if(v1_yt < v2_yb-2 && v1_xr > v2_xl+2 && v1_yb > v2_yb && v1_xl < v2_xl)
		{
			v1.setTranslateY(v1.getTranslateY()-3);
			//System.out.println(3);
		}
		else if(v1_yt < v2_yb-2 && v1_xl < v2_xr-2 && v1_yb > v2_yb && v1_xr > v2_xr)
		{
			v1.setTranslateY(v1.getTranslateY()-3);
			//System.out.println(4);
		}
		else if(v1_yb > v2_yt+2 && v1_xl >= v2_xl && v1_yt < v2_yt && v1_xr <= v2_xr)
		{
			v1.setTranslateY(v1.getTranslateY()-5);
			//System.out.println(5);
		}
		//else if(v1_yt < v2_yt-2 && v1_xl >= v2_xl && v1_yb > v2_yb && v1_xr <= v2_xr)
		//{
		//	v1.setTranslateY(v1.getTranslateY()+5);
			//System.out.println(6);
		//}
	}
}
