package com.hanbit.board.serviceImpl;

import javax.swing.JOptionPane;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;

public class BoardServiceImpl implements BoardService {

	int count;
	BoardBean board;
	BoardBean[] list;
	
	//생성자
	public BoardServiceImpl(){
		count = 0;
		board = new BoardBean();
		list = new BoardBean[count];   
	}
	
	@Override //?
	public void writeBoard(BoardBean bean) {
		
		 //seq 생성
		int seqCount = count + 1; 
		bean.setSeq(seqCount); 
		
		//seq자동생성
		if (count == list.length) {
			BoardBean[] temp = new BoardBean[count + 1]; 
			System.arraycopy(list, 0, temp, 0, count);
			list = temp; 
			//seqCount++; 2
		}
		
		list[count++] = bean; 
		System.out.println("serviceImpl writeBoard:" + bean.toString());
	}

	@Override
	public void updateBoard(BoardBean bean) {
		board = findBySeq(bean.getSeq());
		
		System.out.println("bean2: "+bean.toString());
		System.out.println("board2: "+board.toString());
		
		
		
		if(board.getSeq() == bean.getSeq()){
			board.setTitle(bean.getTitle());
			board.setContent(bean.getContent());
			board.setRegDate(bean.getContent());
		}
		
		System.out.println("bean3: "+bean.toString());
		System.out.println("board3: "+board.toString());
		
	}

	@Override
	public void deleteBoard(int seq) {
		board = findBySeq(seq);
		
		for(int i=0; i<count; i++){
			if(seq == list[i].getSeq()){
				list[i]=list[count-1];
				list[count-1] = null;
				count--;
			}
		}
	}

	@Override
	public BoardBean[] boardList() {
		return list;
	}

	@Override
	public int countArticles() {
		return count;
	}

	@Override
	public BoardBean findBySeq(int seq) {
		
		for(int i=0; i<count; i++){
			if(seq == list[i].getSeq()){
				board = list[i];
				break;
			}
		}
		return board;
	}

	@Override //?
	public BoardBean[] findByWriter(String name) {
		int a = 0;	//결과 배열의 크기
		for(int i=0; i<list.length; i++){
			if(name.equals(list[i].getWriter())){
				a++;
			}
		}
	    
		int j=0;	//결과 배열 index
		BoardBean[] nameRes = new BoardBean[a];
	    for(int i=0; i<list.length; i++){
	        if(name.equals(list[i].getWriter())){
	        	nameRes[j] = list[i];
	            j++;
	        }
	        if(a==j){
            	break;
            }
	    }
	    return nameRes;
	}
}
