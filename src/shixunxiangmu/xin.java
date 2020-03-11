package shixunxiangmu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class xin extends main_thing
{
	public Image image;
	public ImageView imagev;
	public int k = 0;
	public xin()
	{
	    image = new Image("image/heart.png");
	    imagev = new ImageView(image);
		this.getChildren().add(imagev);
	}
	public void set_zuobiao(int x,int y)//¸Ä±äÍ¼Æ¬×ø±ê
	{
		this.setTranslateX(x);
		this.setTranslateY(y);
	}
	public void set_image(String s)
	{
		image = new Image(s);
		imagev.setImage(image);
	}
}
