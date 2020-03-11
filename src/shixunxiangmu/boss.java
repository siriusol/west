package shixunxiangmu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class boss extends main_thing
{
	public int blood;
	public Image image;
	public ImageView imagev;
	public int number;
	public int status;
	public boolean ifright;
	public int buti = 0;
	buttlet[] but = new buttlet[20];
	int begin,end,cnt;//¹¥»÷ÀäÈ´
	boss()
	{
		begin = end = cnt = 0;
		blood = 150;
		number = 0;
		status = 0;
		ifright = true;
	    image = new Image("image/boss.png");
	    imagev = new ImageView(image);
		this.getChildren().add(imagev);
		shanghai = new SimpleIntegerProperty(10);
	}
}
