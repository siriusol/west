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
public class main_work extends Application
{
	public level1 l1;
	public level2 l2;
	public level3 l3;
	public level1_shuang l1_shuang;
	public level2_shuang l2_shuang;
	boolean ifclick = false;
	boolean l1_finished = false,l2_finised = false;//关卡是否完成
	public boolean danren;//模式选择
	public Stage mainStage;
	public void start(Stage main)
	{	
		Image imagemainmenu = new Image("image/main-menu.png");
		Image selectperson = new Image("image/select-person.png");
		ImageView imagevmainmenu = new ImageView(imagemainmenu);
		Pane pane = new Pane();
		pane.getChildren().add(imagevmainmenu);
		
		Image toumingbt = new Image("image/toumingbt.png");
		Image startbt = new Image("image/startbt.png");
		Image startbtbig = new Image("image/startbt-big.png");
		Image menusinglebt = new Image("image/menu-single.png");
		Image menudoublebt = new Image("image/menu-double.png");
		Image menucancelbt = new Image("image/menu-cancel.png");
		Image menusinglebigbt = new Image("image/menu-single-big.png");
		Image menudoublebigbt = new Image("image/menu-double-big.png");
		Image menucancelbigbt = new Image("image/menu-cancel-big.png");
		Image map = new Image("image/map.png");
		Image northbt = new Image("image/north.png");
		Image northbigbt = new Image("image/north-big.png");
		
		Image northbt_2 = new Image("image/yufu.png");
		Image northbigbt_2 = new Image("image/yufu-big.png");
		
		ImageView startbtv = new ImageView(startbt);
		ImageView menusinglebtv = new ImageView(toumingbt);
		ImageView menudoublebtv = new ImageView(toumingbt);
		ImageView menucancelbtv = new ImageView(toumingbt);
		ImageView northbtv = new ImageView(northbt);
		
		ImageView northbtv_2 = new ImageView(northbt_2);
		
		startbtv.setTranslateX(580);
		startbtv.setTranslateY(580);
		menusinglebtv.setTranslateX(570);
		menusinglebtv.setTranslateY(318);
		menudoublebtv.setTranslateX(570);
		menudoublebtv.setTranslateY(408);
		menucancelbtv.setTranslateX(570);
		menucancelbtv.setTranslateY(500);
		
		startbtv.setOnMouseClicked(e ->{//开始游戏点击
			imagevmainmenu.setImage(selectperson);
			pane.getChildren().remove(startbtv);	
			//menusinglebtv.requestFocus();
			menusinglebtv.setImage(menusinglebt);
			menudoublebtv.setImage(menudoublebt);
			menucancelbtv.setImage(menucancelbt);
			pane.getChildren().addAll(menusinglebtv,menudoublebtv,menucancelbtv);
			zhuanhuan();
			//System.out.println("1111111111");
		});
		startbtv.setOnMouseEntered(e ->//开始游戏触碰
		{
			//System.out.println("5555555");
			startbtv.setImage(startbtbig);
			startbtv.setTranslateX(550);
			startbtv.setTranslateY(570);
		});
		startbtv.setOnMouseExited(e ->//开始游戏移除
		{
			startbtv.setTranslateX(580);
			startbtv.setTranslateY(580);
			startbtv.setImage(startbt);
		});
		menusinglebtv.setOnMouseEntered(e ->//单人模式放上去
		{
			//System.out.println("6666666666");
			if (ifclick)
			{
				menusinglebtv.setImage(menusinglebigbt);
				menusinglebtv.setTranslateX(540);
				menusinglebtv.setTranslateY(310);
			}
			
		});
		menusinglebtv.setOnMouseClicked(e ->{//单人模式的点击效果
			if (ifclick)
			{
				/*
				l1 = new level1(this);
				l1.show();
				mainStage.hide();
				*/
				pane.getChildren().clear();
				imagevmainmenu.setImage(map);
				pane.getChildren().add(imagevmainmenu);
				northbtv.setTranslateX(90);	
				northbtv.setTranslateY(57);
				pane.getChildren().add(northbtv);
				
				northbtv_2.setTranslateX(830);	
				northbtv_2.setTranslateY(300);
				pane.getChildren().add(northbtv_2);
				
				
				danren = true;
			}
		});
		menusinglebtv.setOnMouseExited(e ->//单人模式移开
		{
			if (ifclick)
			{
				menusinglebtv.setImage(menusinglebt);
				menusinglebtv.setTranslateX(570);
				menusinglebtv.setTranslateY(318);
			}
			
		});
		
		
		
		menudoublebtv.setOnMouseEntered(e ->//双人模式放上去
		{
			//System.out.println("6666666666");
			if (ifclick)
			{
				menudoublebtv.setImage(menudoublebigbt);
				menudoublebtv.setTranslateX(540);
				menudoublebtv.setTranslateY(408);
			}
			
		});
		menudoublebtv.setOnMouseClicked(e ->{//双人模式点击
			if (ifclick)
			{
				pane.getChildren().clear();
				imagevmainmenu.setImage(map);
				pane.getChildren().add(imagevmainmenu);
				northbtv.setTranslateX(90);	
				northbtv.setTranslateY(57);
				pane.getChildren().add(northbtv);
				danren = false;
				
				northbtv_2.setTranslateX(830);	
				northbtv_2.setTranslateY(300);
				pane.getChildren().add(northbtv_2);
				/*
				l1 = new level1(this);
				l1.show();
				mainStage.hide();
				*/
			}
		});
		menudoublebtv.setOnMouseExited(e ->//双人模式移开
		{
			if (ifclick)
			{
				menudoublebtv.setImage(menudoublebt);
				menudoublebtv.setTranslateX(570);
				menudoublebtv.setTranslateY(408);
			}
			
		});
		
		
		
		
		menucancelbtv.setOnMouseEntered(e ->//取消放上去
		{
			//System.out.println("6666666666");
			if (ifclick)
			{
				menucancelbtv.setImage(menucancelbigbt);
				menucancelbtv.setTranslateX(540);
				menucancelbtv.setTranslateY(488);
			}
			
		});
		
		menucancelbtv.setOnMouseClicked(e ->{//取消点击
			if (ifclick)
			{
				//System.out.println("6666666");
				
				//pane.getChildren().clear();
				
				pane.getChildren().remove(menucancelbtv);
				pane.getChildren().remove(imagevmainmenu);
				pane.getChildren().remove(menusinglebtv);
				pane.getChildren().remove(menudoublebtv);
				imagevmainmenu.setImage(imagemainmenu);
				pane.getChildren().add(imagevmainmenu);
				/*
				menusinglebtv.setImage(toumingbt);
				menudoublebtv.setImage(toumingbt);
				menucancelbtv.setImage(toumingbt);
							*/	
				pane.getChildren().add(startbtv);
				zhuanhuan();
			}
		});
		menucancelbtv.setOnMouseExited(e ->//取消移开
		{
			if (ifclick)
			{
				menucancelbtv.setImage(menucancelbt);
				menucancelbtv.setTranslateX(570);
				menucancelbtv.setTranslateY(498);
			}
			
		});
		
		
		
		
		northbtv.setOnMouseEntered(e ->//第一关放上去
		{
			//System.out.println("6666666666");
			
			
			northbtv.setImage(northbigbt);
			northbtv.setTranslateX(20);
			northbtv.setTranslateY(17);
			
			
		});
		
		northbtv.setOnMouseClicked(e ->//第一关点击
		{
			if(danren)
			{
				l1 = new level1(this);
				l1.show();
				mainStage.hide();
			}
			else
			{
				l1_shuang = new level1_shuang(this);
				l1_shuang.show();
				mainStage.hide();
			}
				
		});
		northbtv.setOnMouseExited(e ->//第一关移开
		{
					
				northbtv.setImage(northbt);
				northbtv.setTranslateX(90);
				northbtv.setTranslateY(57);
						
		});
		
		
		//第二关
		northbtv_2.setOnMouseEntered(e ->//第二关放上去
		{
			//System.out.println("6666666666");
			
			
			northbtv_2.setImage(northbigbt_2);
			northbtv_2.setTranslateX(780);
			northbtv_2.setTranslateY(270);
			
			
		});
		
		northbtv_2.setOnMouseClicked(e ->
		{
			if(danren)
			{
				l2 = new level2(this);
				l2.show();
				mainStage.hide();
			}
			else
			{
				l2_shuang = new level2_shuang(this);
				l2_shuang.show();
				mainStage.hide();
			}
				
		});
		northbtv_2.setOnMouseExited(e ->
		{
					
				northbtv_2.setImage(northbt_2);
				northbtv_2.setTranslateX(830);
				northbtv_2.setTranslateY(300);
						
		});
		
		
		pane.getChildren().add(startbtv);
		//ImageView imagevstartbt = ;
		//Button startbt = new Button("",new ImageView("image/startbt.png"));
		//startbt.setBackground(value);
		//startbt.setTranslateX(500);
		//startbt.setTranslateY(500);
		//pane.getChildren().add(startbt);
		Scene scene = new Scene(pane);
		mainStage = main;
		mainStage.setTitle("死亡解救");
		mainStage.setScene(scene);
		
		
		mainStage.setWidth(1280);
		mainStage.setHeight(760);
		mainStage.setResizable(false);
		
		mainStage.show();
		/*
		startbt.setOnAction((ActionEvent e)->{//关卡一的点击效果
			l1 = new level1(this);
			l1.show();
			mainStage.hide();
		});
		*/
		//bt_level1.requestFocus();
	}
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	public void zhuanhuan()
	{
		
		if (ifclick)
			ifclick = false;
		else
			ifclick = true;
	}
}
