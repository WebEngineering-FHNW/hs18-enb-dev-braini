package webec

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExamServiceSpec extends Specification {

    ExamService examService
    SessionFactory sessionFactory
    Exam exam1, exam2
    User mwinter
    Lecturer weck
    Module aldg1

    /**
     * Populate valid domain instances and return a valid ID
     * @return
     */
    private Long setupData() {
        mwinter    = new User(username:'markus.winter@students2.fhnw.ch', password: 'markus87', lastname:'Winter', firstname:'Markus').save(flush: true, failOnError: true)
        weck      = new Lecturer(lastname:'Weck', firstname:'Wolfgang', email:'wolfgang.weck@fhnw.ch').save(flush: true, failOnError: true)
        aldg1 = new Module(name:'aldg1', semester:3, location:'6.1H07', lecturer:weck, user:mwinter).save(flush: true, failOnError: true)
        exam1 = new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2018-11-09 08:15:00"), description:'Zwischenprüfung', grade: 4.5, module:aldg1).save(flush: true, failOnError: true)
        exam2 = new Exam(date:Date.parse("yyyy-MM-dd hh:mm:ss", "2019-01-15 15:15:00"), description:'MSP', grade: 5.25, module:aldg1).save(flush: true, failOnError: true)

        return exam1.id

    }

    /**
     * Verify that at least two instances exists
     */
    void "test get"() {
        setupData()

        expect:
        examService.get(1) != null
    }

    /**
     * Verify the correct instances are returned
     */
    void "test list"() {
        setupData()

        when:
        List<Exam> examList = examService.list(max: 2, offset: 2)

        then:
        examList.size() == 2

        (examList[0].getDescription() == "Kurztest 1")
        (examList[1].getDescription() == "Kurztest 2")
    }

    /**
     * Verify if there are the correct amount if instances
     */
    void "test count"() {
        setupData()

        expect:
        examService.count() == 11
    }

    /**
     * Verify if instances ary correctly deleted
     */
    void "test delete"() {
        Long examId = setupData()

        expect:
        examService.count() == 11

        when:
        examService.delete(examId)
        sessionFactory.currentSession.flush()

        then:
        examService.count() == 10
    }

    /**
     * Verify instances can be saved
     */
    void "test save"() {
        setupData()

        when:
        Exam exam = exam1
        examService.save(exam)

        then:
        exam.id != null
    }
}
