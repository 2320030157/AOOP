package project;

import java.util.Stack;

public class TextEditor {
    private final StringBuilder text;
    private final Stack<String> undoStack;
    private final Stack<String> redoStack;

    public TextEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void cut(int start, int end) {
        undoStack.push(text.toString());
        text.delete(start, end);
        redoStack.clear();
    }

    public void copy(int start, int end) {
        undoStack.push(text.toString());
        redoStack.clear();
    }

    public void paste(int index, String textToPaste) {
        undoStack.push(text.toString());
        text.insert(index, textToPaste);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text.toString());
            text.setLength(0);
            text.append(undoStack.pop());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text.toString());
            text.setLength(0);
            text.append(redoStack.pop());
        }
    }

    public String getText() {
        return text.toString();
    }
}
