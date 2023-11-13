package test.main;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MyFrame3 extends JFrame{
	//필드
	File openedFile;
	
	//생성자
	public MyFrame3(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//BorderLayout 으로 설정 
		setLayout(new BorderLayout());
		//메뉴바
		JMenuBar mb=new JMenuBar();
		//메뉴
		JMenu menu=new JMenu("File");
		//메뉴 아이템
		JMenuItem newItem=new JMenuItem("New");
		JMenuItem openItem=new JMenuItem("Open");
		JMenuItem saveItem=new JMenuItem("Save");
		JMenuItem saveAsItem=new JMenuItem("Save As");
		//메뉴에 메뉴 아이템을 순서대로 추가 
		menu.add(newItem);
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(saveAsItem);
		//메뉴를 메뉴바에 추가 
		mb.add(menu);
		//프레임의 메소드를 이용해서 메뉴바를 추가하기 
		setJMenuBar(mb);
		
		JTextArea ta=new JTextArea();
		add(ta, BorderLayout.CENTER);
		
		//Open 을 눌렀을때 실행할 리스너 등록
		openItem.addActionListener((e)->{
			//파일 선택을 도와 주는 객체 생성
			JFileChooser fc=new JFileChooser("c:/acorn202310/myFolder");
			//파일선택기 실제로 띄우기
			int result=fc.showOpenDialog(this);
			//파일을 선택하고 확인을 눌렀다면
			if(result == JFileChooser.APPROVE_OPTION) {
				//선택한 파일을 제어할수 있는 File 객체의 참조값 얻어내서 필드에 저장하기
				openedFile=fc.getSelectedFile();
				//선택한 파일의 이름을 title 에 출력하기
				String fileName=openedFile.getName();
				//프레임의 setTitle() 메소드를 이용해서 제목 수정하기 
				setTitle(fileName);
				//try 블럭 안에서 사용할 변수를 미리 만들어 놓는다.
				FileReader fr=null;
				BufferedReader br=null;
				try {
					fr=new FileReader(openedFile);
					br=new BufferedReader(fr);
					//JTextArea 에 출력된 문자열을 지운 다음 
					ta.setText("");
					//반복문 돌면서 
					while(true) {
						//문자열을 한줄씩 읽어낸다.
						String line=br.readLine();
						//만일 더이상 읽을 문자열이 없다면
						if(line==null)break;// 반복문 탈출 
						//읽어낸 문자열을 JTextArea 에 출력하기
						ta.append(line); //개행기호는 제외된 상태로 읽어내기 때문에
						ta.append("\r\n"); //개행기호를 따로 추가해 준다.
					}
				}catch(Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						if(br!=null)br.close();
						if(fr!=null)fr.close();
					}catch(Exception e3) {}
				}
				
			}
		});
		
		//Save 를 눌렀을때 입력한 내용을 선택한 파일에 저장하기 
		saveItem.addActionListener((e)->{
			if(openedFile == null) {
				JOptionPane.showMessageDialog(this, "열린 파일이 없습니다.");
				return;//메소드를 여기서 끝내기 
			}
			//JTextArea 에 입력한 문자열 읽어오기 
			String content=ta.getText();
			
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				//현재 선택된 File 객체를 이용해서 FileWriter 객체 생성 
				fw=new FileWriter(openedFile);
				bw=new BufferedWriter(fw);
				bw.write(content);
				bw.flush();
				JOptionPane.showMessageDialog(this, "저장 했습니다.");
			}catch(Exception e2) {
				e2.printStackTrace();
			}finally {
				try {
					if(bw!=null)bw.close();
					if(fw!=null)fw.close();
				}catch(Exception e2) {}
			}
		});
		
		//new 를 눌렀을때
		newItem.addActionListener((e)->{
			setTitle("제목 없음");
			openedFile=null;
			ta.setText("");
		});
		//save As 를 눌렀을때 
		saveAsItem.addActionListener((e)->{
			JFileChooser fc=new JFileChooser("c:/acorn202310/myFolder");
			int result=fc.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION) {
				//저장될 예정인 파일을 제어 할수 있는 File 객체의 참조값 얻어오기 
				openedFile=fc.getSelectedFile();
				//title 출력
				setTitle(openedFile.getName());
				//새로운 파일을 실제로 만들기
				try {
					openedFile.createNewFile();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				//새로운 파일에 문자열 저장하기 
				//JTextArea 에 입력한 문자열 읽어오기 
				String content=ta.getText();
				
				FileWriter fw=null;
				BufferedWriter bw=null;
				try {
					//현재 선택된 File 객체를 이용해서 FileWriter 객체 생성 
					fw=new FileWriter(openedFile);
					bw=new BufferedWriter(fw);
					bw.write(content);
					bw.flush();
					JOptionPane.showMessageDialog(this, "저장 했습니다.");
				}catch(Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						if(bw!=null)bw.close();
						if(fw!=null)fw.close();
					}catch(Exception e2) {}
				}
			}
		});
		
	}//생성자
	
	public static void main(String[] args) {
		MyFrame3 f=new MyFrame3("제목 없음");
		f.setVisible(true);
	}
}











