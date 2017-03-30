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
			protected Question_Panel(String Question){
				this.Question = new JLabel(Question);
				JRadioButton Safe = new JRadioButton("Safe",false);
				JRadioButton Unsafe = new JRadioButton("Unsafe",false);
				JRadioButton Unobserved = new JRadioButton("Unobserved",false);
				CBG.add(Safe);
				CBG.add(Unsafe);
				CBG.add(Unobserved);
				/*FlowLayout FlwLyt = new FlowLayout();
				JPanel Question_Panel = new JPanel(FlwLyt);
				Question_Panel.add(Safe);
				Question_Panel.add(Unsafe);
				Question_Panel.add(Unobserved);*/
				setVisible(true);
				/*SpringLayout SprngLyt = new SpringLayout();
				SprngLyt.addLayoutComponent("Question",this.Question);
				SprngLyt.addLayoutComponent(Question_Panel,FlwLyt);*/
				GroupLayout GrpLyt = new GroupLayout(this);
				/*this.validate();
				System.out.println(this.Question.getWidth());
				GrpLyt.setHorizontalGroup(GrpLyt.createSequentialGroup().addComponent(this.Question).addGap((this.Question.getWidth()+Safe.getWidth()+Unsafe.getWidth()+Unobserved.getWidth())/6-this.Question.getWidth()).addGroup(GrpLyt.createParallelGroup().addComponent(Safe).addComponent(Unsafe).addComponent(Unobserved)));*/
				//GrpLyt.addLayoutComponent("Question",this.Question);
				//GrpLyt.addLayoutComponent(Question_Panel,FlwLyt);
				GrpLyt.setAutoCreateContainerGaps(true);
				add(this.Question);
				add(Safe);
				add(Unsafe);
				add(Unobserved);
				//add(Question_Panel);
				//setLayout(SprngLyt);
			}
			protected String getAnswer(){
				return ((JRadioButton) CBG.getSelection()).getText();
			}
		}
 
 