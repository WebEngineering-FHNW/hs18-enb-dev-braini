package webec

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserServiceSpec extends Specification {

    UserService userService
    SessionFactory sessionFactory
    User mwinter, thundt, mpeter

    /**
     * Populate valid domain instances and return a valid ID
     * @return
     */
    private Long setupData() {
        mwinter    = new User(username:'markus.winter@students2.fhnw.ch', password: 'markus87', lastname:'Winter', firstname:'Markus').save(flush: true, failOnError: true)
        thundt     = new User(username: 'thierry.hundt@students2.fhnw.ch', password: 'thundt', lastname:'Hundt', firstname:'Thierry').save(flush: true, failOnError: true)
        mpeter     = new User(username: 'marco.peter1@students2.fhnw.ch', password: 'mpeter1', lastname:'Peter', firstname:'Marco').save(flush: true, failOnError: true)

        return mwinter.id
    }

    /**
     * Verify that at least two instances exists
     */
    void "test get"() {
        setupData()

        expect:
        userService.get(1) != null
    }

    /**
     * Verify the correct instances are returned
     */
    void "test list"() {
        setupData()

        when:
        List<User> userList = userService.list(max: 2, offset: 3)

        then:
        userList.size() == 2

        (userList[0].getUsername() == "markus.winter@students2.fhnw.ch")
        (userList[1].getUsername() == "thierry.hundt@students2.fhnw.ch")
    }

    /**
     * Verify if there are the correct amount if instances
     */
    void "test count"() {
        setupData()

        expect:
        userService.count() == 6
    }

    /**
     * Verify if instances ary correctly deleted
     */
    void "test delete"() {
        Long userId = setupData()

        expect:
        userService.count() == 6

        when:
        userService.delete(userId)
        sessionFactory.currentSession.flush()

        then:
        userService.count() == 5
    }

    /**
     * Verify instances can be saved
     */
    void "test save"() {
        setupData()

        when:
        User user = mwinter
        userService.save(user)

        then:
        user.id != null
    }
}
