package End_User;
import java.awt.Panel;
import java.awt.Label;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;
import java.awt.Component;
	protected class Question_Panel1 extends Panel{
		private Label Question;
		private CheckboxGroup CBG = new CheckboxGroup();
		protected Question(String Question,Component...Choice){
				this.Question.setText(Question);
				add(this.Question);
				for(Component n: Choice){
					add(n);
				}
		}
		
	}
 