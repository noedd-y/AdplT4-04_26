package observer;

import entity.Book;

//concrete observer
public class ReservationService implements ReservationObserver{

    @Override
    public void update(Book book) {
        System.out.println("Book is available to be borrowed");
    }

}
