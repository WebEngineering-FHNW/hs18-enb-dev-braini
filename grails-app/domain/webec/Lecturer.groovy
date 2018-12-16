package webec

/**
 * Domain definitions for Lecturer.
 * Each Module have one lecturer.
 */
class Lecturer {
    String lastname
    String firstname
    String email

    static constraints = {
        lastname  size: 3..50, matches: "[a-zA-Z ]+"
        firstname size: 3..50, matches: "[a-zA-Z ]+"
        email     email: true, blank: false, nullable: false
    }

    String toString(){
        return email
    }
}
