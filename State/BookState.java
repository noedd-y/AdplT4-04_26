package State;
public interface BookState {
    boolean borrow();
    boolean returnBook();
    boolean reserve();

    String getState();
}