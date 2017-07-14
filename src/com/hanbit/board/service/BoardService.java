package com.hanbit.board.service;

import java.util.List;
import com.hanbit.board.domain.BoardBean;

public interface BoardService {
	//setter
	public void writeBoard(BoardBean bean);
	public void updateBoard(BoardBean bean);
	public void deleteBoard(int seq);
	//getter
	public List<BoardBean> boardList();
	public int countArticles();
	public BoardBean findBySeq(int seq);
	public List<BoardBean> findByWriter(String name);
}
