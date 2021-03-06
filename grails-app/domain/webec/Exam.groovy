package webec

/**
 * Domain definitions for Exam.
 * One Module can have 0, 1 or many exams.
 */
class Exam {
    Date       date
    String     description
    BigDecimal grade

    // relationsship
    static belongsTo = [module:Module]

    static constraints = {
        date        nullable: false
        description nullable: true, size: 0..50
        grade       nullable: true, min: 1.0, max: 6.0
    }

    String toString(){
        return grade
    }
}
