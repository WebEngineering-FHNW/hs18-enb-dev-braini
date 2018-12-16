package webec

import grails.plugin.springsecurity.annotation.Secured

/**
 * Controller for Grade Calculator
 */
@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class GradeCalculatorController {

    def index() { }
}
