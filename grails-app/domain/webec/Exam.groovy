package webec

class Exam {
    Date    date
    Integer weighting
    Integer grade

    // relationsships
    static belongsTo=[module:Module]

    static constraints = {
        date      (nullable:false)
        weighting (nullable:false, min: 1, max: 100)
        grade     (nullable:true, min: 1, max: 6)
    }

    String toString(){
        return grade
    }
}
