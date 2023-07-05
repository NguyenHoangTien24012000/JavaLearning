package LuyenTapJava.Collection.TreeSet;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Theatre {
    class Seat implements Comparable<Seat> {
        private String seatNum;
        private boolean reserved;

        public Seat(char rowChar, int seatNo) {
            this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase();
        }

        @Override
        public String toString() {
            return seatNum;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }

    private String theatreName;
    private int seatsPerRow;
    private NavigableSet<Seat> seats;

    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats / rows;
        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatsPerRow + (int) 'A');
            int seatInRow = i % seatsPerRow + 1;
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    public void printMapTheatre() {
        String separatorLine = "-".repeat(100);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, theatreName);
        int index = 0;
        for (Seat seat : seats) {
            System.out.printf("%-8s%s",
                    seat.seatNum + (seat.reserved ? "(●)" : ""),
                    (index++ + 1) % seatsPerRow == 0 ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    public String revertSeat(char row, int seat) {
        Seat seatRevert = new Seat(row, seat);
        Seat requested = seats.floor(seatRevert);

        if (requested == null || !requested.seatNum.equals(seatRevert.seatNum)) {
            System.out.print("No such seat: " + seatRevert);
            System.out.printf(": Seat must be between %s and %s%n", seats.first().seatNum, seats.last().seatNum);
        } else {
            if (!requested.reserved) {
                requested.reserved = true;
                return requested.seatNum;
            } else {
                System.out.println("Seat's already reserved!");
            }
        }
        return null;
    }

    public Set<Seat> reserveSeat(int count, char minRow, char maxRow, int minSeat, int maxSeat) {
        char lastValid = seats.last().seatNum.charAt(0);
        System.out.println("last valid" + lastValid);
        maxRow = (maxRow < lastValid) ? maxRow : lastValid;
        if (!validate(count, minRow, maxRow, minSeat, maxSeat)) {
            return null;
        }
        NavigableSet<Seat> selected = null;
        for (char letter = minRow; letter <= maxRow; letter++) {
            NavigableSet<Seat> contiguous = seats.subSet(new Seat(letter, minSeat), true,
                    new Seat(letter, maxSeat), true);
            int index = 0;
            Seat first = null;
            for (Seat current : contiguous){
                if(current.reserved){
                    index = 0;
                    continue;
                }
                first = (index == 0) ? current : first;
                if(++index == count){
                    selected = contiguous.subSet(first, true, current, true);
                    break;
                }
            }
            if (selected != null){
                break;
            }
        }
        Set<Seat> reveredSeats = null;
        if(selected != null){
            selected.forEach(seat -> seat.reserved = true);
            reveredSeats = new TreeSet<>(selected);
        }
        return reveredSeats;
    }

    private boolean validate(int count, char first, char last, int min, int max) {
        boolean result = (min > 0 || seatsPerRow >= count || (max - min + 1) >= count);
        result = result && seats.contains(new Seat(first, min));
        if (!result) {
            System.out.printf("Invalid %1$d seats between " +
                    "%2$c[%3$d-%4$d]-5%$c[%3$d-4%$d] Try again", count, first, min, max, last);
            System.out.printf(": Seat must be between %s and %s%n", seats.first().seatNum, seats.last().seatNum);
        }
        return result;
    }
}
