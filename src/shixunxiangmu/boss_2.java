package shixunxiangmu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class boss_2 extends main_thing
{
	public int blood;
	public Image image;
	public ImageView imagev;
	public int number;
	public int number1;
	public int number2;
	public int status;
	public boolean ifright;
	public int buti = 0;
	//public boolean chuxian = false;
	buttlet[] but = new buttlet[30];
	int begin,end,cnt;//¹¥»÷ÀäÈ´
	public boss_2()
	{
		begin = end = cnt = 0;
		blood = 150;
		number = number1 = number2 = 0;
		status = 0;
		ifright = true;
	    image = new Image("image/boss2.png");
	    imagev = new ImageView(image);
		this.getChildren().add(imagev);
		shanghai = new SimpleIntegerProperty(10);
	}
	public void set_image(String s)
	{
		image = new Image(s);
		imagev.setImage(image);
	}
}
