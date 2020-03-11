package shixunxiangmu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
public class gongd extends main_thing
{
	public Image image;
	public ImageView imagev;
	public gongd(){}
	public gongd(String s)
	{
		image = new Image(s);
		imagev = new ImageView(image);
		this.getChildren().add(imagev);
	}
	public void set_image(String s)
	{
		image = new Image(s);
		imagev.setImage(image);
	}
}
