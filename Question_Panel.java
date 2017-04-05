package EndUser;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import java.awt.FlowLayout;
import java.util;
import javax.swing.AbstractButton;
public class Question_Panel extends JPanel{
			private JLabel Question;
			private ButtonGroup CBG = new ButtonGroup();
			private GroupLayout GrpLyt = new GroupLayout(this);
			private JRadioButton[] Answers = {new JRadioButton("Safe",false), new JRadioButton("Unsafe",false), new JRadioButton("Unobserved",false)};
			protected Question_Panel(String Question){
				this.Question = new JLabel(Question);
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
			protected void addGap(){
				int sizeOfGap = Question.getFontMetrics(Question.getFont()).stringWidth(Question.getText());
				for(JRadioButton button : Answers){
					sizeOfGap += button.getFontMetrics(button.getFont()).stringWidth(button.getText());
				}
				sizeOfGap = (this.getWidth()-sizeOfGap)/6;
				GrpLyt.setHorizontalGroup(GrpLyt.createSequentialGroup().addComponent(Question).addGap(sizeOfGap).addGroup(GrpLyt.createParallelGroup().addComponent(Answers[0]).addComponent(Answers[1]).addComponent(Answers[2])));
			}
		}
