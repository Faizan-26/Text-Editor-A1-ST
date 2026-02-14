package bll.command;

import bll.IEditorBO;

public class SaveCommand implements ICommand {

	private IEditorBO editorBO;
	private int fileId;
	private String fileName;
	private int pageNumber;
	private String content;

	public SaveCommand(IEditorBO editorBO, int fileId, String fileName, int pageNumber, String content) {
		this.editorBO = editorBO;
		this.fileId = fileId;
		this.fileName = fileName;
		this.pageNumber = pageNumber;
		this.content = content;
	}

	@Override
	public boolean execute() {
		return editorBO.updateFile(fileId, fileName, pageNumber, content);
	}
}
