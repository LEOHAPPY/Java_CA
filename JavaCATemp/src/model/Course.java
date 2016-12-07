package model;

import java.io.*;

 
public class Course implements Cloneable, Serializable {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseId;
    private String courseName;
    private java.sql.Date courseStart;
    private java.sql.Date courseEnd;
    private int courseCredit;
    private int courseMaxSize;
    private String courseDesc;
    private String lectureId;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Course () {

    }

    public Course (String courseIdIn) {

          this.courseId = courseIdIn;

    }

    public String getCourseId() {
          return this.courseId;
    }
    public void setCourseId(String courseIdIn) {
          this.courseId = courseIdIn;
    }

    public String getCourseName() {
          return this.courseName;
    }
    public void setCourseName(String courseNameIn) {
          this.courseName = courseNameIn;
    }

    public java.sql.Date getCourseStart() {
          return this.courseStart;
    }
    public void setCourseStart(java.sql.Date courseStartIn) {
          this.courseStart = courseStartIn;
    }

    public java.sql.Date getCourseEnd() {
          return this.courseEnd;
    }
    public void setCourseEnd(java.sql.Date courseEndIn) {
          this.courseEnd = courseEndIn;
    }

    public int getCourseCredit() {
          return this.courseCredit;
    }
    public void setCourseCredit(int courseCreditIn) {
          this.courseCredit = courseCreditIn;
    }

    public int getCourseMaxSize() {
          return this.courseMaxSize;
    }
    public void setCourseMaxSize(int courseMaxSizeIn) {
          this.courseMaxSize = courseMaxSizeIn;
    }

    public String getCourseDesc() {
          return this.courseDesc;
    }
    public void setCourseDesc(String courseDescIn) {
          this.courseDesc = courseDescIn;
    }

    public String getLectureId() {
          return this.lectureId;
    }
    public void setLectureId(String lectureIdIn) {
          this.lectureId = lectureIdIn;
    }



   
    
    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("\nclass Course, mapping to table courses\n");
        out.append("Persistent attributes: \n"); 
        out.append("courseId = " + this.courseId + "\n"); 
        out.append("courseName = " + this.courseName + "\n"); 
        out.append("courseStart = " + this.courseStart + "\n"); 
        out.append("courseEnd = " + this.courseEnd + "\n"); 
        out.append("courseCredit = " + this.courseCredit + "\n"); 
        out.append("courseMaxSize = " + this.courseMaxSize + "\n"); 
        out.append("courseDesc = " + this.courseDesc + "\n"); 
        out.append("lectureId = " + this.lectureId + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Course cloned = new Course();

        if (this.courseId != null)
             cloned.setCourseId(new String(this.courseId)); 
        if (this.courseName != null)
             cloned.setCourseName(new String(this.courseName)); 
        if (this.courseStart != null)
             cloned.setCourseStart((java.sql.Date)this.courseStart.clone()); 
        if (this.courseEnd != null)
             cloned.setCourseEnd((java.sql.Date)this.courseEnd.clone()); 
        cloned.setCourseCredit(this.courseCredit); 
        cloned.setCourseMaxSize(this.courseMaxSize); 
        if (this.courseDesc != null)
             cloned.setCourseDesc(new String(this.courseDesc)); 
        if (this.lectureId != null)
             cloned.setLectureId(new String(this.lectureId)); 
        return cloned;
    }   

}