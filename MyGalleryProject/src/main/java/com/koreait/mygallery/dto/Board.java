package com.koreait.mygallery.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Board {
	private long boardNo;
	private String id;
	private String content;
	private String postdate;
	private String ip;
	private int state;
	private long groupno;
	private int groupord;
	private int depth;
}
