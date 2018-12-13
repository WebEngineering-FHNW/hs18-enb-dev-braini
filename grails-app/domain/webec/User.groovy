package webec

class User {
    String lastname
    String firstname
    String email

    static constraints = {
        lastname   (size:1..50, matches:"[a-zA-Z ]+")
        firstname  (size:1..50, matches:"[a-zA-Z ]+")
        email      (email:true, blank:false, nullable:false)
    }

    String toString(){
        return email
    }
}
