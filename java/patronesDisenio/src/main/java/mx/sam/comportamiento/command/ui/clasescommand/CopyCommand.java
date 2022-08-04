package mx.sam.comportamiento.command.ui.clasescommand;

import mx.sam.comportamiento.command.ui.gui.Editor;

public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}