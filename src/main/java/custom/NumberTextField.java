package custom;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

	public NumberTextField() {
		this.setPromptText("49");
	}
	
	@Override
	public void replaceText(int start, int end, String text) {
		if(text.matches("[0-9]") || text.isEmpty()) {
			super.replaceText(start, end, text);
		}
	}
	
	@Override
	public void replaceSelection(String replacement) {
		super.replaceSelection(replacement);
	}
	
	
}