package EndUser;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
public class Question_Panel extends JPanel{
			private JLabel Question;
			private ButtonGroup CBG = new ButtonGroup();
			protected Question_Panel(String Question){
				this.Question = new JLabel(Question);
				add(this.Question);
				JRadioButton Safe = new JRadioButton("Safe",false);
				JRadioButton Unsafe = new JRadioButton("Unsafe",false);
				JRadioButton Unobserved = new JRadioButton("Unobserved",false);
				CBG.add(Safe);
				CBG.add(Unsafe);
				CBG.add(Unobserved);
				add(Safe);
				add(Unsafe);
				add(Unobserved);
				setVisible(true);
				setLayout(new java.awt.FlowLayout());
			}
			protected String getAnswer(){
				return ((JRadioButton) CBG.getSelection()).getText();
			}
		}
 
 