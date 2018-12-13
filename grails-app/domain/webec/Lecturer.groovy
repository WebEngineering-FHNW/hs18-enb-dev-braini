package webec

class Lecturer {
    String lecturerID
    String lastname
    String firstname
    String email

    static constraints = {
        lecturerID (blank:false, nullable: false, size:1..50, matches:"[a-zA-Z1-9_]+")
        lastname   (size:3..50, matches:"[a-zA-Z ]+")
        firstname  (size:3..50, matches:"[a-zA-Z ]+")
        email      (email:true, blank:false, nullable:false)
    }

    String toString(){
        return lecturerID
    }
}
