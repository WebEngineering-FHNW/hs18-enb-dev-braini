package webec

import grails.plugin.springsecurity.annotation.Secured

/**
 * Controller for Grade Calculator
 */
@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class GradeCalculatorController {

    def index() { }
}
