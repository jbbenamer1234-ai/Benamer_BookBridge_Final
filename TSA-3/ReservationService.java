import java.util.LinkedList;
import java.util.Queue;

public class ReservationService {

    private Queue<Reservation> reservationQueue =
            new LinkedList<>();

    public void reserveBook(
            Reservation reservation) {

        reservationQueue.offer(reservation);
    }

    public Reservation processNextReservation() {

        return reservationQueue.poll();
    }

    public boolean hasReservations() {

        return !reservationQueue.isEmpty();
    }
}