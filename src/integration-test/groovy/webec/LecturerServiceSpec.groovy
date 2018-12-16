package webec

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LecturerServiceSpec extends Specification {

    LecturerService lecturerService
    SessionFactory sessionFactory
    Lecturer ribeaud, weck, mall;

    /**
     * Populate valid domain instances and return a valid ID
     * @return
     */
    private Long setupData() {
        ribeaud   = new Lecturer(lastname:'Ribeaud', firstname:'Christian', email:'christian.ribeaud@fhnw.ch').save(flush: true, failOnError: true)
        weck      = new Lecturer(lastname:'Weck', firstname:'Wolfgang', email:'wolfgang.weck@fhnw.ch').save(flush: true, failOnError: true)
        mall      = new Lecturer(lastname:'Mall', firstname:'Daniel', email:'daniel.mall@fhnw.ch').save(flush: true, failOnError: true)

        return mall.id
    }

    /**
     * Verify that at least two instances exists
     */
    void "test get"() {
        setupData()

        expect:
        lecturerService.get(1) != null
    }

    /**
     * Verify the correct instances are returned
     */
    void "test list"() {
        setupData()

        when:
        List<Lecturer> lecturerList = lecturerService.list(max: 2, offset: 3)

        then:
        lecturerList.size() == 2

        (lecturerList[0].getEmail() == "christian.ribeaud@fhnw.ch")
        (lecturerList[1].getEmail() == "wolfgang.weck@fhnw.ch")
    }

    /**
     * Verify if there are the correct amount if instances
     */
    void "test count"() {
        setupData()

        expect:
        lecturerService.count() == 6
    }

    /**
     * Verify if instances ary correctly deleted
     */
    void "test delete"() {
        Long lecturerId = setupData()

        expect:
        lecturerService.count() == 6

        when:
        lecturerService.delete(lecturerId)
        sessionFactory.currentSession.flush()

        then:
        lecturerService.count() == 5
    }

    /**
     * Verify instances can be saved
     */
    void "test save"() {
        setupData()

        when:
        Lecturer lecturer = ribeaud;
        lecturerService.save(lecturer)

        then:
        lecturer.id != null
    }
}
