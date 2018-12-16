package webec

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String lastname
    String firstname
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        username   (email:true, nullable: false, blank: false, unique: true)
        password   (nullable: false, blank: false, password: true)
        lastname   (size:1..50, matches:"[a-zA-Z ]+")
        firstname  (size:1..50, matches:"[a-zA-Z ]+")
    }

    static mapping = {
        password column: '`password`'
    }

    String toString(){
        return username
    }
}
