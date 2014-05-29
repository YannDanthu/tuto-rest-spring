/**
 * 
 */
package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.danthu.tutorial.rest.model.Course;

/**
 * REST with Spring MVC
 * @author Yann Danthu
 */
public class CourseMemoryRepository implements CourseRepository {
	/** The memory repository */
	private Map<String, Course> courses;

	/**
	 * Constructs a new CourseMemoryRepository using the specified map.
	 * @param courses
	 */
	public CourseMemoryRepository(final Map<String, Course> courses) {
		this.courses = Collections.unmodifiableMap(courses);
	}

	/**
	 * Gets all Course objects available in repository
	 */
	public List<Course> getAll() {
		return Collections.unmodifiableList(new ArrayList<Course>(courses
				.values()));
	}

	/**
	 * Gets course matching the specified <code>id</code>
	 */
	public Course get(String id) {
		return courses.get(id);
	}

	/**
	 * Saves specified <code>course</code> in repository
	 */
	public synchronized Course save(Course course) {

		Map<String, Course> modifiableCourses = new HashMap<String, Course>(courses);
		if (course.getId()==null) {
			course.setId(UUID.randomUUID().toString());
		}
		modifiableCourses.put(course.getId(), course);
		this.courses = Collections.unmodifiableMap(modifiableCourses);

		return course;
	}

	/**
	 * Deletes the course object matching the specified <code>id</code>
	 */
	public synchronized void delete(String id) {
		if (courses.containsKey(id)) {
			Map<String, Course> modifiableCourses = new HashMap<String, Course>(courses);
			modifiableCourses.remove(id);
			this.courses = Collections.unmodifiableMap(modifiableCourses);
		}
	}

}
