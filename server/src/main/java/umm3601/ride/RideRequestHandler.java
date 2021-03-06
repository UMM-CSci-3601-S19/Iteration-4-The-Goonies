package umm3601.ride;

import org.bson.Document;
import spark.Request;
import spark.Response;

public class RideRequestHandler {

  private final RideController rideController;

  public RideRequestHandler(RideController rideController) {
    this.rideController = rideController;
  }

  /**
   * Method called from Server when the 'api/rides' endpoint is received.
   * This handles the request received and the response that will be sent back.
   *
   * @param req the HTTP request
   * @param res the HTTP response
   * @return an array of rides in JSON formatted String
   */
  public String getRides(Request req, Response res) {
    res.type("application/json");
    System.out.println("this is riderequest body" + req.body());
    return rideController.getRides(req.queryMap().toMap());
  }



  public String getMyRides(Request req, Response res) {
    res.type("application/json");
    return rideController.getMyRides(req.queryMap().toMap());
  }

  /**
   * Method called from Server when the 'api/rides/new' endpoint is received.
   * Gets specified rides info from request and calls addNewRide helper method
   * to append that info to a document
   *
   * @param req the HTTP request
   * @param res the HTTP response
   * @return a boolean as whether the ride was added successfully or not
   */
  public String addNewRide(Request req, Response res) {
    res.type("application/json");

    Document newRide = Document.parse(req.body());

    String user = newRide.getString("user");
    String userId = newRide.getString("userId");
    String notes = newRide.getString("notes");
    int seatsAvailable = newRide.getInteger("seatsAvailable");
    int seatsTotal = newRide.getInteger("seatsTotal");
    String origin = newRide.getString("origin");
    String destination = newRide.getString("destination");
    String departureDate = newRide.getString("departureDate");
    String departureTime = newRide.getString("departureTime");
    boolean isDriving = newRide.getBoolean("isDriving");
    boolean roundTrip = newRide.getBoolean("roundTrip");
    boolean nonSmoking = newRide.getBoolean("nonSmoking");
    boolean eco = newRide.getBoolean("eco");
    boolean petFriendly = newRide.getBoolean("petFriendly");

    return rideController.addNewRide(user, userId, notes, seatsAvailable, seatsTotal, origin, destination,
      departureDate, departureTime, isDriving, roundTrip, nonSmoking, eco, petFriendly);

  }

  public Boolean deleteRide(Request req, Response res){
    res.type("application/json");

    Document deleteRide = Document.parse(req.body());

    String id = deleteRide.getString("_id");
    System.err.println("Deleting ride id=" + id);
    return rideController.deleteRide(id);
  }

  public boolean editRide(Request req, Response res) {

    System.err.println("Print something!");

    res.type("application/json");

    // Turn the request into a Document
    Document editRide = Document.parse(req.body());

    String id = editRide.getObjectId("_id").toHexString();
//    We don't include the following fields, because they shouldn't be edited.
//    String user = editRide.getString("user");
//    String userId = editRide.getString("userId");
    String notes = editRide.getString("notes");
    int seatsAvailable = editRide.getInteger("seatsAvailable");
    int seatsTotal = editRide.getInteger("seatsTotal");
    String origin = editRide.getString("origin");
    String destination = editRide.getString("destination");
    String departureDate = editRide.getString("departureDate");
    String departureTime = editRide.getString("departureTime");
    Boolean isDriving = editRide.getBoolean("isDriving");
    Boolean roundTrip = editRide.getBoolean("roundTrip");
    Boolean nonSmoking = editRide.getBoolean("nonSmoking");
    Boolean eco = editRide.getBoolean("eco");
    Boolean petFriendly = editRide.getBoolean("petFriendly");

    return rideController.editRide(id, notes, seatsAvailable, seatsTotal, origin, destination,
      departureDate, departureTime, isDriving, roundTrip, nonSmoking, eco, petFriendly);
  }

  public boolean joinRide(Request req, Response res) {

    res.type("application/json");

    // Turn the request into a Document
    Document joinRide = Document.parse(req.body());

    System.out.println(joinRide);

    String rideId = joinRide.getObjectId("rideId").toHexString();
    System.out.println(rideId);
    String passengerId = joinRide.getString("passengerId");
    System.out.println(passengerId);
    String passengerName = joinRide.getString("passengerName");
    System.out.println(passengerName);

    return rideController.joinRide(rideId, passengerId, passengerName);
  }


}
