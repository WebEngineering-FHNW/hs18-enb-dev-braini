package webec

class Exam {
    Date       date
    String     description
    Integer    weighting = 100
    BigDecimal grade

    // relationsship
    static belongsTo = [module:Module]

    static constraints = {
        date        (nullable:false)
        description (nullable:true, size: 0..50)
        weighting   (nullable:false, min: 1, max: 100)
        grade       (nullable:true, min: 1.0, max: 6.0)
    }

    String toString(){
        return grade
    }
}
