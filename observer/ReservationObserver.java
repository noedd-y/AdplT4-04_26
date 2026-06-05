package observer;

import entity.Book;

public interface ReservationObserver {
    void update(Book book);
}
