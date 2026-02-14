package bll.command;

import java.io.File;
import bll.IEditorBO;

public class ImportCommand implements ICommand {

	private IEditorBO editorBO;
	private File file;
	private String fileName;

	public ImportCommand(IEditorBO editorBO, File file, String fileName) {
		this.editorBO = editorBO;
		this.file = file;
		this.fileName = fileName;
	}

	@Override
	public boolean execute() {
		return editorBO.importTextFiles(file, fileName);
	}
}
