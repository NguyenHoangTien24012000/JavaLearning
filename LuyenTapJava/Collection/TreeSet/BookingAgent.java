package LuyenTapJava.Collection.TreeSet;

public class BookingAgent {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Rap quoc gia", 10, 100);
        theatre.printMapTheatre();
        bookSeat(theatre, 'A', 4);
        bookSeats(theatre, 5, 'B', 1, 10);
        bookSeats(theatre, 5, 'B', 1, 10);
        bookSeats(theatre, 12, 'C','D', 1, 10);
    }
    public static void bookSeat(Theatre theatre, char rowChar, int seatNo){
        String seat = theatre.revertSeat(rowChar, seatNo);
        if(seat != null){
            System.out.println("Booking success: " + seat);
            theatre.printMapTheatre();
        }else {
            System.out.println("Booking error: " + rowChar + seatNo);
        }
    }
    public static void bookSeats(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat){
        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }

    public static void bookSeats(Theatre theatre, int tickets, char minRow, char maxRow, int minSeat, int maxSeat){
        var seats = theatre.reserveSeat(tickets, minRow, maxRow, minSeat, maxSeat);
        if(seats != null){
            System.out.println("Revered success: " + seats);
            theatre.printMapTheatre();
        }else {
            System.out.println("Error: not found " + minRow + "-" + maxRow);
        }
    }

}
