package webec

class Module {
    String  name
    Integer semester
    String  location

    // relationsships
    User     user
    Lecturer lecturer
    static   hasMany=[exams:Exam]

    static constraints = {
        name     (blank:false, nullable: false, size:1..50)
        semester (nullable: false, min:1, max: 16)
        location (blank:false, nullable: false, size:1..50)
    }

    String toString(){
        return name
    }
}
