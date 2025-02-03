interface Flyable { // public is OK as well
    void fly(Destination d);
}

// b. Could NOT be written as an abstract class
//    Because Jet cannot extend both Flyable
//    AND Vehicle (per the class diagram).
//    Java doesn't support multiple inheritance
//    of classes - only of interfaces.
