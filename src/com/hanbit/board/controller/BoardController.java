package com.hanbit.board.controller;

import javax.swing.JOptionPane;
import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[] args){
		
		BoardBean board = null;
		BoardBean[] list;
		String sList = "";
		BoardServiceImpl service = new BoardServiceImpl();
		
		while(true){
			switch(JOptionPane.showInputDialog("0.close 1.게시글 추가 2.게시글 갯수확인 3.리스트 확인 4.seq로 글찾기 5.이름으로 글찾기 6.게시글 업데이트 7.게시글 삭제")){
			case "0": 
				JOptionPane.showMessageDialog(null, "System close");
				return;
			case "1":
				board = new BoardBean(); //초기화
				board.setWriter(JOptionPane.showInputDialog("Writer"));
				board.setTitle(JOptionPane.showInputDialog("Title"));
				board.setContent(JOptionPane.showInputDialog("Content"));
				board.setRegDate(JOptionPane.showInputDialog("RegDate"));
				service.writeBoard(board);
	
				JOptionPane.showMessageDialog(null, "게시글 등록 완료!");
				break;
			case "2":
				JOptionPane.showMessageDialog(null, "등록된 게시글 수: "+service.countArticles());
				break;
			case "3": 
				list =service.boardList();
				sList = "";
				int listCont = service.countArticles();
				
				for(int i=0; i<listCont; i++){
					 sList += list[i].toString()+"\n";
				}
				JOptionPane.showMessageDialog(null, "리스트\n"+sList);
				break;
			case "4": 
				int seq = Integer.parseInt(JOptionPane.showInputDialog("seq를 입력하세요"));
				JOptionPane.showMessageDialog(null, "검색결과\n"+service.findBySeq(seq));
				break;
			case "5": 
				list = service.findByWriter(JOptionPane.showInputDialog("글쓴이를 입력하세요"));
				sList = "";
				
				for(int i=0; i<list.length; i++){
					 sList += list[i].toString()+"\n";
				}
				JOptionPane.showMessageDialog(null, "리스트\n"+sList);
				break;
			case "6": 
				board = new BoardBean();
				board.setSeq(Integer.parseInt(JOptionPane.showInputDialog("변경할 게시글의 seq를 입력하세요")));
				board.setTitle(JOptionPane.showInputDialog("변경할 제목 입력"));
				board.setContent(JOptionPane.showInputDialog("새로운 내용 입력"));
				board.setRegDate(JOptionPane.showInputDialog("수정된 날짜 입력"));
				service.updateBoard(board);
				
				JOptionPane.showMessageDialog(null,"수정이 완료되었습니다.");
				break;
			case "7": 
				service.deleteBoard(Integer.parseInt(JOptionPane.showInputDialog("삭제할 게시글의 seq를 입력하세요")));
				
				JOptionPane.showMessageDialog(null, "게시글 삭제 완료");
				break;			
			}
		}
	}
}
