package bll.command;

import bll.IEditorBO;

public class TransliterateCommand implements ICommand {

	private IEditorBO editorBO;
	private int pageId;
	private String content;
	private String result;

	public TransliterateCommand(IEditorBO editorBO, int pageId, String content) {
		this.editorBO = editorBO;
		this.pageId = pageId;
		this.content = content;
	}

	@Override
	public boolean execute() {
		result = editorBO.transliterate(pageId, content);
		return result != null;
	}

	public String getResult() {
		return result;
	}
}
