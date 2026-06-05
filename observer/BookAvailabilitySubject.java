package observer;

import entity.Book;

public interface BookAvailabilitySubject {
    void addObserver(ReservationObserver o);
    void removeObserver(ReservationObserver o);
    void notifyObservers(Book book);
}
