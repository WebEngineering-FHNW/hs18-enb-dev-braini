package webec

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

/**
 * Controller for Exam
 */
@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class ExamController {

    ExamService examService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /**
     * Lists all exams
     * @param max number of records
     * @return
     */
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond examService.list(params), model:[examCount: examService.count()]
    }

    /**
     * Lists one exam
     * @param id from exam
     * @return
     */
    def show(Long id) {
        respond examService.get(id)
    }

    /**
     * Creates a new exam
     * @return
     */
    def create() {
        respond new Exam(params)
    }

    /**
     * Saves the given exam
     * @param exam
     * @return
     */
    def save(Exam exam) {
        if (exam == null) {
            notFound()
            return
        }

        try {
            examService.save(exam)
        } catch (ValidationException e) {
            respond exam.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'exam.label', default: 'Exam'), exam.id])
                redirect exam
            }
            '*' { respond exam, [status: CREATED] }
        }
    }

    /**
     * Edits an exam
     * @param id from exam
     * @return
     */
    def edit(Long id) {
        respond examService.get(id)
    }

    /**
     * Updates the given exam
     * @param exam
     * @return
     */
    def update(Exam exam) {
        if (exam == null) {
            notFound()
            return
        }

        try {
            examService.save(exam)
        } catch (ValidationException e) {
            respond exam.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'exam.label', default: 'Exam'), exam.id])
                redirect exam
            }
            '*'{ respond exam, [status: OK] }
        }
    }

    /**
     * Deletes the given exam
     * @param id from exam
     * @return
     */
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        examService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'exam.label', default: 'Exam'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    /**
     * Not found message
     */
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'exam.label', default: 'Exam'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
