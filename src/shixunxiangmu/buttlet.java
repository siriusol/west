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
public class buttlet extends main_thing//�ӵ���
{
	public Image image;
	public ImageView imagev;
	public main_thing aim;//�ӵ���˭���ģ�����﷢�䣬�ҷ����﷢��
	public int dir;//�ӵ��ķ��䷽������
	public int cnt=0;//�ж��ӵ��뼸�����﷢����ײ
	public double x,y;
	public buttlet(){}
	public buttlet(IntegerProperty shanghai,String s,main_thing aim)
	{
		cnt = 0;//��ʼ�ӵ�δ��������ײ
		image = new Image(s);
		imagev = new ImageView(image);
		this.getChildren().add(imagev);
		this.shanghai = new SimpleIntegerProperty(shanghai.intValue());
		this.shanghai.bind(aim.shanghai);//���ӵ��˺��󶨵��������˺�����
		this.aim = aim;
	}
	public void set_zuobiao(int x,int y)//�趨�ӵ�����
	{
		this.setTranslateX(x);
		this.setTranslateY(y);
	}
}
