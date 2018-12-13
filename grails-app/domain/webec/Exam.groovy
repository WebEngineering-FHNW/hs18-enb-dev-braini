package webec

class Exam {
    Integer gradeID
    Date    date
    Integer weighting
    Integer grade

    // relationsships
    static belongsTo=[name:Module]

    static constraints = {
        gradeID   (blank:false, nullable: false)
        date      (blank:false, nullable: false)
        weighting (blank:false, nullable: false, min:1, max:100)
        grade     (blank:false, nullable: false, min:1, max:6)
    }

    String toString(){
        return grade
    }
}
