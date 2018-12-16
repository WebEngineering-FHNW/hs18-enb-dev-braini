package webec
/**
 * Domain definitions for Lecturer.
 * Each Module have one user and one lecturer.
 * Each Module have 0, 1 or many exams.
 */
class Module {
    String  name
    Integer semester
    String  location

    // relationsships
    User     user
    Lecturer lecturer
    static   hasMany=[exams:Exam]

    static constraints = {
        name     blank: false, nullable: false, size: 1..50
        semester nullable: false, min: 1, max: 16
        location blank: false, nullable: false, size: 1..50
    }

    String toString(){
        return name
    }
}
