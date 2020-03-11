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
public class buttlet extends main_thing//子弹类
{
	public Image image;
	public ImageView imagev;
	public main_thing aim;//子弹是谁发的，如怪物发射，我方人物发射
	public int dir;//子弹的发射方向，左，右
	public int cnt=0;//判定子弹与几个怪物发生碰撞
	public double x,y;
	public buttlet(){}
	public buttlet(IntegerProperty shanghai,String s,main_thing aim)
	{
		cnt = 0;//初始子弹未发生过碰撞
		image = new Image(s);
		imagev = new ImageView(image);
		this.getChildren().add(imagev);
		this.shanghai = new SimpleIntegerProperty(shanghai.intValue());
		this.shanghai.bind(aim.shanghai);//将子弹伤害绑定到发射者伤害上面
		this.aim = aim;
	}
	public void set_zuobiao(int x,int y)//设定子弹坐标
	{
		this.setTranslateX(x);
		this.setTranslateY(y);
	}
}
