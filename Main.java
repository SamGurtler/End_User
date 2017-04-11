package EndUser;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
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
			JFrame JFrame = new JFrame();
			CardLayout menuPages = new CardLayout();
			CardLayout pages = new CardLayout();
			JPanel[] Menu = new JPanel[3];
			ArrayList<JPanel> JPanel = new ArrayList<JPanel>();
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
					Arrlst_ButtonGroup.add(new ArrayList<ButtonGroup>());
					Arrlst_Button.add(new ArrayList<JRadioButton[]>());
					Arrlst_JLabel.add(new ArrayList<JLabel>());
					System.out.println("Label ->"+line);
				}
				else {
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
				JPanel.add(new JPanel());
				Arrlst_GrpLyt.add(new GroupLayout(JPanel.get(count)));
				Arrlst_GrpLyt.get(count).setAutoCreateContainerGaps(true); 
				System.out.println("What JLabel may actually say:"+Arrlst_Sections.get(count).getText());
				GroupLayout.ParallelGroup verticalGroup = Arrlst_GrpLyt.get(count).createParallelGroup();
				GroupLayout.SequentialGroup verticalJLabel = Arrlst_GrpLyt.get(count).createSequentialGroup();
				for(int count1 = 0;Arrlst_JLabel.get(count).size()>count1;count1++){
					verticalJLabel.addComponent(Arrlst_JLabel.get(count).get(count1));
				}
				GroupLayout.SequentialGroup verticalJRadioButton = Arrlst_GrpLyt.get(count).createSequentialGroup();
				for(int count1 = 0;Arrlst_Button.get(count).size()>count1;count1++){
					GroupLayout.ParallelGroup tmpVerticalButtonGroup = Arrlst_GrpLyt.get(count).createParallelGroup(GroupLayout.Alignment.TRAILING);
					for(JRadioButton button : Arrlst_Button.get(count).get(count1)){
						tmpVerticalButtonGroup.addComponent(button);
					}
					verticalJRadioButton.addGroup(tmpVerticalButtonGroup);
				}
				verticalGroup.addGroup(verticalJLabel);
				verticalGroup.addGroup(verticalJRadioButton);
				Arrlst_GrpLyt.get(count).setVerticalGroup(Arrlst_GrpLyt.get(count).createSequentialGroup().addComponent(Arrlst_Sections.get(count)).addGroup(verticalGroup));
				
				GroupLayout.SequentialGroup horizontalGroup = Arrlst_GrpLyt.get(count).createSequentialGroup();
				horizontalGroup.addGroup(Arrlst_GrpLyt.get(count).createParallelGroup(GroupLayout.Alignment.CENTER)).addComponent(Arrlst_Sections.get(count));
				GroupLayout.ParallelGroup horizontalJLabel = Arrlst_GrpLyt.get(count).createParallelGroup();
				for(int count1 = 0;Arrlst_JLabel.get(count).size()>count1;count1++){
					horizontalJLabel.addComponent(Arrlst_JLabel.get(count).get(count1));
				}
				horizontalGroup.addGroup(horizontalJLabel);
				for(int count1 = 0;3>count1;count1++){
					GroupLayout.ParallelGroup tmpHorizontalButtonGroup = Arrlst_GrpLyt.get(count).createParallelGroup();
					for(int count2 = 0;Arrlst_Button.get(count).size()>count2;count2++){
						tmpHorizontalButtonGroup.addComponent(Arrlst_Button.get(count).get(count2)[count1]);
					}
					horizontalGroup.addGroup(tmpHorizontalButtonGroup);
				}
				Arrlst_GrpLyt.get(count).setHorizontalGroup(horizontalGroup);
				JPanel.get(count).setLayout(Arrlst_GrpLyt.get(count));
				JPanel.get(count).add(Arrlst_Sections.get(count));
				for(int count1 = 0;Arrlst_JLabel.get(count).size()>count1;count1++){
					JPanel.get(count).add(Arrlst_JLabel.get(count).get(count1));
					for(JRadioButton button : Arrlst_Button.get(count).get(count1)){
						JPanel.get(count).add(button);
					}
				}
				JPanel.get(count).validate();
				pages.addLayoutComponent(JPanel.get(count),/*Arrlst_GrpLyt.get(count).toString()*/null);
			}
			Menu[1] = new JPanel(pages);
			for(int count = 0;JPanel.size()>count;count++){
				Menu[1].add(JPanel.get(count));
			}
			JFrame.add(Menu[1]);
			JFrame.setDefaultLookAndFeelDecorated(true);
			JFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			JFrame.pack();
			JFrame.setVisible(true);
			pages.first(Menu[1]);
		}
	}
