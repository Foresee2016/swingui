package org.foresee.swingui.interact;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ImageProvider {
	private ArrayList<ImageIcon> icons;
	private int curIdx;
	public ImageProvider(String... files) {
		icons=new ArrayList<>();
		for (String file : files) {
			icons.add(new ImageIcon(file));
		}
		curIdx=0;
	}
	public ImageIcon refresh() {
		if(icons.size()==0){
			return null;
		}
		ImageIcon icon=icons.get(curIdx);
		curIdx++;
		if(curIdx==icons.size()){
			curIdx=0;
		}
		return icon;
	}
	public void close() {
		System.out.println("清理工作");
	}
}
