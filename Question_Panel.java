package End_User;
import java.awt.Panel;
import java.awt.Label;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;
	public class Question_Panel extends Panel{
		private Label Question;
		private CheckboxGroup CBG = new CheckboxGroup();
		protected Question_Panel(String Question1){
				this.Question.setText(Question1);
				add(this.Question);
				add(new Checkbox("Safe",CBG,false));
				add(new Checkbox("Unsafe",CBG,false));
				add(new Checkbox("Unobserved",CBG,false));
		}
		protected String getAnswer(){
			return CBG.getSelectedCheckbox().getLabel();
		}
		
	}
 
 
 