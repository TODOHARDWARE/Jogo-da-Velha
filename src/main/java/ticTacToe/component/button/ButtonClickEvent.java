package ticTacToe.component.button;

public final class ButtonClickEvent {
    public static enum MouseButton {LEFT, MIDDLE, RIGHT};

    public final Button source;
    public final MouseButton mouseButton;

    public ButtonClickEvent(Button source, MouseButton mouseButton) {
        this.source = source;
        this.mouseButton = mouseButton;
    }


}
