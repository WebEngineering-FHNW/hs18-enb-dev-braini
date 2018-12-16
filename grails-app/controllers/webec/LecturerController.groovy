package webec

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*


/**
 * Controller for Lecturer
 */
@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class LecturerController {

    LecturerService lecturerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /**
     * Lists all lecturers
     * @param max number of records
     * @return
     */
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond lecturerService.list(params), model:[lecturerCount: lecturerService.count()]
    }

    /**
     * Lists one lecturer
     * @param id from lecturer
     * @return
     */
    def show(Long id) {
        respond lecturerService.get(id)
    }

    /**
     * Creates a new lecturer
     * @return
     */
    def create() {
        respond new Lecturer(params)
    }

    /**
     * Saves the given lecturer
     * @param lecturer
     * @return
     */
    def save(Lecturer lecturer) {
        if (lecturer == null) {
            notFound()
            return
        }

        try {
            lecturerService.save(lecturer)
        } catch (ValidationException e) {
            respond lecturer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lecturer.label', default: 'Lecturer'), lecturer.id])
                redirect lecturer
            }
            '*' { respond lecturer, [status: CREATED] }
        }
    }

    /**
     * Edits an lecturer
     * @param id from lecturer
     * @return
     */
    def edit(Long id) {
        respond lecturerService.get(id)
    }

    /**
     * Updates the given lecturer
     * @param lecturer
     * @return
     */
    def update(Lecturer lecturer) {
        if (lecturer == null) {
            notFound()
            return
        }

        try {
            lecturerService.save(lecturer)
        } catch (ValidationException e) {
            respond lecturer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'lecturer.label', default: 'Lecturer'), lecturer.id])
                redirect lecturer
            }
            '*'{ respond lecturer, [status: OK] }
        }
    }

    /**
     * Deletes the given lecturer
     * @param id from lecturer
     * @return
     */
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        lecturerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'lecturer.label', default: 'Lecturer'), id])
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
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lecturer.label', default: 'Lecturer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
