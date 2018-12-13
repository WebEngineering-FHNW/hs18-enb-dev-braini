package webec

class Module {
    String  name
    Integer semester
    String  location

    // relationsships
    User     userID
    Lecturer lecturerID
    static   belongsTo=[exams:Exam]

    static constraints = {
        name     (blank:false, nullable: false, size:1..50)
        semester (blank:false, nullable: false, min: 1, max: 16)
        location (blank:false, nullable: false, size:1..50)
    }

    String toString(){
        return name
    }
}
