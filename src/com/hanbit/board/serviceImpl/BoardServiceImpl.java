package com.hanbit.board.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

public class BoardServiceImpl implements BoardService {
	BoardBean board;
	List<BoardBean> list;
	
	//생성자
	public BoardServiceImpl(){
		board = new BoardBean();
		list = new ArrayList<>();   
	}
	
	@Override
	public void writeBoard(BoardBean bean) {
		//seq 생성
		int seqCount = list.size() + 1;
		bean.setSeq(seqCount); 
		
		list.add(bean);
		
		System.out.println("serviceImpl writeBoard:" + bean.toString());
	}

	@Override
	public void updateBoard(BoardBean bean) {
		for(BoardBean b:list){
			if(bean.getSeq() == b.getSeq()){
				b.setTitle(bean.getTitle());
				b.setContent(bean.getContent());
				b.setRegDate(bean.getContent());
			}
		}
	}

	@Override
	public void deleteBoard(int seq) {
		for(BoardBean b:list){
			if(seq == b.getSeq()){
				list.remove(b);
			}
		}
	}

	@Override
	public List<BoardBean> boardList() {
		return list;
	}

	@Override
	public int countArticles() {
		return list.size();
	}

	@Override
	public BoardBean findBySeq(int seq) {
		board = new BoardBean();
		
		for(BoardBean b:list){
			if(seq == b.getSeq()){
				board = b;
				break;
			}
		}
		return board;
	}

	@Override
	public List<BoardBean> findByWriter(String name) {
		int count = 0;	//결과 배열의 크기
		for(int i=0; i<list.size(); i++){
			if(name.equals(list.get(i).getWriter())){
				count++;
			}
		}
	    
		List<BoardBean> nameRes = new ArrayList<>();
		for(BoardBean b:list){
			if(name.equals(b.getWriter())){
				nameRes.add(b);
				if(count == nameRes.size()){ break; }
			}
		}
	    return nameRes;
	}
}
