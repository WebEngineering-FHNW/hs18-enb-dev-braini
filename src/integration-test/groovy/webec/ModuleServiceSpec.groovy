package webec

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ModuleServiceSpec extends Specification {

    ModuleService moduleService
    SessionFactory sessionFactory
    Lecturer ribeaud, weck, mall
    User mwinter
    Module algd1, eti, webec

    /**
     * Populate valid domain instances and return a valid ID
     * @return
     */
    private Long setupData() {
        mwinter    = new User(username:'markus.winter@students2.fhnw.ch', password: 'markus87', lastname:'Winter', firstname:'Markus').save(flush: true, failOnError: true)

        ribeaud   = new Lecturer(lastname:'Ribeaud', firstname:'Christian', email:'christian.ribeaud@fhnw.ch').save(flush: true, failOnError: true)
        weck      = new Lecturer(lastname:'Weck', firstname:'Wolfgang', email:'wolfgang.weck@fhnw.ch').save(flush: true, failOnError: true)
        mall      = new Lecturer(lastname:'Mall', firstname:'Daniel', email:'daniel.mall@fhnw.ch').save(flush: true, failOnError: true)

        algd1 = new Module(name:'aldg1', semester:3, location:'6.1H07', lecturer: weck, user: mwinter).save(flush: true, failOnError: true)
        eti   = new Module(name:'eti', semester:3, location:'5.4.H06', lecturer: mall, user: mwinter).save(flush: true, failOnError: true)
        webec = new Module(name:'webeC', semester:3, location:'5.2H14', lecturer: ribeaud, user: mwinter).save(flush: true, failOnError: true)

        return webec.id
    }

    /**
     * Verify that at least two instances exists
     */
    void "test get"() {
        setupData()

        expect:
        moduleService.get(1) != null
    }

    /**
     * Verify the correct instances are returned
     */
    void "test list"() {
        setupData()

        when:
        List<Module> moduleList = moduleService.list(max: 2, offset: 3)

        then:
        moduleList.size() == 2

        (moduleList[0].getName() == "aldg1")
        (moduleList[1].getName() == "eti")
    }

    /**
     * Verify if there are the correct amount if instances
     */
    void "test count"() {
        setupData()

        expect:
        moduleService.count() == 6
    }

    /**
     * Verify if instances ary correctly deleted
     */
    void "test delete"() {
        Long moduleId = setupData()

        expect:
        moduleService.count() == 6

        when:
        moduleService.delete(moduleId)
        sessionFactory.currentSession.flush()

        then:
        moduleService.count() == 5
    }

    /**
     * Verify instances can be saved
     */
    void "test save"() {
        setupData()

        when:
        Module module = webec
        moduleService.save(module)

        then:
        module.id != null
    }
}
