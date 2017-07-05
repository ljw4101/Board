package com.hanbit.board.service;

import com.hanbit.board.domain.BoardBean;

public interface BoardService {
	//setter
	public void writeBoard(BoardBean bean);
	public void updateBoard(BoardBean bean);
	public void deleteBoard(int seq);
	//getter
	public BoardBean[] boardList();
	public int countArticles();
	public BoardBean findBySeq(int seq);
	public BoardBean[] findByWriter(String name);
}
