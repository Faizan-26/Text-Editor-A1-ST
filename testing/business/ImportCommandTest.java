package business;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bll.IEditorBO;
import bll.command.ImportCommand;
import java.io.File;

public class ImportCommandTest {

	private IEditorBO mockEditorBO;
	private File mockFile;
	private ImportCommand importCommand;

	@Before
	public void setUp() {
		mockEditorBO = Mockito.mock(IEditorBO.class);
		mockFile = Mockito.mock(File.class);
	}

	@Test
	public void testExecuteSuccess() {
		String fileName = "test.txt";
		Mockito.when(mockEditorBO.importTextFiles(mockFile, fileName)).thenReturn(true);

		importCommand = new ImportCommand(mockEditorBO, mockFile, fileName);
		boolean result = importCommand.execute();

		assertTrue(result);
		Mockito.verify(mockEditorBO).importTextFiles(mockFile, fileName);
	}

	@Test
	public void testExecuteFailure() {
		String fileName = "invalid.txt";
		Mockito.when(mockEditorBO.importTextFiles(mockFile, fileName)).thenReturn(false);

		importCommand = new ImportCommand(mockEditorBO, mockFile, fileName);
		boolean result = importCommand.execute();

		assertFalse(result);
		Mockito.verify(mockEditorBO).importTextFiles(mockFile, fileName);
	}
}
