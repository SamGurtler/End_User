package EndUser;
import javax.swing.JFrame;
//import java.awt.FlowLayout;
import java.util.ArrayList;
//import javax.swing.JPanel;
//import java.awt.GridLayout;
import java.util.Scanner;
import java.io.File;
import javax.swing.JLabel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.GroupLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
	public class Main{
		public static void main(String[] args)throws java.io.FileNotFoundException{
			ArrayList<JFrame> JFrame = new ArrayList<JFrame>();
			//ArrayList<ArrayList<Question_Panel>> Arrlst_Questions = new ArrayList<ArrayList<Question_Panel>>();
			ArrayList<ArrayList<ButtonGroup>> Arrlst_ButtonGroup = new ArrayList<ArrayList<ButtonGroup>>();
			ArrayList<ArrayList<JRadioButton[]>> Arrlst_Button = new ArrayList<ArrayList<JRadioButton[]>>();
			JRadioButton[] Buttons = {new JRadioButton("Safe",false), new JRadioButton("Unsafe",false), new JRadioButton("Unobserved",false)};
			ArrayList<ArrayList<JLabel>> Arrlst_JLabel = new ArrayList<ArrayList<JLabel>>();
			ArrayList<JLabel> Arrlst_Sections = new ArrayList<JLabel>();
			Scanner scan = new Scanner(new File("./Questions.txt"));
			Pattern p = Pattern.compile("[^:]+:");
			String line = "";
			for(int counter = -1,count = 0;scan.hasNext();counter+=0){
				line = scan.nextLine();
				Matcher m = p.matcher(line);
				if(m.matches()){
					counter++;
					count = 0;
					System.out.println("Making new JLabel titled:"+line);
					Arrlst_Sections.add(new JLabel(line));
					//Arrlst_Questions.add(new ArrayList<Question_Panel>());
					Arrlst_ButtonGroup.add(new ArrayList<ButtonGroup>());
					Arrlst_Button.add(new ArrayList<JRadioButton[]>());
					Arrlst_JLabel.add(new ArrayList<JLabel>());
					System.out.println("Label ->"+line);
				}
				else {
					//Arrlst_Questions.get(counter).add(new Question_Panel(line));
					Arrlst_JLabel.get(counter).add(new JLabel(line));
					Arrlst_Button.get(counter).add(Buttons);
					ButtonGroup tmp = new ButtonGroup();
					for(JRadioButton button : Arrlst_Button.get(counter).get(count)){
						tmp.add(button);
					}
					Arrlst_ButtonGroup.get(counter).add(tmp);
					count++;
				}
			}
			ArrayList<GroupLayout> Arrlst_GrpLyt = new ArrayList<GroupLayout>();
			for(int count = 0;Arrlst_Sections.size()>count;count++){
				Arrlst_Sections.get(count).setHorizontalAlignment((int)Arrlst_Sections.get(count).CENTER_ALIGNMENT);
				JFrame.add(new JFrame());
				Arrlst_GrpLyt.add(new GroupLayout(JFrame.get(count).getContentPane()));
				System.out.println("What JLabel may actually say:"+Arrlst_Sections.get(count).getText());
				GroupLayout.ParallelGroup verticalGroup = Arrlst_GrpLyt.get(count).createParallelGroup();
				GroupLayout.SequentialGroup verticalJLabel = Arrlst_GrpLyt.get(count).createSequentialGroup();
				for(int count1 = 0;Arry_JLabel.get(count).size()>count1;count1++){
					verticalJLabel.addComponent(Arrlst_JLabel.get(count).get(count1));
				}
				GroupLayout.SequentialGroup verticalJRadioButton = Arrlst_GrpLyt.get(count).createSequentialGroup();
				for(int count1 = 0;Arrlst_Button.get(count).size()>count1;count1++){
					GroupLayout.ParallelGroup tmpVerticalButtonGroup = Arrlst_GrpLyt.get(count).createParallelGroup();
					for(JRadioButton button : Arrlst_Button.get(count).get(count1)){
						tmpVerticalButtonGroup.addComponent(button);
					}
					verticalJRadioButton.addGroup(tmpVerticalButtonGroup);
				}
				verticalGroup.addGroup(verticalJLabel);
				verticalGroup.addGroup(verticalJRadioButton);
				Arrlst_GrpLyt.get(count).setHorizontalGroup(Arrlst_GrpLyt.get(count).createSequentialGroup().addComponent(Arrlst_Sections.get(count)).addGroup(verticalGroup));
				/*GroupLayout.SequentialGroup Order = Arrlst_GrpLyt.get(count).createSequentialGroup();
				Order.addComponent(Arrlst_Sections.get(count));
				for(int count1 = 0;Arrlst_Questions.get(count).size()>count1;count1++){
					Order.addComponent(Arrlst_Questions.get(count).get(count1));
				}
				GroupLayout.ParallelGroup Order2 = Arrlst_GrpLyt.get(count).createParallelGroup();
				for(int count1 = 0;Arrlst_Questions.get(count).size()>count1;count1++){
					Order2.addComponent(Arrlst_Questions.get(count).get(count1));
				}
				Arrlst_GrpLyt.get(count).setHorizontalGroup(Arrlst_GrpLyt.get(count).createParallelGroup().addComponent(Arrlst_Sections.get(count)).addGroup(Order2));
				Arrlst_GrpLyt.get(count).setVerticalGroup(Order);*/
				JFrame.get(count).getContentPane().setLayout(Arrlst_GrpLyt.get(count));
				JFrame.get(count).add(Arrlst_Sections.get(count));
				for(int count1 = 0;Arry_JLabel.get(count).size()>count1;count1++){
					JFrame.get(count).add(Arrlst_JLabel.get(count).get(count1));
					for(JRadioButton button : Arrlst_Button.get(count).get(count1)){
						JFrame.get(count).add(button);
					}
				}
				/*for(int count1 = 0;Arrlst_Questions.get(count).size()>count1;count1++){
					JFrame.get(count).add(Arrlst_Questions.get(count).get(count1));
					System.out.println("Jframe.get("+count+").add(Arrlst_Questions.get("+count+").get("+count1+"));");
				}*/
				JFrame.get(count).setDefaultLookAndFeelDecorated(true);
				JFrame.get(count).setDefaultCloseOperation(JFrame.get(count).DISPOSE_ON_CLOSE);
				JFrame.get(count).pack();
				JFrame.get(count).setVisible(true);
			}
		}
	}
