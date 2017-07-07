package com.treeApp.dto;

import java.util.List;

public class ManagerDTO extends TreeDTO{
	
	private List<TreeDTO> children;

	public List<TreeDTO> getChildren() {
		return children;
	}

	public void setChildren(List<TreeDTO> children) {
		this.children = children;
	}

}
