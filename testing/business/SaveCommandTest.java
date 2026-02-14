package business;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bll.IEditorBO;
import bll.command.SaveCommand;

public class SaveCommandTest {

	private IEditorBO mockEditorBO;
	private SaveCommand saveCommand;

	@Before
	public void setUp() {
		mockEditorBO = Mockito.mock(IEditorBO.class);
	}

	@Test
	public void testExecuteSuccess() {
		int fileId = 1;
		String fileName = "test.txt";
		int pageNumber = 1;
		String content = "Hello World";
		
		Mockito.when(mockEditorBO.updateFile(fileId, fileName, pageNumber, content)).thenReturn(true);

		saveCommand = new SaveCommand(mockEditorBO, fileId, fileName, pageNumber, content);
		boolean result = saveCommand.execute();

		assertTrue(result);
		Mockito.verify(mockEditorBO).updateFile(fileId, fileName, pageNumber, content);
	}

	@Test
	public void testExecuteFailure() {
		int fileId = 1;
		String fileName = "test.txt";
		int pageNumber = 1;
		String content = "Hello World";
		
		Mockito.when(mockEditorBO.updateFile(fileId, fileName, pageNumber, content)).thenReturn(false);

		saveCommand = new SaveCommand(mockEditorBO, fileId, fileName, pageNumber, content);
		boolean result = saveCommand.execute();

		assertFalse(result);
		Mockito.verify(mockEditorBO).updateFile(fileId, fileName, pageNumber, content);
	}
}
