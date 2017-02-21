package End_User;
import java.awt.Panel;
import java.awt.Label;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;
	protected class Question_Panel extends Panel{
		private Label Question;
		private CheckboxGroup CBG = new CheckboxGroup();
		Question(String Question){
				this.Question.setText(Question);
				add(this.Question);
				CBG.add(new Checkbox("Safe",CBG,false));
				CBG.add(new Checkbox("Unsafe",CBG,false));
				CBG.add(new Checkbox("Unobserved",CBG,false));
				add(CBG);
		}
		String getAnswer(){
			return CBG.getSelectedCheckbox().getLabel();
		}
		
	}
 
 
 