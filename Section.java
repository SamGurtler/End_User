package End_User;
import java.awt.Frame;
import java.awt.Component;
	public class Section extends Frame{
		/*protected Section(String title, Component[] args){
			super(title);
			for(Component n: args){
				add(n);
			}
		}*/
		protected Section(String title, Component...args){
			super(title);
			for(Component n: args){
				add(n);
			}
		}
	}