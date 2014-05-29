/**
 * 
 */
package repository;

import java.util.List;

import com.danthu.tutorial.rest.model.Course;

/**
 * REST with Spring MVC
 * @author Yann Danthu
 */
public interface CourseRepository {
	/**
	 * Get all Courses available in repository.
	 * @return list of Course
	 */
	List<Course> getAll();
	
	/**
	 * Get Course of specified <code>id</code>.
	 * @param id Course identifier
	 * @return Course object
	 */
	Course get(String id);
	
	/**
	 * Saves the Course object in the repository.
	 * @param course
	 * @return the saved Course object.
	 */
	Course save(Course course);

	/**
	 * Deletes the Course object with identifier <code>id</code> from the repository.
	 * @param id
	 */
	void delete(String id);


}
