package EndUser;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import java.awt.FlowLayout;
public class Question_Panel extends JPanel{
			private JLabel Question;
			private ButtonGroup CBG = new ButtonGroup();
			private JRadioButton[] Answers = {new JRadioButton("Safe",false), new JRadioButton("Unsafe",false), new JRadioButton("Unobserved",false)};
			protected Question_Panel(String Question){
				this.Question = new JLabel(Question);
				this.Question.setHorizontalAlignment((int)this.Question.LEFT_ALIGNMENT);
				for(JRadioButton button : Answers){
					CBG.add(button);
				}
				setVisible(true);
				add(this.Question);
				for(JRadioButton button : Answers){
					add(button);
				}
			}
			protected String getAnswer(){
				return ((JRadioButton) CBG.getSelection()).getText();
			}
		}
