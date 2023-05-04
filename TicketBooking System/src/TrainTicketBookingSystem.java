import java.sql.*;

public class TrainTicketBookingSystem {
    private Connection connection;

    public TrainTicketBookingSystem(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        if(connection!=null){
            System.out.println("Connected to the Databse Successfully");
        }
    }

    public void bookTicket(int trainId, String passengerName) throws SQLException {
        // Check if there are available seats on the train
        PreparedStatement checkSeatsStmt = connection.prepareStatement(
            "SELECT seats_available FROM train_schedule WHERE id = ?");
        checkSeatsStmt.setInt(1, trainId);
        ResultSet seatsResult = checkSeatsStmt.executeQuery();
        seatsResult.next();
        int seatsAvailable = seatsResult.getInt("seats_available");
        if (seatsAvailable <= 0) {
            throw new SQLException("No available seats on this train");
        }

        // Book the ticket
        PreparedStatement bookTicketStmt = connection.prepareStatement(
            "INSERT INTO booking_details (train_id, passenger_name, departure_time, arrival_time) " +
            "SELECT id, ?, departure_time, arrival_time FROM train_schedule WHERE id = ?");
        bookTicketStmt.setString(1, passengerName);
        bookTicketStmt.setInt(2, trainId);
        int rowsUpdated = bookTicketStmt.executeUpdate();
        if (rowsUpdated != 1) {
            throw new SQLException("Failed to book ticket");
        }

        // Decrement the number of available seats on the train
        PreparedStatement updateSeatsStmt = connection.prepareStatement(
            "UPDATE train_schedule SET seats_available = seats_available - 1 WHERE id = ?");
        updateSeatsStmt.setInt(1, trainId);
        updateSeatsStmt.executeUpdate();
    }

    public ResultSet getTrainSchedule() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM train_schedule");
        return rs;
    }
}
