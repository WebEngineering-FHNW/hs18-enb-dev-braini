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

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Lecturer(...).save(flush: true, failOnError: true)
        //new Lecturer(...).save(flush: true, failOnError: true)
        //Lecturer lecturer = new Lecturer(...).save(flush: true, failOnError: true)
        //new Lecturer(...).save(flush: true, failOnError: true)
        //new Lecturer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //lecturer.id
    }

    void "test get"() {
        setupData()

        expect:
        lecturerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Lecturer> lecturerList = lecturerService.list(max: 2, offset: 2)

        then:
        lecturerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        lecturerService.count() == 5
    }

    void "test delete"() {
        Long lecturerId = setupData()

        expect:
        lecturerService.count() == 5

        when:
        lecturerService.delete(lecturerId)
        sessionFactory.currentSession.flush()

        then:
        lecturerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Lecturer lecturer = new Lecturer()
        lecturerService.save(lecturer)

        then:
        lecturer.id != null
    }
}
