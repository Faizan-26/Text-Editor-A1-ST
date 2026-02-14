package business;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bll.IEditorBO;
import bll.command.TransliterateCommand;

public class TransliterateCommandTest {

	private IEditorBO mockEditorBO;
	private TransliterateCommand transliterateCommand;

	@Before
	public void setUp() {
		mockEditorBO = Mockito.mock(IEditorBO.class);
	}

	@Test
	public void testExecuteSuccess() {
		int pageId = 1;
		String content = "salam";
		String expectedResult = "سلام";
		
		Mockito.when(mockEditorBO.transliterate(pageId, content)).thenReturn(expectedResult);

		transliterateCommand = new TransliterateCommand(mockEditorBO, pageId, content);
		boolean result = transliterateCommand.execute();

		assertTrue(result);
		assertEquals(expectedResult, transliterateCommand.getResult());
		Mockito.verify(mockEditorBO).transliterate(pageId, content);
	}

	@Test
	public void testExecuteFailure() {
		int pageId = 1;
		String content = "invalid";
		
		Mockito.when(mockEditorBO.transliterate(pageId, content)).thenReturn(null);

		transliterateCommand = new TransliterateCommand(mockEditorBO, pageId, content);
		boolean result = transliterateCommand.execute();

		assertFalse(result);
		assertNull(transliterateCommand.getResult());
		Mockito.verify(mockEditorBO).transliterate(pageId, content);
	}
}
